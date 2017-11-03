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

    public static boolean isNumeric(String s) {
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
        boolean bool = false;
        if (new Date().after(date)) {
            bool = true;
        }
        return bool;
    }

    public static boolean validateString(String value) {
        return !value.matches("[a-zA-Z]*");
    }

    public static boolean validateApplicantId(String text) {

        return  text.startsWith("AP_") && text.split("_")[1].length() == 5 && isNumeric(text.split("_")[1]);

    }
    public static boolean validateStudentId(String text) {

        return  text.startsWith("ST_") && text.split("_")[1].length() == 5 && isNumeric(text.split("_")[1]);

    }
    
    
    
    public static boolean validateAmount(String text){
        return isNumeric(text) && Float.parseFloat(text)>=0;
    }

}
