package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает модель банковской системы, которая регистрирует пользователя,
 * удаляет пользователя, добавляет пользователю банковский счет и переводит деньги
 * с одного счета на другой
 */
public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в hashMap
     * @param user пользователь, который добавляется в hashMap
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод удаляет пользователя по ключу passport
     * @param passport ключ по которому находят пользователя
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод добавляет пользователю банковский счет
     * Если пользователь не существует или у пользователя есть такой account,
     * то account не добавится
     * @param passport ключ по которому находят пользователя
     * @param account банковский счет, который добавится пользователю
     */
    public void addAccount(String passport, Account account) {
        User byPassport = findByPassport(passport);
        if (byPassport != null) {
            List<Account> value = users.get(byPassport);
            if (value.isEmpty() || !value.contains(account)) {
                value.add(account);
            }
        }
    }

    /**
     * Метод находит пользователя по ключю passport
     * @param passport ключ по которому находят пользователя
     * @return возвращает пользователя или null если пользователя не существует
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод находит банковский счет пользователя
     * @param passport ключ по которому находят пользователя
     * @param requisite ключ по которому находят счет пользователя
     * @return возвращает счет пользователя или null если такого пользователя/счета не существует
     */
    public Account findByRequisite(String passport, String requisite) {
        User byPassport = findByPassport(passport);
        if (byPassport != null) {
            List<Account> value = users.get(byPassport);

            for (Account a : value) {
                if (a.getRequisite().equals(requisite)) {
                    return a;
                }
            }

        }
        return null;
    }

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт
     * Сначала находятся счета для перевода, если какого либо счета не существует или недостаточно средств для
     * перевода, то возвращается false
     * @param sourcePassport ключ по которому находят пользователя, с которого переводят
     * @param sourceRequisite ключ по которому находят счет пользователя, с которого пеерводят
     * @param destinationPassport ключ по которому находят пользователя, на который переводят
     * @param destinationRequisite ключ по которому находят счет пользователя, на который пеерводят
     * @param amount сумма перевода
     * @return Возвращает true если перевод прошел, если счёт не найден или не хватает денег на счёте
     * sourcePassport, то возвращает false
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount != null && sourceAccount.getBalance() >= amount
                && destinationAccount != null) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            result = true;
        }
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
