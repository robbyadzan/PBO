package COLLECTION_2;

import java.util.ArrayDeque;

public class ArrayDequeExample {
    public static void main(String[] args) {

        ArrayDeque<String> antrian = new ArrayDeque<>();

        antrian.add("Antrian 1");
        antrian.add("Antrian 2");
        antrian.add("Antrian 3");

        System.out.println("=== ArrayDeque ===");
        while (!antrian.isEmpty()) {
            System.out.println(antrian.poll());
        }
    }
}