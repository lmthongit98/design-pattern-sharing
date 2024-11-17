package com.tma.sharing.casestudies.bookupdate.services.impl;

import com.tma.sharing.casestudies.bookupdate.models.EBook;
import com.tma.sharing.casestudies.bookupdate.repositories.BookRepository;

public class EBookUpdater extends GenericBookStatusUpdater<EBook> {
    public EBookUpdater(BookRepository<EBook> repository) {
        super(repository);
    }

    @Override
    protected boolean validateStatusChange(EBook book, String oldStatus, String newStatus) {
        if (book.getAccessLevel() < 1 && "CheckedOut".equals(newStatus)) {
            System.out.println("Validation failed: User does not have access to checkout EBook: " + book.getTitle());
            return false;
        }
        return true;
    }
}
