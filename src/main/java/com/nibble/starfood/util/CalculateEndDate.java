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
				 System.err.println("An Exception Occured");//This Line is modified by Viofixer as a fix for Poor Logging Practice Use of a System Output Stream 
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
//	    } else if (originalDayOfWeek + remainderDays > Calendar.FRIDAY) {//This Line is commented by Viofixer as a fix for Poor Logging Practice Use of a System Output Stream 
	        adjustmentDays = 2;
	    }
//	    cal.add(Calendar.DAY_OF_MONTH, adjustmentDays);//This Line is commented by Viofixer as a fix for Poor Logging Practice Use of a System Output Stream 
	    System.out.println(cal.getTime());
	    SimpleDateFormat endFormatter = new SimpleDateFormat("yyyy-MM-dd");
	    String endDateString=endFormatter.format(cal.getTime());
	    
	    System.out.println(endDateString);
		return endDateString;
	    
	}
}
