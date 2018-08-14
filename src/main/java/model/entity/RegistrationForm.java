package model.entity;

import controller.utility.Languages;

public class RegistrationForm {

    private String firstName;
    private String lastName;
    private String middleName;

    private String language;

    private String login;

    public RegistrationForm(String firstName, String lastName, String middleName, String language, String login) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.language = language;
        this.login = login;
    }
}
