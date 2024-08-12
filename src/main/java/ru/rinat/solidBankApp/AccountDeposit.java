package ru.rinat.solidBankApp;

public class AccountDeposit extends Account {
    public AccountDeposit(AccountType accountType, String id, String clientId, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientId, balance, withdrawAllowed);
    }
}
