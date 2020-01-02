package com.deloitte.telcom.service;

import com.deloitte.telcom.dao.AccountDaoImpl;
import com.deloitte.telcom.entity.Account;
import com.deloitte.telcom.exceptions.InvalidPhoneNumberException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class AccountServiceImplTest {
    @Test
    public void testCreateAccount_1() {
        AccountServiceImpl service = new AccountServiceImpl(new AccountDaoImpl());
        String ph = "9446012026";
        String name = "Raj";
        String accType = "prepaid";
        double bal = 100;
        Account acc = service.createAccount(ph, name, bal, accType);
        Assert.assertNotNull(acc);
        double returnBal = acc.getBalance();
        Assert.assertEquals(bal, returnBal, 0);
        Assert.assertEquals(name, acc.getName());
        Map<String, Account> store = service.getAccountDao().getStore();
        Account expected = store.get(ph);
        Assert.assertNotNull(expected);
        Assert.assertEquals(expected, acc);
    }

    @Test(expected = InvalidPhoneNumberException.class)
    public void testCreateAccount_2() {
        AccountServiceImpl service = new AccountServiceImpl(new AccountDaoImpl());
        String ph = null;
        String name = "Raj";
        String accType = "prepaid";
        double bal = 100;
        service.createAccount(ph, name, bal, accType);
    }

    @Test
    public void testFindBalance_1() {
        AccountServiceImpl service = new AccountServiceImpl(new AccountDaoImpl());
        String ph = "9446012026";
        String name = "Raj";
        String accType = "prepaid";
        double bal = 100;
        Account acc = service.createAccount(ph, name, bal, accType);
        Map<String, Account> store = service.getAccountDao().getStore();
        store.put(ph, acc);
        Account result = service.findBalance(ph);
        Assert.assertEquals(acc, result);
    }
}
