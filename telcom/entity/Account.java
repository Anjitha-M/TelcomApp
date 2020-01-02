package com.deloitte.telcom.entity;

public class Account {
    private String phoneNo;
    private String name;
    private double balance;
    private String accType;

    public Account() {
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public Account(String phoneNo, String name, double balance, String accType) {
        this.phoneNo = phoneNo;
        this.name = name;
        this.balance = balance;
        this.accType = accType;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Account)) {
            return false;
        }
        Account that = (Account) o;
        return that.phoneNo.equals(this.phoneNo);
    }


}