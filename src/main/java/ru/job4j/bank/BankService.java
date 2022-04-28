package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()
                && !users.get(user.get()).contains(account)) {
            users.get(user.get()).add(account);
        }
    }

    /**
     * Осуществляет поиск пользователя в базе по паспорту, и если
     * находит, то возвращает пользователя, а если нет, то null
     * @param passport String
     * @return User or null
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(x -> x.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Осуществляет поиск счета по переданным паспорту пользоватля и реквизитам счета
     * если счет найден, то вернет Account, если нет, то null
     * @param passport String
     * @param requisite String
     * @return Account or null
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(x -> x.getRequisite().equals(requisite))
                    .findFirst();
        }
        return  Optional.empty();
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
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent()
                && destAccount.isPresent()
                && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}