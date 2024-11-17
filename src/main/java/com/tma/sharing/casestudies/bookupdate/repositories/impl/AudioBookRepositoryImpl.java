package com.tma.sharing.casestudies.bookupdate.repositories.impl;

import com.tma.sharing.casestudies.bookupdate.models.AudioBook;
import com.tma.sharing.casestudies.bookupdate.repositories.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

public class AudioBookRepositoryImpl implements BookRepository<AudioBook> {
    private final List<AudioBook> audioBookDataStore;

    public AudioBookRepositoryImpl(List<AudioBook> audioBookDataStore) {
        this.audioBookDataStore = audioBookDataStore;
    }

    @Override
    public List<AudioBook> findBooksByStatus(String status) {
        return audioBookDataStore.stream().filter(audioBook -> audioBook.getStatus().equals(status)).collect(Collectors.toList());
    }
}