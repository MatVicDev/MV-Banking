package br.com.mvbanking.accountwallet.application.account.port.in;

import br.com.mvbanking.accountwallet.domain.account.Account;

public interface OpenAccountUseCase {

    Account openAccount(OpenAccountCommand command);
}
