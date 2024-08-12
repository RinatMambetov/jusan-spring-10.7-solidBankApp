package ru.rinat.solidBankApp;

import java.util.Scanner;

public class MyCLI implements CLIUI {
    private final Scanner scanner;

    public MyCLI() {
        this.scanner = new Scanner(System.in);
    }

    public MyCLI(Scanner scanner) {
        this.scanner = scanner;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public double requestClientAmount() {
        System.out.println("Enter client amount:");
        return scanner.nextDouble();
    }

    public String requestClientAccountNumber() {
        System.out.println("Enter client account number (id):");
        return scanner.next();
    }

    @Override
    public AccountType requestAccountType() {
        System.out.println("Choose account type:");
        System.out.println("[CHECKING, SAVING, FIXED]");
        return switch (scanner.next().toUpperCase()) {
            case "CHECKING" -> AccountType.CHECKING;
            case "SAVING" -> AccountType.SAVING;
            case "FIXED" -> AccountType.FIXED;
            default -> null;
        };
    }
}
