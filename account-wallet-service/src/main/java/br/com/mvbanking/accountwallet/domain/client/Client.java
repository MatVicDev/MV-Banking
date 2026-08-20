package br.com.mvbanking.accountwallet.domain.client;

import java.time.LocalDate;
import java.util.UUID;

public class Client {
    private UUID id;
    private String name;
    private LocalDate dateOfBirth;
    private CPF cpf;
    private PhoneNumber phoneNumber;
    private Address address;

    public Client(String name, LocalDate dateOfBirth, String cpf, PhoneNumber phoneNumber, Address address) {
        this.id = UUID.randomUUID();

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.cpf = CPF.validate(cpf);
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
