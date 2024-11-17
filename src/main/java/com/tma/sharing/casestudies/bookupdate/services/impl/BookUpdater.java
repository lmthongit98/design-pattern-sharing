package com.tma.sharing.casestudies.bookupdate.services.impl;

import com.tma.sharing.casestudies.bookupdate.models.Book;
import com.tma.sharing.casestudies.bookupdate.repositories.BookRepository;

public class BookUpdater extends GenericBookStatusUpdater<Book> {
    public BookUpdater(BookRepository<Book> repository) {
        super(repository);
    }

    @Override
    protected boolean validateStatusChange(Book book, String oldStatus, String newStatus) {
        if ("Reserved".equals(book.getStatus()) && "CheckedOut".equals(newStatus)) {
            System.out.println("Validation failed: Cannot change status from Reserved to CheckedOut for Book: " + book.getTitle());
            return false;
        }
        return true;
    }
}