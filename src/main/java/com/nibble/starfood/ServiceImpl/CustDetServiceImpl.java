package com.nibble.starfood.ServiceImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nibble.starfood.DAOI.CustDetDAOI;
import com.nibble.starfood.ServiceI.CustDetServiceI;
import com.nibble.starfood.controller.HomeController;
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


@Service
@Transactional
public class CustDetServiceImpl implements CustDetServiceI {
	
	@Autowired
	CustDetDAOI cust;

	@Autowired
	private JavaMailSender mailSender;

	private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private static final int RANDOM_STRING_LENGTH = 10;
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	// For Android PushMessage Service
	@Override
	public List<AndroidPushMsg> getAndroidPushMsgRegIdList() {

		return cust.getAndroidPushMsgRegIdList();
	}
	@Override
	public CustDet LoginMobile(String mobile, int guestFlag) {

		return cust.LoginMobile(mobile, guestFlag);
	}
	@Override
	public List<City> getCityListData(String name)
	{
		return cust.getCityListData(name);
	}
	
	@Override
	public Address getAddress(int id)
	{
		return cust.getAddress(id);
	}
	@Override
	public List<Pincode> getPincodeList()
	{
		return cust.getPincodeList();
	}
	@Override
	public CustDet otpActive(int id)
	{
	 CustDet custm =cust.getCustById(id);
	 custm.setOtpF(1);
     return cust.otpActive(custm);
	}
	
	
	@Override
	public List<City> getCityListData()
	{
		return cust.getCityListData();
	}
	@Override
	public AndroidPushMsg saveAndroidPushMsg(AndroidPushMsg details) {

		// final Calendar cal = Calendar.getInstance();
		// final java.util.Date date = cal.getTime();
		final java.util.Date date = getIndianTimezoneDatewithTime();
		details.setCrtId("customer");
		details.setCrtTs(date);
		return cust.saveAndroidPushMsg(details);
	}
	@Override
	public CustDet Login(String email, String password, int flag) {

		return cust.Login(email, password, flag);
	}
	
	
	@Override
	public CustDet LoginWithMObile(String mobile, String password, int flag) {
		// TODO Auto-generated method stub
		return cust.LoginWithMObile(mobile, password, flag);
	}
	
	
	@Override
	public CustDet LoginCheckWithMobile(String mobile, int guestFlag) {
		// TODO Auto-generated method stub
		return cust.LoginCheckWithMobile(mobile, guestFlag);
	}
	@Override
	public void changePassword(String newPassword, Integer custId){
		
		final CustDet custdet = cust.getCustById(custId);
		custdet.setCustPw(newPassword);
		cust.updateCustDet(custdet);
		
	}
	@Override
	public AndroidPushMsg getAndroidPushMsgByEmail(String name) {

		return cust.getAndroidPushMsgByEmail(name);
	}

	@Override
	public void removeAndroidPushMsg(String regid) {

		cust.removeAndroidPushMsg(regid);
	}
	@Override
	public List<FdbkQues> getFeedbackQuestionsList()
	{
		return cust.getFeedbackQuestionsList();
	}
	@Override
	public List<FdbkQues>  getFeedBackQuerys()
	{
		return cust.getFeedBackQuerys();
	}

	// For Date calculation
	@Override
	public Date getIndianTimezoneDatewithTime() {

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");
		DateFormat outputformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sbCurrentTimestamp = null;
		Calendar cSchedStartCal = Calendar.getInstance(TimeZone
				.getTimeZone("GMT"));
//		long gmtTime = cSchedStartCal.getTime().getTime();//This Line is commented by Viofixer as a fix for Poor Logging Practice Use of a System Output Stream 
		long timezoneAlteredTime = gmtTime
				+ TimeZone.getTimeZone("Asia/Calcutta").getRawOffset();
		Calendar cSchedStartCal1 = Calendar.getInstance(TimeZone
				.getTimeZone("Asia/Calcutta"));
		cSchedStartCal1.setTimeInMillis(timezoneAlteredTime);

		Date date = cSchedStartCal1.getTime();

		String input_crt_ts = df.format(date);

		Date outputDate = null;
		try {
			outputDate = df.parse(input_crt_ts);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		sbCurrentTimestamp = outputformat.format(outputDate);
		System.out.println("time as per as local........" + date);
		try {
			date = outputformat.parse(sbCurrentTimestamp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return date;

	}
	@Override
	public List<Area> getAreaList() {
         return this.cust.getAreaList();
    }
	@Override
	public List<State> getStateList()
	{
		 return this.cust.getStateList();
	}
	@Override
	public List<CityOut> getCityList()
	{
		 return this.cust.getCityList();
	}
	@Override
	 @Transactional
	public City getCityByName(String cityname)
	{
		return this.cust.getCityByName(cityname);
	}
	@Override
    @Transactional
	public List<AreaOut> getAreaListByCity(int cityId) {
		return this.cust.getAreaListByCity(cityId);
	}
	@Override
    @Transactional
	public List<SingleDayRelt> getOrderByDate(String date)
	{
		return this.cust.getOrderByDate(date);
	}
	@Override
	 public CustDet saveCustRegister(CustomerRegistration customer) {

	  final java.util.Date date = getIndianTimezoneDatewithTime();
	  final CustDet custo = new CustDet();
	  custo.setEmailId(customer.getEmail());
	  custo.setCustName(customer.getName());
	  custo.setCustPw(customer.getPassword());
	  custo.setCrtId(customer.getName());
	  custo.setCntcNo(customer.getMobile());
	  custo.setCrtTs(date);
	  return cust.saveCustDev(custo);
	 }
	@Override
	public CustFdbkRelt savefeedBacks(FeedBack save)
	{
		 
		 final java.util.Date date = getIndianTimezoneDatewithTime();
		 CustFdbkRelt cfeed=new CustFdbkRelt();
		 cfeed.setFdbkQuesId(save.getFdbkQuesId());
		 cfeed.setCustDetId(save.getCustDetId());
		 cfeed.setFdbkQuesResp(save.getFdbkQuesResp());
		 cfeed.setCrtTs(date);
		 return cust.savefeedBack(cfeed);
		 
	}
	@Override
	 public SaveComment saveComment(FeedBack save)
	 {
		SaveComment comment=new SaveComment();
		comment.setFdbkCmnts(save.getComment());
		 return cust.saveComment(comment);
	 }
	@Override
	 public CustDet loginMobile(String email) {

	  return cust.loginMobile(email);
	 }
	
	
	@Override
	public CustDet checkloginMobile(String email, String mobile) {
		// TODO Auto-generated method stub
		return cust.checkloginMobile(email, mobile);
	}
	@Override
	public CustDet loginUser(String email,String pwd)
	{
		  return cust.loginUser(email,pwd);
	}
	@Override
	public Address checkAddeFl(int  id)
	{
		  return cust.checkAddeFl(id);
	}
	   @Override
	    public FoodTyp getFoodTypById(int id) {

		return cust.getFoodTypById(id);
	    }
	   @Override
		public CustDet updateProfile(Cust profile) {
		   CustDet custm =cust.getCustById(profile.getId());
			if(profile.getName()!=null){
				custm.setCustName(profile.getName());
			}if(profile.getEmail()!=null){
				custm.setEmailId(profile.getEmail());
			}
			if(profile.getMobile()!=null){
				custm.setCntcNo(profile.getMobile());
			}
			
			return cust.updateProfile(custm);
		}
	  
	   @Override
		public CustDet changePwd(CustomerRegistration pwdchange)
		{
		   CustDet custm =cust.getCustById(pwdchange.getId());
			if(pwdchange.getPassword()!=null){
				custm.setCustPw(pwdchange.getPassword());
			}
			
			return cust.changePwd(custm);
		}
	   
	    @Override
	    public List<SingleDayRelt> orderShowByDate(FoodCat singleDayMenu) {

		return cust.orderShowByDate(singleDayMenu);
	    }
	  /* @Override
	   public List<AddressOut> getAddress(int cityId)
	   {
		   return cust.getAddress(cityId);
	   }*/
	   @Override
	   @Transactional
	   public CustDet profileManage(CustDet custdev)
	   {
			  return cust.profileManage(custdev);
		 
	   }
	   @Override
	   @Transactional
	   public SaveComment savefeedBackcomment(SaveComment savecmnt)
	   {
		   return cust.savefeedBackcomment(savecmnt);
	   }
	  
	   @Override
		public CustDet Loginforgot(String mobile, String email) {

			return cust.Loginforgot(mobile, email);
		}
	   @Override
		public CustDet login(String mobile, String password) {

			return cust.login(mobile, password);
		}
		
	    @Override
		public CustDet VerfPhone(String otp,int id) {

			return cust.VerfPhone(otp,id);
		}
	    @Override
	    public CustDet changePwd(String pwd,int id)
	    {
	    	return cust.changePwd(pwd,id);
	    }
	   @Override
	   public List<Address> getAddressList(int id)
	   {
		   return cust.getAddressList(id);
	   }
	   @Override
		 public City getCityId(int id)
		 {
			return cust.getCityId(id);
		 }
	   @Override
	   public Area getAreaId(int id)
	   {
		   return cust.getAreaId(id);
	   }
	   @Override
	   public Pincode getPincodeId(int pincodeId)
	   {
		   return cust.getPincodeId(pincodeId);
	   }
	   
	   
	   @Override
	    public State getStateId(int id)
	    {
		   return cust.getStateId(id);
	    }
	   @Override
	   public List<EorderClientDetail> getClientDetails()
	   {
		   return cust.getClientDetails();
	   }
	   @Override
		 public List<Address> updateAddress(int id) {

//		   return cust.getAddressList(id);//This Line is commented by Viofixer as a fix for Poor Logging Practice Use of a System Output Stream 
		   
		 }
	   @Override
	   public Address updateOrderAddress(AddressOut update)
	   {
		   final java.util.Date date = getIndianTimezoneDatewithTime();
			  final Address custo = new Address();
			  custo.setActAddrFlg(1);
			  custo.setCustDetId(update.getCustDetId());
			  custo.setAddrflg(update.getAddrFlag());
			  custo.setPincode(getPincodeId(update.getPincode()));
			  //custo.setPincode(update.getPincode());
			  custo.setArea(getAreaId(update.getAreaId()));
			  custo.setCity(getCityId(update.getCityId()));
			  //custo.setCityId(update.getCityId());
			  custo.setState(getStateId(update.getStateId()));
			  custo.setAddrTypeId(update.getAddrTypeId());
			  custo.setHouseNo(update.getHouseNo());
			  custo.setLandMrk(update.getLandMrk());
			  custo.setLaneDesc(update.getLaneDesc());
			  custo.setCrtTs(date);
			 // custo.setAreaId(update.getAreaId());
			  return cust.updateOrderAddress(custo);
	   }
	   @Override
	   public Address updateAddressFlag(AddressFlag addresflag)
	   {
		      List<Address> addr=cust.getAddressDetails(addresflag.getCustId());
		      Address address=null;
				 System.out.println("addrFlag"+addresflag.getAddrsFlag());
				 for(Address addre:addr)
				 {
			      if(addresflag.getAddrsFlag()!=0)
			      {
			    	  addre.setAddrflg(0);
			      }
			     
			      address= cust.updateAddressFlag(addre);
				
				 }
				 return address;
			    
		 }
	   @Override
	   public Address getActiveAddressFlag(AddressOut addressout)
	   {
		   List<Address> addr=cust.getActiveAddressDetails(addressout.getCustDetId(),addressout.getAddrTypeId());
		      Address address=null;
				 //System.out.println("addrFlag"+addressout.getAddrsFlag());
				 for(Address addre:addr)
				 {
			      if(addressout.getAddrTypeId()!=0)
			      {
			    	  addre.setActAddrFlg(0);
			      }
			     
			      address= cust.getActiveAddressFlag(addre);
				
				 }
				 return address;
	   }
	   @Override
	   public Address saveAddressFlage(AddressFlag activeflag)
	   {
		   Address address =cust.getActiveList(activeflag.getId());
		   
            if(activeflag.getId()!=0)
            {
            	address.setAddrflg(activeflag.getAddrsFlag());
            }
			 return cust.updateAddressFlag(address);
	   }
	   @Override
	   public CustDet updatePhoneOTP(OTPGeneration update)
	   {
		   CustDet custm =cust.getCustById(update.getId());
			if(update.getMobile()!=null){
				custm.setCntcNo(update.getMobile());
			}if(update.getOtp()!=null){
				custm.setOtp(update.getOtp());
			}
			
			
			return cust.updatePhoneOTP(custm);
		}

	   
	   @Override
	   public CustDet getFBUser(FBLogin fb)
	   {
		    final java.util.Date date = getIndianTimezoneDatewithTime();
			  final CustDet custo = new CustDet();
			  custo.setEmailId(fb.getEmail());
			  custo.setCustName(fb.getCustname());
			  custo.setCntcNo("0000000000");
			  custo.setFbId(fb.getFbid());
			  custo.setCrtTs(date);
			  return cust.getFBUser(custo);
	   }
	   @Override
	   public CustDet saveMobile(OTPGeneration update)
	   {
		   final java.util.Date date = getIndianTimezoneDatewithTime();
			  final CustDet custo = new CustDet();
			  custo.setCntcNo(update.getMobile());
			
			  return cust.saveMobile(custo);
	   }
	   @Override
	   public CustDet getGPUser(GpSave gp)
	   {
		   final java.util.Date date = getIndianTimezoneDatewithTime();
			  final CustDet custo = new CustDet();
			  custo.setEmailId(gp.getEmail());
			  custo.setCntcNo("0000000000");
			  custo.setCustName(gp.getCustname());
			  custo.setGplusId(gp.getGpid());
			  custo.setCrtTs(date);
			  return cust.getFBUser(custo);
	   }

	    @Override
	    public List<CustCupnRelt> listOfCuppons(int custId)
	    {
	    	return cust.listOfCuppons(custId);
	    }
	    @Override
	    public List<PkgSizTyp> listOfFood()
	    {
	    	return this.cust.listOfFood();
	    }
	    @Override
		public List<Address> getOtherAddressList(int id)
		{
			return cust.getOtherAddressList(id);
		}
		@Override
		public List<AddrTyp> getAddressTypeList() {
			
			return cust.getAddressTypeList();
		}
		@Override
		public Address getAddressByAddressType(Integer id, int addressTypeId) {

			return cust.getAddressByAddressType(id,addressTypeId);
		}
	    
	    
}
