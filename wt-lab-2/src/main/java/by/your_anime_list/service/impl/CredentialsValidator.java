package by.your_anime_list.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CredentialsValidator {
    public boolean validLogin(String login) {
        if (login == null) {
            return false;
        }

        String loginRegex = "[a-zA-Z][a-zA-Z0-9]{5,25}";
        Pattern pattern = Pattern.compile(loginRegex);
        Matcher matcher = pattern.matcher(login);

        return matcher.matches();
    }

    public boolean validPassword(String password) {
        if (password == null) {
            return false;
        }

        String passwordRegex = "[a-zA-Z0-9]{6,26}";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }
}
