public class Main {
    public static void main(String[] args) {
        MyHashTable<Integer, String> hashTable = new MyHashTable<>();

        // Добавляем элементы
        hashTable.put(1, "One");
        hashTable.put(2, "Two");
        hashTable.put(3, "Three");

        // Получаем значение по ключу
        System.out.println("Value for key 2: " + hashTable.get(2));

        // Удаляем элемент
        System.out.println("Removed value: " + hashTable.remove(2));

        // Проверяем наличие значения
        System.out.println("Contains 'Three': " + hashTable.contains("Three"));

        // Получаем ключ по значению
        System.out.println("Key for value 'One': " + hashTable.getKey("One"));
    }
}

