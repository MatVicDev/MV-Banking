package br.com.mvbanking.accountwallet.application.port.out;

import br.com.mvbanking.accountwallet.domain.client.CPF;
import br.com.mvbanking.accountwallet.domain.client.Client;

public interface ClientRepository {

    boolean existsByCpf(CPF cpf);

    void save(Client client);
}
