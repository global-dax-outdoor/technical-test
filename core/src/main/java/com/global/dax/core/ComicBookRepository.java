package com.global.dax.core;

import java.util.ArrayList;
import java.util.List;

import com.global.dax.core.model.ComicBook;

public class ComicBookRepository {

    private final List<ComicBook> comicBooks;

    public ComicBookRepository() {

        this.comicBooks = new ArrayList<>();
    }

    public ComicBookRepository(final List<ComicBook> comicBooks) {

        this.comicBooks = comicBooks;
    }

    public void add(final ComicBook comicBook) {

        comicBooks.add(comicBook);
    }

    public List<ComicBook> getComicBooks() {

        return comicBooks;
    }

    public void clear() {

        comicBooks.clear();
    }

    public List<ComicBook> searchBySeries(final String series) {

        return null; // TODO: Implement this
    }

    // TODO: add ability to remove comic book from repository
}
