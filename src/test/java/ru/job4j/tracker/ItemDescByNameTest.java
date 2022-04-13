package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ItemDescByNameTest {

    @Test
    public void whenItemDescByName() {
        List<Item> inItems = Arrays.asList(new Item("bbb"), new Item("aaa"), new Item("www"));
        Collections.sort(inItems, new ItemDescByName());
        List<Item> expected = Arrays.asList(new Item("www"), new Item("bbb"), new Item("aaa"));
        assertThat(inItems, is(expected));
    }
}