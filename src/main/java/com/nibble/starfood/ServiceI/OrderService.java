package com.nibble.starfood.ServiceI;

import java.util.List;

import com.nibble.starfood.hibernatemodel.Address;
import com.nibble.starfood.hibernatemodel.Area;
import com.nibble.starfood.hibernatemodel.City;
import com.nibble.starfood.hibernatemodel.Cupn;
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
import com.nibble.starfood.webservices.model.Paymod;





public interface OrderService {
	public List<CustOrdDet> saveBill(CustOrderDetails custorderlist);
	public MealTyp getMealTypeById(int id);
	//public List<PkgSizTyp> getMenuforSingleDay(MenuList singleDayMenu);
	public List<PkgSizTyp> getPackagesMenuList(MenuList menu);
	
	 public List<PkgSizTyp> getPkg(MenuList menu);
	 
	 public PkgSizTyp getPackageId(int id); 
	 
	 public  List<PkgSizTyp>  getPackageCount();
	 
	 public List<CustOrdDet> getCustOrderDetails(ManageOrder order);
	 
	public List<PkgConfigRelt> getFoodItemById(GetFoodItems getitems);
	
	public CustDet otpActive();
	
	public List<PkgConfigRelt> getPackgItemById(GetFoodItems getlist);
	
	 //public CustOrdDet saveOrderBill(CustOrderDetails guestcustOrder); 
	 
	 public List<PkgFoodItm> getItemList(AllMenu allmenu);
	 
	 public List<PkgSizTyp> getPackagesMenuList(AllMenu allmenu);
	 
	 public List<PkgSizTyp> listOfMealPlanList();
	 
	 public CustOrdDet saveDate(DatesList dateList);
	 
	 public CustDet findCustDevBYId(int id);
	 
	 public Area getAreaByName(String area);
	 
	 public City getCityByCityName(String city);
	 
	 public MealTime getMealTimeById(int id);
	 
	 public MenuTyp getMenuTypById(int id);
	 
	 public FoodTyp getFoodTypById(int id);
	 
	 public PkgDur getPkgDurById(int id);
	 
	 public WeekTyp getWeekTypById(int id);
	 
	 public List<MealTime> getMealTimeList();
		
	 public List<PkgDur> getMealDurationList();
	 
	 public List<pkgDuration> getPackageDurationList();

	 public List<WeekTyp> getWeekDurationList();
	 
	 public List<PaymentGatewayDet> getPaymentGateWay();
	 
	 public List<CustOrdDet> listOfOrder();

	 public List<PayMod> getPaymentTypeList();

	 public List<Tax> getTaxList();
		
	 public List<FoodTyp> getFoodTypeList();
		
	 public List<MenuTyp> getMenuTypeList();
	 
	 public List<Cupn> getCupnDetails(int id);
	 
	 public CustDet getWalletDetailsById(int id);

	 public List<DelvChrg> getDeliveryChargesList();
		
	 //public List<CustOrdDet> saveBill(List<CustOrderDetails> custorderlist);
	 
	 public List<EorderClientDetail> getClientDetails();
	 
	 public int checkAddress(int addrTypeId, int customerId);

	public List<PkgConfigRelt>  getItemsBasedOnPackage(Integer id, String dates, String endDateForSearch);
	
	public List<PkgConfigRelt>  getItemsBasedOnPackageDinner(Integer id, String dates, String endDateForSearch);
	
	public List<PkgConfigRelt> getListOf(Integer id);

	public List<PkgSizTyp> getPackagesMenuList(GetFoodItems fooditems);
	
	public List<PkgSizTyp> getFoodMenuList(GetFoodItems fooditems);
	
	public List<PkgConfigRelt>  getPackageList();

	public List<PkgSizTyp> getPackageSizeDetails();

	public List<PkgConfigRelt> getItemsBasedOnPackage(int id, String dates);
	
	public int updateOrderPaymode(Paymod paymodeList);
	
	
	public Address getAddressDet(Integer addressId);
	
	public List<CustOrdDet> getCustomerOrders(int custBillId);
	
	public CustBillHist getCustBillDetById(int custBillId);
	
	public List<CustBillHist> getBillDetById(int custBillId);
	
	public PkgSizTyp updatePackageStockCount(Integer id, int pkgQuantity);
	
	public CustBillHist getBillDetailsById(Integer custBillId);
	
	public List<CustBillHist> getBillIdByCustId(ManageOrder order);
	
	public List<CustOrdrs> getOrderDetailsByMealTime(int id);
	
	public List<CustOrdDet> getOrderDetailsByOrderNo(int ordNo);
	
	public MealTime getCutOffTimeBasedonMealTime(int mealTime);
	
	public Holidays getHolidayDet(String dates);
	
	public List<MealPlan> getMealPlanList();
	public List<PkgConfigRelt> getItemsBasedOnPackageMealTime(Integer id, String dates, int mealTime);
	
	
	
}
