package ru.rinat.solidBankApp;

public class SavingAccount extends AccountWithdraw {
    public SavingAccount(AccountType accountType, String id, String clientId, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientId, balance, withdrawAllowed);
    }
}
