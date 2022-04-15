package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс является моделью данных и служит для хранения данных пользоватея
 * @author Федоров Сергей
 * @version 1.0
 */
public class User {
    /**
     * Паспорт пользователя хранится в поле типа String
     */
    private String passport;
    /**
     * Имя пользователя хранится в поле типа String
     */
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Возвращает номер паспорта
     * @return String passport
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Задает passport переднанным значением
     * @param passport String
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод возвращает имя пользователя
     * @return String username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Задает Имя пользователя, переданным значением
     * @param username String
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}