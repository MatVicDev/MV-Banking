package br.com.mvbanking.accountwallet.domain.client;

public class PhoneNumber {
    private String number;

    public PhoneNumber(String number) {
        this.number = number;
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PhoneNumber other = (PhoneNumber) obj;
        return number.equals(other.number);
    }
}
