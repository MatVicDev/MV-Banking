package br.com.mvbanking.accountwallet.application.service;

import br.com.mvbanking.accountwallet.application.port.in.RegisterClientCommand;
import br.com.mvbanking.accountwallet.application.port.in.RegisterClientUseCase;
import br.com.mvbanking.accountwallet.application.port.out.ClientRepository;
import br.com.mvbanking.accountwallet.domain.client.Client;
import org.springframework.stereotype.Service;

@Service
public class RegisterClientService implements RegisterClientUseCase {
    private final ClientRepository repository;

    public RegisterClientService(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Client registerClient(RegisterClientCommand command) {
        Client client = new Client(command.name(), command.dateOfBirth(), command.cpf(), command.phoneNumber(), command.address());

        if (repository.existsByCpf(client.getCpf())) {
            throw new IllegalArgumentException("Client with CPF " + client.getCpf().getValue() + " already exists");
        }

        repository.save(client);

        return client;
    }
}
