package com.nibble.starfood.controller;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

class OTP {
	

	public static void main(String[] args)throws Exception {
		/*String text = "2015-09-28";
		try {
		    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		    SimpleDateFormat sdf2 = new SimpleDateFormat("MMM dd yyyy");

		    Date date = sdf1.parse(text);

		    System.out.println(sdf2.format(date));
		} catch (ParseException exp) {
		    exp.printStackTrace();
		}*/
		/*String names="A,B,C,,";
		if (names.endsWith(",")) {
		    names = names.substring(0, names.length()-1);
		}
		System.out.println(names);*/
		
		
		
		
		
	/*	Date todayDate = getTime();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		
		String systemDate= simpleDateFormat.format(todayDate);
		SimpleDateFormat simpletime=new SimpleDateFormat("HH:mm:ss");
		String systemTime=simpletime.format(todayDate);
		System.out.println("systime  "+systemTime);
		System.out.println("systemDate  "+systemDate);
		
		
		//String s = "15:18:05";
		DateFormat f1 = new SimpleDateFormat("HH:mm:ss"); //HH for hour of the day (0 - 23)
		Date d = f1.parse(systemTime);
		DateFormat f = new SimpleDateFormat("HH:mm");
		DateFormat f2 = new SimpleDateFormat("hh:mm:ss a");
		String time_12Hr_format=f2.format(d);
		System.out.println("12 hour format   "+time_12Hr_format);*/
		   String s="11:30 AM";
		   SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
	       SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
	       Date date = parseFormat.parse(s);
	       String parse_12_hrsFormate=parseFormat.format(date);
	       String date_24_hrsFormate=displayFormat.format(date);
	       System.out.println(parse_12_hrsFormate + " =>>>>  " + date_24_hrsFormate);
		
		
		Calendar givenDate = getIndianTimezoneCalendar();
		Calendar cancelCutOffTime = getIndianTimezoneCalendar();
		//MealTime mealTimeList= cust.mealCuttOffTime(pkg.getMealTimeId());
		String timme = date_24_hrsFormate;
		System.out.println("MealTIME as String.........>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+timme);
		String[] time = timme.split ( ":" );
		int hour = Integer.parseInt ( time[0].trim() );
		int min = Integer.parseInt ( time[1].trim() );
		cancelCutOffTime.set(Calendar.HOUR_OF_DAY, hour);
		cancelCutOffTime.set(Calendar.MINUTE, min);
		System.out.println("Hour : "+hour+" min: "+min);
		boolean isBefore = givenDate.before(cancelCutOffTime);
		if(isBefore==true){
			System.out.println("current time is before cutoff time>>>"+ givenDate);
		}
		else{
			System.out.println("failure>>>>>>>");
		}
	}
	
		static Calendar getIndianTimezoneCalendar(){
		
		Calendar cSchedStartCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		long gmtTime = cSchedStartCal.getTime().getTime();
		long timezoneAlteredTime = gmtTime + TimeZone.getTimeZone("Asia/Calcutta").getRawOffset();
		Calendar cSchedStartCal1 = Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
		cSchedStartCal1.setTimeInMillis(timezoneAlteredTime);
		
		return cSchedStartCal1;
		
	}
	
	/*static Date getTime() {

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sbCurrentTimestamp = outputformat.format(outputDate);
		System.out.println("time as per as local........" + date);
		try {
			date = outputformat.parse(sbCurrentTimestamp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return date;

	}
	*/
}