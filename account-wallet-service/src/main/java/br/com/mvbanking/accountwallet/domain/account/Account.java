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
        this.balance = balance;
        this.accountType = accountType;
        this.accountStatus = accountStatus;
    }
}
