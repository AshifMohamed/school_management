/*
 * Copyright (c) Team Extreme. All rights reserved.
 * Technologies  * 
 * Language - JAVA  * 
 * Database - MySQL  * 
 */
package school_management.student_management;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Neruppuda
 */
public class StudentManagementValidation {
    
    public static void main(String[] args) {
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX
            = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public boolean checkEmpty(String param) {
        return "".equals(param) || param == null;
    }

    public boolean isNumeric(String s) {
        return java.util.regex.Pattern.matches("\\d+", s);
    }

    public boolean validateContactNumber(String param) {
        return !isNumeric(param) || param.length() != 10;
    }

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public boolean validateDate(Date date) {
        boolean bool=false;
        if (date.after(new Date())) {
            bool=true;
        }
        return bool;
    }
    
    public static boolean validateString( String value )
   {
      return !value.matches( "[a-zA-Z]*" );
   } 

}
