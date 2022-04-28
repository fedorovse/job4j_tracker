package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class StudentLevel {
    /**
     * Метод осуществляет поиск студентов в базе с баллом выше переданного
     * @param students List список студентов
     * @param bound int балл (не включительно) выше которого нужен список студентов
     * @return List список студентов с баллом выше переданного
     */
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(st -> st != null)
                .sorted((left, right) -> Integer.compare(right.getScore(), left.getScore()))
                .takeWhile(st -> st.getScore() > bound)
                .collect(Collectors.toList());
    }
}