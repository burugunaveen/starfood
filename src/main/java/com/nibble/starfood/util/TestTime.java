package com.nibble.starfood.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TestTime {

	public static void main(String[] args) {

		boolean isBefore=false;
		DateFormat dateintimeformat = new SimpleDateFormat(
				"hh:mm a");
		Date cutofftimeindate = new Date();
		Date uppercutofftimeindate = new Date();
		Date currenttime = null;
		try {
			cutofftimeindate = dateintimeformat
					.parse("10:30 AM");
			uppercutofftimeindate=dateintimeformat
					.parse("11:30 PM");
			currenttime = dateintimeformat
					.parse(getIndianTimeWithStringForMealTime());
			System.out.println(currenttime + " currenttime for forLunch");
			System.out.println(cutofftimeindate + " cutofftimeindate forLunch");
			System.out.println("upperCuttOffTime: "+uppercutofftimeindate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if ((cutofftimeindate.getTime() - currenttime.getTime() < 0)&&(uppercutofftimeindate.getTime() - currenttime.getTime() > 0)) {
			isBefore = true;
			System.out.println("isBefore>>>>"+isBefore);
		}
		System.out.println("isBefore:"+isBefore);

	}
	
	public static String getIndianTimeWithStringForMealTime() {

		  DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");
		  DateFormat outputformat = new SimpleDateFormat("hh:mm a");
		  String sbCurrentTimestamp = null;
		  Calendar cSchedStartCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		  long gmtTime = cSchedStartCal.getTime().getTime();

		  long timezoneAlteredTime = gmtTime + TimeZone.getTimeZone("Asia/Calcutta").getRawOffset();
		  Calendar cSchedStartCal1 = Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
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

		  return sbCurrentTimestamp;
		 }

}
