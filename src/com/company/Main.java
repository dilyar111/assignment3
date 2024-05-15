package com.company;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> hashTable = new MyHashTable<>();
        BST<Integer, String> tree = new BST<>();

        for(int i = 0; i < 10000; i++)
            hashTable.put(new MyTestingClass("" + i), "One");

        for(int i = 0; i < 10000; i++)
            System.out.println("Value for key " + i + ": " + hashTable.get(new MyTestingClass("1")));

        System.out.println("Removed value: " + hashTable.remove(new MyTestingClass("0")));

        System.out.println("Contains 'Three': " + hashTable.contains("One"));

        System.out.println("Key for value 'One': " + hashTable.getKey("One"));


        tree.put(1, "ONE");
        tree.put(2, "ONE");
        for (var elem : tree.iterator()) {

            System.out.println("key is " + elem);

        }
    }
}

