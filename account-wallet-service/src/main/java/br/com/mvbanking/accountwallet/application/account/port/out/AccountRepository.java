package br.com.mvbanking.accountwallet.application.account.port.out;

import br.com.mvbanking.accountwallet.domain.account.Account;

public interface AccountRepository {

    Account findById(String accountId);

    Account findByClientId(String clientId);

    void save(Account account);
}
