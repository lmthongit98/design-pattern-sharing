package com.tma.sharing.casestudies.bookupdate.models;

public class AudioBook implements Updatable {
    private String title;
    private String status;
    private boolean hasValidSubscription;

    public AudioBook(String title, String status, boolean hasValidSubscription) {
        this.title = title;
        this.status = status;
        this.hasValidSubscription = hasValidSubscription;
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

    public boolean isHasValidSubscription() {
        return hasValidSubscription;
    }

    @Override
    public String toString() {
        return "AudioBook{" + "title='" + title + '\'' + ", status='" + status + '\'' + '}';
    }
}