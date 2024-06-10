package org.example;

import org.example.concreteObject.HtmlDialog;
import org.example.concreteObject.WindowsDialog;
import org.example.factory.DialogFactory;

// Press ⇧ twice to open the Search Everywhere dialogFactory and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static DialogFactory dialogFactory;
    public static void main(String[] args) {
        configure();
        runBusinessLogic();
    }

    static void configure() {
        System.out.println(System.getProperty("os.name"));
        if(System.getProperty("os.name").equals("Mac OS X"))
            dialogFactory = new WindowsDialog();
        else
            dialogFactory = new HtmlDialog();
    }

    static void runBusinessLogic() {
        dialogFactory.renderWindow();
    }
}