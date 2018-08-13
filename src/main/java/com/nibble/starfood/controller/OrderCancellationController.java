package com.nibble.starfood.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nibble.starfood.ServiceI.OrderCancellationService;
import com.nibble.starfood.hibernatemodel.CustDet;
import com.nibble.starfood.webservices.model.OrderCancel;



@Controller
public class OrderCancellationController {

	@Autowired
	OrderCancellationService cust;

  @RequestMapping(value = "mobile/orderCancel", method = RequestMethod.POST)
	public @ResponseBody Object cancel(@RequestBody final OrderCancel cancelOrderDet) {

	final HashMap<String, String> map = new HashMap<String, String>();
		
		final String checkCancelDelvDates = cust.getCheckCancelDates(cancelOrderDet.getCancelDate(), cancelOrderDet.getOrderId());
		//final String checksharedDelvDates = cust.getCheckShareDates(prvOrder.getCancelDT(), prvOrder.getOrderId());
		if(checkCancelDelvDates==null){
		  final String i = cust.saveOrderCancel(cancelOrderDet);
		
		  if (i != null) {
			if (!i.equals("0")) {

				CustDet custdetails = cust.custdet(cancelOrderDet.getCustId());

				//sendExotelSMS(custdetails, prvOrder); // SMS Triggering for Order Cancel, Here we are passing customer contact number and Order Cancellation Date 

				//sendEmail(custdetails, prvOrder); // E-Mail Triggering for Order Cancel, Here we are passing customer E-Mail address and Order Cancellation Date

				map.put("Customer Wallet Amount", i);
				map.put("status","success");
				} 
			else {
				map.put("status", "failure");
				}
		  } 
		else {
			map.put("status", "failure");
		}
	  }
	 else
	 {
		map.put("Status", "Already Your Order has Cancelled");
		
	 }
		return map;
}

	}
