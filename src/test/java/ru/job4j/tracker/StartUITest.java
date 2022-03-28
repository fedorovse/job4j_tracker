package ru.job4j.tracker;

import static org.hamcrest.MatcherAssert.*;

import org.junit.Ignore;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        new CreateAction().execute(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenEditItemTrue() {
        Tracker tracker = new Tracker();
        Item item = new Item("new Item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()),
                "edited Item"
        };
        Input input = new StubInput(answers);
        new EditAction().execute(input, tracker);
        Item expected = tracker.findById(item.getId());
        assertThat(expected.getName(), is("edited Item"));
    }

    @Test
    public void whenEditItemFalse() {
        Tracker tracker = new Tracker();
        Item item = new Item("new Item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId() + 1),
                "edited Item"
        };
        Input input = new StubInput(answers);
        new EditAction().execute(input, tracker);
        Item expected = tracker.findById(item.getId());
        assertThat(expected.getName(), is("new Item"));
    }
}