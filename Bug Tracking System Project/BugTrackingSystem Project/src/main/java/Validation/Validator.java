package Validation;

import java.util.regex.Pattern;

public class Validator {
	 // Email Regex
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    
    //Mobile Regex
    private static final String MOBILE_REGEX = "^[6-9]\\d{9}$";
    
    // Name Regex (only alphabets, minimum 2 characters)
    private static final String NAME_REGEX = "^[A-Za-z]{2,}$";

    
    public static boolean isValidEmail(String email) {
        return Pattern.matches(EMAIL_REGEX, email);
    }
    
    public static boolean isValidMobile(String mobile) {
        return Pattern.matches(MOBILE_REGEX, mobile);
    }
    
    public static boolean isValidName(String name) {
        return Pattern.matches(NAME_REGEX, name);
    }


   

}
