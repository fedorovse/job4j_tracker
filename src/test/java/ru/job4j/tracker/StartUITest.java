package ru.job4j.tracker;

import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import java.util.SplittableRandom;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(new String[] {"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item name"));
        String replacedItem = "NEW Item NAME";
        Input in = new StubInput(new String[] {"0", String.valueOf(item.getId()), replacedItem, "1"});
        UserAction[] actions = {
          new ReplaceAction(),
          new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedItem));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item"));
        Input in = new StubInput(new String[] {"0", String.valueOf(item.getId()), "1"});
        UserAction[] actions = {
                new DeleteAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }
}