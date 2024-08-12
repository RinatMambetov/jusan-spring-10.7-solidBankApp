package ru.rinat.solidBankApp;

public class AccountCreationServiceImpl implements AccountCreationService {
    private final AccountDAO accountDAO;

    public AccountCreationServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void create(AccountType accountType, long bankId, String clientId, long accountId) {
        Account account = new Account(accountType, String.valueOf(accountId), clientId, 0, false);
        accountDAO.createNewAccount(account);
    }
}
