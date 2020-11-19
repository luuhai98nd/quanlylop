package hvitclan.com.restful.validate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import hvitclan.com.restful.annotation.StringToDate;

public class DateValidator implements ConstraintValidator<StringToDate, String>{
	public boolean isValid(String date,ConstraintValidatorContext constraintValidatorContext) {
		try {
			Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date1);
			if((calendar.get(Calendar.YEAR)<2001)||(calendar.get(Calendar.YEAR)>2013)) return false;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return true;
	}
}


