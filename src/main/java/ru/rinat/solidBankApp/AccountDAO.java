package ru.rinat.solidBankApp;

import java.util.List;

public interface AccountDAO {
    public List<Account> getClientAccounts(String clientId);

    public void createNewAccount(Account account);

    public void updateAccount(Account account);

    public List<Account> getClientAccountsByType(String clientId, AccountType accountType);

    public AccountWithdraw getClientWithdrawAccount(String clientId, String accountId);

    public Account getClientAccount(String clientId, String accountId);
}
