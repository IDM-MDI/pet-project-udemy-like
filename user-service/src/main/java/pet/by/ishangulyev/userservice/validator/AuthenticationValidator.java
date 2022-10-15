package pet.by.ishangulyev.userservice.validator;

import pet.by.ishangulyev.userservice.model.UserAuthenticationModel;

public class AuthenticationValidator {
    private AuthenticationValidator() {}
    public static boolean isAuthenticationValid(UserAuthenticationModel authentication) {
        return authentication != null &&
                isLoginValid(authentication.getLogin()) &&
                isPasswordValid(authentication.getPassword());
    }

    public static boolean isLoginValid(String login) {
        return true;
    }   //TODO: FINISH VALIDATOR

    public static boolean isPasswordValid(String password) {
        return true;
    }   //TODO: FINISH VALIDATOR
}
