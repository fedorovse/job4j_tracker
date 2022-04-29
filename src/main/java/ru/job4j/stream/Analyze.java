package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс получает статистику по аттестатам
 */
public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(p -> p.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(-1D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(p -> new Tuple(p.getName(), p.getSubjects()
                .stream()
                .mapToInt(Subject::getScore)
                .average()
                .orElse(-1D)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return List.of();
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(p -> new Tuple(p.getName(), p.getSubjects()
                .stream()
                .mapToInt(Subject::getScore)
                .sum()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .get();
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return null;
    }
}