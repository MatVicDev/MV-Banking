package br.com.mvbanking.accountwallet.application.port.in;

import br.com.mvbanking.accountwallet.domain.client.Client;

public interface RegisterClientUseCase {

    Client registerClient(RegisterClientCommand command);
}
