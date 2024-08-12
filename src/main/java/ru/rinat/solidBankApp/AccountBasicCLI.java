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
        CreateAccountOperationUI myCLI = (MyCLI) createAccountOperationUI;
        AccountType accountType = myCLI.requestAccountType();
        if (accountType == null) {
            System.out.println("Please select correct account type");
            return;
        }
        bankCore.createNewAccount(accountType, clientId);
        System.out.println("Bank account created");
    }

    public void getAccounts(String clientId) {
        List<Account> clientAccounts = accountListing.getClientAccounts(clientId);
        System.out.println(clientAccounts);
    }
}
