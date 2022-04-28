package ru.job4j.search;

import org.junit.Test;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByKey() {
        var phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        var rsl = phoneDictionary.find("ya").get(0).getName();
        var expected = "Petr";
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenFindByKeyReturnEmptyList() {
        var phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        var rsl = phoneDictionary.find("VVV").size();
        var expected = 0;
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }
}