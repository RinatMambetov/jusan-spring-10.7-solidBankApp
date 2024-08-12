package ru.rinat.solidBankApp;

import java.util.List;

public class AccountListingServiceImpl implements AccountListingService {
    private final AccountDAO accountDAO;

    AccountListingServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public Account getClientAccount(String clientId, String accountId) {
        return accountDAO.getClientAccount(clientId, accountId);
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientId, String accountId) {
        return accountDAO.getClientWithdrawAccount(clientId, accountId);
    }

    @Override
    public List<Account> getClientAccounts(String clientId) {
        return accountDAO.getClientAccounts(clientId);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientId, AccountType accountType) {
        return accountDAO.getClientAccountsByType(clientId, accountType);
    }
}
