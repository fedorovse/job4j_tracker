package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ItemAscByNameTest {

    @Test
    public void whenItemAscByName() {
        List<Item> inItems = Arrays.asList(new Item("vvv"), new Item("ggg"), new Item("aaa"));
        Collections.sort(inItems, new ItemAscByName());
        List<Item> expectred = Arrays.asList(new Item("aaa"), new Item("ggg"), new Item("vvv"));
        assertThat(inItems, is(expectred));
    }
}