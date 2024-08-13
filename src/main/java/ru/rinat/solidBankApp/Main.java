package ru.rinat.solidBankApp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
        
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        MyCLI myCLI = context.getBean("myCLI", MyCLI.class);
        Scanner scanner = myCLI.getScanner();
        String clientId = myCLI.requestClientAccountNumber();
        System.out.println(help);
        AccountDAO memoryAccountDAO = context.getBean("memoryAccountDAO", MemoryAccountDAO.class);
        AccountCreationService accountCreationService =
                context.getBean("accountCreationServiceImpl", AccountCreationServiceImpl.class);
        BankCore bankCore = context.getBean("bankCore", BankCore.class);
        AccountListingService accountListingService =
                context.getBean("accountListingServiceImpl", AccountListingServiceImpl.class);
        AccountBasicCLI accountBasicCLI = context.getBean("accountBasicCLI", AccountBasicCLI.class);

        while (scanner.hasNext()) {
            switch (scanner.next()) {
                case "1" -> accountBasicCLI.getAccounts(clientId);
                case "2" -> accountBasicCLI.createAccountRequest(clientId);
                case "6" -> System.out.println(help);
                case "7" -> System.exit(0);
                default -> System.out.println("Wrong operation number");
            }
        }
        context.close();
    }
}
