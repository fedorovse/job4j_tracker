package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс является моделью данных. Служит для хранения реквизитов счета и его баланса.
 * @author Fedorov Sergey
 * @version 1.0
 */
public class Account {

    /**
     * Реквизиты счета хранятся в String
     */
    private String requisite;
    /**
     * Баланс счета хранится в поле типа double
     */
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Возвращает реквизиты текущего счета.
     * @return String requisite
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод инициализирует реквизиты счета переданным значением
     * @param requisite String
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод возвращает значение баланса текущего счета
     * @return double balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод заменяет баланс текущего счета переданным значением double
     * @param balance double
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
