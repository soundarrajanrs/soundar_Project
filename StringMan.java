package main;
import java.util.regex.*;  
import java.util.ArrayList;
import java.util.List;

public class StringMan {

	public static void main (String[] srgs) {
	
		System.out.println(validateObject("TAKE ONE TABLET TWO TIMES A DAY UNTIL GONE /,"));
		System.out.println(validateObjectN1to11("13244"));
		
	}
	public static boolean validateObject(String obj) {
        // Regular expression for alphanumeric strings with length between 1 and 35
        String regex = "^[a-zA-Z0-9 ,/.]{1,105}$";
        
        // Check if the string matches the regex
        return obj.matches(regex);
    }
	
	public static boolean validateObjectN1to11(String obj) {
		// Regular expression for alphanumeric strings with length between 1 and 35
		String regex = "^\\d{1,11}$";

		// Check if the string matches the regex
		return obj.matches(regex);
	}
}
