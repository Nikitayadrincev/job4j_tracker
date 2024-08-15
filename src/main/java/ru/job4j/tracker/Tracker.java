package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int rls = indexOf(id);
        return rls != -1 ? items[rls] : null;
    }

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(key)) {
                result[j] = items[i];
                j++;
            }
        }
        return Arrays.copyOf(result, j);
    }

    public Item[] findAll() {
        Item[] result = new Item[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            Item name = items[i];
            if (name != null) {
                result[j] = name;
                j++;
            }
        }
        return Arrays.copyOf(result, j);
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            items[index].setName(item.getName());
        }
        return result;
    }

    public void delete(int id) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            size--;
        }
    }
}

