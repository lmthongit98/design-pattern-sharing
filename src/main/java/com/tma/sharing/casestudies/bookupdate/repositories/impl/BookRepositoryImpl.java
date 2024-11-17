package com.tma.sharing.casestudies.bookupdate.repositories.impl;

import com.tma.sharing.casestudies.bookupdate.models.Book;
import com.tma.sharing.casestudies.bookupdate.repositories.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

public class BookRepositoryImpl implements BookRepository<Book> {
    private final List<Book> bookDataStore;

    public BookRepositoryImpl(List<Book> bookDataStore) {
        this.bookDataStore = bookDataStore;
    }

    @Override
    public List<Book> findBooksByStatus(String status) {
        return bookDataStore.stream().filter(book -> book.getStatus().equals(status)).collect(Collectors.toList());
    }
}