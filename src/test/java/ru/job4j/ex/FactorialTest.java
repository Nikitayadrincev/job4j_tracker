package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialTest {
    @Test
    public void whenException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Factorial().calc(-1);
                });
        assertThat(exception.getMessage()).isEqualTo("Number could not be less than 0");
    }

    @Test
    public void when3Then6() {
        int number = 3;
        int expected = 6;
        int result = new Factorial().calc(number);
        assertThat(result).isEqualTo(expected);
    }
}