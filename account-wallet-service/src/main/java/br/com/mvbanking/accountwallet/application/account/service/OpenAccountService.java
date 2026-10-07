package br.com.mvbanking.accountwallet.application.account.service;

import br.com.mvbanking.accountwallet.application.account.port.in.OpenAccountCommand;
import br.com.mvbanking.accountwallet.application.account.port.in.OpenAccountUseCase;
import br.com.mvbanking.accountwallet.application.account.port.out.AccountRepository;
import br.com.mvbanking.accountwallet.domain.account.Account;

public class OpenAccountService implements OpenAccountUseCase {
    private final AccountRepository accountRepository;

    public OpenAccountService (AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account openAccount(OpenAccountCommand command) {
        if (command == null) {
            throw new IllegalArgumentException("Command cannot be null");
        }

        Account account = new Account(
                command.clientId(),
                command.accountType());

        accountRepository.save(account);

        return account;
    }
}
