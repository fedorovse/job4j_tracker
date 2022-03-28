package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Show all items ===");
        Item[] items = tracker.findAll();
        if (items.length == 0) {
            System.out.println("В хранилище пока нет заявок");
        } else {
            for (Item i: items) {
                System.out.println(i);
            }
        }
        return true;
    }
}
