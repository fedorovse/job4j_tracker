package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    /**
     * Данные о пользователях хранятся в коллекции типа HashMap
     * где ключ это пользователь (User),
     * а значение это коллекция типа ArrayList со счетами данного пользователя
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в коллекцию при условии, что
     * такого пользователя там нет
     * @param user User
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет пользователю новый счет при условии, что
     * пользоватль с таким паспортом есть в базе.
     * @param passport String
     * @param account Account
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (!users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Осуществляет поиск пользователя в базе по паспорту, и если
     * находит, то возвращает пользователя, а если нет, то null
     * @param passport String
     * @return User or null
     */
    public User findByPassport(String passport) {
        User result = null;
        for (User user: users.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            }
        }
        return result;
    }

    /**
     * Осуществляет поиск счета по переданным паспорту пользоватля и реквизитам счета
     * если счет найден, то вернет Account, если нет, то null
     * @param passport String
     * @param requisite String
     * @return Account or null
     */
    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account: users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    result = account;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод осуществляет перевод средств с счета одного пользователя на
     * счет другого пользователя
     * @param srcPassport String паспорт отправителя средств
     * @param srcRequisite String реквизиты счета отправителя
     * @param destPassport String паспорт получателя
     * @param destRequisite String счет получателя
     * @param amount double сумма переода
     * @return boolean true если перевод прошел успешно, и false если нет
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}