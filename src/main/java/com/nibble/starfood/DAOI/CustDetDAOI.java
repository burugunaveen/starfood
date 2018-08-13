package com.nibble.starfood.DAOI;

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
import com.nibble.starfood.webservices.model.AreaOut;
import com.nibble.starfood.webservices.model.CityOut;
import com.nibble.starfood.webservices.model.FoodCat;



public interface CustDetDAOI {

	// for Android PushMessage Service
	public List<AndroidPushMsg> getAndroidPushMsgRegIdList();
	
	public CustDet updateProfile(CustDet profile);
	
	public List<City> getCityListData(String name);
	
	public CustDet login(String mobile, String password);
	
    public Address getAddress(int id);
    
    public City getCityId(int id);
    
    public Area getAreaId(int id);
    
    public State getStateId(int id);
    
    public CustDet otpActive(CustDet data);
	
	public void updateCustDet(CustDet custdet);
	
	public List<SingleDayRelt> orderShowByDate(FoodCat singleDayMenu);
	
	public CustDet changePwd(CustDet pwdchange);
	
	public List<FdbkQues> getFeedbackQuestionsList();
	
	//public void changePassword(String newPassword, Integer custId);
	
	public CustDet saveMobile(CustDet update);
	
	public CustDet getCustById(int userId);

	public AndroidPushMsg saveAndroidPushMsg(AndroidPushMsg details);
	
	public CustDet Login(String email, String password, int flag);
	
	public CustDet LoginWithMObile(String mobile, String password, int flag);

	public AndroidPushMsg getAndroidPushMsgByEmail(String name);

	public void removeAndroidPushMsg(String reg);
	
	public List<Area> getAreaList();
	

	
	public List<Pincode> getPincodeList();
	
	public List<State> getStateList();
	
	public List<City> getCityListData();
	
	public List<EorderClientDetail> getClientDetails();
	
	public List<AreaOut> getAreaListByCity(int cityId);
	
	public List<SingleDayRelt> getOrderByDate(String date);
	
	 public CustDet LoginMobile(String mobile, int guestFlag);
	 
	 public CustDet LoginCheckWithMobile(String mobile, int guestFlag);
	
	public List<CityOut> getCityList();
	
	public CustDet saveCustDev(CustDet custdev);
	
	public CustDet profileManage(CustDet custdev);
	
	public CustDet Loginforgot(String mobile, String email);
	
	public City getCityByName(String cityname);
	
	public CustDet updatePhoneOTP(CustDet saveotp);
	
	public CustDet VerfPhone(String otp,int id);
	
	public CustDet changePwd(String pwd,int id);
	
	public CustDet loginUser(String email,String pwd);
	
	public CustDet loginMobile(String email);
	
	
	public CustDet checkloginMobile(String email,String mobile);
	
	
	
    public CustDet getFBUser(CustDet fb);
    
    public CustDet getGPUser(CustDet gp);
	
	public Address checkAddeFl(int  id);
	
	public FoodTyp getFoodTypById(int id);
	
/*	public List<Address> getAddress(int cityId);*/
	
	
	//public PkgSizTyp showPkg(PkgSelection sel);
	
	public List<Address> getAddressList(int id);
	
	public Address getActiveList(int id);
	
	 public List<Address> updateAddress(int id);
	 
	 public List<Address> getAddressDetails(int userId);
	 
	 public SaveComment savefeedBackcomment(SaveComment savecmnt);
	 
	 public Address updateOrderAddress(Address update);
	 
	 public Address updateAddressFlag(Address addresflag);
	 
	 public List<Address> getActiveAddressDetails(int userId,int addrFlag);
	 
	 public Address getActiveAddressFlag(Address addresflag);
	 
	 public Address saveAddressFlage(Address activeflag);
	 
	 
	 ///------------Coupan Interface------////////
	 public CustFdbkRelt savefeedBack(CustFdbkRelt send);
	 
	 public SaveComment saveComment(SaveComment save);
	
	 public List<CustCupnRelt> listOfCuppons(int custId);
	 
	 public List<FdbkQues>  getFeedBackQuerys();
	 
	 public List<PkgSizTyp> listOfFood();

	 public List<Address> getOtherAddressList(int id);

	public Pincode getPincodeId(int pincodeId);

	public List<AddrTyp> getAddressTypeList();

	public Address getAddressByAddressType(Integer id, int addressTypeId);
	}
