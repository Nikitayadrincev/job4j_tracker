package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int rls = indexOf(id);
        return rls != -1 ? items.get(rls) : null;
    }

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                result = index;
            }
        }
        return result;
    }

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().contains(key)) {
                result.add(j, items.get(i));
                j++;
            }
        }
        return result;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            items.set(index, item);
            items.get(index).setId(id);
        }
        return result;
    }

    public void delete(int id) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            items.remove(index);
        }
    }
}

