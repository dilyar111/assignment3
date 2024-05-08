public class Main {
    public static void main(String[] args) {
//        BinaryTree tree = new BinaryTree();
//
//        tree.insert(35);
//        tree.insert(64);
//        tree.insert(28);
//        tree.insert(11);
//        tree.insert(60);
//        tree.printTree(tree.root);
//        System.out.println();
//
//        tree.delete(60);
//        tree.printTree(tree.root);
//        System.out.println();
//
//        tree.countEvenOdd();
//
//        System.out.println("Max: " + tree.findMax());
//        tree.printTree(tree.root);
//        System.out.println();
//        System.out.println("Min: " + tree.findMin());
//
//        if (tree.isEmpty()) {
//            System.out.println("Tree is empty!");
//        }
//        else {
//            System.out.println("Tree is not empty!");
//            tree.deleteTree();
//            System.out.println("But now is empty");
//        }
//
//        tree.insert(35);
//        tree.insert(64);
//        tree.insert(28);
//        tree.insert(11);
//        tree.insert(60);
//        tree.printTree(tree.root);
//        System.out.println();
//
//        System.out.println("Height: " + tree.height());

        MyHashTable hashTable = new MyHashTable(10);
        hashTable.add("apple", 5);
        hashTable.add("banana", 7);
        hashTable.add("apple", 10);
        hashTable.add("orange", 3);
        hashTable.display();

        hashTable.remove("banana");
        hashTable.display();

        int sum = hashTable.calculateSum();
        System.out.println("Сумма всех элементов: " + sum);

        int max = hashTable.findMax();
        int min = hashTable.findMin();
        System.out.println("Максимальный элемент: " + max);
        System.out.println("Минимальный элемент: " + min);

        hashTable.displayEven();
        hashTable.displayOdd();
    }
}