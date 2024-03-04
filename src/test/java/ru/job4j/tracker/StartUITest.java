package ru.job4j.tracker;

import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;
import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.Validate;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.Stub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class StartUITest {

    @Test
    public void whenExit() {
        Output out = new Stub();
        Input in = new ru.job4j.tracker.input.Stub(new String[]{"0"});
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new Stub();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        List<UserAction> actions = Arrays.asList(new Replace(out), new Exit());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                        "Menu:" + ln
                                + "0. Edit item" + ln
                                + "1. Exit Program" + ln
                                + "=== Replace item ===" + ln
                                + "Заявка заменена" + ln
                                + "Menu:" + ln
                                + "0. Edit item" + ln
                                + "1. Exit Program" + ln
                )
        );
    }

    @Test
    public void whenFindByIdIsSuccessfully() {
        Output out = new Stub();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"0", String.valueOf(one.getId()), "1"}
        );
        List<UserAction> actions = Arrays.asList(new FindById(out), new Exit());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenFindByIdIsFail() {
        Output out = new Stub();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"0", String.valueOf(one.getId() + 1), "1"}
        );
        List<UserAction> actions = Arrays.asList(new FindById(out), new Exit());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + "Заявка с id: " + (one.getId() + 1) + " не найдена" + ln
                        + "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenFindByNameIsSuccessfully() {
        Output out = new Stub();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"0", String.valueOf(one.getName()), "1"}
        );
        List<UserAction> actions = Arrays.asList(new FindByName(out), new Exit());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Find items by name ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenFindByNameIsFail() {
        Output out = new Stub();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"0", one.getName() + "g", "1"}
        );
        List<UserAction> actions = Arrays.asList(new FindByName(out), new Exit());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Find items by name ===" + ln
                        + "Заявки с именем: " + one.getName() + "g" + " не найдены" + ln
                        + "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenShowAllIsSuccessfully() {
        Output out = new Stub();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test2"));
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"0", "1"}
        );
        List<UserAction> actions = Arrays.asList(new ShowAll(out), new Exit());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + one + ln
                        + two + ln
                        + "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenShowAllIsFail() {
        Output out = new Stub();
        Tracker tracker = new Tracker();
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"0", "1"}
        );
        List<UserAction> actions = Arrays.asList(new ShowAll(out), new Exit());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + "В хранилище пока нет заявок" + ln
                        + "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new Stub();
        Tracker tracker = new Tracker();
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"1", "0"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "Некорректный ввод. Введите номер пункта меню от 0 до 0" + ln
                        + "Menu:" + ln
                        + "0. Exit Program" + ln
        ));
    }

    @Test
    public void whenStringInsteadOfInt() {
        Output out = new Stub();
        Tracker tracker = new Tracker();
        Input in = new Validate(new ru.job4j.tracker.input.Stub(new String[]{"vv", "0"}), out);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "Пожалуйста, введите корректные данные" + ln
        ));
    }

    @Test
    public void whenInvalidInput() {
        Output out = new Stub();
        Input in = new ru.job4j.tracker.input.Stub(
                new String[] {"one", "1"}
        );
        Validate input = new Validate(in, out);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInputNumbers() {
        Output out = new Stub();
        String[] numbers = new String[] {"0", "1", "2", "3", "4", "5", "6"};
        Input in = new ru.job4j.tracker.input.Stub(numbers);
        Validate input = new Validate(in, out);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(0));
        selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
        selected = input.askInt("Enter menu:");
        assertThat(selected, is(2));
        selected = input.askInt("Enter menu:");
        assertThat(selected, is(3));
        selected = input.askInt("Enter menu:");
        assertThat(selected, is(4));
        selected = input.askInt("Enter menu:");
        assertThat(selected, is(5));
        selected = input.askInt("Enter menu:");
        assertThat(selected, is(6));
    }

    @Test
    public void whenNegativeNumberInput() {
        Output out = new Stub();
        Input in = new ru.job4j.tracker.input.Stub(
                new String[] {"-5"}
        );
        Validate input = new Validate(in, out);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-5));
    }
}