package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFolder {
    /**
     * Метод выбирает из переданного списка значения соответствующие услувию Predicate
     * и добавляет их в новый список
     * @param list List
     * @param pred Predicate
     * @return List с отфильтрованными значениями
     */
    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        List<Folder> result = new ArrayList<>();
        for (Folder folder : list) {
            if (pred.test(folder)) {
                result.add(folder);
            }
        }
        return result;
    }
}