package br.com.mvbanking.accountwallet.application.account.port.in;

import br.com.mvbanking.accountwallet.domain.account.AccountType;

import java.util.UUID;

public record OpenAccountCommand(UUID clientId, AccountType accountType) {
}
