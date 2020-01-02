package com.deloitte.telcom.dao;

import com.deloitte.telcom.entity.Account;
import com.deloitte.telcom.exceptions.AccountNotFoundException;
import com.deloitte.telcom.exceptions.InvalidPhoneNumberException;

import java.util.*;

public class AccountDaoImpl implements IAccountDao {
    Map<String, Account> store = new HashMap<>();

    @Override
    public Account createAccount(String ph, String name, double bal, String accType) {
        validatePhoneNumber(ph);
        Account a = new Account(ph, name, bal, accType);
        store.put(a.getPhoneNo(), a); //need to edit code
        return a;
    }

    public void validatePhoneNumber(String ph) {
        if (ph == null || (ph.length() != 10)) {
            throw new InvalidPhoneNumberException("Invalid Phone Number!!!");
        }
    }

    public void validateAccount(Account a) {
        if (a == null) {
            throw new AccountNotFoundException("No account found!!");
        }
    }

    @Override
    public Map<String, Account> getStore() {
        return store;
    }

    @Override
    public Account findBalance(String ph) {
        validatePhoneNumber(ph);
        Account a = store.get(ph);
        validateAccount(a);
        return a;

    }

    @Override
    public Account RechargeAccount(String ph, double amount) {
        validatePhoneNumber(ph);
        Account a = store.get(ph);
        validateAccount(a);
        double bal = a.getBalance();
        bal = bal + amount;
        a.setBalance(bal);
        return a;


    }

    @Override
    public Set<Account> ListAccounts() {
        Collection<Account> acc = store.values();
        Set<Account> accountSet = new HashSet<>(acc);
        return accountSet;
    }

    @Override
    public void exitApp() {
        System.out.println("Exiting...."); //need to edit code
    }
}