package com.tma.sharing.structurals.observer.notifiers;

import com.tma.sharing.structurals.observer.Observer;
import com.tma.sharing.structurals.observer.Subject;
import com.tma.sharing.structurals.observer.VideoData;

public class EmailNotifier extends Observer {

    public EmailNotifier(Subject subject) {
        super(subject);
        subject.attachObserver(this);
    }

    @Override
    public void update(Object arg) {
        if (subject instanceof VideoData videoData) {
            System.out.format("\nNotify all subscribers via Email with new data " +
                            "\n\tName: %s" +
                            "\n\tDescription: %s" +
                            "\n\tTitle: %s\n",
                    videoData.getFileName(), videoData.getDescription(), videoData.getTitle());
        }
    }

}
