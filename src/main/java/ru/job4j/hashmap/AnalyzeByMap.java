package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {

    private static double sumScoreOfPupil(Pupil pupil) {
        double sum = 0.0;
            for (Subject score : pupil.subjects()) {
                sum += score.score();
            }
        return sum;
    }

    /**
     * Вычисляет общий средний балл по всем предметам и всем ученикам
     * @param pupils - список учеников
     * @return - сумма всех оценок всех учеников поделить на общее количество оценок
     */
    public static double averageScore(List<Pupil> pupils) {
        int count = 0;
        double sum = 0.0;
        for (Pupil pupil : pupils) {
            sum += sumScoreOfPupil(pupil);
            count += pupil.subjects().size();
        }
        return sum / count;
    }

    /**
     * Вычисляет средний балл каждого ученика
     * @param pupils - список учеников
     * @return - список объектов Lable в котором Имя ученика, Средний балл ученика по всем предметам
     */
    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            rsl.add(new Label(pupil.name(), sumScoreOfPupil(pupil) / pupil.subjects().size()));
        }
        return rsl;
    }

    private static Map<String, Integer> sumScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> sum = new LinkedHashMap<>();
        for (Pupil pupil: pupils) {
            for (Subject subject: pupil.subjects()) {
                sum.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        return sum;
    }

    /**
     * Вычисляет средний балл по каждому предмету
     * @param pupils - список учеников
     * @return - список объектов Label в котором: Название предмета, Средний балл по
     * этому предмету для всех учеников
     */
    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        Map<String, Integer> sum = sumScoreBySubject(pupils);
        for (Map.Entry<String, Integer> entry: sum.entrySet()) {
            rsl.add(new Label(entry.getKey(), (double) entry.getValue() / pupils.size()));
        }
        return rsl;
    }

    /**
     * Поиск ученика с лучшим суммарным баллом
     * @param pupils - список ученика
     * @return - объект Label в котором: Имя ученика, Сумма баллок по всем предметам
     */
    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            labels.add(new Label(pupil.name(), sumScoreOfPupil(pupil)));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    /**
     * Поиск предмета с большим суммарным баллом
     * @param pupils - список учеников
     * @return - объект Label в котором: Название предмета, Суммарный балл по этому
     * предмету по всем ученикам
     */
    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        Map<String, Integer> sum = sumScoreBySubject(pupils);
        for (Map.Entry<String, Integer> entry : sum.entrySet()) {
            rsl.add(new Label(entry.getKey(), entry.getValue()));
        }
        rsl.sort(Comparator.naturalOrder());
        return rsl.get(rsl.size() - 1);
    }
}