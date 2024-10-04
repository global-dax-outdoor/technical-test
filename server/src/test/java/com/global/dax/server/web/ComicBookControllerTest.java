package com.global.dax.server.web;

import static com.global.dax.testing.TestConstants.GREEN_LANTERN_V4_1;
import static com.global.dax.testing.TestConstants.GREEN_LANTERN_V4_2;
import static com.global.dax.testing.TestConstants.GREEN_LANTERN_V5_1;
import static com.global.dax.testing.TestConstants.GREEN_LANTERN_V5_2;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import com.global.dax.core.ComicBookRepository;
import com.global.dax.core.model.ComicBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ComicBookControllerTest {

    @Autowired private ComicBookRepository comicBookRepository;

    @Autowired private TestRestTemplate testRestTemplate;

    @BeforeEach
    void setUp() {

        comicBookRepository.clear();
    }

    @Test
    void comicBooksCanBeRetrieved() {

        final var comicBooksResponse = getComicBooks();
        assertThat(comicBooksResponse.getBody()).isEmpty();

        comicBookRepository.add(GREEN_LANTERN_V4_1);
        comicBookRepository.add(GREEN_LANTERN_V4_2);

        final var comicBooksResponse2 = getComicBooks();

        assertThat(comicBooksResponse2.getBody()).containsExactlyInAnyOrder(GREEN_LANTERN_V4_1,
                                                                            GREEN_LANTERN_V4_2);
    }

    @Test
    void comicBooksCanBeAdded() {

        addComicBook(GREEN_LANTERN_V4_1);

        assertThat(comicBookRepository.getComicBooks()).containsExactlyInAnyOrder(GREEN_LANTERN_V4_1);

        addComicBook(GREEN_LANTERN_V4_2);

        assertThat(comicBookRepository.getComicBooks()).containsExactlyInAnyOrder(GREEN_LANTERN_V4_1,
                                                                                  GREEN_LANTERN_V4_2);
    }

    @Test
    void comicBooksCanBeSearched() {

        comicBookRepository.add(GREEN_LANTERN_V4_1);
        comicBookRepository.add(GREEN_LANTERN_V4_2);
        comicBookRepository.add(GREEN_LANTERN_V5_1);
        comicBookRepository.add(GREEN_LANTERN_V5_2);

        final var searchResponse = searchComicBooksBySeries("Green Lantern");

        assertThat(searchResponse.getBody()).containsExactlyInAnyOrder(GREEN_LANTERN_V4_1,
                                                                       GREEN_LANTERN_V4_2,
                                                                       GREEN_LANTERN_V5_1,
                                                                       GREEN_LANTERN_V5_2);

    }

    private ResponseEntity<ComicBook[]> getComicBooks() {

        final var responseEntity = testRestTemplate.getForEntity("/api/comic-books", ComicBook[].class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        return responseEntity;
    }

    private ResponseEntity<ComicBook[]> searchComicBooksBySeries(final String series) {

        final var responseEntity = testRestTemplate.getForEntity("/api/comic-books/search?series=" + series,
                                                                 ComicBook[].class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        return responseEntity;
    }

    private void addComicBook(final ComicBook comicBook) {

        final var responseEntity = testRestTemplate.postForEntity("/api/comic-books",
                                                                  comicBook,
                                                                  Void.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
