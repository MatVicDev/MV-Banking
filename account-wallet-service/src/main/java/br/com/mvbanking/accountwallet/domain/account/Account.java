package br.com.mvbanking.accountwallet.domain.account;

import java.math.BigDecimal;
import java.util.UUID;

public class Account {
    private UUID id;
    private UUID clientId;
    private int number;
    private int agency;
    private Money balance;
    private AccountType accountType;
    private AccountStatus accountStatus;

    public Account(UUID clientId, AccountType accountType) {
        this.id = UUID.randomUUID();
        this.clientId = clientId;
        this.number = generateAccountNumber();
        this.agency = generateAgencyNumber();
        this.balance = new Money(BigDecimal.ZERO);
        this.accountType = accountType;
        this.accountStatus = AccountStatus.ACTIVE;
    }

    private int generateAccountNumber() {
        return (int) (Math.random() * 1000000);
    }

    private int generateAgencyNumber() {
        return (int) (Math.random() * 10000);
    }

    public void deposit(Money amount) {
        if (accountStatus != AccountStatus.ACTIVE) {
            throw new IllegalStateException("Cannot deposit to an inactive or blocked account");
        }

        this.balance = this.balance.add(amount.getAmount());
    }

    public void withdraw(Money amount) {
        if (accountStatus != AccountStatus.ACTIVE) {
            throw new IllegalStateException("Cannot withdraw from an inactive or blocked account");
        }

        BigDecimal balanceAfter = this.balance.getAmount().subtract(amount.getAmount());

        if (balanceAfter.compareTo(this.accountType.getOverdraftFloor()) < 0) {
            throw new IllegalArgumentException("Insufficient funds for withdrawal");
        }

        this.balance = new Money(balanceAfter);
    }

    public void block() {
        this.accountStatus = AccountStatus.BLOCKED;
    }

    public void deactivate() {
        this.accountStatus = AccountStatus.INACTIVE;
    }

    public Money generateExtract() {
        return this.balance;
    }
}
