package ru.rinat.solidBankApp;

import java.util.ArrayList;
import java.util.List;

public class MemoryAccountDAO implements AccountDAO {
    private final List<Account> accountList = new ArrayList<>();

    @Override
    public List<Account> getClientAccounts(String clientId) {
        return accountList.stream()
                .filter(account -> account.getClientId().equals(clientId))
                .toList();
    }

    @Override
    public void createNewAccount(Account account) {
        accountList.add(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountList.stream()
                .filter(a -> a.equals(account))
                .findFirst()
                .ifPresent(a -> accountList.set(accountList.indexOf(a), account));
    }

    @Override
    public List<Account> getClientAccountsByType(String clientId, AccountType accountType) {
        return accountList.stream()
                .filter(account -> account.getClientId().equals(clientId))
                .filter(account -> account.getAccountType().equals(accountType))
                .toList();
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientId, String accountId) {
        return (AccountWithdraw) accountList.stream()
                .filter(account -> account.getClientId().equals(clientId))
                .filter(account -> account.getId().equals(accountId))
                .filter(Account::isWithdrawAllowed)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Account getClientAccount(String clientId, String accountId) {
        return accountList.stream()
                .filter(account -> account.getClientId().equals(clientId))
                .filter(account -> account.getId().equals(accountId))
                .findFirst()
                .orElse(null);
    }
}
