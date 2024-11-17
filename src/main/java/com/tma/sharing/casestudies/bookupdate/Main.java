package com.tma.sharing.casestudies.bookupdate;

import com.tma.sharing.casestudies.bookupdate.models.AudioBook;
import com.tma.sharing.casestudies.bookupdate.models.Book;
import com.tma.sharing.casestudies.bookupdate.models.EBook;
import com.tma.sharing.casestudies.bookupdate.repositories.BookRepository;
import com.tma.sharing.casestudies.bookupdate.repositories.impl.AudioBookRepositoryImpl;
import com.tma.sharing.casestudies.bookupdate.repositories.impl.BookRepositoryImpl;
import com.tma.sharing.casestudies.bookupdate.repositories.impl.EBookRepositoryImpl;
import com.tma.sharing.casestudies.bookupdate.services.impl.AudioBookUpdater;
import com.tma.sharing.casestudies.bookupdate.services.impl.BookUpdater;
import com.tma.sharing.casestudies.bookupdate.services.impl.EBookUpdater;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Data stores
        List<Book> bookDataStore = new ArrayList<>();
        bookDataStore.add(new Book("Book 1", "Available"));
        bookDataStore.add(new Book("Book 2", "Reserved"));

        List<EBook> eBookDataStore = new ArrayList<>();
        eBookDataStore.add(new EBook("EBook 1", "Available", 1)); // Access level 1
        eBookDataStore.add(new EBook("EBook 2", "Available", 0)); // Access level 0 (restricted access)

        List<AudioBook> audioBookDataStore = new ArrayList<>();
        audioBookDataStore.add(new AudioBook("AudioBook 1", "Available", true)); // Valid subscription
        audioBookDataStore.add(new AudioBook("AudioBook 2", "Available", false)); // Invalid subscription

        // Create repositories
        BookRepository<Book> bookRepository = new BookRepositoryImpl(bookDataStore);
        BookRepository<EBook> eBookRepository = new EBookRepositoryImpl(eBookDataStore);
        BookRepository<AudioBook> audioBookRepository = new AudioBookRepositoryImpl(audioBookDataStore);

        // Create and test Book Updater
        BookUpdater bookUpdater = new BookUpdater(bookRepository);
        try {
            bookUpdater.updateBookStatus("Available", "CheckedOut");
        } catch (Exception e) {
            System.out.println("Error updating Book: " + e.getMessage());
        }

        // Create and test EBook Updater
        EBookUpdater eBookUpdater = new EBookUpdater(eBookRepository);
        try {
            eBookUpdater.updateBookStatus("Available", "CheckedOut");
        } catch (Exception e) {
            System.out.println("Error updating EBook: " + e.getMessage());
        }

        // Create and test AudioBook Updater
        AudioBookUpdater audioBookUpdater = new AudioBookUpdater(audioBookRepository);
        try {
            audioBookUpdater.updateBookStatus("Available", "CheckedOut");
        } catch (Exception e) {
            System.out.println("Error updating AudioBook: " + e.getMessage());
        }

        // Display results
        System.out.println("\nBooks after update:");
        bookDataStore.forEach(System.out::println);

        System.out.println("\nEBooks after update:");
        eBookDataStore.forEach(System.out::println);

        System.out.println("\nAudioBooks after update:");
        audioBookDataStore.forEach(System.out::println);
    }

}
