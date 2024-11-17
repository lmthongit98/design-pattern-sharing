package com.tma.sharing.structurals.observer;

import com.tma.sharing.structurals.observer.notifiers.EmailNotifier;
import com.tma.sharing.structurals.observer.notifiers.PhoneNotifier;
import com.tma.sharing.structurals.observer.notifiers.YoutubeNotifier;

public class Client {

    public static void main(String[] args) {
        var videoData = new VideoData();
        var emailNotifier = new EmailNotifier(videoData);
        var phoneNotifier = new PhoneNotifier(videoData);
        var youtubeNotifier = new YoutubeNotifier(videoData);
        videoData.setTitle("Observer design pattern");
        videoData.detachObserver(emailNotifier);
        System.out.println("\n-------------------");
        System.out.println("After detaching email notifier");
        videoData.setDescription("Study observer design pattern");

    }

}
