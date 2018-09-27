package com.nibble.starfood.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class Test {

	public static void main(String[] args){
		/*
		Date todayDate = getIndianTimezoneDatewithTime();
		
		Calendar calendr = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		
		try {
//			calendr.setTime(simpleDateFormat.parse(simpleDateFormat.format(todayDate)));//This Line is commented by Viofixer as a fix for Poor Logging Practice Use of a System Output Stream 
		} catch (ParseException e) {
			e.printStackTrace();
		}
		DateFormat df = new SimpleDateFormat("EEEE yyyy-MM-dd");
		int day = calendr.get(Calendar.DAY_OF_WEEK);
		if(day==Calendar.SATURDAY){
			System.out.println("days are matching");
			calendr.add(Calendar.DATE,2);
            System.out.println(df.format(calendr.getTime()));
		}else{
			System.out.println("days are not matching");
			System.out.println("calDay "+Calendar.SUNDAY+", day "+day);
			calendr.add(Calendar.DATE,1);
            System.out.println(df.format(calendr.getTime()));
		}
		System.out.println("day from current ");
		 Calendar c = Calendar.getInstance();
	        // Set the calendar to monday of the current week
	        c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);

	        // Print dates of the current week starting on Monday to Friday
	        DateFormat df = new SimpleDateFormat("EEE dd/MM/yyyy");
	        
	            
	            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
	            if (dayOfWeek == day) { // If it's Friday so skip to Monday
	                c.add(Calendar.DATE, 1);
	                System.out.println(df.format(c.getTime()));
	            } else if (dayOfWeek == Calendar.SATURDAY) { // If it's Saturday skip to Monday
	                c.add(Calendar.DATE, 2);
	            } else {
	                c.add(Calendar.DATE, 1);
	            }

	            // As Cute as a ZuZu pet.
	            //c.add(Calendar.DATE, dayOfWeek > Calendar.THURSDAY ? (9 - dayOfWeek) : 1);
	        
		
	}
	
	static Date getIndianTimezoneDatewithTime() {

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");
		DateFormat outputformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sbCurrentTimestamp = null;
		Calendar cSchedStartCal = Calendar.getInstance(TimeZone
				.getTimeZone("GMT"));
		long gmtTime = cSchedStartCal.getTime().getTime();

		long timezoneAlteredTime = gmtTime
				+ TimeZone.getTimeZone("Asia/Calcutta").getRawOffset();
		Calendar cSchedStartCal1 = Calendar.getInstance(TimeZone
				.getTimeZone("Asia/Calcutta"));
		cSchedStartCal1.setTimeInMillis(timezoneAlteredTime);

		Date date = cSchedStartCal1.getTime();

		String input_crt_ts = df.format(date);

		Date outputDate = null;
		try {
			outputDate = df.parse(input_crt_ts);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		sbCurrentTimestamp = outputformat.format(outputDate);
		System.out.println("time as per as local........" + date);
		try {
			date = outputformat.parse(sbCurrentTimestamp);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
*/
		
		int i=0;
		List<Integer> a=new ArrayList<Integer>(); 
		for(int j=0;j<10;j++){
			i=j;
			a.add(i);
			
		}
		for(int j=0;j<10;j++){
			System.out.println(a.get(j));
		}
	}
	
}
