package com.nibble.starfood.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
//import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nibble.starfood.ServiceI.CustDetServiceI;
/*import com.nibble.spicebox.model.CustCupnRelt;
import com.nibble.spicebox.model.CustOrdDet;
import com.nibble.spicebox.webservices.model.CustId;
*/



public class PayUController {
	
	
	@Autowired
	CustDetServiceI cust;
	
	@RequestMapping(value = "mobile/payUCallBack", method = RequestMethod.GET)
	public @ResponseBody ModelAndView payUCallBack(@RequestParam(value = "mode", required = false) String mode,
                @RequestParam(value = "status", required = false) String status,
                @RequestParam(value = "key", required = false) String key,
                @RequestParam(value = "txnid", required = false) String txnid,
                @RequestParam(value = "amount", required = false) String amount,
                @RequestParam(value = "productinfo", required = false) String productinfo,
                @RequestParam(value = "firstname", required = false) String firstname,
                @RequestParam(value = "lastname", required = false) String lastname,
                @RequestParam(value = "email", required = false) String email,
                @RequestParam(value = "Error", required = false) String Error,
                @RequestParam(value = "phone", required = false) String phone,
                @RequestParam(value = "hash", required = false) String hash,
                @RequestParam(value = "PG_TYPE", required = false) String PG_TYPE,
                @RequestParam(value = "bank_ref_num", required = false) String bank_ref_num,
                @RequestParam(value = "payuMoneyId", required = false) String payuMoneyId,
                @RequestParam(value = "udf1", required = false) String ORDERID
                
               ) {
		
		final Map<String, Object> map = new HashMap<String, Object>();
			map.put("status", "success");
			return new ModelAndView("redirect:/mobile/mySpiceBox");		
		}
	
	 

	/*@RequestMapping(value = "/mobile/mySpiceBox", method = RequestMethod.GET)
	public @ResponseBody Object mySpiceBox(@RequestBody final CustId custId) {
		
		final Map<String, Object> map = new HashMap<String, Object>();
		final List<CustOrdDet> currentOrders = cust.listOfCurrentCustomerOrder(custId.getCustId());// order status id=1 then new orders will display here
		//final List<CustOrdDet> unprocessed = cust.listOfCustomerOrderHistory(custId.getCustId()); // order status id=8 then unprocessed orders will display here
		final List<CustOrdDet> activeorders = cust.listOfActiveCustomerOrderHistory(custId.getCustId());// order status id=9 then Active orders will display here
		// below list have order status id=5 then cancelled orders will display here
		final List<CustOrdDet> cancelledeorders = cust.listOfCancelledCustomerOrderHistory(custId.getCustId());
		final List<CustCupnRelt> appSharecouponss = cust.listOfAppShareCuppons(custId.getCustId());
		final List<CustCupnRelt> cancelcouponss = cust.listOfCancelCuppons(custId.getCustId());
		
		if (currentOrders.size() == 0) {
			map.put("Current Orders", "No Current Orders");

		} else {
			map.put("Current Orders", currentOrders);

		}
		
		if (currentOrders.size() == 0) {
			map.put("Active Orders", "No Active Orders");

		} else {
			map.put("Active Orders", activeorders);

		}
		
		if (currentOrders.size() == 0) {
			map.put("cancelled Orders", "No Cancelled Orders");

		} else {
			map.put("Cancelled Orders", cancelledeorders);

		}
		
		if (unprocessed.size() == 0) {
			map.put("Unprocessed Orders", "No Previous Orders");

		} else {
			map.put("Unprocessed Orders", unprocessed);

		}

		if (appSharecouponss.size() == 0) {
			map.put("App share couponss", "No coupons");

		} else {
			System.err.println("An exception is occurred");//This Line is modifided by VioFixer as a fix for Poor Error Handling: Empty Catch Block
			map.put("App share couponss", appSharecouponss);

		}
		if (cancelcouponss.size() == 0) {
			map.put("Order Cancellation  coupons", "No coupons");

		} else {
			map.put("Order Cancellation  coupons", cancelcouponss);

		}
		return map;

	}*/
	
	public String hashCal(String type,String str){
		   byte[] hashseq=str.getBytes();
		   StringBuffer hexString = new StringBuffer();
		   try{
		   MessageDigest algorithm = MessageDigest.getInstance(type);
		   algorithm.reset();
		   algorithm.update(hashseq);
		   byte messageDigest[] = algorithm.digest();
		             
		   

		   for (int i=0;i<messageDigest.length;i++) {
		    String hex=Integer.toHexString(0xFF & messageDigest[i]);
		    if(hex.length()==1) hexString.append("0");
		    hexString.append(hex);
		   }
		    
		   }catch(NoSuchAlgorithmException nsae){ }
		   
		   return hexString.toString();

		  }

		  public boolean empty(String s)
		  {
		   if(s== null || s.trim().equals(""))
		    return true;
		   else
		    return false;
		  }

}
