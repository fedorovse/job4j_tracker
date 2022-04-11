package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(size++, item);
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = this.indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
    return items.subList(0, size);
    }

    public List<Item> findByName(String key) {
    List<Item> result = new ArrayList<>();
    for (int i = 0; i < size; i++) {
        if (items.get(i).getName().equals(key)) {
            result.add(items.get(i));
        }
    }
    return result;
    }

    public boolean replace(int id, Item item) {
        int index = this.indexOf(id);
        boolean result = index != -1;
        if (result) {
            item.setId(id);
            items.set(index, item);
        }
        return result;
    }

    public boolean delete(int id) {
        int index = this.indexOf(id);
        boolean result = index != -1;
        if (result) {
            List<Item> subList = items.subList(index + 1, size);
            items.addAll(index, subList);
            size--;
            items.set(size, null);
        }
        return result;
    }
}