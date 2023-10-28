package spo.ifsp.edu.br.projeto_lp2.domain.builders;

import spo.ifsp.edu.br.projeto_lp2.domain.*;
import spo.ifsp.edu.br.projeto_lp2.domain.builders.interfaces.IUserBuilder;

import java.util.Arrays;
import java.util.Date;

public class UserBuilder implements IUserBuilder {
    private final User user;

    public UserBuilder() {
        user = new User();
    }

    @Override
    public UserBuilder withGender(char gender) {
        user.setGender(gender);
        return this;
    }

    @Override
    public UserBuilder withName(String title, String first, String last) {
        Name name = new Name(title, first, last);
        user.setName(name);
        return this;
    }

    @Override
    public IUserBuilder withLocation(String street, String city, String state, String postcode, double latitude, double longitude) {
        Coordinates coordinates = new Coordinates(latitude, longitude);
        Location location = new Location(street, city, state, postcode, coordinates);
        user.setLocation(location);
        return this;
    }

    @Override
    public IUserBuilder withTimezone(String offset, String description) {
        Timezone timezone = new Timezone(offset, description);
        user.setTimezone(timezone);
        return this;
    }

    @Override
    public IUserBuilder withEmail(String email) {
        user.setEmail(email);
        return this;
    }

    @Override
    public IUserBuilder withBirthday(Date date) {
        user.setBirthday(date);
        return this;
    }

    @Override
    public IUserBuilder withRegistered(Date date) {
        user.setRegistered(date);
        return this;
    }

    @Override
    public IUserBuilder withTelephoneNumbers(String[] telephoneNumbers) {
        user.setTelephoneNumbers(Arrays.asList(telephoneNumbers));
        return this;
    }

    @Override
    public IUserBuilder withMobilePhoneNumbers(String[] mobilePhoneNumbers) {
        user.setMobilePhoneNumbers(Arrays.asList(mobilePhoneNumbers));
        return this;
    }

    @Override
    public IUserBuilder withPicture(String large, String medium, String thumbnail) {
        Picture picture = new Picture(large, medium, thumbnail);
        user.setPicture(picture);
        return this;
    }

    @Override
    public IUserBuilder withNationality(String nationality) {
        user.setNationality(nationality);
        return this;
    }

    public User build() {
        return user;
    }
}
