package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int lessLength = Math.min(left.length(), right.length());
        for (int i = 0; i < lessLength; i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                return result;
            }
        }
        if (left.length() != right.length()) {
            result = Integer.compare(left.length(), right.length());
        }

        return result;
    }
}
