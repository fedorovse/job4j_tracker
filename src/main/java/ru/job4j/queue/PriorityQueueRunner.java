package ru.job4j.queue;

import java.util.PriorityQueue;
import java.util.function.Predicate;

public class PriorityQueueRunner {

    public static void main(String[] args) {
        PriorityQueue<String> stringQueue = new PriorityQueue<>();
        stringQueue.offer("f");
        stringQueue.offer("a");
        stringQueue.offer("z");
        stringQueue.offer("d");
        System.out.println("Current element: " + stringQueue.peek());
        System.out.println("Current element: " + stringQueue.peek());
        printStringElements(stringQueue);
        System.out.println(stringQueue.poll());

        PriorityQueue<Transaction> transactionQueue = new PriorityQueue<>(new TransactionSortDescByAmount());
        transactionQueue.offer(new Transaction(1, "number_1", 100));
        transactionQueue.offer(new Transaction(2, "number_2", 1000));
        transactionQueue.offer(new Transaction(3, "number_3", 30));
        transactionQueue.offer(new Transaction(4, "number_4", 550));
        printTransactionElements(transactionQueue);
    }

    public static void printStringElements(PriorityQueue<String> queue) {
        while (!queue.isEmpty()) {
            System.out.println("Current element: " + queue.poll());
        }
    }

    public static void printTransactionElements(PriorityQueue<Transaction> queue) {
        while (!queue.isEmpty()) {
            System.out.println("Current element: " + queue.poll());
        }
    }
}
