public class MyHashTable<K, V> {
    private class HashNode {
        private K key;
        private V value;
        private HashNode next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode[] chainArray;
    private final int M = 11; // default number of chains
    private int size;

    public MyHashTable() {
        this.chainArray = new HashNode[M];
        this.size = 0;
    }

    private int hash(K key) {
        int hashCode = key.hashCode();
        return (hashCode ^ (hashCode >>> 16)) % M;
    }

    public void put(K key, V value) {
        int index = hash(key);
        HashNode node = chainArray[index];

        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }

        HashNode newNode = new HashNode(key, value);
        newNode.next = chainArray[index];
        chainArray[index] = newNode;
        size++;
    }

    public V get(K key) {
        for (HashNode node = chainArray[hash(key)]; node != null; node = node.next) {
            if (node.key.equals(key))
                return node.value;
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        HashNode node = chainArray[index];
        HashNode prev = null;

        while (node != null && !node.key.equals(key)) {
            prev = node;
            node = node.next;
        }

        if (node != null) {
            if (prev != null) {
                prev.next = node.next;
            } else {
                chainArray[index] = node.next;
            }
            size--;
            return node.value;
        }
        return null;
    }

    public boolean contains(V value) {
        for (HashNode node : chainArray) {
            while (node != null) {
                if (node.value.equals(value))
                    return true;
                node = node.next;
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (HashNode node : chainArray) {
            while (node != null) {
                if (node.value.equals(value))
                    return node.key;
                node = node.next;
            }
        }
        return null;
    }
}
