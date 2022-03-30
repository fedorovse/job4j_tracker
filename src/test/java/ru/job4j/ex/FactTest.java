package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenNLess0() {
        new Fact().calc(-1);
    }

    @Test
    public void whenNIs0Then1() {
        int n = 0;
        int out = new Fact().calc(n);
        int expected = 1;
        assertThat(expected, is(out));
    }

    @Test
    public void whenNIs1Then1() {
        int n = 1;
        int out = new Fact().calc(n);
        int expected = 1;
        assertThat(expected, is(out));
    }

    @Test
    public void whenNIs5Then120() {
        int n = 5;
        int out = new Fact().calc(n);
        int expected = 120;
        assertThat(expected, is(out));
    }
}