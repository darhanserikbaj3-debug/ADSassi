import models.*;
import structures.hashtable.MyHashTable;
import structures.bst.BST;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>(100);
        Random rand = new Random();

        for (int i = 0; i < 10000; i++) {
            table.put(new MyTestingClass(rand.nextInt(100000), "Name" + i), new Student("Student" + i));
        }
        table.printBucketSizes();

        System.out.println("--- BST Test ---");
        BST<Integer, String> tree = new BST<>();
        tree.put(5, "Five");
        tree.put(3, "Three");
        tree.put(8, "Eight");

        for (var elem : tree) {
            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
        }
    }
}