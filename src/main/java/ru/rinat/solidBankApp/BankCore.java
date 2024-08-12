package ru.rinat.solidBankApp;

public class BankCore {
    private static long id = 0;
    private final AccountCreationService accountCreation;
    private long lastAccountNumber = 1;

    public BankCore(AccountCreationService accountCreation) {
        this.accountCreation = accountCreation;
        id++;
    }

    public void createNewAccount(AccountType accountType, String clientId) {
        accountCreation.create(accountType, id, clientId, lastAccountNumber);
        incrementLastAccountNumber();
    }

    private void incrementLastAccountNumber() {
        lastAccountNumber++;
    }
}
