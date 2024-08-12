package ru.rinat.solidBankApp;

import java.util.List;

public class AccountBasicCLI {
    private final CreateAccountOperationUI createAccountOperationUI;
    private final BankCore bankCore;
    private final AccountListingService accountListing;

    public AccountBasicCLI(CreateAccountOperationUI createAccountOperationUI,
                           BankCore bankCore,
                           AccountListingService accountListing) {
        this.createAccountOperationUI = createAccountOperationUI;
        this.bankCore = bankCore;
        this.accountListing = accountListing;
    }

    public void createAccountRequest(String clientId) {
        MyCLI myCLI = (MyCLI) createAccountOperationUI;
        int clientAmount = (int) myCLI.requestClientAmount();
        while (clientAmount > 0) {
            AccountType accountType = myCLI.requestAccountType();
            bankCore.createNewAccount(accountType, clientId);
            clientAmount--;
        }
    }

    public void getAccounts(String clientId) {
        List<Account> clientAccounts = accountListing.getClientAccounts(clientId);
        clientAccounts.forEach(account -> bankCore.createNewAccount(account.getAccountType(), clientId));
    }
}
