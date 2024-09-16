package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {
    @Test
    public void whenItemAscByName() {
        List<Item> items = Arrays.asList(
                new Item("Denis"),
                new Item("Andrey"),
                new Item("Vovka")
        );

        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("Andrey"),
                new Item("Denis"),
                new Item("Vovka")
        );
    assertThat(items).isEqualTo(expected);
    }

    @Test
    public void whenItemDescByName() {
        List<Item> items = Arrays.asList(
                new Item("Andrey"),
                new Item("Denis"),
                new Item("Vovka")
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item("Vovka"),
                new Item("Denis"),
                new Item("Andrey")
        );
        assertThat(items).isEqualTo(expected);
    }
}