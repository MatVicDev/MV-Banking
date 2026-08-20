package br.com.mvbanking.accountwallet.domain.client;

public class CPF {
    private String value;

    public CPF(String value) {
        this.value = value;
    }

    public static CPF validate(String cpf) {
        if (cpf == null) return null;

        String cleanCpf = cpf.replaceAll("\\D", "");

        if (isCPF(cleanCpf)) {
            return new CPF(cleanCpf);
        }

        throw new IllegalArgumentException("Invalid CPF!");
    }

    private static boolean isCPF(String cpf) {
        if (cpf.length() != 11) return false;

        if (cpf.matches("(\\d)\\1{10}")) return false;

        try {
            int soma = 0;
            int peso = 10;
            for (int i = 0; i < 9; i++) {
                soma += (cpf.charAt(i) - '0') * peso--;
            }

            int resto = 11 - (soma % 11);
            char digito1 = (resto == 10 || resto == 11) ? '0' : (char) (resto + '0');

            soma = 0;
            peso = 11;
            for (int i = 0; i < 10; i++) {
                soma += (cpf.charAt(i) - '0') * peso--;
            }

            resto = 11 - (soma % 11);
            char digito2 = (resto == 10 || resto == 11) ? '0' : (char) (resto + '0');

            return (digito1 == cpf.charAt(9)) && (digito2 == cpf.charAt(10));
        } catch (Exception e) {
            return false;
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        CPF other = (CPF) obj;
        return value.equals(other.value);
    }
}
