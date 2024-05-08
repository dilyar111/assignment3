import java.util.LinkedList;

class MyHashTable {
    private int size;
    private LinkedList<Entry>[] table;

    public MyHashTable(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hashFunction(String key) {
        return Math.abs(key.hashCode() % size);
    }

    public void add(String key, int value) {
        int index = hashFunction(key);
        LinkedList<Entry> list = table[index];
        for (Entry entry : list) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        list.add(new Entry(key, value));
    }

    public void remove(String key) {
        int index = hashFunction(key);
        LinkedList<Entry> list = table[index];
        for (Entry entry : list) {
            if (entry.key.equals(key)) {
                list.remove(entry);
                return;
            }
        }
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": ");
            for (Entry entry : table[i]) {
                System.out.print(entry + " ");
            }
            System.out.println();
        }
    }

    public int calculateSum() {
        int sum = 0;
        for (LinkedList<Entry> list : table) {
            for (Entry entry : list) {
                sum += entry.value;
            }
        }
        return sum;
    }

    public int findMax() {
        int max = Integer.MIN_VALUE;
        for (LinkedList<Entry> list : table) {
            for (Entry entry : list) {
                if (entry.value > max) {
                    max = entry.value;
                }
            }
        }
        return max;
    }

    public int findMin() {
        int min = Integer.MAX_VALUE;
        for (LinkedList<Entry> list : table) {
            for (Entry entry : list) {
                if (entry.value < min) {
                    min = entry.value;
                }
            }
        }
        return min;
    }

    public void displayEven() {
        System.out.println("Четные элементы:");
        for (LinkedList<Entry> list : table) {
            for (Entry entry : list) {
                if (entry.value % 2 == 0) {
                    System.out.println(entry);
                }
            }
        }
    }

    public void displayOdd() {
        System.out.println("Нечетные элементы:");
        for (LinkedList<Entry> list : table) {
            for (Entry entry : list) {
                if (entry.value % 2 != 0) {
                    System.out.println(entry);
                }
            }
        }
    }

    private static class Entry {
        String key;
        int value;

        Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }
    }
}

