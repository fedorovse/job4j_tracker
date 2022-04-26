package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToList {

    /**
     * Преобразование двумерного массива в список
     * @param matrix Integer[][]
     * @return List список элементов массива
     */
    public static List<Integer> convert(Integer[][] matrix) {
        return Stream.of(matrix)
                .flatMap(Stream::of)
                .collect(Collectors.toList());
    }
}