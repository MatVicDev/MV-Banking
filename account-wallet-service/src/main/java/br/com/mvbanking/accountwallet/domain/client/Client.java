package br.com.mvbanking.accountwallet.domain.client;

import java.time.LocalDate;
import java.util.UUID;

public class Client {
    private UUID id;
    private String name;
    private LocalDate dateOfBirth;
    private CPF cpf;
    private String phoneNumber;
    private Address address;

    public Client(String name, LocalDate dateOfBirth, String cpf, String phoneNumber, Address address) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.cpf = CPF.validar(cpf);
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
