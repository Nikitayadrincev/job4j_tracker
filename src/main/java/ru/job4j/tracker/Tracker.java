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
        boolean result = false;
        int index = indexOf(id);
        if (index != -1) {
            items[index].setName(item.getName());
            result = true;
        }
        return result;
    }

    public void delete(int id) {
        int res = indexOf(id);
        if (res != -1) {
            System.arraycopy(items, res + 1, items, res, size - res - 1);
            size--;
        }
    }
}

