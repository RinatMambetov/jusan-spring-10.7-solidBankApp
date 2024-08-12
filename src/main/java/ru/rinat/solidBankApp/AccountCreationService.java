package ru.rinat.solidBankApp;

public interface AccountCreationService {
    public void create(AccountType accountType, long bankId, String clientId, long accountId);
}
