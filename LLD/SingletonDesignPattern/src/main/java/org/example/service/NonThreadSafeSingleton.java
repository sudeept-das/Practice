package org.example.service;

import lombok.Getter;

@Getter
public class NonThreadSafeSingleton {
    private static NonThreadSafeSingleton instance;
    private String value;
    private NonThreadSafeSingleton(String value) {
        try{
           Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.value = value;
    }

    public static NonThreadSafeSingleton getInstance(String value) {
        if(instance == null)
            instance = new NonThreadSafeSingleton(value);
        return instance;
    }
}
