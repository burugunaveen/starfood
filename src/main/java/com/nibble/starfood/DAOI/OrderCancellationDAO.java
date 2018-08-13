package com.nibble.starfood.DAOI;

import com.nibble.starfood.hibernatemodel.CancelledOrderDetails;
import com.nibble.starfood.hibernatemodel.CustDet;
import com.nibble.starfood.hibernatemodel.CustOrdCancel;
import com.nibble.starfood.hibernatemodel.CustOrdDet;





public interface OrderCancellationDAO {

	public String getCheckCancelDates(String cancelDT, int orderId);
	
	public CustOrdCancel saveOrdCal(CustOrdCancel ord);
	
	public CustDet findCustDetBYId(int id);
	
	public void updateCustDet(CustDet custdev);
	
	public CustOrdDet getCustOrdDetById(int OrderDetails);
	
	public int updateCustOrdDetails(CustOrdDet order);
	
	public CustDet custdet(int custId);

	
	public CancelledOrderDetails saveOrderCancelDetails(CancelledOrderDetails orderCancelDetails);

	public CustDet findCustDevBYId(int id);
}
