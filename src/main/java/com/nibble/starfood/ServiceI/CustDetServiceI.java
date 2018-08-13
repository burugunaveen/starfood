package com.nibble.starfood.ServiceI;

import java.util.Date;
import java.util.List;

import com.nibble.starfood.hibernatemodel.AddrTyp;
import com.nibble.starfood.hibernatemodel.Address;
import com.nibble.starfood.hibernatemodel.AndroidPushMsg;
import com.nibble.starfood.hibernatemodel.Area;
import com.nibble.starfood.hibernatemodel.City;
import com.nibble.starfood.hibernatemodel.CustCupnRelt;
import com.nibble.starfood.hibernatemodel.CustDet;
import com.nibble.starfood.hibernatemodel.CustFdbkRelt;
import com.nibble.starfood.hibernatemodel.EorderClientDetail;
import com.nibble.starfood.hibernatemodel.FdbkQues;
import com.nibble.starfood.hibernatemodel.FoodTyp;
import com.nibble.starfood.hibernatemodel.Pincode;
import com.nibble.starfood.hibernatemodel.PkgSizTyp;
import com.nibble.starfood.hibernatemodel.SaveComment;
import com.nibble.starfood.hibernatemodel.SingleDayRelt;
import com.nibble.starfood.hibernatemodel.State;
import com.nibble.starfood.webservices.model.AddressFlag;
import com.nibble.starfood.webservices.model.AddressOut;
import com.nibble.starfood.webservices.model.AreaOut;
import com.nibble.starfood.webservices.model.CityOut;
import com.nibble.starfood.webservices.model.Cust;
import com.nibble.starfood.webservices.model.CustomerRegistration;
import com.nibble.starfood.webservices.model.FBLogin;
import com.nibble.starfood.webservices.model.FeedBack;
import com.nibble.starfood.webservices.model.FoodCat;
import com.nibble.starfood.webservices.model.GpSave;
import com.nibble.starfood.webservices.model.OTPGeneration;


public interface CustDetServiceI {
	
	// For Android push message service
	public List<AndroidPushMsg> getAndroidPushMsgRegIdList();
	
	public CustDet updateProfile(Cust profile);
	
	public CustDet otpActive(int id);
	
	 public City getCityId(int id);
	
	public List<City> getCityListData(String name);
	
	public CustDet changePwd(CustomerRegistration pwdchange);
	
	public List<SingleDayRelt> orderShowByDate(FoodCat singleDayMenu);
	
	public City getCityByName(String cityname);
	
	public List<FdbkQues> getFeedbackQuestionsList();
	
	public AndroidPushMsg saveAndroidPushMsg(AndroidPushMsg details);
	
	public AndroidPushMsg getAndroidPushMsgByEmail(String name);
	
	public void removeAndroidPushMsg(String reg);
	// For Date calculation
	public Date getIndianTimezoneDatewithTime();
	
    public CustDet Login(String email, String venderId, int flag);
    
    public CustDet LoginWithMObile(String mobile, String password, int flag);
    
    public CustDet LoginCheckWithMobile(String mobile, int guestFlag);

	
	public CustDet Loginforgot(String mobile, String email);
	
	public void changePassword(String newPassword, Integer custId);
	
	public CustDet login(String mobile, String password);
	
	public CustDet VerfPhone(String otp,int id);
	
	public CustDet changePwd(String pwd,int id);
	
	public CustDet loginUser(String email,String pwd);
	
	public CustDet profileManage(CustDet custdev);
	
	public CustDet saveMobile(OTPGeneration update);
	
	
	
	public CustDet updatePhoneOTP(OTPGeneration update);
	
	public List<Area> getAreaList();
	
	public List<City> getCityListData();
	
	public List<Pincode> getPincodeList();
	
	public List<State> getStateList();
	
	public List<CityOut> getCityList();
	
	public List<AreaOut> getAreaListByCity(int cityId);
	
	public List<SingleDayRelt> getOrderByDate(String date);
	
	public CustDet saveCustRegister(CustomerRegistration customer);
	
	 public CustDet loginMobile(String email);
	 
	 public CustDet checkloginMobile(String email,String mobile);
	 
	 public FoodTyp getFoodTypById(int id);

	 
 
    /*public List<AddressOut> getAddress(int cityId);*/
     
    public List<Address> getAddressList(int id);
    
    public Address getAddress(int id);
    
    public List<EorderClientDetail> getClientDetails();
    
    public List<Address> updateAddress(int  id);
    
    public Area getAreaId(int id);
    
    public Pincode getPincodeId(int pincodeId);
    
    public State getStateId(int id);
    
    public Address updateOrderAddress(AddressOut update);
    
    public Address updateAddressFlag(AddressFlag addresflag);
    
    public Address getActiveAddressFlag(AddressOut addressout);
    
    public Address saveAddressFlage(AddressFlag activeflag);
    
    public Address checkAddeFl(int  id);
    
    public CustDet LoginMobile(String mobile, int guestFlag);
    
    public CustDet getFBUser(FBLogin fb);
    
    
    public CustDet getGPUser(GpSave gp);
    
    /////////////----coupenup-----------////////////
  
    public List<CustCupnRelt> listOfCuppons(int custId);
    
    public CustFdbkRelt savefeedBacks(FeedBack save);
    
    public SaveComment saveComment(FeedBack save);
    
    public List<FdbkQues>  getFeedBackQuerys();
    
    public List<PkgSizTyp> listOfFood();

	public SaveComment savefeedBackcomment(SaveComment savecmnt);
	
	public List<Address> getOtherAddressList(int id);

	public List<AddrTyp> getAddressTypeList();

	public Address getAddressByAddressType(Integer id, int addressTypeId);
	
}
