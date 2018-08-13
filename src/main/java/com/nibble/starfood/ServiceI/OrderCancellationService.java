package com.nibble.starfood.ServiceI;



import com.nibble.starfood.hibernatemodel.CustDet;
import com.nibble.starfood.hibernatemodel.CustOrdCancel;
import com.nibble.starfood.webservices.model.OrderCancel;



public interface OrderCancellationService {

	public String getCheckCancelDates(String cancelDT, int orderId);
	
	public String saveOrderCancel(OrderCancel cancelOrderDet);
	
	public CustOrdCancel saveOrdCal(CustOrdCancel ord);
	
	public CustDet custdet(int custId);
	
	public CustDet findCustDevBYId(int id);
	
}
