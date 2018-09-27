package com.nibble.starfood.controller;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.URLName;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nibble.starfood.ServiceI.CustDetServiceI;
import com.nibble.starfood.ServiceImpl.FeedBackWrapper;
import com.nibble.starfood.hibernatemodel.AddrTyp;
import com.nibble.starfood.hibernatemodel.Address;
import com.nibble.starfood.hibernatemodel.Area;
import com.nibble.starfood.hibernatemodel.City;
import com.nibble.starfood.hibernatemodel.CustDet;
import com.nibble.starfood.hibernatemodel.CustFdbkRelt;
import com.nibble.starfood.hibernatemodel.FdbkQues;
import com.nibble.starfood.hibernatemodel.Pincode;
import com.nibble.starfood.hibernatemodel.SaveComment;
import com.nibble.starfood.hibernatemodel.SingleDayRelt;
import com.nibble.starfood.hibernatemodel.State;
import com.nibble.starfood.util.SendEmail;
import com.nibble.starfood.webservices.model.AddressFlag;
import com.nibble.starfood.webservices.model.AddressOut;
import com.nibble.starfood.webservices.model.AreaOut;
import com.nibble.starfood.webservices.model.ChangePassword;
import com.nibble.starfood.webservices.model.CitsInputName;
import com.nibble.starfood.webservices.model.CityOut;
import com.nibble.starfood.webservices.model.Cust;
import com.nibble.starfood.webservices.model.CustomerComplaintsMail;
import com.nibble.starfood.webservices.model.CustomerRegistration;
import com.nibble.starfood.webservices.model.FBLogin;
import com.nibble.starfood.webservices.model.FeedBack;
import com.nibble.starfood.webservices.model.FeedBackQuery;
import com.nibble.starfood.webservices.model.FoodCat;
import com.nibble.starfood.webservices.model.ForgotPassword;
import com.nibble.starfood.webservices.model.GpSave;
import com.nibble.starfood.webservices.model.Id;
import com.nibble.starfood.webservices.model.IdDet;
import com.nibble.starfood.webservices.model.OTPGeneration;
import com.nibble.starfood.webservices.model.OrderJsonObject;
import com.nibble.starfood.webservices.model.Sign;
import com.sun.mail.smtp.SMTPTransport;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    CustDetServiceI cust;

    @Autowired
    private JavaMailSender mailSender;

    /**
	 * Simply selects the home view to render by returning its name.-----TEST----
	 */
    @RequestMapping(value = "/getMachedNames.web", method = RequestMethod.GET)
    @ResponseBody
    public List<String> getMachedNames(@RequestParam("term") String name) {
        List<Area> city = cust.getAreaList();
        List<String> names = new ArrayList<String>();
        List<String> returnMatchName = new ArrayList<String>();
        for (Area list : city) {
            names.add(list.getAreaDesc());
            logger.info("list.getAreaDesc()");//This Line is modified by Viofixer as a fix for Poor Logging Practice Use of a System Output Stream 
        }
        String[] data = names.toString().split(",");
        for (String string : data) {
            if (string.toUpperCase().indexOf(name.toUpperCase()) != -1) {
                returnMatchName.add(string);
            }
        }
        return returnMatchName;
    }

    @RequestMapping(value = "/mobile/getAddressById", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Object getAddressUsingId(@RequestBody final IdDet id) {
        final Map<String, Object> map = new HashMap<String, Object>();
        final Map<String, String> status = new HashMap<String, String>();
        final List<Address> addresslist = new ArrayList<Address>();
        final List<Address> addrs = cust.getAddressList(id.getId());
        logger.info("listsize + addrs.size()");//This Line is modified by Viofixer as a fix for Poor Logging Practice Use of a System Output Stream 
        if (addrs.size() != 0) {
            for (final Address addr : addrs) {
                if (addr.getAddrTypeId() == 1) {
                    logger.info("addtypidhome   + addr.getAddrTypeId()");//This Line is modified by Viofixer as a fix for Poor Logging Practice Use of a System Output Stream 
                    addresslist.add(addr);
                } else if (addr.getAddrTypeId() == 2) {
                    logger.info("addtypidoffice   + addr.getAddrTypeId()");//This Line is modified by Viofixer as a fix for Poor Logging Practice Use of a System Output Stream 
                    addresslist.add(addr);
                } else if (addr.getAddrTypeId() == 3) {
                    logger.info("OtherAddress    + addr.getAddrTypeId()");//This Line is modified by Viofixer as a fix for Poor Logging Practice Use of a System Output Stream 
                    addresslist.add(addr);
                }
            }
            map.put("Address", addresslist);
            map.put("status", "success");
            map.put("key", "1");
        } else {
            status.put("status", "user not found");
            status.put("key", "2");
            return status;
        }
        return map;
    }

    @RequestMapping(value = "/mobile/contactUs", method = RequestMethod.POST)
    @ResponseBody
    public Object contactUs(@RequestBody CustomerComplaintsMail contactDet) {
        final HashMap<String, Object> map = new HashMap<String, Object>();
        String emailAddress = "Tandurust@hotmail.com";
        String emailBody = "Dear Admin," + "\n\n" + "Please contact customer with below details: " + "\n\n" + "Name: " + contactDet.getName() + "\n" + "Email: " + contactDet.getEmail() + "\n" + "Area: " + contactDet.getArea() + "\n" + "Mobile Number: " + contactDet.getMobileNumber() + "\n" + "Complaint text: " + contactDet.getText() + "\n" + "Thank you for checking mail" + "\n\n" + "Team Tandurust!";
        String subject = "Customer Complaint Details";
        /*SendEmail sendEmail=new SendEmail();
		 sendEmail.mailSending(emailAddress, subject, emailBody);*/
        map.put("key", "1");
        map.put("status", "success");
        return map;
    }

    @RequestMapping(value = "/viewArea", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String viewAbondonedOrdersbasedonDatePagination(HttpServletRequest request) {
        logger.info("::::::::::::::OrderController::viewAbondonedOrdersBasedOn datePagination::::::::::");
        //Fetch Page display length
        Integer pageDisplayLength = Integer.valueOf(request.getParameter("iDisplayLength"));
        /* Area order=new Area();
	        order.setOrderStartDate(orderStartDate);
	        order.setOrderEndDate(orderEndDate);*/
        List<Pincode> area = cust.getPincodeList();
        // ordersList=orderService.abondonedOrderDetailsBDates(order);
        PagedListHolder<Pincode> pagedList = new PagedListHolder<Pincode>(area);
        //	     pagedList.setSort(new MutableSortDefinition("orderId",true,false));
        //	     pagedList.resort();
        pagedList.setPageSize(pageDisplayLength);
        int totalRecords = pagedList.getNrOfElements();
        //Fetch the page number from client
        Integer pageNumber = 0;
        if (null != request.getParameter("iDisplayStart"))
            pageNumber = (Integer.valueOf(request.getParameter("iDisplayStart")) / pageDisplayLength);
        OrderJsonObject ojson = new OrderJsonObject();
        ojson.setiTotalDisplayRecords(totalRecords);
        ojson.setiTotalRecords(totalRecords);
        pagedList.setPage(pageNumber);
        List<Pincode> areaList = pagedList.getPageList();
        //final	List<Area>  areaList=cust.getAreaList();
        ojson.setAaData(areaList);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json2 = gson.toJson(ojson);
        return json2;
    }

    @RequestMapping(value = "/getMu", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<City> getawMatSubCatg(HttpServletRequest request) {
        logger.info("::::::::::::::VendorController::getMu::::::::::");
        List<City> measuringUnitsList = cust.getCityListData();
        return measuringUnitsList;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("serverTime", formattedDate);
        return "home";
    }

    @RequestMapping(value = "/jquery", method = RequestMethod.GET)
    @ResponseBody
    public String jqueryTest(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);
        return "jquery";
    }

    @RequestMapping(value = "/mobile/getDate", method = RequestMethod.GET)
    @ResponseBody
    public Object getDate(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);
        Map<String, Object> map = new HashMap<String, Object>();
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date d = new Date();
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
        String currentDate = simpleDateFormat.format(d);
        //System.out.println("currentDate "+currentDate);
        map.put("key", "1");
        map.put("status", "success");
        map.put("date", currentDate);
        //d.getTime(simpleDateFormat)
        return map;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String test(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("serverTime", formattedDate);
        return "test";
    }

    @RequestMapping(value = "/showList", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<City> showList(@ModelAttribute("rawMaterial") City rawMaterial, BindingResult errors) {
        System.out.println("hi");
        List<City> city = cust.getCityListData();
        return city;
    }

    /*@RequestMapping(value = "/listofarea", method = RequestMethod.GET)
	public @ResponseBody Object foodTyp() {
		 
//		 final HashMap<String, Object> map = new HashMap<String, Object>();//This Line is commented by Viofixer as a fix for Privacy Violation
		  //CustDet customer;
		 List<Area> ord=cust.getAreaList();
		 
		  map.put("status", "OK");
		 // map.put("name",ord.getCityId());
		 
		 
		  return map;
		return cust.getAreaList();
		 
		

	}*/
    /*@ResponseBody
	@RequestMapping(value = "/areas", method = RequestMethod.POST)
	public Map<String, Object> listAreas(@ModelAttribute Id id) {
		logger.info("Id :" + id.toString());
		Map<String, Object> model = new HashMap<String, Object>();
		List<AreaOut> list = cust.getAreaListByCity(id.getId());
		if (list.size() == 0) {
			model.put("status", "NOK");
			model.put("areas", new ArrayList<AreaOut>());
			return model;
		}
		model.put("status", "OK");
		model.put("areas", list);
		return model;

	}*/
    @RequestMapping(value = "/mobile/area", method = RequestMethod.POST)
    @ResponseBody
    public Object custCupons(@RequestBody final Id id) {
        Map<String, Object> map = new HashMap<String, Object>();
        final List<AreaOut> areaList = cust.getAreaListByCity(id.getId());
        // String json = new Gson().toJson(areaList);
        if (areaList.size() != 0) {
            map.put("Status", "Sucess");
            map.put("AreaList", areaList);
        } else {
            map.put("Status", "Failure");
        }
        return map;
    }

    /*@RequestMapping(value = "/mobile/areaList", method = RequestMethod.GET)
	public @ResponseBody Object areaDetails() {
		Map<String, Object> map=new HashMap<String, Object>();
		final	List<Area>  areaList=cust.getAreaList();
		if(areaList.size() != 0){
		map.put("list",areaList);
		map.put("status","success");
		map.put("key","1");
		}else{
			map.put("status","failure");
			map.put("key","2");
		}
		return map;
	}*/
    @RequestMapping(value = "/mobile/pincodeList", method = RequestMethod.GET)
    @ResponseBody
    public Object pincodeList() {
        Map<String, Object> map = new HashMap<String, Object>();
        final List<Pincode> pincode = cust.getPincodeList();
        map.put("Pincode", pincode);
        return map;
    }

    @RequestMapping(value = "/mobile/addressList", method = RequestMethod.GET)
    @ResponseBody
    public Object areaList() {
        Map<String, Object> map = new HashMap<String, Object>();
        final List<Area> areaList = cust.getAreaList();
        final List<City> cityList = cust.getCityListData();
        final List<State> state = cust.getStateList();
        final List<Pincode> pincode = cust.getPincodeList();
        List<AddrTyp> addressType = cust.getAddressTypeList();
        // String json = new Gson().toJson(areaList);
        if (areaList.size() != 0) {
            map.put("key", "1");
            map.put("status", "success");
            map.put("cityList", cityList);
            map.put("areaList", areaList);
            map.put("stateList", state);
            map.put("Pincode", pincode);
            map.put("addressTypeList", addressType);
        } else {
            map.put("key", "2");
            map.put("status", "failure");
        }
        return map;
    }

    @RequestMapping(value = "/mobile/feedback", method = RequestMethod.POST)
    @ResponseBody
    public Object payMod(@RequestBody FeedBackWrapper feed) {
        final Map<String, String> map = new HashMap<String, String>();
        List<FeedBack> feedbacklist = feed.getFeedback();
        String comment = null;
        int custDetId = 0;
        CustFdbkRelt save = null;
        for (FeedBack fdbk : feedbacklist) {
            final CustFdbkRelt feedbacksave = new CustFdbkRelt();
            save = cust.savefeedBacks(fdbk);
            comment = fdbk.getComment();
            custDetId = fdbk.getCustDetId();
        }
        SaveComment savecmnt = new SaveComment();
        savecmnt.setFdbkCmnts(comment);
        savecmnt.setCustDetId(custDetId);
        savecmnt = cust.savefeedBackcomment(savecmnt);
        if (save != null) {
            map.put("status", "success");
        } else {
            map.put("status", "fail");
        }
        return map;
    }

    @RequestMapping(value = "/mobile/listOfFeedbackQuery", method = RequestMethod.POST)
    @ResponseBody
    public Object getFeedBackQuery(@RequestBody final FeedBackQuery feedbackQuery) {
        final Map<String, Object> map = new HashMap<String, Object>();
        final List<FdbkQues> queryList = cust.getFeedBackQuerys();
        if (queryList.size() != 0) {
            map.put("status", "success");
            map.put("QueryList", queryList);
        } else {
            map.put("status", "fail");
        }
        return map;
    }

    @RequestMapping(value = "/mobile/citylist", method = RequestMethod.POST)
    @ResponseBody
    public Object getCityList(@RequestBody final CitsInputName cityname) {
        final Map<String, Object> map = new HashMap<String, Object>();
        final List<CityOut> cityList = cust.getCityList();
        // String json = new Gson().toJson(cityList);
        if (cityList.size() != 0) {
            map.put("Status", "sucess");
            map.put("CityList", cityList);
        } else {
            map.put("Status", "fail");
        }
        return map;
    }

    @RequestMapping(value = "/mobile/register", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Object register(@RequestBody final CustomerRegistration register) {
        final HashMap<String, Object> map = new HashMap<String, Object>();
        CustDet customer;
        logger.info("Customer is registering");
        Boolean emailCheck = null;
        Boolean mobileCheck = null;
        try {
            String mydomain = register.getEmail();
            String emailregex = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
            emailCheck = mydomain.matches(emailregex);
            if (emailCheck == false) {
                System.out.println("Email Address is Invalid");
            } else if (emailCheck == true) {
                System.out.println("Email Address is Valid");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("e.getMessage()");//This Line is modified by Viofixer as a fix for Poor Logging Practice Use of a System Output Stream 
        }
        try {
            String mobileNo = register.getMobile();
            mobileCheck = mobileNo.matches("[7-9]{1}[0-9]{9}");
            System.out.println("mobile check result: " + mobileCheck);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (emailCheck == true && mobileCheck == true) {
            //customer = cust.loginMobile(register.getEmail());
            customer = cust.checkloginMobile(register.getEmail(), register.getMobile());
            if (customer == null) {
                customer = cust.saveCustRegister(register);
                map.put("status", "new registration");
                map.put("key", "1");
                map.put("custcontact", customer.getCntcNo());
                map.put("custname", customer.getCustName());
                map.put("emailId", customer.getEmailId());
                map.put("customerId", customer.getId());
                final String emailAddress = customer.getEmailId();
                final String emailBody = "Hi " + customer.getCustName() + ",\n\n" + "Welcome to StarFood!" + "\n\n" + "Fitness in your mind? Don't have time to cook? Want to eat out but eat healthy?" + "\n\n" + "If your answer to any of these is " + "\"Yes\"" + ", you are at the right place!" + "\n\n" + "Come, join hands with us on this journey of light and healthy food, and we know you'll love it!" + "\n\n" + "Now that you are a part of our StarFood family, what are you waiting for? Login to your account, check all that StarFood has in offer for you and get set to choose your subscription plan!" + "\n\n\n\n" + "Let's eat healthy and be StarFood!" + "\n\n" + "Team StarFood";
                final String Subject = "Registration at StarFood";
                SendEmail sendEmail = new SendEmail();
                sendEmail.mailSending(emailAddress, Subject, emailBody);
            } else {
                map.put("key", "2");
                map.put("status", "already registered");
                return map;
            }
        } else {
            if (emailCheck == false && mobileCheck == false) {
                map.put("key", "3");
                map.put("status", "Invalid email & mobile number");
            } else if (emailCheck == false) {
                map.put("key", "3");
                map.put("status", "Invalid email");
            } else if (mobileCheck == false) {
                map.put("key", "3");
                map.put("status", "Invalid mobile number");
            }
            return map;
        }
        return map;
    }

    @RequestMapping(value = "/mobile/changePassword", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> changePassword(@RequestBody final CustomerRegistration register) {
        final HashMap<String, Object> map = new HashMap<String, Object>();
        CustDet customer;
        logger.info("change Password is ");
        customer = cust.changePwd(register);
        if (customer != null) {
            map.put("status", "change password sucess ");
            map.put("key", "1");
            return map;
        } else {
            map.put("status", " fail change password");
            map.put("key", "2");
            return map;
        }
    }

    @RequestMapping(value = "mobile/changepassword", method = RequestMethod.POST)
    @ResponseBody
    public Object sign(@RequestBody final ChangePassword changePass) {
        final HashMap<String, Object> map = new HashMap<String, Object>();
        CustDet customer;
        CustDet customerMobile = null;
        if (!changePass.getMobile().isEmpty() && !changePass.getPassword().isEmpty()) {
            customer = cust.login(changePass.getMobile(), changePass.getPassword());
            if (customer == null) {
                customerMobile = cust.loginMobile(changePass.getMobile());
                if (customerMobile != null) {
                    map.put("status", "WrongPassword");
                } else {
                    map.put("status", "Not registered");
                    return map;
                }
                return map;
            } else {
                logger.info(customer.getId() + "user password is changing now");
                cust.changePassword(changePass.getNewPassword(), customer.getId());
                final Map<String, Object> custdetails = new HashMap<String, Object>();
                custdetails.put("custId", customer.getId());
                custdetails.put("cntcNo", customer.getCntcNo());
                custdetails.put("custName", customer.getCustName());
                custdetails.put("emailId", customer.getEmailId());
                map.put("customerDetails", custdetails);
                //map.put("key", 2);
                map.put("status", "Successfully Password Changed");
                return map;
            }
        }
        map.put("status", "please fill required fields");
        return map;
    }

    /*@RequestMapping(value = "mobile/login", method = RequestMethod.POST)
		public @ResponseBody Object sign(@RequestBody final Sign sign) {
			final HashMap<String, Object> map = new HashMap<String, Object>();
			CustDet customer;
			CustDet customerMobile = null;
			int guestFlag=0;
			  Boolean emailCheck=null;
			  try {
		          String mydomain = sign.getEmail();
		          String emailregex = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		          emailCheck = mydomain.matches(emailregex);
		          
		          if (emailCheck == false) {
		              System.out.println("Email Address is Invalid");
		              }else if(emailCheck == true){
		              System.out.println("Email Address is Valid");
		          }
		      }
		      catch (Exception e) {
		          e.printStackTrace();
		          System.out.println(e.getMessage());
		      }
			 
			  
			if(emailCheck==true){
			logger.info("Trying to log with,Mobile number:" + sign.getEmail() + "  VenderId" + sign.getPassword());
			if (!sign.getEmail().isEmpty() && !sign.getPassword().isEmpty()) {
				System.out.println("Trying to log with,Mobile number:" + sign.getEmail() + "  VenderId" + sign.getPassword());
				
				customer = cust.Login(sign.getEmail(), sign.getPassword(), guestFlag);
				
				
				if (customer == null) {
					
					customerMobile = cust.LoginMobile(sign.getEmail(), guestFlag);
					if (customerMobile != null) {
						map.put("status", "WrongPassword");
						logger.info(">>>>>>>wrong password>>>>>>>");
						map.put("key", 4);

					} else {
						map.put("status", "Not registered");
						logger.info(">>>>>>>Not registered>>>>>>");
						map.put("key", 5);
					}

					return map;

				} else {
					logger.info(customer.getId() + "Successfully logined");
                    //map.put("customerDetails", customer);
					
					 map.put("custid",customer.getId());
					 map.put("custname",customer.getCustName());
					 map.put("custcontact",customer.getCntcNo());
					 map.put("emailId",customer.getEmailId());
					 map.put("key", 2);
					 map.put("status", "Successfully Logged In");
					return map;

				}
			}
			map.put("status", "please enter correct details");
			map.put("key", 3);
			logger.info("please enter correct details");
			return map;
			}else{
				map.put("status", "Invalid email");
				map.put("key", 6);
				return map;
			}

		}*/
    @RequestMapping(value = "mobile/login", method = RequestMethod.POST)
    @ResponseBody
    public Object sign(@RequestBody final Sign sign) {
        final HashMap<String, Object> map = new HashMap<String, Object>();
        CustDet customer;
        CustDet customerMobile = null;
        int guestFlag = 0;
        Boolean emailCheck = false;
        Boolean mobileCheck = false;
        if (sign.getEmail() != null) {
            try {
                String mydomain = sign.getEmail();
                String emailregex = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
                emailCheck = mydomain.matches(emailregex);
                if (emailCheck == false) {
                    System.out.println("Email Address is Invalid");
                } else if (emailCheck == true) {
                    System.out.println("Email Address is Valid");
                }
            } catch (Exception e) {
//                e.printStackTrace();//This Line is commented by Viofixer as a fix for Privacy Violation
                System.out.println(e.getMessage());
            }
        } else if (sign.getMobile() != null) {
            try {
                String mobileNo = sign.getMobile();
                mobileCheck = mobileNo.matches("[7-9]{1}[0-9]{9}");
                System.out.println("mobile check result: " + mobileCheck);
            } catch (Exception e) {
//                e.printStackTrace();//This Line is commented by Viofixer as a fix for Privacy Violation
            }
        }
        if (emailCheck == true || mobileCheck == true) {
            //This Line is modified by Viofixer as a fix for Poor Logging Practice Use of a System Output Stream 
            logger.info("Entered");
            logger.info("Trying to log with,Mobile number:" + sign.getEmail() + "  VenderId" + sign.getPassword());
            System.out.println("Login Mobile :" + sign.getMobile());
            if (sign.getMobile() != null) {
                if (!sign.getMobile().isEmpty() && !sign.getPassword().isEmpty()) {
                    System.out.println("Trying to login with Mobile  Number:" + sign.getMobile() + " Password" + sign.getPassword());
                    customer = cust.LoginWithMObile(sign.getMobile(), sign.getPassword(), guestFlag);
                    if (customer == null) {
                        customerMobile = cust.LoginCheckWithMobile(sign.getMobile(), guestFlag);
                        if (customerMobile != null) {
                            map.put("status", "Wrong Password");
                            logger.info(">>>>>>>wrong password>>>>>>>");
                            map.put("key", 4);
                        } else {
                            map.put("status", "Not registered");
                            logger.info(">>>>>>>Not registered>>>>>>");
                            map.put("key", 5);
                        }
                    //                        return map;//This Line is commented by Viofixer as a fix for Privacy Violation
                    } else {
                        logger.info(customer.getId() + "Successfully logined");
                        //map.put("customerDetails", customer);
                        map.put("custid", customer.getId());
                        map.put("custname", customer.getCustName());
                        map.put("custcontact", customer.getCntcNo());
                        map.put("emailId", customer.getEmailId());
                        map.put("key", 2);
                        map.put("status", "Successfully Logged In");
                    //                        return map;//This Line is commented by Viofixer as a fix for Privacy Violation
                    }
                }
            }
            if (!sign.getEmail().isEmpty() && !sign.getPassword().isEmpty()) {
                System.out.println("Trying to log with,Mobile number:" + sign.getEmail() + "  VenderId" + sign.getPassword());
                customer = cust.Login(sign.getEmail(), sign.getPassword(), guestFlag);
                if (customer == null) {
                    customerMobile = cust.LoginMobile(sign.getEmail(), guestFlag);
                    if (customerMobile != null) {
                        map.put("status", "WrongPassword");
                        logger.info(">>>>>>>wrong password>>>>>>>");
                        map.put("key", 4);
                    } else {
                        map.put("status", "Not registered");
                        logger.info(">>>>>>>Not registered>>>>>>");
                        map.put("key", 5);
                    }
                    return map;
                } else {
                    logger.info(customer.getId() + "Successfully logined");
                    //map.put("customerDetails", customer);
                    map.put("custid", customer.getId());
                    map.put("custname", customer.getCustName());
                    map.put("custcontact", customer.getCntcNo());
                    map.put("emailId", customer.getEmailId());
                    map.put("key", 2);
                    map.put("status", "Successfully Logged In");
                    return map;
                }
            }
            map.put("status", "please enter correct details");
            map.put("key", 3);
            logger.info("please enter correct details");
            return map;
        } else {
            map.put("status", "Invalid email");
            map.put("key", 6);
            return map;
        }
    }

    ///////------------------LOGIN------------------//////////////
    /* @RequestMapping(value = "/mobile/login", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	 public @ResponseBody Object login(@RequestBody final CustomerRegistration register) {
	  
	  final HashMap<String, Object> map = new HashMap<String, Object>();
	  CustDet customer;
	  logger.info("Customer is login");
	  customer = cust.loginUser(register.getEmail(),register.getPassword());
	  
	  if (customer == null) {
	   map.put("status","fail");
	   map.put("status", "not a register");
	  
	   return map;

	  } else {
	   map.put("status","success");
	   map.put("custid",customer.getId());
	   map.put("custname",customer.getCustName());
	   map.put("custcontact",customer.getCntcNo());
	   return map;

	  }

	 }*/
    /*  final List<Address> addrs= cust.getAddressList(id.getId());
		System.out.println("listsize"+addrs.size());
		if (addrs.size()!=0) {
			for (final Address addr : addrs) {
				if (addr.getAddrTypeId() == 1) {
					System.out.println("addtypidhome......"+ addr.getAddrTypeId());
					homeaddresslist.add(addr);
				} else if (addr.getAddrTypeId() == 2) {
					System.out.println("addtypidoffice...."+ addr.getAddrTypeId());
					officeaddresslist.add(addr);
				}
			}
			map.put("HomeAddress", homeaddresslist);
			map.put("OfficeAddress", officeaddresslist);
			
			list.add(map);
		}else {
			status.put("status","user not found");
			return status;
		}*/
    @RequestMapping(value = "/mobile/singleDayFoodMenu", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> price(@RequestBody final FoodCat singleDayMenu) {
        final Map<String, Object> taxList = new HashMap<String, Object>();
        List<SingleDayRelt> menu = cust.orderShowByDate(singleDayMenu);
        // final  List<PkgFoodItm> pkg=cust.listOfFood();
        taxList.put("List Of Items", menu);
        return taxList;
    }

    /*@RequestMapping(value = "/mobile/packagList", method = RequestMethod.POST)
	    public @ResponseBody Map<String, Object> packageList(@RequestBody final FoodCat singleDayMenu) {
	     final Map<String, Object> taxList= new HashMap<String, Object>();
	   // List<SingleDayRelt> menu = cust.orderShowByDate(singleDayMenu);
	     final HashMap<String, Object> miniVeg = new HashMap<String, Object>();
	    final  List<PkgSizTyp> pkgs=cust.listOfFood();
	  
		final Iterator<PkgSizTyp> it = pkgs.iterator();
		
		while (it.hasNext()) {
			final PkgSizTyp pkg = it.next();
			
			
			
			if (pkg.getMealTime().getId() == 1) 
			{
				if (pkg.getMealTyp().getId() == 1) {

					miniVeg.put("mealtype",pkg.getPkgSizTypDesc());
							
					
				}
			}
		}
	    
	     return miniVeg;
	  }*/
    @RequestMapping(value = "/mobile/FBsign", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Object sfbLogin(@RequestBody final FBLogin fb) {
        final HashMap<String, Object> map = new HashMap<String, Object>();
        CustDet customer;
        logger.info("Customer is FB registering");
        customer = cust.loginMobile(fb.getEmail());
        if (customer == null) {
            customer = cust.getFBUser(fb);
            map.put("status", "save fb user data");
            map.put("customerId", customer.getId());
            //map.put("customerId", customer.getId());
            return map;
        } else {
            map.put("status", "already registered");
            map.put("customerId", customer.getId());
            return map;
        }
    }

    @RequestMapping(value = "/mobile/GplusSave", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Object saveGPlus(@RequestBody final GpSave gp) {
        final HashMap<String, Object> map = new HashMap<String, Object>();
        CustDet customer;
        logger.info("Customer is G+ registering");
        customer = cust.loginMobile(gp.getEmail());
        if (customer == null) {
            customer = cust.getGPUser(gp);
            map.put("status", "save G+ user details");
            map.put("customerId", customer.getId());
            //map.put("customerId", customer.getId());
            return map;
        } else {
            map.put("status", "already registered");
            map.put("customerId", customer.getId());
            return map;
        }
    }

    @RequestMapping(value = "/mobile/EOrderClientDet", method = RequestMethod.GET)
    @ResponseBody
    public Object clientDetails() {
        final Map<String, Object> mealTimeList = new HashMap<String, Object>();
        mealTimeList.put("ClientDetails", cust.getClientDetails());
        return mealTimeList;
    }

    @RequestMapping(value = "/mobile/forgotpassword", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> forgotPassword(@RequestBody final ForgotPassword forgotPassword) {
        final HashMap<String, Object> map = new HashMap<String, Object>();
        CustDet customer;
        logger.info("Trying to log with,Mobile number:" + forgotPassword.getMobile() + "  VenderId" + forgotPassword.getEmail());
        if (forgotPassword.getMobile() != null || forgotPassword.getEmail() != null) {
            //CustDet custorderdet;
            customer = cust.Loginforgot(forgotPassword.getMobile(), forgotPassword.getEmail());
            if (customer == null) {
                map.put("key", "2");
                map.put("status", "user not found");
                return map;
            } else {
                map.put("key", "1");
                map.put("Status", "Successfully password sent");
            }
            if (forgotPassword.getEmail() != null) {
                String emailAddress = forgotPassword.getEmail();
                String emailBody = "Dear " + customer.getCustName() + "," + "\n\n" + "Your StarFood Account Password is: " + customer.getCustPw() + "\n\n\n" + "Let's eat healthy and be StarFood!" + "\n\n" + "Team StarFood";
                String subject = "Account Login Credentials";
                SendEmail sendEmail = new SendEmail();
                sendEmail.mailSending(emailAddress, subject, emailBody);
            }
        }
        return map;
    }

    @RequestMapping(value = "/mobile/verfuserotp", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> verifOTP(@RequestBody final OTPGeneration otpgen) {
        final HashMap<String, Object> map = new HashMap<String, Object>();
        CustDet customer;
        logger.info("Trying to log with,Mobile number:" + otpgen.getId());
        if (!otpgen.getOtp().isEmpty()) {
            CustDet custorderdet;
            // customer=cust.updatePhoneOTP(otpgen);
            customer = cust.VerfPhone(otpgen.getOtp(), otpgen.getId());
            if (customer != null) {
                customer = cust.otpActive(otpgen.getId());
                map.put("status", "Success");
                return map;
            } else {
                map.put("status", "enter wrong OTP");
                return map;
            }
        }
        return map;
    }

    @RequestMapping(value = "/mobile/savemobileotp", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> saveMobileAndOTP(@RequestBody final OTPGeneration otpgen) {
        final HashMap<String, Object> map = new HashMap<String, Object>();
        CustDet customer;
        logger.info("Trying to log with,Mobile number:" + otpgen.getMobile());
        if (!otpgen.getMobile().isEmpty()) {
            CustDet custorderdet;
            customer = cust.updatePhoneOTP(otpgen);
            //customer = cust.verfphone(otpgen.getotp());// This comment is modified by Viofixer as a fix for XXXX**** Management: XXXX**** in Comment 
            if (customer != null) {
                map.put("status", "save mobile number");
                return map;
            } else {
                map.put("status", "not save mobile");
                //String custo = sendExotelSMS(otpgen.getMobile(),otpgen.getOtp()); // SMS Triggering for ForgotPassword
                //forgotPasswordSendEmail(forgotPassword, customer.getCustPw(),customer.getCustName()); // E-Mail Triggering for ForgotPassword
                map.put("Status", "Successfully OTP sent");
                return map;
            }
        }
        return map;
    }

    @RequestMapping(value = "/mobile/generateotp", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> generateOTP(@RequestBody final OTPGeneration otpgen) {
        final HashMap<String, Object> map = new HashMap<String, Object>();
        CustDet customer;
        CustDet custma;
        logger.info("Generate OTP log with,Mobile number:" + otpgen.getMobile());
        if (!otpgen.getMobile().isEmpty() && !otpgen.getOtp().isEmpty()) {
            custma = cust.updatePhoneOTP(otpgen);
            if (custma == null) {
                map.put("status", "fail");
                return map;
            } else {
                map.put("status", "success");
                // SMS Triggering for ForgotPassword
                sendExotelSMS(otpgen.getMobile(), otpgen.getOtp());
                return map;
            }
        }
        return map;
    }

    /* @RequestMapping(value = "/mobile/updateAddress", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	 public @ResponseBody Object updateAddress(@RequestBody final  Id id) {
		// final HashMap<String, Object> map = new HashMap<String, Object>();
		
	  // final List<Address> adds= cust.getAddressList(1);
//		 final HashMap<String, Object> map = new HashMap<String, Object>();//This Line is commented by Viofixer as a fix for Privacy Violation
		  CustDet customer;
		  logger.info("Customer is update pro");
		  customer = cust.loginMobile(id);
		  
		  if (customer == null) {
		   customer = cust.profileManage(addressout);
		   map.put("status", "new registration");
		   map.put("customerId", customer.getId());
		   return map;

		  } else {
		   map.put("status", "already registered");
		   return map;

		  }

					   CustDet customer = cust.profileManage(addressout);
					   map.put("status", "update");
					   map.put("customerId", customer.getId());
				
		  
		               return map;
			
		}*/
    @RequestMapping(value = "/mobile/foodItemByarea", method = RequestMethod.POST)
    @ResponseBody
    public Object getFoodTypeId(@RequestBody final Id id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("AreaList", cust.getFoodTypById(id.getId()));
        return map;
    }

    /*	
	 @RequestMapping(value = "/getAddr", method = RequestMethod.POST)
		public @ResponseBody Object getAddr(@RequestBody final Id id) {
		
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("Address",cust.getAddress(id.getId()));
			return map;
		}*/
    /*@RequestMapping(value = "/mobile/getAddr", method = RequestMethod.POST)
		public @ResponseBody  Map<String, Object> listAreas(@RequestBody  Id id) {
			logger.info("Id :" + id.toString());
			Map<String, Object> model = new HashMap<String, Object>();
			List<Address> list = cust.getAddress(id.getId());
			if (list.size() == 0) {
				model.put("status", "NOK");
				model.put("areas", new ArrayList<AddressOut>());
				return model;
			}
			model.put("status", "OK");
			model.put("areas", list);
			return model;

		}*/
    @RequestMapping(value = "/mobile/getAddressId", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Object getAddressId(@RequestBody final Id id) {
        final Map<String, Object> map = new HashMap<String, Object>();
        final Map<String, String> status = new HashMap<String, String>();
        final List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        final Address addrs = cust.getAddress(id.getId());
        //logger.info("listsize+addrs.size()");//This Line is modified by Viofixer as a fix for Poor Logging Practice Use of a System Output Stream 
        if (addrs != null) {
            if (addrs.getAddrTypeId() == 1) {
                System.out.println("addtypidhome......" + addrs.getAddrTypeId());
                //homeaddresslist.add(addrs);
                map.put("HomeAddress", addrs);
            } else if (addrs.getAddrTypeId() == 2) {
                System.out.println("addtypidoffice...." + addrs.getAddrTypeId());
                map.put("OffeAddress", addrs);
            }
            /*map.put("HomeAddress", homeaddresslist);
				map.put("OfficeAddress", officeaddresslist);*/
            list.add(map);
        } else {
            status.put("status", "address not found");
            return status;
        }
        return list;
    }

    /* @RequestMapping(value = "/mobile/getAddressWithId", method = RequestMethod.POST,produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
		public @ResponseBody Object getAddressWithId(@RequestBody final Id id) {
		
		    final Map<String,Object> map = new HashMap<String,Object>();
			final Map<String,String> status = new HashMap<String,String>();
			final List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			
			final List<Address> officeaddresslist= new ArrayList<Address>();
			final List<Address> addresslist= new ArrayList<Address>();
			final List<Address> other= cust.getOtherAddressList(id.getId());
			
			final List<Address> addrs= cust.getAddressList(id.getId());
			System.out.println("listsize"+addrs.size());
			
			if (addrs.size()!=0) {
				for (final Address addr : addrs) {
					if (addr.getAddrTypeId() == 1) {
						
						System.out.println("addtypidhome......"+ addr.getAddrTypeId());
						addresslist.add(addr);
						
						
					} else if (addr.getAddrTypeId() == 2) {
						System.out.println("addtypidoffice...."+ addr.getAddrTypeId());
						addresslist.add(addr);
						
					}
					
					addresslist.add(addr);
				}
				for (final Address addr : other) {
					if (addr.getAddrTypeId() == 1) {
						
						System.out.println("addtypidhome......"+ addr.getAddrTypeId());
						addresslist.add(addr);
						
						
					} else if (addr.getAddrTypeId() == 2) {
						System.out.println("addtypidoffice...."+ addr.getAddrTypeId());
						addresslist.add(addr);
						
					}
					
					addresslist.add(addr);
				}
				
				
				map.put("status","success");
				map.put("Address", addresslist);
				
				//map.put("Other",other);
				
				//map.put("OfficeAddress", officeaddresslist);
				
				list.add(map);
			}else {
				map.put("status","address not found");
				list.add(map);
				return list;
			}
		
			return list;
		}*/
    @RequestMapping(value = "mobile/getAddressWithId", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Object getAddressWithId(@RequestBody final Id addressDet) {
        final Map<String, Object> map = new HashMap<String, Object>();
        final Address addrs = cust.getAddressByAddressType(addressDet.getId(), addressDet.getAddressTypeId());
        if (addrs != null) {
            map.put("Address", addrs);
            map.put("status", "success");
            map.put("key", "1");
        } else {
            map.put("status", "user not found");
            map.put("key", "2");
        }
        return map;
    }

    @RequestMapping(value = "/mobile/updateAddress", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Object updateAddress(@RequestBody final AddressOut addressout) {
        final HashMap<String, Object> map = new HashMap<String, Object>();
        final List<Address> adds = cust.getAddressList(addressout.getCustDetId());
        Address active = cust.getActiveAddressFlag(addressout);
        if (adds != null) {
            // Address setzero=cust.getActiveAddressFlag(addressout.getCustDetId(),addressout.getAddrTypeId());
            Address customer = cust.updateOrderAddress(addressout);
            map.put("status", "success");
            map.put("customerId", customer.getCustDetId());
            //				} else {//This Line is commented by Viofixer as a fix for Poor Logging Practice Use of a System Output Stream 
            map.put("status", "fail");
        }
        return map;
    }

    @RequestMapping(value = "/mobile/addressDefaultActive", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Object addrDefaultFlagId(@RequestBody final AddressFlag addresflag) {
        final HashMap<String, Object> map = new HashMap<String, Object>();
        final Address adds;
        Address customer = cust.updateAddressFlag(addresflag);
        if (addresflag != null) {
            map.put("status", "update");
            map.put("customerId", customer.getCustDetId());
        } else {
            map.put("status", "Fail to update");
        }
        return map;
    }

    @RequestMapping(value = "/mobile/getOtherAddressWithId", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Object getOtherAddressWithId(@RequestBody final Id id) {
        final Map<String, Object> map = new HashMap<String, Object>();
        final Map<String, String> status = new HashMap<String, String>();
        final List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        final List<Address> addresslist = new ArrayList<Address>();
        final List<Address> addrs = cust.getOtherAddressList(id.getId());
        System.out.println("listsize" + addrs.size());
        if (addrs.size() != 0) {
            map.put("Address", addrs);
            //map.put("OfficeAddress", officeaddresslist);
            list.add(map);
        } else {
            status.put("status", "user not found");
            return status;
        }
        return list;
    }

    @RequestMapping(value = "/mobile/addressDefaultFlag", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Object addrDefaultFlag(@RequestBody final AddressFlag addresflag) {
        final HashMap<String, Object> map = new HashMap<String, Object>();
        //List<Address> address=setAddrFlagZero();
        final Address adds;
        Address customer = cust.updateAddressFlag(addresflag);
        Address setactive = cust.saveAddressFlage(addresflag);
        if (addresflag != null) {
            map.put("status", "update");
            map.put("customerId", customer.getCustDetId());
        } else {
            map.put("status", "Fail to update");
        }
        return map;
    }

    @RequestMapping(value = "/mobile/manageProfiles", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> reviewsave(@RequestBody final Cust custs) {
        final HashMap<String, Object> map = new HashMap<String, Object>();
        CustDet customer;
        if (!custs.getMobile().isEmpty()) {
            customer = cust.updateProfile(custs);
            if (customer == null) {
                map.put("status", "fail to update");
                map.put("key", "2");
                return map;
            } else {
                map.put("key", "1");
                //String custo = sendExotelSMS(otpgen.getMobile(),otpgen.getOtp()); // SMS Triggering for ForgotPassword
                //forgotPasswordSendEmail(forgotPassword, customer.getCustPw(),customer.getCustName()); // E-Mail Triggering for ForgotPassword
                map.put("Status", "update Successfully");
                return map;
            }
        }
        return map;
    }

    /*@RequestMapping(value = "/mobile/manageProfiles", method = RequestMethod.POST)
		public  @ResponseBody Map<String, Object> packSelection(@RequestBody  final PkgSelection selection) {
//		 final HashMap<String, Object> map = new HashMap<String, Object>();//This Line is commented by Viofixer as a fix for Privacy Violation
		 final HashMap<String,Object> map2=new HashMap<String,Object>();
		 List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
			
			return map;

		}
	 */
    public String sendExotelSMS(String cntcNo, String password) {
        HttpClient client = new DefaultHttpClient();
        ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
        postParameters.add(new BasicNameValuePair("From", "09243422233"));
        postParameters.add(new BasicNameValuePair("To", cntcNo));
        String body = "Dear SpiceBox Customer, your login password is " + password + ". Thank You ";
        System.out.println("Password is:---------");
        String out;
        try {
            out = new String(body.getBytes("UTF-8"), "ISO-8859-1");
            postParameters.add(new BasicNameValuePair("Body", out));
        } catch (UnsupportedEncodingException e1) {
        // TODO Auto-generated catch block
        //            e1.printStackTrace();//This Line is commented by Viofixer as a fix for Privacy Violation
        }
        // Replace <sid> with your account sid
        String sid = "spicebox";
        // Replace <token> with your secret token
        String authStr = sid + ":" + "b75c0e7782b3ad7159aacbc928441ffee3554a33";
        String url = "https://" + authStr + "@twilix.exotel.in/v1/Accounts/" + sid + "/Sms/send";
        byte[] authEncBytes = Base64.encodeBase64(authStr.getBytes());
        String authStringEnc = new String(authEncBytes);
        HttpPost post = new HttpPost(url);
        post.setHeader("Authorization", "Basic " + authStringEnc);
        try {
            post.setEntity(new UrlEncodedFormEntity(postParameters));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            HttpResponse response = client.execute(post);
            int httpStatusCode = response.getStatusLine().getStatusCode();
            System.out.println(httpStatusCode + "is the status code");
            HttpEntity entity = response.getEntity();
            System.out.println(EntityUtils.toString(entity));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Password is Returning now.....:");
        return password;
    }

    public void forgotPasswordSendEmail(ForgotPassword forgotPassword, String password, String cntcName) {
        final String FROM = "info@spicebox.in";
        //  final String FROM = "info@spicebox.in"; 
        // This has been verified on the Amazon SES setup
        // I have production access
        final String TO = forgotPassword.getEmail();
        final String BODY = "Hi " + cntcName + ",\n\nYour login password is:" + password + "\n\nTeam SpiceBox!";
        final String SUBJECT = "SpiceBox Login Credentials";
        //gurmit
        final String SMTP_USERNAME = "AKIAINVWQY4OC4JYLQTQ";
        //nibm  final String SMTP_USERNAME = "AKIAIDPTFHPDXAIPUMGA";
        //gurmit
        final String SMTP_PASSWORD = "AvQ5uT1ufPbxMoAhGeSk2SFRwIrNOKRueDoEVO9Y63j+";
        //nim final String SMTP_PASSWORD = "Ag8uEyD5/sc3QqjTdMaaSSImgSzLOWaQkhoHZh0qHXbX"; 
        final String HOST = "email-smtp.us-west-2.amazonaws.com";
        final int PORT = 25;
        Properties props = System.getProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.port", PORT);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");
        props.setProperty("mail.smtp.host", HOST);
        props.setProperty("mail.smtps.auth", "true");
        props.setProperty("mail.user", "info@spicebox.in");
        props.setProperty("mail.password", "macintosh1");
        props.setProperty("mail.debug", "true");
        Session session = Session.getDefaultInstance(props);
        MimeMessage msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(FROM));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
            msg.setSubject(SUBJECT);
            msg.setContent(BODY, "text/plain");
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        SMTPTransport smtpTransport = null;
        try {
            smtpTransport = new SMTPTransport(session, new URLName("email-smtp.us-west-2.amazonaws.com"));
            System.out.println("Attempting to send an email through the Amazon SES SMTP interface...");
            smtpTransport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
            smtpTransport.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Email sent!");
        } catch (Exception ex) {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
        } finally {
            try {
                smtpTransport.close();
            } catch (MessagingException e) {
//                e.printStackTrace();//This Line is commented by Viofixer as a fix for Privacy Violation
            }
        }
    }
}
