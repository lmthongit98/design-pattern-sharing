package com.tma.sharing.casestudies.bookupdate.services.impl;

import com.tma.sharing.casestudies.bookupdate.models.AudioBook;
import com.tma.sharing.casestudies.bookupdate.models.Updatable;
import com.tma.sharing.casestudies.bookupdate.repositories.BookRepository;
import com.tma.sharing.casestudies.bookupdate.services.BookStatusUpdater;

import java.util.List;

public abstract class GenericBookStatusUpdater<T extends Updatable> implements BookStatusUpdater {
    protected final BookRepository<T> repository;

    public GenericBookStatusUpdater(BookRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public void updateBookStatus(String oldStatus, String newStatus) {
        List<T> books = repository.findBooksByStatus(oldStatus);
        for (T book : books) {
            if (!validateStatusChange(book, oldStatus, newStatus)) {
                throw new IllegalStateException("Status change validation failed for book: " + book.toString());
            }
            updateStatus(book, newStatus);
        }
    }

    protected void updateStatus(T book, String newStatus) {
        book.setStatus(newStatus);
        System.out.println("Status updated: " + book);
    }

    protected abstract boolean validateStatusChange(T book, String oldStatus, String newStatus);

}
