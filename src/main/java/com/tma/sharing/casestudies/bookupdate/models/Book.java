package com.tma.sharing.casestudies.bookupdate.models;

public class Book implements Updatable {
    private String title;
    private String status;

    public Book(String title, String status) {
        this.title = title;
        this.status = status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Book{" + "title='" + title + '\'' + ", status='" + status + '\'' + '}';
    }
}
