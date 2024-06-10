package org.example;

import org.example.concreteClass.AdvancedRemote;
import org.example.concreteClass.BasicRemote;
import org.example.concreteClass.Radio;
import org.example.concreteClass.Tv;
import org.example.interfaces.Device;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());

    }

    static void testDevice(Device device){
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();

    }
}