package org.example;

import java.io.File;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        System.out.printf("Hello and welcome!");

        // create a new hash map
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        // add a key-value pair to the hash map
        map.put("apple", 10);
        map.put("orange", 5);

        System.out.println("Custom Map after inserting element: "+ map.toString());

        Integer fetchedVal = map.get("orange");
        System.out.println("Fetch value is: "+ fetchedVal.toString());

        map.remove("apple");
        System.out.println("Custom Map after removing element: "+ map.toString());

    }

}