package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> names = new HashMap<>();
        names.put("aa@yandex.ru", "Vasa");
        names.put("bb@bk.ru", "Ura");
        names.put("vv@mail.ru", "Sasha");
        names.put("mr@ru.ru", "Sergey");
        for (Map.Entry<String, String> entry: names.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " = " + value);
        }
        System.out.println();
        for (String key: names.keySet()) {
            String value = names.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
