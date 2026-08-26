package br.com.mvbanking.accountwallet.domain.account;

import java.math.BigDecimal;

public class Money {
    private final BigDecimal amount;

    public Money(BigDecimal amount) {
        if (amount == null) {
            throw new IllegalArgumentException("Amount cannot be null");
        }

        this.amount = amount;
    }

    public Money add(BigDecimal amount) {
        return new Money(this.amount.add(amount));
    }

    public Money subtract(BigDecimal amount) {
        return new Money(this.amount.subtract(amount));
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public int hashCode() {
        return amount.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Money other = (Money) obj;
        return amount.compareTo(other.amount) == 0;
    }
}
