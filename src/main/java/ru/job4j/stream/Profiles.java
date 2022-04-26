package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }

    /**
     * Метод возвращает отсортированный список (по городу) уникальных адресов клиентов
     * @param profiles List база клиентов
     * @return List список адресов
     */
    public static List<Address> collectSortWithoutDuplicate(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .sorted((x1, x2) -> x1.getCity().compareTo(x2.getCity()))
                .distinct()
                .collect(Collectors.toList());
    }
}
