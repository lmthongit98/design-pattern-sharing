package com.tma.sharing.casestudies.bookupdate.repositories;

import com.tma.sharing.casestudies.bookupdate.models.Updatable;

import java.util.List;

public interface BookRepository<T extends Updatable> {
    List<T> findBooksByStatus(String status);
}