package UserLogic;

import java.time.LocalDate;

public class DateValidator {
	public static boolean isValidBirthDate (String year, String month, String day) {
		if (!isValidFormatDate(year, month, day)) {
			return false;
		}
		
		LocalDate date = LocalDate.of(
				Integer.parseInt(year), 
				Integer.parseInt(month), 
	Integer.parseInt(day)
			);
		
		if (date.isAfter(LocalDate.now())) {
			return false;
		}
		
		return true;
	}
	
	public static boolean isValidFormatDate (String year, String month, String day) {
		String[] data = {year, month, day};
		
		for (String string : data) {
			if (!hasNumber(string)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean hasNumber (String string) {
		try {
	        Integer.parseInt(string);
	        
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
}
