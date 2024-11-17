package com.tma.sharing.structurals.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private final List<Observer> observers = new ArrayList<>();

     public void attachObserver(Observer observer) {
         observers.add(observer);
     }

     public void detachObserver(Observer observer) {
         observers.remove(observer);
     }

     public void notifyObserver(Object arg) {
         observers.forEach(observer -> observer.update(arg));
     }


}
