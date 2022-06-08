package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс получает статистику по аттестатам
 */
public class Analyze {

    /**
     * Вычисляет общий средний балл по всем предметам всех учеников
     * @param stream Pupil на входе поток учеников
     * @return double средний балл по всем предметам всех учеников. Либо -1
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(p -> p.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(-1D);
    }

    /**
     * Вычисляет средний бал по всем предметам для каждого ученика
     * @param stream Pupil поток учеников
     * @return список Tuple в котором имя ученика и его средний балл по всем предметам
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(p -> new Tuple(p.getName(), p.getSubjects()
                .stream()
                .mapToInt(Subject::getScore)
                .average()
                .orElse(-1D)))
                .collect(Collectors.toList());
    }

    /**
     * Вычисляет средний балл по каждому предмету
     * @param stream Pupil поток учеников
     * @return список Tuple в котором название предмета и средний балл по нему
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(p -> p.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(m -> new Tuple(m.getKey(), m.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * Поиск лучшего ученика
     * @param stream Pupil поток учеников
     * @return Tuple в котором имя ученика с мах суммой баллов и сумма баллов
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(p -> new Tuple(p.getName(), p.getSubjects()
                .stream()
                .mapToInt(Subject::getScore)
                .sum()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }

    /**
     * Поиск предмета с наилучшим баллом для всех учеников
     * @param stream Pupil поток учеников
     * @return Tuple с предметом и суммой баллов по предмету (наибольшей)
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(p -> p.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        LinkedHashMap::new,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(m -> new Tuple(m.getKey(), m.getValue()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }
}