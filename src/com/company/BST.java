package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BST<K extends Comparable<K>, V> {
    private Node root;
    private int size;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    // Constructor
    public BST() {
        size = 0;
    }

    public void put(K key, V val) {
        root = put(root, key, val);
        size++;
    }

    private Node put(Node x, K key, V val) {
        if (x == null)
            return new Node(key, val);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        return x;
    }

    public V get(K key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else
                return x.val;
        }
        return null;
    }

    public void delete(K key) {
        root = delete(root, key);
        size--;
    }

    private Node delete(Node x, K key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null)
                return x.left;
            if (x.left == null)
                return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        return x;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        else return min(x.left);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }

    public int size() {
        return size;
    }

    public Iterable<K> iterator() {
        List<K> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    private void inOrder(Node x, List<K> list) {
        if (x == null) return;
        inOrder(x.left, list);
        list.add(x.key);
        inOrder(x.right, list);
    }
}
