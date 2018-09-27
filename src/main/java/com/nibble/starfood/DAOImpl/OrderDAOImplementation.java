package com.nibble.starfood.DAOImpl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.nibble.starfood.DAOI.OrderDAO;
import com.nibble.starfood.exception.CustomGenericException;
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

@Repository
public class OrderDAOImplementation implements OrderDAO {

    @Autowired
    private SessionFactory sessionF;

    @Override
    public City getCityByCityName(String city) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From City c where c.cityDesc=:cityName");
        query.setParameter("cityName", city);
        return (City) query.list().get(0);
    }

    @Override
    public CustOrdDet checkOrderDetId(int ordDetId) {
        // TODO Auto-generated method stub
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From CustOrdDet c where c.id=:ordDetId");
        query.setParameter("ordDetId", ordDetId);
        if (query.list().size() == 0)
            return null;
        return (CustOrdDet) query.list().get(0);
    }

    @Override
    public void saveOrderDateDetails(OrderDateDetails orderDate) {
        // TODO Auto-generated method stub
        final Session session = sessionF.getCurrentSession();
        session.save(orderDate);
    }

    @Override
    public List<PkgSizTyp> getPackageCount() {
        final Session session = sessionF.getCurrentSession();
        final List<PkgSizTyp> kitchen = session.createQuery("From PkgSizTyp ").list();
        return kitchen;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CustOrdDet> getCustOrderDetails(ManageOrder order) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From CustOrdDet c where c.custDet.id=:id and c.payModId!=:payMode and ordrStId=:orderStatusId");
        query.setParameter("payMode", 0);
        query.setParameter("id", order.getCustId());
        query.setParameter("orderStatusId", order.getOrderStatusId());
        return query.list();
    }

    @Override
    public CupnDet saveCouponDetails(CupnDet saveCouponDet) {
        final Session session = sessionF.getCurrentSession();
//        System.out.println("saving coupon Details........");//This Line is commented by Viofixer as a fix for Poor Logging Practice Use of a System Output Stream 
        session.save(saveCouponDet);
        return saveCouponDet;
    }

    @Override
    public List<CustBillHist> getBillDetById(int custBillId) {
        // TODO Auto-generated method stub
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From CustBillHist c where  c.id=:billId ORDER BY id DESC");
        query.setParameter("billId", custBillId);
        return query.list();
    }

    @Override
    public MealTyp getMealTypeById(int id) {
        final Session session = sessionF.getCurrentSession();
        final MealTyp cupn = (MealTyp) session.createQuery("FROM  MealTyp where id=:id").setParameter("id", id).list().get(0);
        return cupn;
    }

    @Override
    public List<PaymentGatewayDet> getPaymentGateWay() {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From PaymentGatewayDet c where c.paymentDatewayF=:otp");
        query.setParameter("otp", 1);
        return query.list();
    }

    @Override
    public CustDet otpActive() {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From CustDet c where c.otpF=:otp");
        query.setParameter("otp", 1);
        return (CustDet) query.list().get(0);
    }

    @Override
    public List<EorderClientDetail> getClientDetails() {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From EorderClientDetail ");
        return query.list();
    }

    @Override
    public int checkAddress(int addrTypeId, int customerId) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From Address c where c.addrTypeId =:addressTypeId and c.custDetId=:custId");
        query.setParameter("addressTypeId", addrTypeId);
        query.setParameter("custId", customerId);
        if (query.list().size() == 0) {
            return 0;
        }
        return 1;
    }

    @Override
    public CustBillHist saveBillHist(CustBillHist bill) {
        final Session session = sessionF.getCurrentSession();
        session.save(bill);
        return bill;
    }

    ///sample
    @Override
    public CustOrdDet gatListDate(CustOrdDet orderdetails) {
        final Session session = sessionF.getCurrentSession();
        session.save(orderdetails);
        return orderdetails;
    }

    @Override
    public MenuTyp getMenuTypById(int id) {
        final Session session = sessionF.getCurrentSession();
        final MenuTyp cust = (MenuTyp) session.get(MenuTyp.class, id);
        return cust;
    }

    @Override
    public PkgDur getPkgDurById(int id) {
        final Session session = sessionF.getCurrentSession();
        final PkgDur cust = (PkgDur) session.get(PkgDur.class, id);
        return cust;
    }

    @Override
    public WeekTyp getWeekTypById(int id) {
        final Session session = sessionF.getCurrentSession();
        final WeekTyp cust = (WeekTyp) session.get(WeekTyp.class, id);
        return cust;
    }

    @Override
    public Area getAreaByName(String area) {
        final Session session = sessionF.getCurrentSession();
//        System.out.println("area name : " + area);//This Line is commented by Viofixer as a fix for Poor Logging Practice Use of a System Output Stream 
        final Query query = session.createQuery("From Area c where c.areaDesc=:areaName");
        query.setParameter("areaName", area);
        List<Area> list = query.list();
//        System.out.println("area size" + list.size());//This Line is commented by Viofixer as a fix for Poor Logging Practice Use of a System Output Stream 
        if (list.size() == 0) {
            throw new CustomGenericException("error", "Area name is not avaibile in database");
        }
        return list.get(0);
    }

    @Override
    public FoodTyp getFoodTypById(int id) {
        final Session session = sessionF.getCurrentSession();
        final FoodTyp cupn = (FoodTyp) session.createQuery("FROM  FoodTyp where id=:id").setParameter("id", id).list().get(0);
        return cupn;
    }

    @Override
    public MealTime getMealTimeById(int id) {
        final Session session = sessionF.getCurrentSession();
        final MealTime cupn = (MealTime) session.createQuery("FROM  MealTime where id=:id").setParameter("id", id).list().get(0);
        return cupn;
    }

    @Override
    public PkgSizTyp getPackageId(int id) {
        final Session session = sessionF.getCurrentSession();
        final PkgSizTyp cupn = (PkgSizTyp) session.createQuery("FROM  PkgSizTyp where id=:id").setParameter("id", id).list().get(0);
        return cupn;
    }

    @Override
    public CustDet findCustDevBYId(int id) {
        final Session session = sessionF.getCurrentSession();
        final CustDet cust = (CustDet) session.createQuery("FROM  CustDet where id=:id").setParameter("id", id).list().get(0);
        return cust;
    }

    /*@SuppressWarnings("unchecked")
	@Override
	public List<PkgSizTyp> getMenuforSingleDay(MenuList menu) {

		final Session session = sessionF.getCurrentSession();
		final Query query = session.createQuery("From PkgSizTyp where mealTimeId=:mealtime and foodTypId=:foodtype and pkgDurId=:pkgduration and weekDurId=:weekduration and menuTypId=:menutype  ");
		query.setParameter("mealtime", menu.getMealTime());
		query.setParameter("foodtype", menu.getFoodType());
		query.setParameter("pkgduration", menu.getPkgDur());
		query.setParameter("weekduration", menu.getWeekDur());
		query.setParameter("menutype", menu.get
e());
		return query.list();
	}*/
    @SuppressWarnings("unchecked")
    @Override
    public List<PkgSizTyp> getPackagesMenuList(AllMenu allmenu) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From PkgSizTyp");
        query.setFirstResult(allmenu.getStartId());
        query.setMaxResults(allmenu.getEndId());
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PkgFoodItm> getItemList(AllMenu allmenu) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From PkgFoodItm");
        query.setFirstResult(allmenu.getStartId());
        query.setMaxResults(allmenu.getEndId());
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PkgSizTyp> getPkg(MenuList menu) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From PkgSizTyp where id=:mealtime");
        query.setParameter("mealtime", menu.getMealTime());
        query.setFirstResult(menu.getStart());
        query.setMaxResults(menu.getEnd() + 1);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PkgSizTyp> getPackagesMenuList(GetFoodItems menu) {
        final Session session = sessionF.getCurrentSession();
        Query query = null;
        if (menu.getMealTime() != 0 && menu.getFoodTypeId() != 0 && menu.getPriceDurationId() != 0) {
            query = session.createQuery("From PkgSizTyp where mealtime.id=:mealtime and pkgSizTypF=:pkgflg and foodtyp.id=:foodTypeId");
            query.setParameter("mealtime", menu.getMealTime());
            query.setParameter("foodTypeId", menu.getFoodTypeId());
            query.setParameter("pkgflg", 1);
        }
        if (menu.getMealTime() != 0 && menu.getFoodTypeId() == 0 && menu.getPriceDurationId() == 0) {
            query = session.createQuery("From PkgSizTyp where pkgSizTypF=:pkgflg");
            //		query.setParameter("mealtime", menu.getMealTime());
            query.setParameter("pkgflg", 1);
        //		query.setFirstResult(menu.getStart());
        //		query.setMaxResults(menu.getEnd());
        }
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PkgSizTyp> getFoodMenuList(GetFoodItems menu) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From PkgSizTyp where mealtime.id=:mealtime and pkgSizTypF=:pkgflg ");
        query.setParameter("mealtime", menu.getMealTime());
        query.setParameter("pkgflg", 1);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PkgSizTyp> getPackageSizeDetails() {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From PkgSizTyp where  pkgSizTypF=:pkgflg ");
        query.setParameter("pkgflg", 1);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PkgConfigRelt> getPackageList() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
        String date = sdf.format(new Date());
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 6);
        Date dates = cal.getTime();
//        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-M-dd");//This Line is commented by Viofixer as a fix for Poor Logging Practice Use of a System Output Stream 
//        String date1 = format1.format(dates);//This Line is commented by Viofixer as a fix for Poor Logging Practice Use of a System Output Stream 
        System.out.println(date);
        System.out.println(date1);
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From PkgConfigRelt where menuDate BETWEEN :cdate AND :sdates and packagSize.pkgSizTypF=:pkgflg and pkgConfigReltF=:flag");
        query.setParameter("cdate", date);
        query.setParameter("sdates", date1);
        query.setParameter("pkgflg", 1);
        query.setParameter("flag", 1);
        return query.list();
    }

    public List<PkgSizTyp> listOfMealPlanList() {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From PkgSizTyp where pkgSizTypF=:pkgflg ");
        query.setParameter("pkgflg", 1);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PkgConfigRelt> getFoodItemById(GetFoodItems getitems) {
        final Session session = sessionF.getCurrentSession();
        /*Criteria criteria = session.createCriteria(PkgFoodItm.class);
		criteria.setFirstResult(getitems.getStart())
		        .setMaxResults(getitems.getEnd());
*/
        final Query query = session.createQuery("From PkgConfigRelt where  mealTime=:mealtime and menuDate=:date and pkgConfigReltF=:flag");
        //query.setParameter("foodItem", getitems.getFoodId());
        query.setParameter("mealtime", getitems.getMealTime());
        query.setParameter("date", getitems.getDates());
        query.setParameter("flag", 1);
        query.setFirstResult(getitems.getStart());
        query.setMaxResults(getitems.getEnd() + 1);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PkgConfigRelt> getPackgItemById(GetFoodItems getlist) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From PkgConfigRelt where  mealTime=:mealtime and menuDate=:date");
        //query.setParameter("foodItem", getitems.getFoodId());
        query.setParameter("mealtime", getlist.getMealTime());
        query.setParameter("date", getlist.getDates());
        query.setFirstResult(getlist.getStart());
        query.setMaxResults(getlist.getEnd() + 1);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public CustOrdDet saveOrderBill(CustOrdDet orderdetails) {
        final Session session = sessionF.getCurrentSession();
        session.save(orderdetails);
        return orderdetails;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CustOrdDet> listOfOrder() {
        final Session session = sessionF.getCurrentSession();
        final List<CustOrdDet> mealTimeList = session.createQuery("From CustOrdDet ").list();
        return mealTimeList;
    }

    @Override
    public CustDet getWalletDetailsById(int id) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("FROM  CustDet where id=:id");
        query.setParameter("id", id);
        if (query.list().size() == 0)
            return null;
        return (CustDet) query.list().get(0);
    }

    @Override
    public List<Cupn> getCupnDetails(int id) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From Cupn where  custDetId=:id or custDetId=:num");
        query.setParameter("id", id);
        query.setParameter("num", 0);
        return query.list();
    }

    @Override
    public Address saveCustomerAddress(Address address) {
        final Session session = sessionF.getCurrentSession();
        session.save(address);
        return address;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MealTime> getMealTimeList() {
        /*final Session session = sessionF.getCurrentSession();
		final List<MealTime> mealTimeList = session.createQuery("From MealTime ").list();
		return mealTimeList;*/
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From MealTime c where c.mealTimeF=:flag");
        query.setParameter("flag", 1);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PkgDur> getMealDurationList() {
        /*final Session session = sessionF.getCurrentSession();
		final List<PkgDur> mealDurationList = session.createQuery("From PkgDur ").list();
		return mealDurationList;*/
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From PkgDur c where c.pkgDurF=:flag");
        query.setParameter("flag", 1);
        return query.list();
    }

    @Override
    public List<pkgDuration> getPackageDurationList() {
        // TODO Auto-generated method stub
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From pkgDuration c where c.pkgDurF=:flag");
        query.setParameter("flag", 1);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<WeekTyp> getWeekDurationList() {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From WeekTyp c where c.weekTypF=:flag");
        query.setParameter("flag", 1);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PayMod> getPaymentTypeList() {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From PayMod c where c.payModF=:flag");
        query.setParameter("flag", 1);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Tax> getTaxList() {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From Tax c where c.taxVisF=:flag");
        query.setParameter("flag", 1);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<FoodTyp> getFoodTypeList() {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From FoodTyp c where c.foodTypeVisF=:flag");
        query.setParameter("flag", 1);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MenuTyp> getMenuTypeList() {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From MenuTyp c where c.menuTypF=:flag");
        query.setParameter("flag", 1);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DelvChrg> getDeliveryChargesList() {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From DelvChrg c where c.delvChrgF=:flag");
        query.setParameter("flag", 1);
        return query.list();
    }

    @SuppressWarnings("unchecked")
//    @Override//This Line is commented by Viofixer as a fix for Poor Logging Practice Use of a System Output Stream 
    public List<PkgConfigRelt> getItemsBasedOnPackage(Integer id, String startDates, String endDate) {
        System.out.println("Start Date in DAO:" + startDates);
        System.out.println("END date in DAo:" + endDate);
        final Session session = sessionF.getCurrentSession();
        /*Criteria criteria = session.createCriteria(PkgFoodItm.class);
		criteria.setFirstResult(getitems.getStart())
		        .setMaxResults(getitems.getEnd());
*/
        final Query query = session.createQuery("From PkgConfigRelt where  packagSize.id=:id and meal_time_id=1 and menuDate BETWEEN :startdate AND :endDate");
        //query.setParameter("foodItem", getitems.getFoodId());
        query.setParameter("id", id);
        query.setParameter("startdate", startDates);
        query.setParameter("endDate", endDate);
        return query.list();
    }

    @Override
    public List<PkgConfigRelt> getItemsBasedOnPackageDinner(Integer id, String dates, String endate) {
        // TODO Auto-generated method stub
        final Session session = sessionF.getCurrentSession();
        /*Criteria criteria = session.createCriteria(PkgFoodItm.class);
		criteria.setFirstResult(getitems.getStart())
		        .setMaxResults(getitems.getEnd());
*/
        final Query query = session.createQuery("From PkgConfigRelt where  packagSize.id=:id and meal_time_id=2 and menuDate BETWEEN :startdate AND :endDate");
        //query.setParameter("foodItem", getitems.getFoodId());
        query.setParameter("id", id);
        query.setParameter("startdate", dates);
        query.setParameter("endDate", endate);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PkgConfigRelt> getListOf(Integer id) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From PkgConfigRelt where  pkgSizTypId=:id and pkgConfigReltF=:flag ");
        query.setParameter("id", id);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PkgConfigRelt> getItemsBasedOnPackage(int id, String startDates) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From PkgConfigRelt where  packagSize.id=:id and menuDate=:startdate and pkgConfigReltF=:flag");
        //query.setParameter("foodItem", getitems.getFoodId());
        query.setParameter("id", id);
//        query.setParameter("startdate", startDates);//This Line is commented by Viofixer as a fix for Poor Logging Practice Use of a System Output Stream 
//        query.setParameter("flag", 1);//This Line is commented by Viofixer as a fix for Poor Logging Practice Use of a System Output Stream 
        System.out.println("Date in Config:" + startDates);
        System.out.println("Query:" + query);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PkgConfigRelt> getItemsBasedOnPackageMealTime(Integer id, String dates, int mealTime) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From PkgConfigRelt where  packagSize.id=:id and menuDate=:startdate and pkgConfigReltF=:flag and mealTime=:mealTimeId");
        //query.setParameter("foodItem", getitems.getFoodId());
        query.setParameter("id", id);
        query.setParameter("startdate", dates);
//        query.setParameter("flag", 1);//This Line is commented by Viofixer as a fix for Poor Logging Practice Use of a System Output Stream 
//        query.setParameter("mealTimeId", mealTime);//This Line is commented by Viofixer as a fix for Poor Logging Practice Use of a System Output Stream 
        System.out.println("Date in Config:" + dates);
        System.out.println("Query:" + query);
        return query.list();
    }

    @Override
    public CustBillHist getCustBillHistById(int id) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From CustBillHist c where c.id =:billId");
        query.setParameter("billId", id);
        final CustBillHist custBill = (CustBillHist) query.list().get(0);
        return custBill;
    }

    @Override
    public void updateWalletAmount(CustDet custDetails) {
        final Session session = sessionF.getCurrentSession();
        session.merge(custDetails);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CancelledOrderDetails> findCancelOrdDetById(int id) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From CancelledOrderDetails where custDetId=:custId");
        query.setParameter("custId", id);
        return query.list();
    }

    @Override
    public void updateCancelCouponFlg(CancelledOrderDetails cancelCouponDetails) {
        final Session session = sessionF.getCurrentSession();
        session.merge(cancelCouponDetails);
    }

    @Override
    public void insertNewCancelCoupon(CancelledOrderDetails cancelCouponDetails) {
        final Session session = sessionF.getCurrentSession();
        session.merge(cancelCouponDetails);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CupnDet> getUserCouponDetails(int custDetId, int id) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From CupnDet where custDetId=:custId and custBillHistId=:billId");
        query.setParameter("custId", custDetId);
        query.setParameter("billId", id);
        return query.list();
    }

    @Override
    public void updateCouponDet(CupnDet couponDet) {
        final Session session = sessionF.getCurrentSession();
        session.merge(couponDet);
    }

    @Override
    public int updateCustBillDetails(CustBillHist order) {
        final Session session = sessionF.getCurrentSession();
        session.merge(order);
        return 1;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CustOrdDet> getCustOrdDetById(int id) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From CustOrdDet where custBillId=:billId");
        query.setParameter("billId", id);
        return query.list();
    }

    @Override
    public void updateCustOrdDetails(CustOrdDet order) {
        final Session session = sessionF.getCurrentSession();
        session.merge(order);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CustOrdDet> getCustomerOrders(int custBillId) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From CustOrdDet c where c.custBillId=:billId");
        query.setParameter("billId", custBillId);
        return query.list();
    }

    @Override
    public Address getAddressDet(Integer addressId) {
        final Session session = sessionF.getCurrentSession();
        final Address address = (Address) session.createQuery("FROM  Address where id=:addressId").setParameter("addressId", addressId).list().get(0);
        return address;
    }

    @Override
    public CustBillHist getCustBillDetById(int custBillId) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From CustBillHist c where c.id =:billId");
        query.setParameter("billId", custBillId);
        final CustBillHist custBill = (CustBillHist) query.list().get(0);
        return custBill;
    }

    @Override
    public PkgSizTyp getPackageDetailsById(Integer id) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From PkgSizTyp c where c.id=:packageId");
        query.setParameter("packageId", id);
        if (query.list().size() == 0)
            return null;
        return (PkgSizTyp) query.list().get(0);
    }

    @Override
    public PkgSizTyp upadatePackageStock(PkgSizTyp upadatePackageStock) {
        final org.hibernate.Session session = sessionF.getCurrentSession();
        session.save(upadatePackageStock);
        return upadatePackageStock;
    }

    @Override
    public CustBillHist getBillDetailsById(Integer custBillId) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From CustBillHist c where c.id=:custBillId");
        query.setParameter("custBillId", custBillId);
        if (query.list().size() == 0)
            return null;
        return (CustBillHist) query.list().get(0);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CustOrdrs> getLastId() {
        final Session session = sessionF.getCurrentSession();
        List<CustOrdrs> result = session.createQuery("from CustOrdrs ORDER BY id DESC").setMaxResults(1).list();
        return result;
    }

    @Override
    public CustOrdrs saveCusterOrders(CustOrdrs custOrders) {
        final Session session = sessionF.getCurrentSession();
        session.save(custOrders);
        return custOrders;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CustBillHist> getBillIdByCustId(ManageOrder order) {
        final Session session = sessionF.getCurrentSession();
        Query query = null;
        if (order.getOrderStatusId() == 7) {
            query = session.createQuery("From CustBillHist c where (c.payModId=:couponPaid or c.payModId=:codPaid	 or c.payModId=:onlinePaid) and c.custDetId=:custId ORDER BY id DESC");
            query.setParameter("custId", order.getCustId());
            query.setParameter("couponPaid", 1);
            query.setParameter("codPaid", 3);
            query.setParameter("onlinePaid", 5);
        } else if (order.getOrderStatusId() == 6) {
            query = session.createQuery("From CustBillHist c where (c.payModId=:couponUnPaid or c.payModId=:codUnPaid or c.payModId=:onlineUnPaid) and c.custDetId=:custId ORDER BY id DESC");
            query.setParameter("custId", order.getCustId());
            query.setParameter("couponUnPaid", 2);
            query.setParameter("codUnPaid", 4);
            query.setParameter("onlineUnPaid", 6);
        }
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CustOrdrs> getOrderDetailsByMealTime(int id) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From CustOrdrs c where c.custBillId=:billId");
        query.setParameter("billId", id);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CustOrdDet> getOrderDetailsByOrderNo(int ordNo) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From CustOrdDet c where c.ordNo=:OrderNo");
        query.setParameter("OrderNo", ordNo);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CustOrdrs> getCustOrdsById(int custBillId) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From CustOrdrs where custBillId=:billId");
        query.setParameter("billId", custBillId);
        return query.list();
    }

    @Override
    public void updateCustOrdrs(CustOrdrs custOrds) {
        final Session session = sessionF.getCurrentSession();
        session.merge(custOrds);
    }

    @Override
    public MealTime getCutOffTimeBasedonMealTime(int mealTime) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From MealTime c where c.id=:mealTimeId");
        query.setParameter("mealTimeId", mealTime);
        if (query.list().size() == 0)
            return null;
        return (MealTime) query.list().get(0);
    }

    @Override
    public Holidays getHolidayDet(String dates) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From Holidays c where c.holidayDate=:date");
        query.setParameter("date", dates);
        if (query.list().size() == 0)
            return null;
        return (Holidays) query.list().get(0);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MealPlan> getMealPlanList() {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From MealPlan where mealPlanF=:flag");
        query.setParameter("flag", 1);
        return query.list();
    }
}
