package br.com.mvbanking.accountwallet.application.port.in;

import br.com.mvbanking.accountwallet.domain.client.Address;
import br.com.mvbanking.accountwallet.domain.client.PhoneNumber;

import java.time.LocalDate;

public record RegisterClientCommand(
        String name,
        LocalDate dateOfBirth,
        String cpf,
        PhoneNumber phoneNumber,
        Address address) {
}
