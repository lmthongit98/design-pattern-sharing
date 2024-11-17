package com.tma.sharing.structurals.observer;


public class VideoData extends Subject {

    private String title;
    private String description;
    private String fileName;

    public void setTitle(String title) {
        this.title = title;
        videoDataChange();
    }

    public void setDescription(String description) {
        this.description = description;
        videoDataChange();
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
        videoDataChange();
    }

    private void videoDataChange() {
        super.notifyObserver(null);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getFileName() {
        return fileName;
    }
}
