package ru.rinat.solidBankApp;

import java.util.List;

public interface AccountListingService {
    public Account getClientAccount(String clientId, String accountId);

    public AccountWithdraw getClientWithdrawAccount(String clientId, String accountId);

    public List<Account> getClientAccounts(String clientId);

    public List<Account> getClientAccountsByType(String clientId, AccountType accountType);
}
