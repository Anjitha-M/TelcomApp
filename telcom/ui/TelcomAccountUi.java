package com.deloitte.telcom.ui;

import com.deloitte.telcom.dao.AccountDaoImpl;
import com.deloitte.telcom.entity.Account;
import com.deloitte.telcom.service.AccountServiceImpl;
import com.deloitte.telcom.service.IAccountService;

import java.util.Collection;
import java.util.Scanner;
import java.util.Set;

public class TelcomAccountUi {
    private IAccountService as = new AccountServiceImpl(new AccountDaoImpl());

    public static void main(String[] args) {
        TelcomAccountUi tui = new TelcomAccountUi();
        //tui.menu();
        tui.execute();
    }

    public void menu() {
        System.out.println("---------Menu---------------");
        System.out.println("Choose any of the following options to proceed");
        System.out.println("1. Account Balance Enquiry");
        System.out.println("2. Recharge Account");
        System.out.println("3. Create Account");
        System.out.println("4. Exit");
        System.out.println("Enter your choice: ");


    }

    public void execute() {

        int choice = 0;
        for (int i = 0; i < 4; i++) {
            menu();

            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();


            switch (choice) {
                case 1:

                    System.out.println("-------------Account Balance Enquiry--------------");
                    System.out.println("Enter phone number of account to find balance: ");
                    String ph = sc.next();
                    Account fetched = as.findBalance(ph);
                    System.out.println("Balance = " + fetched.getBalance());
                    break;
                case 2:

                    System.out.println("-------Recharging Account -------------");
                    System.out.println("Enter phone number of account to recharge: ");
                    Account recharged = as.RechargeAccount("9446012026", 100);
                    System.out.println("New Balance: " + recharged.getBalance());
                    break;
                case 3:
                    System.out.println("-------Creating Account -------------");
                    //Account a1 = new Account("9446012026", "Ram", 1000, "prepaid");
                    //Account a2 = new Account("9495574686", "Raj", 300, "postpaid");
                    System.out.println("Enter ph.no, name, balance and acc type to create account");
                    String phone = sc.next();
                    String name = sc.next();
                    double b = sc.nextDouble();
                    String acT = sc.next();
                    as.createAccount(phone, name, b, acT);
                    //as.createAccount(a2);
                    Set<Account> ac = as.ListAccounts();
                    print(ac);
                    break;
                case 4:
                    as.exitApp();
                    break;
                default:
                    System.out.println("Your choice is invalid!");

            }
        }

    }

    public void print(Collection<Account> acc) {
        for (Account a : acc) {
            System.out.println("Customer [" + a.getName() +
                    ", Phone Number: " + a.getPhoneNo() + ", Account Balance: " + a.getBalance() + ", Account Type: " + a.getAccType() + "]");
        }
    }


}