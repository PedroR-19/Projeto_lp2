package spo.ifsp.edu.br.projeto_lp2.infra.helpers;

import org.json.JSONArray;
import org.json.JSONObject;
import spo.ifsp.edu.br.projeto_lp2.domain.User;
import spo.ifsp.edu.br.projeto_lp2.domain.builders.UserBuilder;

import java.util.ArrayList;
import java.util.List;

public class JsonUserHelper {
    public static List<User> getUsersFromJson(String json) throws Exception {
        List<User> users = new ArrayList<>();

        JSONArray usersNode = new JSONObject(json).getJSONArray("results");

        for (int i = 0; i < usersNode.length(); i++) {
            JSONObject jsonUser = usersNode.getJSONObject(i);

            User user = new UserBuilder()
                    .withGender(jsonUser.getString("gender").charAt(0))
                    .withName(
                            jsonUser.getJSONObject("name").getString("first"),
                            jsonUser.getJSONObject("name").getString("last"),
                            jsonUser.getJSONObject("name").getString("title")
                    )
                    .withLocation(
                            jsonUser.getJSONObject("location").getString("street"),
                            jsonUser.getJSONObject("location").getString("city"),
                            jsonUser.getJSONObject("location").getString("state"),
                            String.valueOf(jsonUser.getJSONObject("location").getInt("postcode")),
                            Double.parseDouble(jsonUser.getJSONObject("location").getJSONObject("coordinates").getString("latitude")),
                            Double.parseDouble(jsonUser.getJSONObject("location").getJSONObject("coordinates").getString("longitude"))
                    )
                    .withTimezone(
                            jsonUser.getJSONObject("location").getJSONObject("timezone").getString("offset"),
                            jsonUser.getJSONObject("location").getJSONObject("timezone").getString("description")
                    )
                    .withEmail(jsonUser.getString("email"))
                    .withBirthday(DateHelper.getDateFromString(jsonUser.getJSONObject("dob").getString("date")))
                    .withRegistered(DateHelper.getDateFromString(jsonUser.getJSONObject("registered").getString("date")))
                    .withTelephoneNumbers(jsonUser.getString("phone").split(";"))
                    .withMobilePhoneNumbers(jsonUser.getString("cell").split(";"))
                    .withPicture(
                            jsonUser.getJSONObject("picture").getString("large"),
                            jsonUser.getJSONObject("picture").getString("medium"),
                            jsonUser.getJSONObject("picture").getString("thumbnail")
                    )
                    .withNationality("BR")
                    .build();

            users.add(user);
        }

        return users;
    }
}
