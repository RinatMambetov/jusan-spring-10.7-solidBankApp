package ru.rinat.solidBankApp;

import java.util.Scanner;

public class Main {
    private static final String help =
            """
                    Welcome to CLI bank service
                    Enter operation number:
                    1 - show accounts
                    2 - create account
                    3 - deposit
                    4 - withdraw
                    5 - transfer
                    6 - this message
                    7 - exit""";

    public static void main(String[] args) {

        MyCLI myCLI = new MyCLI();
        Scanner scanner = myCLI.getScanner();
        String clientId = myCLI.requestClientAccountNumber();
        System.out.println(help);
        AccountDAO memoryAccountDAO = new MemoryAccountDAO();
        AccountCreationService accountCreationService = new AccountCreationServiceImpl(memoryAccountDAO);
        BankCore bankCore = new BankCore(accountCreationService);
        AccountListingService accountListingService = new AccountListingServiceImpl(memoryAccountDAO);
        AccountBasicCLI accountBasicCLI = new AccountBasicCLI(myCLI, bankCore, accountListingService);

        while (scanner.hasNext()) {
            switch (scanner.next()) {
                case "1" -> accountBasicCLI.getAccounts(clientId);
                case "2" -> accountBasicCLI.createAccountRequest(clientId);
                case "6" -> System.out.println(help);
                case "7" -> System.exit(0);
                default -> System.out.println("Wrong operation number");
            }
        }
    }
}
