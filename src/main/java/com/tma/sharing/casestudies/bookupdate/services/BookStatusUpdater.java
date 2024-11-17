package com.tma.sharing.casestudies.bookupdate.services;

public interface BookStatusUpdater {
    void updateBookStatus(String oldStatus, String newStatus);
}
