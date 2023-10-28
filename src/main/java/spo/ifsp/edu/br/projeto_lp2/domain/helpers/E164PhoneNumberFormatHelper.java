package spo.ifsp.edu.br.projeto_lp2.domain.helpers;

public class E164PhoneNumberFormatHelper {
    public static String format(String phoneNumber) {
        String formattedPhoneNumber = phoneNumber.replaceAll("[^0-9]", "");
        formattedPhoneNumber = "+55" + formattedPhoneNumber;
        return formattedPhoneNumber;
    }
}
