package com.tma.sharing.casestudies.bookupdate.services.impl;

import com.tma.sharing.casestudies.bookupdate.models.AudioBook;
import com.tma.sharing.casestudies.bookupdate.repositories.BookRepository;

public class AudioBookUpdater extends GenericBookStatusUpdater<AudioBook> {
    public AudioBookUpdater(BookRepository<AudioBook> repository) {
        super(repository);
    }

    @Override
    protected boolean validateStatusChange(AudioBook book, String oldStatus, String newStatus) {
        if ("Available".equals(oldStatus) && "CheckedOut".equals(newStatus) && !book.isHasValidSubscription()) {
            System.out.println("Validation failed: Listener does not have a valid subscription to checkout AudioBook: " + book.getTitle());
            return false;
        }
        return true;
    }
}
