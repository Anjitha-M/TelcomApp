package com.deloitte.telcom.dao;

import com.deloitte.telcom.entity.Account;

import java.util.Map;
import java.util.Set;

public interface IAccountDao {
    Account createAccount(String ph, String name, double bal, String accType);

    Account findBalance(String ph);

    Account RechargeAccount(String ph, double amount);

    Set<Account> ListAccounts();

    Map<String, Account> getStore();

    void exitApp();

}