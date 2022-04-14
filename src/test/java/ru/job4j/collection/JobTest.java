package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.equalTo;

public class JobTest {

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorJobAscByName() {
        int result = new JobAscByName().compare(
                new Job("job a", 1),
                new Job("job b", 1)
        );
        assertThat(result, lessThan(0));
    }

    @Test
    public void whenComparatorJobDescByName() {
        int result = new JobDescByName().compare(
                new Job("job a", 1),
                new Job("job b", 1)
        );
        assertThat(result, greaterThan(0));
    }

    @Test
    public void whenComparatorJobAscByPriority() {
        int result = new JobAscByPriority().compare(
                new Job("job a", 1),
                new Job("job a", 2)
        );
        assertThat(result, lessThan(0));
    }

    @Test
    public void whenComparatorJobDescByPriority() {
        int result = new JobDescByPriority().compare(
                new Job("job a", 1),
                new Job("job a", 2)
        );
        assertThat(result, greaterThan(0));
    }

    @Test
    public void whenComparatorJobAscByPriorityThenJobDescByName() {
        Comparator<Job> comparator = new JobAscByPriority().thenComparing(new JobDescByName());
        int result = comparator.compare(
                new Job("job a", 1),
                new Job("job b", 1)
        );
        assertThat(result, greaterThan(0));
    }

    @Test
    public void whenComparatorJobDescByPriorityThenJobDescByName() {
        Comparator<Job> comparator = new JobAscByPriority().thenComparing(new JobDescByName());
        int result = comparator.compare(
                new Job("job a", 1),
                new Job("job a", 1)
        );
        assertThat(result, equalTo(0));
    }
}