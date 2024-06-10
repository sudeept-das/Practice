package org.example.service;


import lombok.Data;
import lombok.Getter;

import java.util.concurrent.locks.ReentrantLock;

@Getter
public class ReentrantLockSingleton {
    private static ReentrantLockSingleton singleton;
    private String value;
    private static final ReentrantLock lock = new ReentrantLock();
    private ReentrantLockSingleton(String value)
    {
        this.value = value;
    }
    public static ReentrantLockSingleton getInstance(String value){
        try {
            lock.tryLock();
            if (singleton == null)
                singleton = new ReentrantLockSingleton(value);
            lock.unlock();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return singleton;
    }
}
