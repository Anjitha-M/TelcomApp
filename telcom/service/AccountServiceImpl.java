package com.deloitte.telcom.service;

import com.deloitte.telcom.dao.AccountDaoImpl;
import com.deloitte.telcom.dao.IAccountDao;
import com.deloitte.telcom.entity.Account;
import com.deloitte.telcom.exceptions.InvalidPhoneNumberException;

import java.util.Map;
import java.util.Set;

public class AccountServiceImpl implements IAccountService {
    private IAccountDao dao;

    public AccountServiceImpl(IAccountDao dao) {
        this.dao = dao;
    }

    @Override
    public Account createAccount(String ph, String name, double bal, String accType) {
        Account ac = dao.createAccount(ph, name, bal, accType);
        return ac;
    }

    @Override
    public IAccountDao getAccountDao() {
        return dao;
    }

    @Override
    public Account findBalance(String ph) {
        Account a = dao.findBalance(ph);
        return a;
    }

    @Override
    public Account RechargeAccount(String ph, double amount) {

        Account a = dao.RechargeAccount(ph, amount);
        return a;

    }

    @Override
    public Set<Account> ListAccounts() {
        Set<Account> accounts = dao.ListAccounts();
        return accounts;
    }

    @Override
    public void exitApp() {
        dao.exitApp();
    }


}