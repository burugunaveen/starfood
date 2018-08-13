package com.nibble.starfood.ServiceImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nibble.starfood.DAOI.OrderDAO;
import com.nibble.starfood.ServiceI.OrderService;
import com.nibble.starfood.hibernatemodel.Address;
import com.nibble.starfood.hibernatemodel.Area;
import com.nibble.starfood.hibernatemodel.CancelledOrderDetails;
import com.nibble.starfood.hibernatemodel.City;
import com.nibble.starfood.hibernatemodel.Cupn;
import com.nibble.starfood.hibernatemodel.CupnDet;
import com.nibble.starfood.hibernatemodel.CustBillHist;
import com.nibble.starfood.hibernatemodel.CustDet;
import com.nibble.starfood.hibernatemodel.CustOrdDet;
import com.nibble.starfood.hibernatemodel.CustOrdrs;
import com.nibble.starfood.hibernatemodel.DelvChrg;
import com.nibble.starfood.hibernatemodel.EorderClientDetail;
import com.nibble.starfood.hibernatemodel.FoodTyp;
import com.nibble.starfood.hibernatemodel.Holidays;
import com.nibble.starfood.hibernatemodel.MealPlan;
import com.nibble.starfood.hibernatemodel.MealTime;
import com.nibble.starfood.hibernatemodel.MealTyp;
import com.nibble.starfood.hibernatemodel.MenuTyp;
import com.nibble.starfood.hibernatemodel.OrderDateDetails;
import com.nibble.starfood.hibernatemodel.PayMod;
import com.nibble.starfood.hibernatemodel.PaymentGatewayDet;
import com.nibble.starfood.hibernatemodel.PkgConfigRelt;
import com.nibble.starfood.hibernatemodel.PkgDur;
import com.nibble.starfood.hibernatemodel.PkgFoodItm;
import com.nibble.starfood.hibernatemodel.PkgSizTyp;
import com.nibble.starfood.hibernatemodel.Tax;
import com.nibble.starfood.hibernatemodel.WeekTyp;
import com.nibble.starfood.hibernatemodel.pkgDuration;
import com.nibble.starfood.webservices.model.AllMenu;
import com.nibble.starfood.webservices.model.CustOrderDetails;
import com.nibble.starfood.webservices.model.DatesList;
import com.nibble.starfood.webservices.model.GetFoodItems;
import com.nibble.starfood.webservices.model.ManageOrder;
import com.nibble.starfood.webservices.model.MenuList;
import com.nibble.starfood.webservices.model.PackgSave;
import com.nibble.starfood.webservices.model.Paymod;
import com.nibble.starfood.webservices.model.orderDatesDet;




@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	private static final Logger logger = LoggerFactory
			.getLogger(OrderServiceImpl.class);
	@Autowired
	OrderDAO cust;
	@Override
	 public List<CustOrdDet> getCustOrderDetails(ManageOrder order)
	 {
		return cust.getCustOrderDetails(order); 
	 }
	@Override
	 public List<PaymentGatewayDet> getPaymentGateWay()
	 {
		return cust.getPaymentGateWay(); 
	 }
	@Override
	public MenuTyp getMenuTypById(int id)
	{
		return cust.getMenuTypById(id);
	}
	 @Override
	public CustDet otpActive()
	{
		 return cust.otpActive();
	}
	 @Override
	 public List<Cupn> getCupnDetails(int id)
	 {
		 return cust.getCupnDetails(id);
	 }
	 @Override
	public CustDet getWalletDetailsById(int id)
	{
		 return cust.getWalletDetailsById(id);
	}
	  @Override
    public List<EorderClientDetail> getClientDetails()
	   {
		   return cust.getClientDetails();
	   }
	@Override
	 public List<PkgSizTyp> getPkg(MenuList menu)
	 {
		return cust.getPkg(menu);
	 }
	@Override
	public List<PkgSizTyp> getPackagesMenuList(AllMenu allmenu)
	{
		return cust.getPackagesMenuList(allmenu);
	}
	@Override
	 public List<PkgSizTyp> listOfMealPlanList()
	 {
		return cust.listOfMealPlanList();
	 }
	@Override
	 public List<PkgConfigRelt> getPackgItemById(GetFoodItems getlist)
	 {
		return cust.getPackgItemById(getlist); 
	 }
	@Override
	public List<PkgFoodItm> getItemList(AllMenu allmenu)
	{
		return cust.getItemList(allmenu);
	}
	@Override
	public List<CustOrdDet> listOfOrder()
	{
		return cust.listOfOrder();
	}
	@Override
    public City getCityByCityName(String city) {

	return cust.getCityByCityName(city);
    }
	@Override
	public MealTime getMealTimeById(int id) {

		return cust.getMealTimeById(id);
	}
	@Override
	public PkgSizTyp getPackageId(int id) {

		return cust.getPackageId(id);
	}
	
	@Override
	 public PkgDur getPkgDurById(int id)
	 {
		return cust.getPkgDurById(id);
	 }
	   @Override
	    public Area getAreaByName(String area) {

		return cust.getAreaByName(area);
	    }
	   @Override
	   public FoodTyp getFoodTypById(int id)
	   {
		   return cust.getFoodTypById(id);
	   }
	@Override
	public List<PkgConfigRelt> getFoodItemById(GetFoodItems getitems)
	{
		return cust.getFoodItemById(getitems);
	}
	@Override
	public List<PkgSizTyp> getPackagesMenuList(GetFoodItems menu) {

		return cust.getPackagesMenuList(menu);
	}
	@Override
	public List<PkgSizTyp> getFoodMenuList(GetFoodItems fooditems)
	{
		return cust.getFoodMenuList(fooditems);
	}
	@Override
	public List<PkgConfigRelt>  getPackageList()
	{
		return cust.getPackageList();
	}
	
	
	
	
	
	
	
	@Override
	public List<PkgConfigRelt> getItemsBasedOnPackageMealTime(Integer id, String dates, int mealTime) {
		
		return cust.getItemsBasedOnPackageMealTime( id,  dates,  mealTime);
	}
	
	/*@Override
	public List<PkgSizTyp> getMenuforSingleDay(
			MenuList singleDayMenu) {

		return cust.getMenuforSingleDay(singleDayMenu);
	}*/
	@Override
	public CustOrdDet saveDate(DatesList dateList)
	{
		final CustOrdDet order = new CustOrdDet();
		
		order.setOrdDt(dateList.getDatesList());
		
	
		
		
		
		return cust.saveOrderBill(order);
	}
	/*@Override
	 public CustOrdDet saveOrderBill(CustOrderDetails guestcustOrder)
	 {
		System.out.println("time as per as local........");
		final CustOrdDet order = new CustOrdDet();

		for(PackgSave save:guestcustOrder.getSavePkg())
			
		{
			order.setCustDet(findCustDevBYId(guestcustOrder.getCustomerId()));
			
			//order.setCustDetId(guestcustOrder.getCustomerId());
			//order.setMealTyp(getMealTypById(guestcustOrder.getMealTimeId()));
//			order.setMealTime(getMealTimeById(guestcustOrder.getMealTimeId()));
//			order.setFoodTyp(getFoodTypById(guestcustOrder.getFoodTypId()));
//			order.setPkgDur(getPkgDurById(guestcustOrder.getPkgDurId()));
		//	order.setPkgSizTypId(1);
			//order.setFoodTypId(guestcustOrder.getFoodTypId());
			//order.setMealTimeId(guestcustOrder.getMealTimeId());
			//order.setPkgDurId(guestcustOrder.getPkgDurId());
			//order.setWeekTyp(getWeekTypById(guestcustOrder.getWeekDur()));
			order.setCrtId(guestcustOrder.getCustomerId() + "");
			order.setUpdId(guestcustOrder.getCustomerId() + "");
			order.setCrtTs(date);
			order.setUpdTs(date);
			order.setOrdDt(dateFormat.format(date));
			order.setAddressId(newAddress.getId());
			cust.saveOrderBill(order);
			final CustBillHist bill = new CustBillHist();
			bill.setCustDetId(guestcustOrder.getCustomerId());
			
			bill.setPayModId(guestcustOrder.getPayModId());
			bill.setCupnDiscAmnt(100.00f);
			bill.setTransactionId("1");
			bill.setCrtId(guestcustOrder.getCustomerId() + "");
			bill.setUpdId(guestcustOrder.getCustomerId() + "");
			bill.setCrtTs(date);
			bill.setUpdTs(date);
			//System.out.println("food DI------->"+guestcustOrder.getFoodTypId());
			cust.saveBillHist(bill);
			logger.info("id------->"+save.getPkgId());
			
			System.out.println("id"+save.getPkgId());
			//return cust.saveOrderBill(order);
		}
		

		for(DatesList orderdet:guestcustOrder.getDates())
		{
			System.out.println("Dates:"+orderdet);
		}
		//System.out.println("Dates:"+guestcustOrder.getDates());
		final java.util.Date date = DateCal();
		final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("id"+dateFormat);
		final Address address = new Address();
		address.setAddrTypeId(guestcustOrder.getAddrTypeId());
		address.setAreaId(getAreaByName(guestcustOrder.getArea()).getId());
		address.setCityId(getCityByCityName(guestcustOrder.getCity()).getId());
		address.setCustDetId(guestcustOrder.getCustomerId());
		address.setHouseNo(guestcustOrder.getHouseNo());
		address.setLandMrk(guestcustOrder.getLandMrk());
		address.setLaneDesc(guestcustOrder.getLaneDesc());
		//address.setLoginTyp(guestcustOrder.getLoginTyp());
		//address.setPinCode(guestcustOrder.getPinCode());
		address.setCrtId(guestcustOrder.getCustomerId() + "");
		address.setCrtTs(date);
		
		address.setUpdId(guestcustOrder.getCustomerId() + "");
		Address newAddress=cust.saveCustomerAddress(address);
		
		
		
	  return cust.saveOrderBill(order);
		
	 }*/
	@Override
	public  int checkAddress (int addrTypeId, int customerId ){
		
		return cust.checkAddress(addrTypeId, customerId);
	}
	 /* @Override
	  public List<CustOrdDet> saveBill(List<CustOrderDetails> custorderlist)
	  {
		  final List<CustOrdDet> orderDet = new ArrayList<CustOrdDet>();
			final Calendar cal = Calendar.getInstance();
			final java.util.Date date = DateCal();
			final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			int addresscheck=0;
			float subAmount=0,taxAmount=0,grandSumTotal=0;
			float delvCharges=0,couponAmount=0,orderTotal=0,cpudes=0,vat=0,schtx=0,sertax=0,gsttax=0,redcan=0;
			
			for (final CustOrderDetails custOrder : custorderlist) {
				subAmount=subAmount+custOrder.getSubAmnt();
				taxAmount=taxAmount+custOrder.getTaxAmnt();
				delvCharges=delvCharges+custOrder.getDelChrg();
				orderTotal=orderTotal+custOrder.getGrndTot();
				cpudes=cpudes+custOrder.getCupnDiscAmnt();
				vat=vat+custOrder.getVatTax();
				schtx=schtx+custOrder.getSchTax();
				sertax=sertax+custOrder.getSerTax();
				gsttax=gsttax+custOrder.getSerTax();
				redcan=redcan+custOrder.getRedeemCancelAmnt();
				//couponAmount=custOrder.getCupnDiscAmnt();
			}
			
			final CustBillHist bill = new CustBillHist();
			bill.setCustDetId(custorderlist.get(0).getCustomerId());
			bill.setDelChrg(delvCharges);
		    bill.setCupnDiscAmnt(cpudes);
			bill.setPayModId(custorderlist.get(0).getPayModId());
			bill.setSubAmnt(subAmount);
			bill.setTaxAmnt(taxAmount);
			bill.setVatTax(vat);
			bill.setSchTax(schtx);
			bill.setGrndTot(gsttax);
			bill.setRedeemCancelAmnt(redcan);
			bill.setTransactionId("1");
		
			bill.setCrtId(custorderlist.get(0).getCustomerId()+ "");
			//bill.setCupnDiscAmnt(couponAmount);
			bill.setGrndTot(orderTotal);
			//bill.setTransactionId();
			bill.setUpdId(custorderlist.get(0).getCustomerId()+ "");
			bill.setCrtTs(date);
			bill.setUpdTs(date);
			cust.saveBillHist(bill);
			
			
			for (final PackgSave ord : custorderlist.get(0).getSavePkg()) {
			
			if(ord.getAddrTypeId()!=3){
				addresscheck= checkAddress(ord.getAddrTypeId(),ord.getCustomerId());
			}
			if(addresscheck==0){
				final Address address = new Address();
				address.setAddrTypeId(ord.getAddrTypeId());
				address.setAreaId(getAreaByName(ord.getArea()).getId());
				address.setCityId(getCityByCityName(ord.getCity()).getId());
				address.setCustDetId(ord.getCustomerId());
				address.setHouseNo(ord.getHouseNo());
				address.setLandMrk(ord.getLandMrk());
				address.setLaneDesc(ord.getLaneDesc());
				//address.setLoginTyp(ord.getLoginTyp());
				//address.setPinCode(ord.getPinCode());
				address.setCrtId(ord.getCustomerId() + "");
				address.setCrtTs(date);
				//address.setUpdTs(date);
				address.setUpdId(ord.getCustomerId() + "");
				System.out.println("address is saving now>>>>>");
				cust.saveCustomerAddress(address);
				
				final CustOrdDet order = new CustOrdDet();
				order.setCustBillId(bill.getId());
				order.setCustDet(findCustDevBYId(ord.getCustomerId()));
				order.setAddressId(ord.getAddressId());
				//order.setPkgSizTypQty(ord.getPkgQunty());
				//order.setPkgSizTyp(getPkgSizTypById(ord.getPkgSizTyp()));
				order.setMealTime(getMealTimeById(ord.getMealTimeId()));
				order.setMealTyp(getMealTypById(ord.getMealTypeId()));
				//order.setPkgSizTypId(ord.getp);
				order.setPkgSizTypQty(ord.getPkgQunty());
				order.setCrtId(ord.getCustomerId() + "");
				order.setUpdId(ord.getCustomerId() + "");
				order.setCrtTs(date);
				order.setUpdTs(date);
				order.setOrdStDt(ord.getOrdStDt());
				order.setOrdEndDt(ord.getOrdEndDt());
				order.setOrdTmstp(ord.getOrdStDt());
				order.setOrdBillAmnt(subAmount);
				order.setCrtId("1");
				order.setPayModId(ord.getPayModId());
				//order.setBillAmount(ord.getGrndTot());
				//order.setOrdOrigin(2);
				order.setOrdDt(dateFormat.format(date));
				//order.setOrdrSt(getOrdStById(ord.getOrdStatusId()));
				//order.setPkgsiztyp(ord.getPkgSizTyp());
				
				order.setFoodTyp(getFoodTypById(ord.getFoodTypId()));
				order.setPkgDur(getPkgDurById(ord.getPkgDurId()));
				order.setWeekTyp(getWeekTypById(ord.getWeekDur()));
				//order.setEndDt(dateFormat.format(endDate(ord.getWeakTypId(), ord.getPkgDurId())));
				//order.setStartDt(orderStartDateString);
				
				cust.saveOrderBill(order);
				CustOrdDet detail=new CustOrdDet();
				detail.setOrdNo(order.getOrdNo());
				detail.setCrtId("1");
				cust.saveOrderBill(detail);
				CustOrdDet orderSave = new CustOrdDet();
				orderSave=order;
				if (orderSave != null) {
					orderDet.add(orderSave);
				}
				//return orderDet;
			}return orderDet;
				  }*/
	 @Override
	 public List<CustOrdDet> saveBill(CustOrderDetails custorderlist) {
	  
	  final List<CustOrdDet> orderDet = new ArrayList<CustOrdDet>();
	  final List<PackgSave> lunchBasedOrders = new ArrayList<PackgSave>();
	  final List<PackgSave> dinnerBasedOrders = new ArrayList<PackgSave>();
	  final java.util.Date date = DateCal();
	  final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  /*
	   * int addresscheck=0; float subAmount=0,taxAmount=0,grandSumTotal=0;
	   * float
	   * delvCharges=0,couponAmount=0,orderTotal=0,cpudes=0,vat=0,schtx=0
	   * ,sertax=0,gsttax=0,redcan=0;
	   * 
	   * for (final CustOrderDetails custOrder : custorderlist) {
	   * subAmount=subAmount+custOrder.getSubAmnt();
	   * taxAmount=taxAmount+custOrder.getTaxAmnt();
	   * delvCharges=delvCharges+custOrder.getDelChrg();
	   * orderTotal=orderTotal+custOrder.getGrndTot();
	   * cpudes=cpudes+custOrder.getCupnDiscAmnt();
	   * vat=vat+custOrder.getVatTax(); schtx=schtx+custOrder.getSchTax();
	   * sertax=sertax+custOrder.getSerTax();
	   * gsttax=gsttax+custOrder.getSerTax();
	   * redcan=redcan+custOrder.getRedeemCancelAmnt(); }
	   */

	  final CustBillHist bill = new CustBillHist();
	  bill.setCustDetId(custorderlist.getCustomerId());
	  bill.setDelChrg(custorderlist.getDelChrg());
	  bill.setCupnDiscAmnt(custorderlist.getCupnDiscAmnt());
	  bill.setPayModId(custorderlist.getPayModId());
	  bill.setSubAmnt(custorderlist.getSubAmnt());
	  bill.setTaxAmnt(custorderlist.getTaxAmnt());
	  bill.setVatTax(custorderlist.getVatTax());
	  bill.setSchTax(custorderlist.getSchTax());
	  bill.setSubGrndTot(custorderlist.getSubGrandTotal());
	  bill.setGrndTot(custorderlist.getGrndTot());
	  bill.setOrdrStId(1);
	  bill.setOrdStDt(custorderlist.getSavePkg().get(0).getOrdStDt());
	  bill.setOrdEndDt(custorderlist.getSavePkg().get(0).getOrdEndDt());
	  bill.setRedeemCancelAmnt(custorderlist.getRedeemCancelAmnt());
	  bill.setTransactionId(custorderlist.getTransactionId());
	  bill.setGstTax(custorderlist.getGstTax());
	  bill.setSerTax(custorderlist.getSerTax());
	  bill.setPaymentGatewayTypId(custorderlist.getPayModId());
	  bill.setVatTax(custorderlist.getVatTax());
	  bill.setGstTax(custorderlist.getGstTax());
	  bill.setSchTax(custorderlist.getSchTax());
	  bill.setSerTax(custorderlist.getSerTax());
	  //bill.setOrdrStId(custorderlist.getOrderStatusId());
	  bill.setCrtId(custorderlist.getCustomerId() +"");
	  bill.setUpdId(custorderlist.getCustomerId() +"");
	  bill.setCrtTs(date);
	  bill.setUpdTs(date);
	  cust.saveBillHist(bill);
	  
	  final CupnDet saveCouponDet= new CupnDet();
	  
	  saveCouponDet.setCupnAmount(custorderlist.getCupnDiscAmnt()+"");
	  saveCouponDet.setCupnId(custorderlist.getCupnId());
	  saveCouponDet.setCustBillHistId(bill.getId());
	  saveCouponDet.setCustDetId(custorderlist.getCustomerId());
	  saveCouponDet.setCrtTs(date+"");
	  saveCouponDet.setCupnAmontF(0);
	  
	  cust.saveCouponDetails(saveCouponDet);
	  float lunchPackagesAmount=0;
	  float dinnerPackagesAmount=0;
	  for (final PackgSave order : custorderlist.getSavePkg()) {
		 
		  if(order.getMealTimeId()==2){
			//  dinnerPackagesAmount=dinnerPackagesAmount+(order.getPackageAmount()*order.getPkgQunty());
			 
			  dinnerPackagesAmount=dinnerPackagesAmount+(order.getPackageAmount());
			  System.out.println("dinner is added>>>>>");
			  dinnerBasedOrders.add(order);
		  }
		  if(order.getMealTimeId()==1){
			 // lunchPackagesAmount=lunchPackagesAmount+(order.getPackageAmount()*order.getPkgQunty());
			  lunchPackagesAmount=lunchPackagesAmount+(order.getPackageAmount());
			  lunchBasedOrders.add(order);
		  }
	  }
	  
	  if(lunchBasedOrders.size()>0){
		  CustOrdrs custOrders = new CustOrdrs();
			List<CustOrdrs> custOrdr = cust.getLastId();
			if (custOrdr.size() == 0) {
				System.out.println("lunchcustOrdersSize>>>>" + custOrdr.size());
				
				custOrders.setCustBillId(bill.getId());
				custOrders.setOrdNo(1);
				custOrders.setOrdrStId(1);
				custOrders.setMealTimeId(lunchBasedOrders.get(0).getMealTimeId());
				custOrders.setCustDetId(custorderlist.getCustomerId());
				custOrders.setPkgsSumAmount(lunchPackagesAmount);
				custOrders.setCrtTs(date);
				cust.saveCusterOrders(custOrders);
				
			} 
			if (custOrdr.size() != 0) {
				System.out.println("IfElse>>lunchCustOrdersSize>>>>"
						+ custOrdr.size());
				System.out.println("IfElse>>lunchCustOrderId>>>>"
						+ custOrdr.get(0).getId());
				custOrders.setCustBillId(bill.getId());
				custOrders.setOrdNo((custOrdr.get(0).getId()+1));
				custOrders.setOrdrStId(1);
				custOrders.setMealTimeId(lunchBasedOrders.get(0).getMealTimeId());
				custOrders.setCustDetId(custorderlist.getCustomerId());
				custOrders.setPkgsSumAmount(lunchPackagesAmount);
				custOrders.setCrtTs(date);
				cust.saveCusterOrders(custOrders);
			}
			
			for (final PackgSave ord : lunchBasedOrders) {

				   final CustOrdDet order = new CustOrdDet();
				   order.setCustBillId(bill.getId());
				   order.setCustDet(findCustDevBYId(custorderlist.getCustomerId()));
				   order.setAddressId(ord.getAddressId());
				   order.setMealTime(getMealTimeById(ord.getMealTimeId()));
				   order.setMenuTyp(getMenuTypById(ord.getMenuTypeId()));
				   order.setPkgSizTypQty(ord.getPkgQunty());
				   order.setCrtId(custorderlist.getCustomerId()+ "");
				   order.setUpdId(custorderlist.getCustomerId()+ "");
				   order.setPkgSize(getPackageId(ord.getPkgId()));
				   order.setCrtTs(date);
				   order.setUpdTs(date);
				   order.setOrdNo(custOrders.getOrdNo());
				   order.setOrdStDt(ord.getOrdStDt());
				   order.setOrdEndDt(ord.getOrdEndDt());
				   order.setOrdTmstp(ord.getOrdStDt());
				//   order.setOrdBillAmnt((ord.getPackageAmount()*ord.getPkgQunty()));
				   order.setOrdBillAmnt((ord.getPackageAmount()));
				   order.setCrtId(custorderlist.getCustomerId()+ "");
				   order.setPayModId(custorderlist.getPayModId());
				   order.setOrdDt(dateFormat.format(date));
				   order.setFoodTyp(getFoodTypById(ord.getFoodTypId()));
				   order.setMealType(getMealTypeById(ord.getMealTypeId()));
				   order.setPkgDur(getPkgDurById(ord.getPkgDurId()));
				   order.setWeekTyp(getWeekTypById(ord.getWeekDur()));
				   System.out.println("Paymod of in ordersAVE:"+ord.getPayModId());
				   
					   order.setOrdrStId(1);
				  
				   CustOrdDet ordDetails = cust.saveOrderBill(order);
				   List<orderDatesDet> orderDatesDet = ord.getOrderdates();
				     for (orderDatesDet saveOrderDates : orderDatesDet) {
				      OrderDateDetails orderDateDetails = new OrderDateDetails();
				      orderDateDetails.setActiveflag(1);
				      orderDateDetails.setCustOrdDetId(cust.checkOrderDetId(ordDetails.getId()));
				      //orderDate.setDayPrie(saveOrderDates.getDayPrice());
				      //orderDateDetails.setDayPrie(packageDayPrice);
				      orderDateDetails.setOrdDate(saveOrderDates.getOrdDate());
				      orderDateDetails.setQuantity(ord.getPkgQunty());
				      orderDateDetails.setCrtTs(date);
				      cust.saveOrderDateDetails(orderDateDetails);
				     }

				   CustOrdDet orderSave = new CustOrdDet();
				   orderSave = order;
				   if (orderSave != null) {
				    orderDet.add(orderSave);
				   }
				  }	
	  }
	  if (dinnerBasedOrders.size()>0){
		  CustOrdrs custOrdersDet = new CustOrdrs();
			List<CustOrdrs> custOrdrs = cust.getLastId();
			if (custOrdrs.size() == 0) {
				System.out.println("dinnerOrdersSize>>>>" + custOrdrs.size());
				custOrdersDet.setCustBillId(bill.getId());
				custOrdersDet.setOrdNo(1);
				custOrdersDet.setOrdrStId(6);
				custOrdersDet.setMealTimeId(dinnerBasedOrders.get(0).getMealTimeId());
				custOrdersDet.setCustDetId(custorderlist.getCustomerId());
				custOrdersDet.setPkgsSumAmount(dinnerPackagesAmount);
				custOrdersDet.setCrtTs(date);
				cust.saveCusterOrders(custOrdersDet);
				
			} 
			if (custOrdrs.size() != 0) {
				System.out.println("dinnerOrdersSize>>>>"
						+ custOrdrs.size());
				System.out.println("dinnerCustOrderId>>>>"
						+ custOrdrs.get(0).getId());
				custOrdersDet.setCustBillId(bill.getId());
				custOrdersDet.setOrdNo((custOrdrs.get(0).getId()+1));
				custOrdersDet.setOrdrStId(1);
				custOrdersDet.setMealTimeId(dinnerBasedOrders.get(0).getMealTimeId());
				custOrdersDet.setCustDetId(custorderlist.getCustomerId());
				custOrdersDet.setPkgsSumAmount(dinnerPackagesAmount);
				custOrdersDet.setCrtTs(date);
				cust.saveCusterOrders(custOrdersDet);
			}
			
			for (final PackgSave ord : dinnerBasedOrders) {

				   final CustOrdDet order = new CustOrdDet();
				   order.setCustBillId(bill.getId());
				   order.setCustDet(findCustDevBYId(custorderlist.getCustomerId()));
				   order.setAddressId(ord.getAddressId());
				   order.setMealTime(getMealTimeById(ord.getMealTimeId()));
				   order.setMenuTyp(getMenuTypById(ord.getMenuTypeId()));
				   order.setPkgSizTypQty(ord.getPkgQunty());
				   order.setCrtId(custorderlist.getCustomerId()+ "");
				   order.setUpdId(custorderlist.getCustomerId()+ "");
				   order.setPkgSize(getPackageId(ord.getPkgId()));
				   order.setCrtTs(date);
				   order.setUpdTs(date);
				   order.setOrdNo(custOrdersDet.getOrdNo());
				   order.setOrdStDt(ord.getOrdStDt());
				   order.setOrdEndDt(ord.getOrdEndDt());
				   order.setOrdTmstp(ord.getOrdStDt());
				   order.setOrdBillAmnt((ord.getPackageAmount()*ord.getPkgQunty()));
				   order.setCrtId(custorderlist.getCustomerId()+ "");
				   order.setPayModId(custorderlist.getPayModId());
				   order.setOrdDt(dateFormat.format(date));
				   order.setFoodTyp(getFoodTypById(ord.getFoodTypId()));
				   order.setMealType(getMealTypeById(ord.getMealTypeId()));
				   order.setPkgDur(getPkgDurById(ord.getPkgDurId()));
				   order.setWeekTyp(getWeekTypById(ord.getWeekDur()));
				   
					   order.setOrdrStId(1);  
				  
				   CustOrdDet ordDetails =cust.saveOrderBill(order);
				   List<orderDatesDet> orderDatesDet = ord.getOrderdates();
				     for (orderDatesDet saveOrderDates : orderDatesDet) {
				      OrderDateDetails orderDateDetails = new OrderDateDetails();
				      orderDateDetails.setActiveflag(1);
				      orderDateDetails.setCustOrdDetId(cust.checkOrderDetId(ordDetails.getId()));
				      //orderDate.setDayPrie(saveOrderDates.getDayPrice());
				      orderDateDetails.setOrdDate(saveOrderDates.getOrdDate());
				      orderDateDetails.setQuantity(ord.getPkgQunty());
				      orderDateDetails.setCrtTs(date);
				      cust.saveOrderDateDetails(orderDateDetails);
				     }
				
				   CustOrdDet orderSave = new CustOrdDet();
				   orderSave = order;
				   if (orderSave != null) {
				    orderDet.add(orderSave);
				   }
				  }
			
	  }
	  
	  System.out.println("LunchList"+lunchBasedOrders);
	  System.out.println("DinnerList"+dinnerBasedOrders);
	  /*for (final PackgSave ord : custorderlist.getSavePkg()) {

	   final CustOrdDet order = new CustOrdDet();
	   order.setCustBillId(bill.getId());
	   order.setCustDet(findCustDevBYId(custorderlist.getCustomerId()));
	   order.setAddressId(ord.getAddressId());
	   order.setMealTime(getMealTimeById(ord.getMealTimeId()));
	   order.setMenuTyp(getMenuTypById(ord.getMenuTypeId()));
	   order.setPkgSizTypQty(ord.getPkgQunty());
	   order.setCrtId(custorderlist.getCustomerId()+ "");
	   order.setUpdId(custorderlist.getCustomerId()+ "");
	   order.setPkgSize(getPackageId(ord.getPkgId()));
	   order.setCrtTs(date);
	   order.setUpdTs(date);
	   order.setOrdStDt(ord.getOrdStDt());
	   order.setOrdEndDt(ord.getOrdEndDt());
	   order.setOrdTmstp(ord.getOrdStDt());
	   order.setOrdBillAmnt((ord.getPackageAmount()*ord.getPkgQunty()));
	   order.setCrtId(custorderlist.getCustomerId()+ "");
	   order.setPayModId(custorderlist.getPayModId());
	   order.setOrdDt(dateFormat.format(date));
	   order.setFoodTyp(getFoodTypById(ord.getFoodTypId()));
	   order.setMealType(getMealTypeById(ord.getMealTypeId()));
	   order.setPkgDur(getPkgDurById(ord.getPkgDurId()));
	   order.setWeekTyp(getWeekTypById(ord.getWeekDur()));
	   order.setOrdrStId(6);
	   cust.saveOrderBill(order);

	   CustOrdDet orderSave = new CustOrdDet();
	   orderSave = order;
	   if (orderSave != null) {
	    orderDet.add(orderSave);
	   }
	  }*/

	  return orderDet;

	 }
	@Override
	public WeekTyp getWeekTypById(int id) {
		return cust.getWeekTypById(id);
	}
	@Override
	public CustDet findCustDevBYId(int id)
	{
		return cust.findCustDevBYId(id);
	}
	@Override
	public List<MealTime> getMealTimeList() {

		return cust.getMealTimeList();
	}
	@Override
	 public MealTyp getMealTypeById(int id){
	  
	  return cust.getMealTypeById(id);
	 }
	@Override
	public  List<PkgSizTyp>  getPackageCount()
	{
		return cust.getPackageCount();
	}
	@Override
	public List<PkgDur> getMealDurationList() {

		return cust.getMealDurationList();
	}
	
	
	
	@Override
	public List<pkgDuration> getPackageDurationList() {
		// TODO Auto-generated method stub
		return cust.getPackageDurationList();
		
	}
	@Override
	public List<WeekTyp> getWeekDurationList() {

		return cust.getWeekDurationList();
	}
	
	@Override
	public List<PayMod> getPaymentTypeList() {

		return cust.getPaymentTypeList();
	}
	
	@Override
	public List<Tax> getTaxList() {

		return cust.getTaxList();
	}
	@Override
	public List<FoodTyp> getFoodTypeList() {
		
		return cust.getFoodTypeList();
	}
	
	@Override
	public List<MenuTyp> getMenuTypeList() {
		
		return cust.getMenuTypeList();
	}
	@Override
	public List<DelvChrg> getDeliveryChargesList() {
		
		return cust.getDeliveryChargesList();
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



	@Override
	public List<PkgSizTyp> getPackagesMenuList(MenuList menu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PkgConfigRelt> getItemsBasedOnPackage(Integer id, String dates,String endate) {
		// TODO Auto-generated method stub
		System.out.println("Start Date In Service :"+dates);
		System.out.println("End Date in Service:"+endate);
		return cust.getItemsBasedOnPackage(id,dates,endate);
	}
	
	@Override
	public List<PkgConfigRelt> getItemsBasedOnPackageDinner(Integer id, String dates, String endDateForSearch) {
		// TODO Auto-generated method stub
		return cust.getItemsBasedOnPackageDinner(id,dates,endDateForSearch);
	}
	@Override
	public List<PkgConfigRelt> getListOf(Integer id)
	{
		return cust.getListOf(id);
	}
	@Override
	public List<PkgSizTyp> getPackageSizeDetails() {
		
		return cust.getPackageSizeDetails();
	}
	@Override
	public List<PkgConfigRelt> getItemsBasedOnPackage(int id, String dates) {
		
		return cust.getItemsBasedOnPackage(id,dates);
	}
	
	@Override
	public int updateOrderPaymode(Paymod paymod) {
		int check = 0;
			
			CustBillHist billDetails = cust.getCustBillHistById(paymod
					.getCustBillId());
			billDetails.setPayModId(paymod.getPaymodeId());
			billDetails.setTransactionId(paymod.getTransactionId());
			if(paymod.getPaymodeId()==4){
				billDetails.setOrdrStId(1);
			}else if (paymod.getPaymodeId()!=4 && paymod.getPaymodeId()!=0){
				billDetails.setOrdrStId(1);
			}
			CustDet custDetails = cust.findCustDevBYId(billDetails
					.getCustDetId());

			if (billDetails.getRedeemCancelAmnt() > 0) {
				float walletAmount = custDetails.getCupnRedmAmnt()- billDetails.getRedeemCancelAmnt();
				custDetails.setCupnRedmAmnt(walletAmount);
				cust.updateWalletAmount(custDetails);
				List<CancelledOrderDetails> cancelOrdDet = cust.findCancelOrdDetById(billDetails.getCustDetId());
				if (walletAmount > 0) {
					int custBillId = 0;
					int custDetId = 0;
					int custOrdDetailId = 0;
					for (CancelledOrderDetails cancelDet : cancelOrdDet) {
						cancelDet.setCupnF(1);

						cust.updateCancelCouponFlg(cancelDet);
						custBillId = Integer.parseInt(cancelDet
								.getCustBillHistId());
						custDetId = cancelDet.getCustDetId();
						custOrdDetailId = Integer.parseInt(cancelDet
								.getCustOrdDetId());

					}
					CancelledOrderDetails insertCancelCoupon = new CancelledOrderDetails();
					insertCancelCoupon.setCupnAmnt(walletAmount);
					insertCancelCoupon.setCupnDesc("New Cancel Coupon");
					insertCancelCoupon.setCupnF(0);
					insertCancelCoupon.setCustBillHistId(custBillId + "");
					insertCancelCoupon.setCustDetId(custDetId);
					insertCancelCoupon.setCustOrdDetId(custOrdDetailId + "");
					cust.insertNewCancelCoupon(insertCancelCoupon);
				} else {

					for (CancelledOrderDetails cancelDet : cancelOrdDet) {
						cancelDet.setCupnF(1);
						cust.updateCancelCouponFlg(cancelDet);
					}
				}

			}

			if (billDetails.getCupnDiscAmnt() > 0) {
				List<CupnDet> couponDetails = cust
						.getUserCouponDetails(billDetails.getCustDetId(), billDetails.getId());
				for (CupnDet couponDet : couponDetails) {

					couponDet.setCupnAmontF(1);
					cust.updateCouponDet(couponDet);

				}
			}

			check = cust.updateCustBillDetails(billDetails);

			List<CustOrdDet> paymentStatusUpdate = cust.getCustOrdDetById(paymod.getCustBillId());
			List<CustOrdrs> statusCustOrdersUpdate = cust.getCustOrdsById(paymod.getCustBillId());
			for (CustOrdDet custOrdDt : paymentStatusUpdate) {

				custOrdDt.setPayModId(paymod.getPaymodeId());
				
				if(paymod.getPaymodeId()==4){
					custOrdDt.setOrdrStId(1);
				}else if (paymod.getPaymodeId()!=4 && paymod.getPaymodeId()!=0){
					custOrdDt.setOrdrStId(1);
				}
				cust.updateCustOrdDetails(custOrdDt);
			}

			for (CustOrdrs custOrds : statusCustOrdersUpdate) {

				if(paymod.getPaymodeId()==4){
					custOrds.setOrdrStId(1);
				}else if (paymod.getPaymodeId()!=4 && paymod.getPaymodeId()!=0){
					custOrds.setOrdrStId(1);
				}
				cust.updateCustOrdrs(custOrds);
			}
		

		if (check == 1)
			return 1;
		else
			return 0;
	}
	
/*	@Override
	public int updateOrderPaymode(Paymod paymod) {
		int check = 0;
			
			CustBillHist billDetails = cust.getCustBillHistById(paymod
					.getCustBillId());
			billDetails.setPayModId(paymod.getPaymodeId());
			billDetails.setTransactionId(paymod.getTransactionId());
			if(paymod.getPaymodeId()==4){
				billDetails.setOrdrStId(6);
			}else if (paymod.getPaymodeId()!=4 && paymod.getPaymodeId()!=0){
				billDetails.setOrdrStId(7);
			}
			CustDet custDetails = cust.findCustDevBYId(billDetails
					.getCustDetId());

			if (billDetails.getRedeemCancelAmnt() > 0) {
				float walletAmount = custDetails.getCupnRedmAmnt()- billDetails.getRedeemCancelAmnt();
				custDetails.setCupnRedmAmnt(walletAmount);
				cust.updateWalletAmount(custDetails);
				List<CancelledOrderDetails> cancelOrdDet = cust.findCancelOrdDetById(billDetails.getCustDetId());
				if (walletAmount > 0) {
					int custBillId = 0;
					int custDetId = 0;
					int custOrdDetailId = 0;
					for (CancelledOrderDetails cancelDet : cancelOrdDet) {
						cancelDet.setCupnF(1);

						cust.updateCancelCouponFlg(cancelDet);
						custBillId = Integer.parseInt(cancelDet
								.getCustBillHistId());
						custDetId = cancelDet.getCustDetId();
						custOrdDetailId = Integer.parseInt(cancelDet
								.getCustOrdDetId());

					}
					CancelledOrderDetails insertCancelCoupon = new CancelledOrderDetails();
					insertCancelCoupon.setCupnAmnt(walletAmount);
					insertCancelCoupon.setCupnDesc("New Cancel Coupon");
					insertCancelCoupon.setCupnF(0);
					insertCancelCoupon.setCustBillHistId(custBillId + "");
					insertCancelCoupon.setCustDetId(custDetId);
					insertCancelCoupon.setCustOrdDetId(custOrdDetailId + "");
					cust.insertNewCancelCoupon(insertCancelCoupon);
				} else {

					for (CancelledOrderDetails cancelDet : cancelOrdDet) {
						cancelDet.setCupnF(1);
						cust.updateCancelCouponFlg(cancelDet);
					}
				}

			}

			if (billDetails.getCupnDiscAmnt() > 0) {
				List<CupnDet> couponDetails = cust
						.getUserCouponDetails(billDetails.getCustDetId(), billDetails.getId());
				for (CupnDet couponDet : couponDetails) {

					couponDet.setCupnAmontF(1);
					cust.updateCouponDet(couponDet);

				}
			}

			check = cust.updateCustBillDetails(billDetails);

			List<CustOrdDet> paymentStatusUpdate = cust.getCustOrdDetById(paymod.getCustBillId());
			List<CustOrdrs> statusCustOrdersUpdate = cust.getCustOrdsById(paymod.getCustBillId());
			for (CustOrdDet custOrdDt : paymentStatusUpdate) {

				custOrdDt.setPayModId(paymod.getPaymodeId());
				if(paymod.getPaymodeId()==4){
					custOrdDt.setOrdrStId(6);
				}else if (paymod.getPaymodeId()!=4 && paymod.getPaymodeId()!=0){
					custOrdDt.setOrdrStId(7);
				}
				cust.updateCustOrdDetails(custOrdDt);
			}

			for (CustOrdrs custOrds : statusCustOrdersUpdate) {

				if(paymod.getPaymodeId()==4){
					custOrds.setOrdrStId(6);
				}else if (paymod.getPaymodeId()!=4 && paymod.getPaymodeId()!=0){
					custOrds.setOrdrStId(7);
				}
				cust.updateCustOrdrs(custOrds);
			}
		

		if (check == 1)
			return 1;
		else
			return 0;
	}*/
	
	@Override
	public List<CustOrdDet> getCustomerOrders(int custBillId) {
		
		return cust.getCustomerOrders(custBillId);
	}
	
	
	
	
	
	@Override
	public Address getAddressDet(Integer addressId) {
		// TODO Auto-generated method stub
		return cust.getAddressDet(addressId);
	}
	@Override
	public CustBillHist getCustBillDetById(int custBillId) {
		// TODO Auto-generated method stub
		return cust.getCustBillDetById(custBillId);

	}
	
	
	@Override
	public List<CustBillHist> getBillDetById(int custBillId) {
		// TODO Auto-generated method stub
		return cust.getBillDetById(custBillId);
	}
	@Override
	public PkgSizTyp updatePackageStockCount(Integer id,int pkgQuantity) {
		PkgSizTyp upadatePackageStock= cust.getPackageDetailsById(id);
		if(upadatePackageStock!=null){
		int packageStockCount=upadatePackageStock.getPkgStockCount()-pkgQuantity;
		upadatePackageStock.setPkgStockCount(packageStockCount);
		}
		
		return cust.upadatePackageStock(upadatePackageStock);
		
	}
	@Override
	public CustBillHist getBillDetailsById(Integer custBillId) {
		
		return cust.getBillDetailsById(custBillId);
	}
	@Override
	public List<CustBillHist> getBillIdByCustId(ManageOrder order) {
		
		return cust.getBillIdByCustId(order);
	}
	@Override
	public List<CustOrdrs> getOrderDetailsByMealTime(int id) {
		
		return cust.getOrderDetailsByMealTime(id);
	}
	@Override
	public List<CustOrdDet> getOrderDetailsByOrderNo(int ordNo) {
		
		return cust.getOrderDetailsByOrderNo(ordNo);
	}
	@Override
	public MealTime getCutOffTimeBasedonMealTime(int mealTime) {
		
		return cust.getCutOffTimeBasedonMealTime(mealTime);
	}
	@Override
	public Holidays getHolidayDet(String dates) {
		
		return cust.getHolidayDet(dates);
	}
	@Override
	public List<MealPlan> getMealPlanList() {
		
		return cust.getMealPlanList();
	}
	
	String orderStartDateString="2016-02-05";
	
	public Date endDate(int weekId, int pkgDurId) {

		String orderDate = "";

		String orderEndDateString = "";
		int weekPkgid, pkgDruId;
		weekPkgid = weekId;
		pkgDruId = pkgDurId;

		Date deliveryDates = null;

		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = new Date();

		DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal1 = Calendar.getInstance();
		String todayDate = dateFormat1.format(cal1.getTime());
		Date orderEndDate = null;
		try {

			Calendar c = Calendar.getInstance();
			c.setTime(d);

			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int date = c.get(Calendar.DATE);

			GregorianCalendar mondayDate = new GregorianCalendar(year, month,date);

			while (mondayDate.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
				mondayDate.add(Calendar.DATE, 1);
			}

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// System.out.println(":::::::MONDAY DATE:::::::"+sdf.format(mondayDate.getTime()));
			orderStartDateString = sdf.format(orderStartDateString);

			orderDate = sdf.format(d);
			/*
			 * if(orderStartDateString.equls(orderDate)){
			 * mondayDate.add(Calendar.WEEK_OF_MONTH, 1); }
			 */

			SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate = formate.parse(orderStartDateString);
			Date today = formate.parse(orderDate);

			if (startDate.compareTo(today) == 0) {
				System.out.println("startdate  is equal to end");
				mondayDate.add(Calendar.DATE, 7);

			}

			// meal.setOrderDate(orderDate);
			orderStartDateString = sdf.format(orderStartDateString);
			// System.out.println(":::DELIVERY START DATE::::"+sdf.parse(orderStartDateString));
			// meal.setDeliveryStartDate(orderStartDateString); // Order start
			// date (MONDAY of the next week from the order placed date)

			if (pkgDruId == 1) { // Package Duration : 1 Week Trial
				c.setTime(sdf.parse(orderStartDateString));
				System.out.println("OrderStartDate>>>>>>> "+c.getTime());
				/*
				 * c.add(Calendar.WEEK_OF_MONTH, 1); // add one week to the
				 * orderStartDate c.add(Calendar.DAY_OF_WEEK,-2);
				 */
				orderEndDateString = sdf.format(c.getTime()); // Last date of
																// the week
				if (weekPkgid == 2) {
					c.add(Calendar.WEEK_OF_MONTH, 1);
					c.add(Calendar.DAY_OF_WEEK, -2);
					orderEndDateString = sdf.format(c.getTime());
					System.out.println(":::DELIVERY end DATE::::"
							+ sdf.parse(orderEndDateString));
					// deliveryDates =
					// getSixDayDates(sdf.parse(orderStartDateString),
					// sdf.parse(orderEndDateString)); // Get dates with 6 day
					// week [MON - SAT]
					// System.out.println(":::DELIVERY DATES [including Cancelled delivery]::::"+deliveryDates);
				} else {
					c.add(Calendar.WEEK_OF_MONTH, 1);
					c.add(Calendar.DAY_OF_WEEK, -3);
					orderEndDateString = sdf.format(c.getTime());
					// deliveryDates =
					// getFiveDayDates(sdf.parse(orderStartDateString),
					// sdf.parse(orderEndDateString)); // Get dates with 5 day
					// week [MON - FRI]
					// System.out.println(":::DELIVERY DATES [including Cancelled delivery]::::"+deliveryDates);
				}
			} else if (pkgDruId == 2) { // Package Duration : 1 Month
				c.setTime(sdf.parse(orderStartDateString));
				//c.add(Calendar.MONTH, 1);
				c.add(Calendar.WEEK_OF_MONTH, 4);
				// c.add(Calendar.MONTH, 1); // add one month to the
				// orderStartDate

				// Last date of 1 month duration
				if (weekPkgid == 2) {
					//c.add(Calendar.DAY_OF_MONTH, -1);
					c.add(Calendar.DAY_OF_MONTH, -2);
					orderEndDateString = sdf.format(c.getTime());
					// deliveryDates =
					// getSixDayDates(sdf.parse(orderStartDateString),
					// sdf.parse(orderEndDateString)); // Get dates with 6 day
					// week [MON - SAT]
				} else {
					//c.add(Calendar.DAY_OF_MONTH, -1);
					c.add(Calendar.DAY_OF_MONTH, -3);
					orderEndDateString = sdf.format(c.getTime());
					// deliveryDates =
					// getFiveDayDates(sdf.parse(orderStartDateString),
					// sdf.parse(orderEndDateString)); // Get dates with 5 day
					// week [MON - FRI]
				}
			} else { // Package Duration : 3 Months
				c.setTime(sdf.parse(orderStartDateString));
				// c.add(Calendar.MONTH, 3); // add three months to the
				// orderStartDate
				//c.add(Calendar.MONTH, 3);
				c.add(Calendar.WEEK_OF_MONTH, 12);
				orderEndDateString = sdf.format(c.getTime()); // Last date of 3
																// months
																// duration
				if (weekPkgid == 2) {
					//c.add(Calendar.DAY_OF_MONTH, -1);
					c.add(Calendar.DAY_OF_MONTH, -2);
					orderEndDateString = sdf.format(c.getTime());
					// deliveryDates =
					// getSixDayDates(sdf.parse(orderStartDateString),
					// sdf.parse(orderEndDateString)); // Get dates with 6 day
					// week [MON - SAT]
				} else {
					//c.add(Calendar.DAY_OF_MONTH, -1);
					c.add(Calendar.DAY_OF_MONTH, -3);
					orderEndDateString = sdf.format(c.getTime());
					// deliveryDates =
					// getFiveDayDates(sdf.parse(orderStartDateString),
					// sdf.parse(orderEndDateString)); // Get dates with 5 day
					// week [MON - FRI]
				}

			}
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			orderEndDate = format.parse(orderEndDateString);

		} catch (Exception e) {
		}

		return orderEndDate;

	}
	
	
}
