package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByKey() {
        PhoneDictionary phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        String rsl = phoneDictionary.find("ya").get(0).getName();
        String expected = "Petr";
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenFindByKeyReturnEmptyList() {
        PhoneDictionary phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        int rsl = phoneDictionary.find("VVV").size();
        int expected = 0;
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }
}