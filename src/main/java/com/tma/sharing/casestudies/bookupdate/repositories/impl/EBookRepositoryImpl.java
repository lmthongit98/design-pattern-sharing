package com.tma.sharing.casestudies.bookupdate.repositories.impl;

import com.tma.sharing.casestudies.bookupdate.models.EBook;
import com.tma.sharing.casestudies.bookupdate.repositories.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

public class EBookRepositoryImpl implements BookRepository<EBook> {
    private final List<EBook> eBookDataStore;

    public EBookRepositoryImpl(List<EBook> eBookDataStore) {
        this.eBookDataStore = eBookDataStore;
    }

    @Override
    public List<EBook> findBooksByStatus(String status) {
        return eBookDataStore.stream().filter(eBook -> eBook.getStatus().equals(status)).collect(Collectors.toList());
    }
}