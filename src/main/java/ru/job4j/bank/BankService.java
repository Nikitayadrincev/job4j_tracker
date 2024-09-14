package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                users.remove(user);
            }
        }
    }

    public void addAccount(String passport, Account account) {
        User byPassport = findByPassport(passport);
        if (byPassport != null) {
            List<Account> value = users.get(byPassport);
            if (value.isEmpty() || !value.contains(account)) {
                value.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User byPassport = findByPassport(passport);
        if (byPassport != null) {
            List<Account> value = users.get(byPassport);

            if (!value.isEmpty()) {
                for (Account a : value) {
                    if (a.getRequisite().equals(requisite)) {
                        return a;
                    }
                }
            }
        }
        return null;
    }

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
