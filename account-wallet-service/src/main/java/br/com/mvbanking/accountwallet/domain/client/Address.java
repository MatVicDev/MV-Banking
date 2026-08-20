package br.com.mvbanking.accountwallet.domain.client;

public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private int number;

    public Address(String street, String city, String state, String zipCode, int number) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.number = number;
    }

    @Override
    public int hashCode() {
        int result = street.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + state.hashCode();
        result = 31 * result + zipCode.hashCode();
        result = 31 * result + number;

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Address other = (Address) obj;

        return street.equals(other.street) &&
               city.equals(other.city) &&
               state.equals(other.state) &&
               zipCode.equals(other.zipCode) &&
               number == other.number;
    }
}
