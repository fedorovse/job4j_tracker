package ru.job4j.hashmap;

/**
 * Модель данных для представления результатов:
 * name - Имя ученика или название школьного предмета
 * score - балл
 */
public record Label(String name, double score) implements Comparable<Label> {

    @Override
    public int compareTo(Label o) {
        return Double.compare(this.score, o.score);
    }
}
