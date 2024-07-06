package org.example;

import java.io.BufferedInputStream;
import java.security.KeyPair;
import java.util.*;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<KeyValuePair> values = new ArrayList<>();
        values.add(new KeyValuePair("Ramesh", 50));
        values.add(new KeyValuePair("Mahesh", 50));
        values.add(new KeyValuePair("Suresh", 50));
        values.add(new KeyValuePair("Raj", 50));
        values.add(new KeyValuePair("Ram", 50));

        Collections.sort(values, new Comparator<KeyValuePair>() {
            @Override
            public int compare(KeyValuePair o1, KeyValuePair o2) {
                if(o1.getMarks()!=o2.getMarks())
                    return Integer.compare(o1.getMarks(), o2.getMarks());
                else
                    return o1.getName().compareTo(o2.getName());
            }
        });

        int rank=1, val= values.get(0).getMarks();
        for(KeyValuePair kv: values)
        {
            if(val!=kv.getMarks()) {
                val = kv.getMarks();
                rank++;
            }
            System.out.println(rank+" "+kv.getName()+" "+kv.getMarks());
        }
    }
}