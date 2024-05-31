package ru.job4j.hashmap;

import java.util.List;

/**
 * Модель данных описывает:
 * name - Имя ученика
 * subjects - список объектов Subject (name - название предмета, score - аттестационный балл)
 */
public record Pupil(String name, List<Subject> subjects) {
}
