package com.nibble.starfood.ServiceImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nibble.starfood.DAOI.OrderCancellationDAO;
import com.nibble.starfood.ServiceI.OrderCancellationService;
import com.nibble.starfood.hibernatemodel.CancelledOrderDetails;
import com.nibble.starfood.hibernatemodel.CustDet;
import com.nibble.starfood.hibernatemodel.CustOrdCancel;
import com.nibble.starfood.hibernatemodel.CustOrdDet;
import com.nibble.starfood.webservices.model.OrderCancel;


@Service
@Transactional
public class OrderCancellationServiceImpl implements OrderCancellationService  {

	@Autowired
	OrderCancellationDAO cust;
	
	@Override
	public String getCheckCancelDates(String cancelDT, int orderId) {

		return  cust.getCheckCancelDates(cancelDT, orderId);
	}
	
	@Override
	public String saveOrderCancel(OrderCancel cancelOrderDet) {
		CustOrdDet ordDetails = cust.getCustOrdDetById(cancelOrderDet.getOrderId());
		if(ordDetails.getPayModId()!=0){
		float previousCuponsAmnt = 0;

		final CustOrdCancel ordr = new CustOrdCancel();
		final CancelledOrderDetails orderCancelDetails= new CancelledOrderDetails();

		String cancelDate = cancelOrderDet.getCancelDate();
		Date canclDate = null;

		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			canclDate = format.parse(cancelDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Calendar cancelCutOffTime = DateCalendar();
		cancelCutOffTime.set(Calendar.HOUR_OF_DAY, 21);
		cancelCutOffTime.set(Calendar.MINUTE, 00);
		System.out.println("Cancel CuttoffTime"+cancelCutOffTime);
		
		Calendar currentDateTime = DateCalendar();
		System.out.println("Given Date should be before cuttoff time"+currentDateTime);

		boolean isBefore = currentDateTime.before(cancelCutOffTime);
		
		float presentAmount = 0;

		Date date = DateCal();

		if (canclDate.compareTo(date) > 0) {
			System.out.println("canclDate"+canclDate+"today date"+date+"we are comparing here,cancel date should be tomorrow");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = DateCalendar();
			c.add(Calendar.DAY_OF_MONTH, 1);

			String tomorrowDate = sdf.format(c.getTime());
			Date convertTomorrowDate = null;
			try {
				SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
				convertTomorrowDate = formate.parse(tomorrowDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("tomorrow date is coming fine" + tomorrowDate);
			
			if (canclDate.compareTo(convertTomorrowDate) == 0) {
				System.out.println("comparing tomorrow date and canceldate");
				if (isBefore == true) {
					CustOrdDet orderDetails = cust.getCustOrdDetById(cancelOrderDet.getOrderId());
					orderCancelDetails.setCupnAmnt((cancelOrderDet.getMealPricePerDay()
							* cancelOrderDet.getQuantity()));
					orderCancelDetails.setCupnDesc("Meal Cancellation");
					orderCancelDetails.setCupnF(0);
					orderCancelDetails.setCustBillHistId(orderDetails.getCustBillId()+"");
					orderCancelDetails.setCustDetId(orderDetails.getCustDet().getId());
					orderCancelDetails.setCustOrdDetId(cancelOrderDet.getOrderId()+"");
					orderCancelDetails.setCrtTs(date);
					CancelledOrderDetails SavedCancelDetails =cust.saveOrderCancelDetails(orderCancelDetails);
					
					ordr.setCpnRefId(SavedCancelDetails.getId());
					ordr.setCustOrdDetId(cancelOrderDet.getOrderId());
					ordr.setCancelledForDate(cancelOrderDet.getCancelDate());
					ordr.setCancelQty(cancelOrderDet.getQuantity());
					System.out.println("Quantity>>>>>>>>>>"+cancelOrderDet.getQuantity());
					
					saveOrdCal(ordr);

					//CustOrdDet order = cust.getCustOrdDetById(cancelOrderDet.getOrderId());
					//OrdSt st = cust.getOrdStById(5);
					//order.setOrdrSt(st);
					//cust.updateCustOrdDetails(order);
					
					final CustDet customer = cust.findCustDetBYId(cancelOrderDet.getCustId());
					if (customer.getCupnRedmAmnt() != 0) {
						previousCuponsAmnt = customer.getCupnRedmAmnt();
					}
					presentAmount = previousCuponsAmnt
							+ cancelOrderDet.getMealPricePerDay()
							* cancelOrderDet.getQuantity();
					customer.setCupnRedmAmnt(presentAmount);
					cust.updateCustDet(customer);

				}
				System.out.println("Present Amount is coming fine......."
						+ presentAmount);
				if(presentAmount>=0)
					return presentAmount + "";
				else
					return null;
			} else {

				CustOrdDet orderDetails = cust.getCustOrdDetById(cancelOrderDet.getOrderId());
				orderCancelDetails.setCupnAmnt((cancelOrderDet.getMealPricePerDay()
						* cancelOrderDet.getQuantity()));
				orderCancelDetails.setCupnDesc("Meal Cancellation");
				orderCancelDetails.setCupnF(0);
				orderCancelDetails.setCustBillHistId(orderDetails.getCustBillId()+"");
				orderCancelDetails.setCustDetId(orderDetails.getCustDet().getId());
				orderCancelDetails.setCustOrdDetId(cancelOrderDet.getOrderId()+"");
				orderCancelDetails.setCrtTs(date);
				CancelledOrderDetails SavedCancelDetails =cust.saveOrderCancelDetails(orderCancelDetails);
				
				ordr.setCpnRefId(SavedCancelDetails.getId());
				ordr.setCustOrdDetId(cancelOrderDet.getOrderId());
				ordr.setCancelledForDate(cancelOrderDet.getCancelDate());
				ordr.setCancelQty(cancelOrderDet.getQuantity());
				System.out.println("Quantity>>>>>>>>>>"+cancelOrderDet.getQuantity());
				saveOrdCal(ordr);

				CustOrdDet order = cust.getCustOrdDetById(cancelOrderDet.getOrderId());
				//OrdSt st = cust.getOrdStById(5);
				//order.setOrdrSt(st);
				cust.updateCustOrdDetails(order);
			
				final CustDet customer = cust.findCustDetBYId(cancelOrderDet
						.getCustId());
				if (customer.getCupnRedmAmnt() != 0) {
					previousCuponsAmnt = customer.getCupnRedmAmnt();
				}
				presentAmount = previousCuponsAmnt
						+ cancelOrderDet.getMealPricePerDay()
						* cancelOrderDet.getQuantity();
				customer.setCupnRedmAmnt(presentAmount);
				cust.updateCustDet(customer);
				System.out.println("Present Amount is coming fine......."+ presentAmount);
				if(presentAmount>=0)
					return presentAmount + "";
				else
					return 0+"";

			}

		} else {
			return null;
		}
		}
		else{
			return null;
		}

	}
	
	@Override
	public CustDet custdet(int custId) {

		return cust.custdet(custId);
	}
	
	
	
	
	public Calendar DateCalendar(){
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");
		DateFormat outputformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sbCurrentTimestamp=null;
		Calendar cSchedStartCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		long gmtTime = cSchedStartCal.getTime().getTime();

		long timezoneAlteredTime = gmtTime + TimeZone.getTimeZone("Asia/Calcutta").getRawOffset();
		Calendar cSchedStartCal1 = Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
		cSchedStartCal1.setTimeInMillis(timezoneAlteredTime);
		
		Date date=cSchedStartCal1.getTime();
		
		String input_crt_ts=df.format(date);
		
		Date outputDate=null;
		try {
			outputDate = df.parse(input_crt_ts);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sbCurrentTimestamp=outputformat.format(outputDate);
		System.out.println("time as per as local........"+date);
		try {
			date=outputformat.parse(sbCurrentTimestamp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cSchedStartCal1;
		
	}
	
	public Date DateCal(){
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");
		DateFormat outputformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sbCurrentTimestamp=null;
		Calendar cSchedStartCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		long gmtTime = cSchedStartCal.getTime().getTime();

		long timezoneAlteredTime = gmtTime + TimeZone.getTimeZone("Asia/Calcutta").getRawOffset();
		Calendar cSchedStartCal1 = Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
		cSchedStartCal1.setTimeInMillis(timezoneAlteredTime);
		
		Date date=cSchedStartCal1.getTime();
		
		String input_crt_ts=df.format(date);
		
		Date outputDate=null;
		try {
			outputDate = df.parse(input_crt_ts);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sbCurrentTimestamp=outputformat.format(outputDate);
		System.out.println("time as per as local........"+date);
		try {
			date=outputformat.parse(sbCurrentTimestamp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return date;
		
	}
	
	@Override
	public CustOrdCancel saveOrdCal(CustOrdCancel ord) {

		final java.util.Date date = DateCal();
		ord.setCrtId(ord.getCustOrdDetId()+"");
		ord.setCrtTs(date);
		return cust.saveOrdCal(ord);
	}
	
	@Override
	public CustDet findCustDevBYId(int id) {
		
		return cust.findCustDevBYId(id);
	}
	
	
}
