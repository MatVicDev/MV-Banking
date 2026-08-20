package br.com.mvbanking.accountwallet.domain.client;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CPFTest {

    @Test
    void shouldThrowExceptionForInvalidCPF() {
        List<String> cpf = List.of("111.111.111-11", "11111111111", "1111111111", "111111111111");

        cpf.forEach(c ->
                assertThrows(IllegalArgumentException.class, () -> CPF.validate(c)));
    }

    @Test
    void shouldValidateValidCPF() {
        String cpf = "382.910.450-20";
        CPF validateCPF = CPF.validate(cpf);

        assertEquals("38291045020", validateCPF.getValue());
    }
}