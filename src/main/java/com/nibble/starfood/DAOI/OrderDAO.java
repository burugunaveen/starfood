package com.nibble.starfood.DAOI;

import java.util.List;

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
import com.nibble.starfood.webservices.model.GetFoodItems;
import com.nibble.starfood.webservices.model.ManageOrder;
import com.nibble.starfood.webservices.model.MenuList;


public interface OrderDAO {

		//public List<PkgSizTyp> getMenuforSingleDay(MenuList singleDayMenu);
	     public List<EorderClientDetail> getClientDetails();
	     
	     
	     public MealTyp getMealTypeById(int id);
	     
	     public PkgSizTyp getPackageId(int id); 
	     
	     public CupnDet saveCouponDetails(CupnDet saveCouponDet);
	
	      public List<PkgConfigRelt> getFoodItemById(GetFoodItems getitems);
	      
	      public List<PkgSizTyp> getPackagesMenuList(GetFoodItems menu);
	      
	      public List<PkgSizTyp>  getFoodMenuList(GetFoodItems menu);
	      
	      public List<PkgConfigRelt>  getPackageList();
	      
	      public List<PkgSizTyp> getPkg(MenuList menu);
	      
	      public CustDet otpActive();
	      
	      public CustOrdDet checkOrderDetId(int ordDetId);
	     
	      public  List<PkgSizTyp>  getPackageCount();
	      
	      
	      public void saveOrderDateDetails(OrderDateDetails orderDate);
	  	
	      
	      public List<CustOrdDet> getCustOrderDetails(ManageOrder order);
	      
	      public List<PkgConfigRelt> getPackgItemById(GetFoodItems getlist);
	      
	     public List<PkgFoodItm> getItemList(AllMenu allmenu);
	      
	      public List<PkgSizTyp> getPackagesMenuList(AllMenu allmenu);
	      
	      public List<PkgSizTyp> listOfMealPlanList();
	      
	      public CustOrdDet saveOrderBill(CustOrdDet orderdetails);
	      
	      public CustDet findCustDevBYId(int id);
	      
	      public CustBillHist saveBillHist(CustBillHist bill);
	      
	      public Address saveCustomerAddress(Address address);
	      
	      public Area getAreaByName(String area);
	      
	      public City getCityByCityName(String city);
	      
	      public MealTime getMealTimeById(int id);
	      
	      public MenuTyp getMenuTypById(int id);
	      
	      public FoodTyp getFoodTypById(int id);
	      
	      public PkgDur getPkgDurById(int id);
	      
	      public List<Cupn> getCupnDetails(int id);
	      
	      public WeekTyp getWeekTypById(int id);
	      
	      public CustOrdDet gatListDate(CustOrdDet orderdetails);
	      
	      public List<CustOrdDet> listOfOrder();
	      
	      public CustDet getWalletDetailsById(int id);
	      
	      public List<MealTime> getMealTimeList();
	      
	      public List<PaymentGatewayDet> getPaymentGateWay();
		   	
	      public List<PkgDur> getMealDurationList();
	      
	      public List<pkgDuration> getPackageDurationList();
	      
			
		  public List<WeekTyp> getWeekDurationList();
		
		  public List<PayMod> getPaymentTypeList();
		
		  public List<Tax> getTaxList();
		
		  public List<FoodTyp> getFoodTypeList();
		
		  public List<MenuTyp> getMenuTypeList();
		
		  public List<DelvChrg> getDeliveryChargesList();	
		  
		  public int checkAddress(int addrTypeId, int customerId);

		public List<PkgConfigRelt> getItemsBasedOnPackage(Integer id,String dates, String endate);
		
		public List<PkgConfigRelt> getItemsBasedOnPackageDinner(Integer id,String dates, String endate);
		
		public List<PkgConfigRelt> getListOf(Integer id);

		List<PkgSizTyp> getPackageSizeDetails();

		public List<PkgConfigRelt> getItemsBasedOnPackage(int id,String dates);
		
		public CustBillHist getCustBillHistById(int id);
		
		public void updateWalletAmount(CustDet custDetails);
		
		public List<CancelledOrderDetails> findCancelOrdDetById(int id);
		
		public void updateCancelCouponFlg(CancelledOrderDetails cancelCouponDetails);
		
		public void insertNewCancelCoupon(CancelledOrderDetails cancelCouponDetails);
		
		public List<CupnDet> getUserCouponDetails(int custDetId, int id);
		
		public void updateCouponDet(CupnDet couponDet);
		
		public int updateCustBillDetails(CustBillHist order);
		
		public List<CustOrdDet> getCustOrdDetById(int id);
		
		public void updateCustOrdDetails(CustOrdDet order);

		public List<CustOrdDet> getCustomerOrders(int custBillId);
		
		public Address getAddressDet(Integer addressId);
		
		
		public CustBillHist getCustBillDetById(int custBillId);
		
		public List<CustBillHist> getBillDetById(int custBillId);


		public PkgSizTyp getPackageDetailsById(Integer id);


		public PkgSizTyp upadatePackageStock(PkgSizTyp upadatePackageStock);


		public CustBillHist getBillDetailsById(Integer custBillId);


		public List<CustOrdrs> getLastId();


		public CustOrdrs saveCusterOrders(CustOrdrs custOrders);


		public List<CustBillHist> getBillIdByCustId(ManageOrder order);


		public List<CustOrdrs> getOrderDetailsByMealTime(int id);


		public List<CustOrdDet> getOrderDetailsByOrderNo(int ordNo);


		public List<CustOrdrs> getCustOrdsById(int custBillId);


		public void updateCustOrdrs(CustOrdrs custOrds);


		public MealTime getCutOffTimeBasedonMealTime(int mealTime);


		public Holidays getHolidayDet(String dates);


		public List<MealPlan> getMealPlanList();


		public List<PkgConfigRelt> getItemsBasedOnPackageMealTime(Integer id, String dates, int mealTime);
		
}

																			  