package br.com.mvbanking.accountwallet.domain.account;

import java.math.BigDecimal;
import java.util.UUID;

public class Account {
    private UUID clientId;
    private int number;
    private int agency;
    private Money balance;
    private AccountType accountType;
    private AccountStatus accountStatus;

    public Account(UUID clientId, int number, int agency, Money balance, AccountType accountType, AccountStatus accountStatus) {
        this.clientId = clientId;
        this.number = number;
        this.agency = agency;
        this.balance = new Money(balance.getAmount());
        this.accountType = accountType;
        this.accountStatus = accountStatus;
    }

    public void deposit(Money amount) {
        this.balance = this.balance.add(amount.getAmount());
    }

    public void withdraw(Money amount) {
        BigDecimal balanceAfter = this.balance.getAmount().subtract(amount.getAmount());

        if (balanceAfter.compareTo(this.accountType.getOverdraftFloor()) < 0) {
            throw new IllegalArgumentException("Insufficient funds for withdrawal");
        }

        this.balance = new Money(balanceAfter);
    }

    public Money generateExtract() {
        return new Money(this.balance.getAmount());
    }
}
