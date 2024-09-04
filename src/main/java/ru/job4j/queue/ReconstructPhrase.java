package ru.job4j.queue;

import java.util.Deque;
import java.util.Iterator;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        Object[] array = evenElements.toArray();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                text.append(array[i]);
            }
        }
        return text.toString();
    }

    private String getDescendingElements() {
        StringBuilder text = new StringBuilder();
        Iterator<Character> iterator = descendingElements.descendingIterator();
        while (iterator.hasNext()) {
            text.append(iterator.next());
        }
        return text.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }

}
