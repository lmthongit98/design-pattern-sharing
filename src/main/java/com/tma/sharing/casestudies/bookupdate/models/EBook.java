package com.tma.sharing.casestudies.bookupdate.models;

public class EBook implements Updatable {
    private String title;
    private String status;
    private int accessLevel;

    public EBook(String title, String status, int accessLevel) {
        this.title = title;
        this.status = status;
        this.accessLevel = accessLevel;
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

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Override
    public String toString() {
        return "EBook{" + "title='" + title + '\'' + ", status='" + status + '\'' + ", accessLevel=" + accessLevel + '}';
    }
}