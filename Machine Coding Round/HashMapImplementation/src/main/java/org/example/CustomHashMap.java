package org.example;

import lombok.Data;
import lombok.Getter;

@Data
public class CustomHashMap<K,V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_CAPACITY = 0.75f;
    private float loadFactor;
    private int capacity, size;
    private Node<K,V>[] table;

    public CustomHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_CAPACITY);
    }
    public CustomHashMap(int capacity, float loadFactor) {
        if(capacity <= 0)
            throw new IllegalArgumentException("Capacity must be positive");
        if(loadFactor <= 0 || loadFactor > 1)
            throw new IllegalArgumentException("Load factor must be between 0 and 1");
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.table = (Node<K, V>[]) new Node[capacity];
    }

    private int hash(Object key){
        return (key == null) ? 0 : Math.abs(key.hashCode()) %capacity;
    }

    public void put(K key, V value){
        int index = hash(key);

        Node<K, V> node = table[index];
        while(node!= null)
        {
            if(node.getKey().equals(key)){
                node.value = value;
                return;
            }
            node = node.next;
        }
        Node<K,V> newNode = new Node<>(key, value, null);
        newNode.next = table[index];
        table[index] = newNode;
        size++;
        if(size> capacity*loadFactor)
            resize();
    }

    private void resize() {
        int newCapacity = capacity * 2;
        Node<K,V>[] newTable = new Node[newCapacity];
        for(int i=0; i<capacity; i++){
            Node<K,V> node = table[i];
            while(node!=null){
                Node<K,V> next = node.next;
                int index = hash(node.getKey());
                node.next = newTable[index];
                newTable[index] = node;
                node= next;
            }
        }
        table = newTable;
        capacity = newCapacity;
    }

    public V get(K key){
        int index = hash(key);
        Node<K,V> node = table[index];
        while(node!=null){
            if(node.getKey().equals(key))
                return node.value;
            node = node.next;
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        Node<K, V> node = table[index];
        Node<K,V> prev = null;
        while (node != null) {
            if (node.key.equals(key)) {
                if (prev == null) {
                    table[index] = node.next;
                } else {
                    prev.next = node.next;
                }
                size--;
                return;
            }
            prev = node;
            node = node.next;
        }
    }


    @Getter
    static class Node<K, V> {
        K key;
        V value;
        Node<K,V> next;
        Node(K key, V value, Node<K,V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
