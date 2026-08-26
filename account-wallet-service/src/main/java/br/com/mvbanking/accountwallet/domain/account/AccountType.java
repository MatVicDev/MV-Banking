package br.com.mvbanking.accountwallet.domain.account;

import java.math.BigDecimal;

public enum AccountType {
    CURRENT(new BigDecimal(-100)),
    SAVINGS(BigDecimal.ZERO);

    private final BigDecimal overdraftFloor;

    AccountType(BigDecimal overdraftFloor) {
        this.overdraftFloor = overdraftFloor;
    }

    public BigDecimal getOverdraftFloor() {
        return overdraftFloor;
    }
}