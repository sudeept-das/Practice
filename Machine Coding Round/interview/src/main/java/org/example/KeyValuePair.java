package org.example;

import lombok.Data;

@Data
public class KeyValuePair {
    String name;
    Integer marks;
    KeyValuePair(String name, Integer marks)
    {
        this.name = name;
        this.marks = marks;
    }
}
