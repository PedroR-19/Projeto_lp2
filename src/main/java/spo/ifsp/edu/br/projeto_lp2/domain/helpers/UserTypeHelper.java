package spo.ifsp.edu.br.projeto_lp2.domain.helpers;

import spo.ifsp.edu.br.projeto_lp2.domain.enums.UserType;

import java.util.ArrayList;
import java.util.List;

public class UserTypeHelper {
    public static List<UserType> getUserTypesByString(String userTypes) {
        List<UserType> userTypesList = new ArrayList<>();
        if (userTypes != null) {
            String[] userTypesArray = userTypes.split(",");
            for (String userType : userTypesArray) {
                userTypesList.add(UserType.valueOf(userType.toUpperCase()));
            }
        }
        return userTypesList;
    }
}
