package org.example;

import org.example.service.NonThreadSafeSingleton;
import org.example.service.ReentrantLockSingleton;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
            System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                    "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                    "RESULT:" + "\n");
            System.out.println("Non Thread Safe: ");
            NonThreadSafeSingleton s1 = NonThreadSafeSingleton.getInstance("FOO");
            NonThreadSafeSingleton s2 = NonThreadSafeSingleton.getInstance("BAR");
            System.out.println(s1.getValue());
            System.out.println(s2.getValue());

            System.out.println("Reentrant Lock Thread Safe: ");
            Thread r1 = new Thread(new ThreadR1());
            Thread r2 = new Thread(new ThreadR2());
            r1.start();
            r2.start();

            System.out.println("Volatile Lock Thread Safe: ");
            Thread v1 = new Thread(new ThreadV1());
            Thread v2 = new Thread(new ThreadV2());
            v1.start();
            v2.start();

    }

    private static class ThreadR1 implements Runnable {
        @Override
        public void run(){
            ReentrantLockSingleton r1 = ReentrantLockSingleton.getInstance("r1");
            System.out.println(r1.getValue());
        }
    }

    private static class ThreadR2 implements Runnable {
        @Override
        public void run(){
            ReentrantLockSingleton r2 = ReentrantLockSingleton.getInstance("r2");
            System.out.println(r2.getValue());
        }
    }

    private static class ThreadV1 implements Runnable {
        @Override
        public void run(){
            ReentrantLockSingleton v1 = ReentrantLockSingleton.getInstance("v1");
            System.out.println(v1.getValue());
        }
    }

    private static class ThreadV2 implements Runnable {
        @Override
        public void run(){
            ReentrantLockSingleton v2 = ReentrantLockSingleton.getInstance("v2");
            System.out.println(v2.getValue());
        }
    }
}