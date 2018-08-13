package com.nibble.starfood.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalculateEndDate {
	
	
	public static String endDate(String startDate,int numberOfDays,int noOfDaysInWeek) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date=null;
		try {
			date = formatter.parse(startDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(date);
		Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    int originalDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	    int numWeeks = numberOfDays / noOfDaysInWeek;
	    int remainderDays = numberOfDays % noOfDaysInWeek;
	    cal.add(Calendar.DAY_OF_MONTH, numWeeks * 7 + remainderDays);

	    int adjustmentDays = 0;
	    if (originalDayOfWeek == Calendar.SUNDAY) {
	        adjustmentDays = 1;
	    } else if (originalDayOfWeek + remainderDays > Calendar.FRIDAY) {
	        adjustmentDays = 2;
	    }
	    cal.add(Calendar.DAY_OF_MONTH, adjustmentDays);
	    System.out.println(cal.getTime());
	    SimpleDateFormat endFormatter = new SimpleDateFormat("yyyy-MM-dd");
	    String endDateString=endFormatter.format(cal.getTime());
	    
	    System.out.println(endDateString);
		return endDateString;
	    
	}
}
