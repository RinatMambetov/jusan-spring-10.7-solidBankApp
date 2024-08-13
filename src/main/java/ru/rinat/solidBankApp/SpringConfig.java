package ru.rinat.solidBankApp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    MyCLI myCLI() {
        return new MyCLI();
    }

    @Bean
    MemoryAccountDAO memoryAccountDAO() {
        return new MemoryAccountDAO();
    }

    @Bean
    AccountCreationServiceImpl accountCreationServiceImpl() {
        return new AccountCreationServiceImpl(memoryAccountDAO());
    }

    @Bean
    BankCore bankCore() {
        return new BankCore(accountCreationServiceImpl());
    }

    @Bean
    AccountListingServiceImpl accountListingServiceImpl() {
        return new AccountListingServiceImpl(memoryAccountDAO());
    }

    @Bean
    AccountBasicCLI accountBasicCLI() {
        return new AccountBasicCLI(myCLI(), bankCore(), accountListingServiceImpl());
    }
}
