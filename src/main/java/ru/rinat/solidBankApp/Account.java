package ru.rinat.solidBankApp;

import java.util.Objects;

public class Account {
    private AccountType accountType;
    private String id;
    private String clientId;
    private double balance;
    private boolean withdrawAllowed;

    public Account(AccountType accountType, String id, String clientId, double balance, boolean withdrawAllowed) {
        this.accountType = accountType;
        this.id = id;
        this.clientId = clientId;
        this.balance = balance;
        this.withdrawAllowed = withdrawAllowed;
    }

    protected double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountType == account.accountType
                && Objects.equals(id, account.id)
                && Objects.equals(clientId, account.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountType, id, clientId);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountType=" + accountType +
                ", id='" + id + '\'' +
                ", clientId='" + clientId + '\'' +
                ", withdrawAllowed=" + withdrawAllowed +
                '}';
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public boolean isWithdrawAllowed() {
        return withdrawAllowed;
    }

    public void setWithdrawAllowed(boolean withdrawAllowed) {
        this.withdrawAllowed = withdrawAllowed;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
