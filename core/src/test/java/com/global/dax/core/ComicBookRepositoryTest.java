package com.global.dax.core;

import static com.global.dax.testing.TestConstants.BATMAN_V2_1;
import static com.global.dax.testing.TestConstants.BATMAN_V2_2;
import static com.global.dax.testing.TestConstants.GREEN_LANTERN;
import static com.global.dax.testing.TestConstants.GREEN_LANTERN_V4_1;
import static com.global.dax.testing.TestConstants.GREEN_LANTERN_V4_2;
import static com.global.dax.testing.TestConstants.GREEN_LANTERN_V5_1;
import static com.global.dax.testing.TestConstants.GREEN_LANTERN_V5_2;
import static com.global.dax.testing.TestConstants.SUPERMAN_V4_1;
import static com.global.dax.testing.TestConstants.SUPERMAN_V4_2;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import com.global.dax.core.model.ComicBook;
import org.junit.jupiter.api.Test;

class ComicBookRepositoryTest {

    @Test
    void addStoresComicBookToRepository() {

        final var comicBooks = new ArrayList<ComicBook>();

        final var underTest = new ComicBookRepository(comicBooks);

        underTest.add(GREEN_LANTERN_V4_1);
        underTest.add(GREEN_LANTERN_V4_2);

        assertThat(comicBooks).containsExactlyInAnyOrder(GREEN_LANTERN_V4_1, GREEN_LANTERN_V4_2);
    }

    @Test
    void addDoesNotStoreDuplicatedComicBookIfComicBookIsAddedTwice() {

        final var comicBooks = new ArrayList<ComicBook>();

        final var underTest = new ComicBookRepository(comicBooks);

        underTest.add(GREEN_LANTERN_V4_1);
        underTest.add(GREEN_LANTERN_V4_1);

        assertThat(comicBooks).containsOnlyOnce(GREEN_LANTERN_V4_1); // TODO: Why is this failing?
    }

    @Test
    void getComicBooksReturnsAllStoredComicBooks() {

        final var underTest = new ComicBookRepository();

        underTest.add(BATMAN_V2_1);
        underTest.add(BATMAN_V2_2);
        underTest.add(GREEN_LANTERN_V4_1);
        underTest.add(GREEN_LANTERN_V4_2);
        underTest.add(GREEN_LANTERN_V5_1);
        underTest.add(GREEN_LANTERN_V5_2);
        underTest.add(SUPERMAN_V4_1);
        underTest.add(SUPERMAN_V4_2);

        final var foundComicBooks = underTest.getComicBooks();

        assertThat(foundComicBooks).containsExactlyInAnyOrder(BATMAN_V2_1,
                                                              BATMAN_V2_2,
                                                              GREEN_LANTERN_V4_1,
                                                              GREEN_LANTERN_V4_2,
                                                              GREEN_LANTERN_V5_1,
                                                              GREEN_LANTERN_V5_2,
                                                              SUPERMAN_V4_1,
                                                              SUPERMAN_V4_2);
    }

    @Test
    void clearRemovesAllStoredComicBooks() {

        final var underTest = new ComicBookRepository();

        underTest.add(BATMAN_V2_1);
        underTest.add(BATMAN_V2_2);
        underTest.add(GREEN_LANTERN_V4_1);
        underTest.add(GREEN_LANTERN_V4_2);
        underTest.add(GREEN_LANTERN_V5_1);
        underTest.add(GREEN_LANTERN_V5_2);
        underTest.add(SUPERMAN_V4_1);
        underTest.add(SUPERMAN_V4_2);

        underTest.clear();

        final var foundComicBooks = underTest.getComicBooks();

        assertThat(foundComicBooks).isEmpty();
    }

    @Test
    void searchBySeriesReturnsCorrectComicBooksForProvidedSeries() {

        final var underTest = new ComicBookRepository();

        underTest.add(BATMAN_V2_1);
        underTest.add(BATMAN_V2_2);
        underTest.add(GREEN_LANTERN_V4_1);
        underTest.add(GREEN_LANTERN_V4_2);
        underTest.add(GREEN_LANTERN_V5_1);
        underTest.add(GREEN_LANTERN_V5_2);
        underTest.add(SUPERMAN_V4_1);
        underTest.add(SUPERMAN_V4_2);

        final var foundComicBooks = underTest.searchBySeries(GREEN_LANTERN);

        assertThat(foundComicBooks).containsExactlyInAnyOrder(GREEN_LANTERN_V4_1,
                                                              GREEN_LANTERN_V4_2,
                                                              GREEN_LANTERN_V5_1,
                                                              GREEN_LANTERN_V5_2);
    }
}
