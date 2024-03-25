package com.neostore.domain.exception.validation;

public class CnpjValidation {

    public static boolean validate(String cnpj) {
        cnpj = cnpj.replaceAll("\\D", "");

        if (cnpj.length() != 14) {
            return false;
        }

        int[] multiplicadores1 = { 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
        int[] multiplicadores2 = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

        int soma = 0;
        for (int i = 0; i < 12; i++) {
            soma += Character.getNumericValue(cnpj.charAt(i)) * multiplicadores1[i];
        }

        int resto = (soma % 11);
        int digito1 = (resto < 2) ? 0 : 11 - resto;

        soma = 0;
        for (int i = 0; i < 13; i++) {
            soma += Character.getNumericValue(cnpj.charAt(i)) * multiplicadores2[i];
        }

        resto = (soma % 11);
        int digito2 = (resto < 2) ? 0 : 11 - resto;

        return (Character.getNumericValue(cnpj.charAt(12)) == digito1) &&
                (Character.getNumericValue(cnpj.charAt(13)) == digito2);
    }
}
