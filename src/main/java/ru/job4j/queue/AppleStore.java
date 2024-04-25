package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {

    private final Queue<Customer> queue;
    private int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    private Customer shiftQueue(int number) {
        for (int i = 0; i < number - 1; i++) {
            queue.poll();
        }
        return queue.poll();
    }

    public String getLastHappyCustomer() {
        return shiftQueue(count).name();
    }

    public String getFirstUpsetCustomer() {
        return shiftQueue(count + 1).name();
    }
}