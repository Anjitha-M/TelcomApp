package com.deloitte.telcom.service;

import com.deloitte.telcom.dao.IAccountDao;
import com.deloitte.telcom.entity.Account;

import java.util.Map;
import java.util.Set;

public interface IAccountService {
    Account createAccount(String ph, String name, double bal, String accType);

    Account findBalance(String ph);

    Account RechargeAccount(String ph, double amount);

    Set<Account> ListAccounts();

    void exitApp();

    IAccountDao getAccountDao();

}