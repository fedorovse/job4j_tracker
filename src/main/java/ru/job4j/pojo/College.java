package ru.job4j.pojo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class College {

    public static void main(String[] args) {
        Student sergey = new Student();
        sergey.setName("Sergey");
        sergey.setSurname("Fedorov");
        sergey.setPatronymic("Evgenevich");
        sergey.setGroup("RT5-52");
        sergey.setReceiptDate(LocalDateTime.now());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String printDate = sergey.getReceiptDate().format(formatter);

        System.out.println("Студент: " + sergey.getName() + System.lineSeparator()
        + "Фамилия: " + sergey.getSurname() + System.lineSeparator()
        + "Отчество: " + sergey.getPatronymic() + System.lineSeparator()
        + "Группа: " + sergey.getGroup() + System.lineSeparator()
        + "Дата поступления: " + printDate + " г.");
    }
}
