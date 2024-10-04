package com.global.dax.server.web;

import java.util.List;

import com.global.dax.core.ComicBookRepository;
import com.global.dax.core.model.ComicBook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/comic-books")
@RestController
public class ComicBookController {

    private final ComicBookRepository comicBookRepository;

    public ComicBookController(final ComicBookRepository comicBookRepository) {

        this.comicBookRepository = comicBookRepository;
    }

    @PostMapping
    public void addComicBook(final @RequestBody ComicBook comicBook) {

        comicBookRepository.add(comicBook);
    }

    @GetMapping
    public List<ComicBook> getComicBooks() {

        return comicBookRepository.getComicBooks();
    }

    @GetMapping("/search")
    public List<ComicBook> searchBySeries(final @RequestParam("series") String series) {

        return null; // TODO: Implement this
    }

    // TODO: add ability to remove comic book from repository
}
