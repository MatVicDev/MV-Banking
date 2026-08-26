package br.com.mvbanking.accountwallet.domain.account;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    public void shouldDeposit() {
        Account account = new Account(
                UUID.fromString("12345678-1234-1234-1234-123456789012"),
                123,
                123456,
                new Money(new BigDecimal("0.00")),
                AccountType.CURRENT,
                AccountStatus.ACTIVE);
        account.deposit(new Money(new BigDecimal("100.00")));

        assertEquals(new Money(new BigDecimal("100.00")), account.generateExtract());
    }

    @Test
    public void shouldWithdraw() {
        Account account = new Account(
                UUID.fromString("12345678-1234-1234-1234-123456789012"),
                123,
                123456,
                new Money(new BigDecimal("100.00")),
                AccountType.CURRENT,
                AccountStatus.ACTIVE);
        account.withdraw(new Money(new BigDecimal("50.00")));

        assertEquals(new Money(new BigDecimal("50.00")), account.generateExtract());
    }

    @Test
    public void shouldNotWithdrawWhenInsufficientFundsInCurrentAccount() {
        Account account = new Account(
                UUID.fromString("12345678-1234-1234-1234-123456789012"),
                123,
                123456,
                new Money(new BigDecimal("0.00")),
                AccountType.CURRENT,
                AccountStatus.ACTIVE);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(new Money(new BigDecimal("150.00")));
        });

        assertEquals("Insufficient funds for withdrawal", exception.getMessage());
    }

    @Test
    public void shouldNotWithdrawWhenInsufficientFundsInSavingsAccount() {
        Account account = new Account(
                UUID.fromString("12345678-1234-1234-1234-123456789012"),
                123,
                123456,
                new Money(new BigDecimal("0.00")),
                AccountType.SAVINGS,
                AccountStatus.ACTIVE);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(new Money(new BigDecimal("50.00")));
        });

        assertEquals("Insufficient funds for withdrawal", exception.getMessage());
    }

    @Test
    public void shouldNotDepositWhenAccountIsInactive() {
        Account account = new Account(
                UUID.fromString("12345678-1234-1234-1234-123456789012"),
                123,
                123456,
                new Money(new BigDecimal("0.00")),
                AccountType.CURRENT,
                AccountStatus.INACTIVE);

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            account.deposit(new Money(new BigDecimal("50.00")));
        });

        assertEquals("Cannot deposit to an inactive or blocked account", exception.getMessage());
    }

    @Test
    public void shouldNotWithdrawWhenAccountIsInactive() {
        Account account = new Account(
                UUID.fromString("12345678-1234-1234-1234-123456789012"),
                123,
                123456,
                new Money(new BigDecimal("100.00")),
                AccountType.CURRENT,
                AccountStatus.INACTIVE);

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            account.withdraw(new Money(new BigDecimal("50.00")));
        });

        assertEquals("Cannot withdraw from an inactive or blocked account", exception.getMessage());
    }

    @Test
    public void shouldNotDepositWhenAccountIsBlocked() {
        Account account = new Account(
                UUID.fromString("12345678-1234-1234-1234-123456789012"),
                123,
                123456,
                new Money(new BigDecimal("0.00")),
                AccountType.CURRENT,
                AccountStatus.BLOCKED);

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            account.deposit(new Money(new BigDecimal("50.00")));
        });

        assertEquals("Cannot deposit to an inactive or blocked account", exception.getMessage());
    }

    @Test
    public void shouldNotWithdrawWhenAccountIsBlocked() {
        Account account = new Account(
                UUID.fromString("12345678-1234-1234-1234-123456789012"),
                123,
                123456,
                new Money(new BigDecimal("100.00")),
                AccountType.CURRENT,
                AccountStatus.BLOCKED);

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            account.withdraw(new Money(new BigDecimal("50.00")));
        });

        assertEquals("Cannot withdraw from an inactive or blocked account", exception.getMessage());
    }
}