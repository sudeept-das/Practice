package org.example;

import org.example.editors.Editor;
import org.example.listeners.EmailNotificationListener;
import org.example.listeners.LogOpenListener;

import java.io.File;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("save", new LogOpenListener(new File("file.txt")));
        editor.events.subscribe("open", new EmailNotificationListener("open@example.com"));

        try{
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}