package com.nibble.starfood.DAOImpl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.nibble.starfood.DAOI.CustDetDAOI;
import com.nibble.starfood.hibernatemodel.AddrTyp;
import com.nibble.starfood.hibernatemodel.Address;
import com.nibble.starfood.hibernatemodel.AndroidPushMsg;
import com.nibble.starfood.hibernatemodel.Area;
import com.nibble.starfood.hibernatemodel.City;
import com.nibble.starfood.hibernatemodel.CustCupnRelt;
import com.nibble.starfood.hibernatemodel.CustDet;
import com.nibble.starfood.hibernatemodel.CustFdbkRelt;
import com.nibble.starfood.hibernatemodel.CustOrdDet;
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
import com.nibble.starfood.webservices.model.FeedBack;
import com.nibble.starfood.webservices.model.FeedBackSend;
import com.nibble.starfood.webservices.model.FoodCat;

@Repository
public class CustDetDAOImpl implements CustDetDAOI {

    @Autowired
    private SessionFactory sessionF;

    // for Android PushMessage Service
    @Override
    public List<AndroidPushMsg> getAndroidPushMsgRegIdList() {
        final Session session = sessionF.getCurrentSession();
        @SuppressWarnings("unchecked") final List<AndroidPushMsg> custList = session.createQuery("FROM AndroidPushMsg").list();
        return custList;
    }

    @Override
    public List<City> getCityListData(String name) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From City ");
        // query.setParameter("name", name);
        return query.list();
    }

    @Override
    public CustDet otpActive(CustDet data) {
        final Session session = sessionF.getCurrentSession();
        session.save(data);
        return data;
    }

    @Override
    public List<FdbkQues> getFeedbackQuestionsList() {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From FdbkQues c where c.fdbkQuesF=:flag");
        query.setParameter("flag", 0);
        return query.list();
    }

    @Override
    public List<EorderClientDetail> getClientDetails() {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From EorderClientDetail ");
        return query.list();
    }

    @Override
    public CustFdbkRelt savefeedBack(CustFdbkRelt send) {
        final Session session = sessionF.getCurrentSession();
        session.save(send);
        return send;
    }

    @Override
    public CustDet getCustById(int userId) {
        Session session = sessionF.getCurrentSession();
        CustDet user = (CustDet) session.get(CustDet.class, userId);
        return user;
    }

    @Override
    public List<Address> getAddressDetails(int userId) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From Address c where c.custDetId=:userId");
        query.setParameter("userId", userId);
        return query.list();
    /*Session session=sessionF.getCurrentSession();
		Address user=(Address) session.get(Address.class, userId);
		return user;*/
    /*final Session session = sessionF.getCurrentSession();
		final Query query = session.createQuery("From Address c where c.custDetId=:userId and c.addrTypeId=:addrTypeId");
		query.setParameter("userId", userId);
		query.setParameter("addrTypeId", addrType);
		if (query.list().size() == 0)
			return null;
		return (Address) query.list().get(0);*/
    }

    @Override
    public List<Address> getActiveAddressDetails(int userId, int addrFlag) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From Address c where c.custDetId=:userId and addrTypeId=:addressTypId");
        query.setParameter("userId", userId);
        query.setParameter("addressTypId", addrFlag);
        return query.list();
    }

    @Override
    public City getCityId(int id) {
        Session session = sessionF.getCurrentSession();
        City city = (City) session.get(City.class, id);
        return city;
    }

    @Override
    public Pincode getPincodeId(int pincodeId) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From Pincode c where c.id=:pincodeId");
        query.setParameter("pincodeId", pincodeId);
        if (query.list().size() == 0)
            return null;
        return (Pincode) query.list().get(0);
    }

    @Override
    public Area getAreaId(int id) {
        Session session = sessionF.getCurrentSession();
        Area area = (Area) session.get(Area.class, id);
        return area;
    }

    @Override
    public State getStateId(int id) {
        Session session = sessionF.getCurrentSession();
        State state = (State) session.get(State.class, id);
        return state;
    }

    @Override
    public SaveComment saveComment(SaveComment save) {
        final Session session = sessionF.getCurrentSession();
        session.save(save);
        return save;
    }

    @Override
    public SaveComment savefeedBackcomment(SaveComment savecmnt) {
        final Session session = sessionF.getCurrentSession();
        session.save(savecmnt);
        return savecmnt;
    }

    @Override
    public void updateCustDet(CustDet custdet) {
        final org.hibernate.Session session = sessionF.getCurrentSession();
        session.saveOrUpdate(custdet);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SingleDayRelt> orderShowByDate(FoodCat singleDayMenu) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From SingleDayRelt where menuDate=:date");
        query.setParameter("date", singleDayMenu.getDate());
        return query.list();
    }

    @Override
    public CustDet updateProfile(CustDet profile) {
        Session session = sessionF.getCurrentSession();
        session.merge(profile);
        return profile;
    }

    @Override
    public CustDet login(String mobile, String password) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From CustDet c where c.cntcNo=:mobile and c.custPw=:password");
        query.setParameter("mobile", mobile);
        query.setParameter("password", password);
        if (query.list().size() == 0)
            return null;
        return (CustDet) query.list().get(0);
    }

    @Override
    public CustDet changePwd(CustDet pwdchange) {
        Session session = sessionF.getCurrentSession();
        session.merge(pwdchange);
        return pwdchange;
    }

    @Override
    public CustDet saveMobile(CustDet update) {
        Session session = sessionF.getCurrentSession();
        session.merge(update);
        return update;
    }

    @Override
    public CustDet LoginMobile(String mobile, int guestFlag) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From CustDet c where c.emailId=:email and c.guestF=:guestFlg");
        if (query != null) {
            query.setParameter("guestFlg", guestFlag);
        }
        query.setParameter("email", mobile);
        if (query.list().size() == 0)
            return null;
        return (CustDet) query.list().get(0);
    }

    @Override
    public CustDet LoginCheckWithMobile(String mobile, int guestFlag) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From CustDet c where c.cntcNo=:mobile and c.guestF=:guestFlg");
        query.setParameter("guestFlg", guestFlag);
        query.setParameter("mobile", mobile);
        if (query.list().size() == 0)
            return null;
        return (CustDet) query.list().get(0);
    }

    @Override
    public AndroidPushMsg saveAndroidPushMsg(AndroidPushMsg details) {
        final Session session = sessionF.getCurrentSession();
        session.save(details);
        return details;
    }

    @Override
    public CustDet Loginforgot(String mobile, String email) {
        final Session session = sessionF.getCurrentSession();
        Query query = null;
        if (mobile != null) {
            query = session.createQuery("From CustDet c where c.cntcNo=:mobile");
            query.setParameter("mobile", mobile);
        }
        if (email != null) {
            query = session.createQuery("From CustDet c where c.emailId=:email");
            query.setParameter("email", email);
        }
        if (query.list().size() == 0)
            return null;
        return (CustDet) query.list().get(0);
    }

    @Override
    public CustDet updatePhoneOTP(CustDet saveotp) {
        final org.hibernate.Session session = sessionF.getCurrentSession();
        session.merge(saveotp);
        return saveotp;
    }

    @Override
    public CustDet VerfPhone(String otp, int id) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From CustDet c where c.otp=:otps and c.id=:ids");
        query.setParameter("otps", otp);
        query.setParameter("ids", id);
        if (query.list().size() == 0)
            return null;
        return (CustDet) query.list().get(0);
    }

    @Override
    public CustDet changePwd(String pwd, int id) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("update CustDet c  set c.custPw=:pwd where c.id=:ids");
        query.setParameter("pwd", pwd);
        query.setParameter("ids", id);
        if (query.list().size() == 0)
            return null;
        return (CustDet) query.list().get(0);
    }

    @Override
    public CustDet profileManage(CustDet custdev) {
        final Session session = sessionF.getCurrentSession();
        Query query = session.createQuery("update AddressOut u set u.name = :newName where u.name=:name");
        query.setString("name", "Bill");
        query.setString("newName", "John");
        query.executeUpdate();
        if (query.list().size() == 0)
            return null;
        return (CustDet) query.list().get(0);
    }

    @Override
    public CustDet getFBUser(CustDet fb) {
        final org.hibernate.Session session = sessionF.getCurrentSession();
        session.save(fb);
        return fb;
    }

    @Override
    public CustDet getGPUser(CustDet gp) {
        final org.hibernate.Session session = sessionF.getCurrentSession();
        session.save(gp);
        return gp;
    }

    @Override
    public AndroidPushMsg getAndroidPushMsgByEmail(String name) {
        final Session session = sessionF.getCurrentSession();
        final AndroidPushMsg custList = (AndroidPushMsg) session.createQuery("FROM AndroidPushMsg where email=:id").setParameter("id", name).list().get(0);
        return custList;
    }

    @Override
    public CustDet Login(String email, String password, int flag) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From CustDet c where c.emailId=:email and c.custPw=:password and c.guestF=:flag");
        query.setParameter("email", email);
        query.setParameter("password", password);
        query.setParameter("flag", flag);
        if (query.list().size() == 0)
            return null;
        return (CustDet) query.list().get(0);
    }

    @Override
    public CustDet LoginWithMObile(String mobile, String password, int flag) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From CustDet c where c.cntcNo=:mobile and c.custPw=:password and c.guestF=:flag");
        query.setParameter("mobile", mobile);
        query.setParameter("password", password);
        query.setParameter("flag", flag);
        if (query.list().size() == 0)
            return null;
        return (CustDet) query.list().get(0);
    }

    @Override
    public void removeAndroidPushMsg(String regid) {
    // TODO Auto-generated method stub
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<State> getStateList() {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From State where stateF=:flag");
        query.setParameter("flag", 1);
        /*if (query.list().size() == 0)
			return null;*/
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Area> getAreaList() {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From Area where areaF=:flag");
        query.setParameter("flag", 1);
        /*if (query.list().size() == 0)
			return null;*/
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Pincode> getPincodeList() {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From Pincode where pincodeVisF=:flag");
        query.setParameter("flag", 1);
        /*if (query.list().size() == 0)
			return null;*/
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AreaOut> getAreaListByCity(int cityId) {
        /*Criteria criteria=sessionF.getCurrentSession().createCriteria(City.class).add(Restrictions.like("actFlg", 1));
		criteria.add(Restrictions.like("id", cityId))
		.setProjection(
				Projections
						.projectionList()
						.add(Projections.property("cityDesc"),
								"cityDesc")
						.add(Projections.property("lat"),
								"lat")
						
						.add(Projections.property("long_"),
								"long_")
								
						
					
						)
		.setCacheable(true)
		.setResultTransformer(Transformers.aliasToBean(CityOut.class));
		
	return criteria.list();*/
        Session session = sessionF.getCurrentSession();
        Criteria criteria = session.createCriteria(Area.class).createAlias("city", "city").add(Restrictions.like("city.id", cityId));
        criteria.setProjection(Projections.projectionList().add(Projections.property("areaDesc"), "areaDesc").add(Projections.property("lat"), "lat").add(Projections.property("longt"), "longt").add(Projections.property("addressDesc"), "addressDesc")).setResultTransformer(Transformers.aliasToBean(AreaOut.class)).setCacheable(true);
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SingleDayRelt> getOrderByDate(String date) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From SingleDayRelt where menuDate=:date");
        query.setParameter("date", date);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CityOut> getCityList() {
        Session session = this.sessionF.getCurrentSession();
        /* DetachedCriteria ownerCriteria = DetachedCriteria.forClass(CatgCityRel.class);
	        ownerCriteria.setProjection(Property.forName("catgId"))
	        .add(Restrictions.like("actFlg", 1));*/
        //   ownerCriteria.add(Restrictions.eq("cityId", cityId));
        Criteria criteria = session.createCriteria(City.class);
        criteria.add(Restrictions.like("cityF", 1)).setProjection(Projections.projectionList().add(Projections.property("id"), "id").add(Projections.property("cityDesc"), "cityDesc").add(Projections.property("lat"), "lat").add(Projections.property("longt"), "longt")).setResultTransformer(Transformers.aliasToBean(CityOut.class));
        return criteria.list();
    }

    /*@SuppressWarnings("unchecked")
	@Override
	public List<AddressOut> getAddress(int cityId) {
		Session session = sessionF.getCurrentSession();
        Criteria criteria = session.createCriteria(Address.class).createAlias("custorddet", "custorddet")
        		.add(Restrictions.like("custorddet.id", cityId));
        criteria.setProjection(
			Projections
					.projectionList()
						.add(Projections.property("houseNo"),
							"houseNo")
					.add(Projections.property("laneDesc"),
							"laneDesc")
					.add(Projections.property("landMrk"),
							"landMrk")
				)
				.setResultTransformer(Transformers.aliasToBean(AddressOut.class)).setCacheable(true);
        return criteria.list();
		
	}*/
    @Override
    public City getCityByName(String cityname) {
        final Session session = sessionF.getCurrentSession();
        final City custList = (City) session.createQuery("FROM City where cityDesc=:name").setParameter("name", cityname).list().get(0);
        return custList;
    }

    @Override
    public CustDet saveCustDev(CustDet custdev) {
        final org.hibernate.Session session = sessionF.getCurrentSession();
        session.save(custdev);
        return custdev;
    }

    @Override
    public CustDet loginMobile(String email) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From CustDet c where c.emailId=:email");
        query.setParameter("email", email);
        if (query.list().size() == 0)
            return null;
        return (CustDet) query.list().get(0);
    }

    @Override
    public CustDet checkloginMobile(String email, String mobile) {
        // TODO Auto-generated method stub
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From CustDet c where c.emailId=:email or c.cntcNo=:mobile");
        query.setParameter("email", email);
        query.setParameter("mobile", mobile);
        if (query.list().size() == 0)
            return null;
        return (CustDet) query.list().get(0);
    }

    @Override
    public CustDet loginUser(String email, String pwd) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From CustDet c where c.emailId=:email and c.custPw=:pwd");
        query.setParameter("email", email);
        query.setParameter("pwd", pwd);
        if (query.list().size() == 0)
            return null;
        return (CustDet) query.list().get(0);
    }

    public Address checkAddeFl(int id) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From Address c where c.addrflg=:flag");
        query.setParameter("flag", 0);
        if (query.list().size() == 0)
            return null;
        return (Address) query.list().get(0);
    }

    @Override
    public FoodTyp getFoodTypById(int id) {
        final Session session = sessionF.getCurrentSession();
        final FoodTyp cust = (FoodTyp) session.get(FoodTyp.class, id);
        return cust;
    }

    @Override
    public Address getActiveList(int id) {
        final Session session = sessionF.getCurrentSession();
        final Address cust = (Address) session.get(Address.class, id);
        return cust;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Address> getAddressList(int id) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From Address where custDetId=:custId and actAddrFlg=:activeAddrFlg");
        query.setParameter("custId", id);
        query.setParameter("activeAddrFlg", 1);
        return query.list();
    }

    @Override
    public Address getAddressByAddressType(Integer id, int addressTypeId) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From Address where custDetId=:custId and actAddrFlg=:activeAddrFlg and addrTypeId=:addressTypeId ");
        query.setParameter("custId", id);
        query.setParameter("addressTypeId", addressTypeId);
        query.setParameter("activeAddrFlg", 1);
        if (query.list().size() == 0)
            return null;
        return (Address) query.list().get(0);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AddrTyp> getAddressTypeList() {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From AddrTyp where addrTypF=:flag");
        query.setParameter("flag", 1);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<City> getCityListData() {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From City where cityF=:flag");
        query.setParameter("flag", 1);
        /*if (query.list().size() == 0)
			return null;*/
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Address getAddress(int id) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From Address where custDetId=:custId and addrTypeId!=:addrTypeId");
        query.setParameter("custId", id);
        query.setParameter("addrTypeId", 3);
        /*if (query.list().size() == 0)
			return null;*/
        if (query.list().size() == 0)
            return null;
        return (Address) query.list().get(0);
    }

    @Override
    public List<Address> updateAddress(int id) {
        /*Session session = this.sessionF.getCurrentSession();
        final Query query=  session.update(id);
        return id;
        */
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From Address where custDetId=:custId and addrTypeId!=:addrTypeId");
        query.setParameter("custId", id);
        query.setParameter("addrTypeId", 3);
        /*if (query.list().size() == 0)
			return null;*/
        return query.list();
    }

    @Override
    public Address updateOrderAddress(Address update) {
        /*final Session session = sessionF.getCurrentSession();
		final Query query = session.createQuery("From Address where id=:custId");
		query.setParameter("custId", 1);
		if (query.list().size() == 0)
			return null;
		return update;*/
        final org.hibernate.Session session = sessionF.getCurrentSession();
        session.merge(update);
        return update;
    }

    @Override
    public Address updateAddressFlag(Address addresflag) {
        final org.hibernate.Session session = sessionF.getCurrentSession();
        session.merge(addresflag);
        return addresflag;
    }

    @Override
    public Address getActiveAddressFlag(Address addresflag) {
        final org.hibernate.Session session = sessionF.getCurrentSession();
        session.merge(addresflag);
        return addresflag;
    }

    @Override
    public Address saveAddressFlage(Address activeflag) {
        final org.hibernate.Session session = sessionF.getCurrentSession();
        session.merge(activeflag);
        return activeflag;
    }

    ///////////////--------------coupen details-----------------/////////////
    /*	@Override
	public List<CustCupnRelt> getCustCupnReltListByCust(int Cust) {

		final Calendar calendar = Calendar.getInstance();
		final java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
		final Session session = sessionF.getCurrentSession();
		@SuppressWarnings("unchecked")
		final List<CustCupnRelt> custList = session.createQuery("FROM CustCupnRelt where id=:id and :stDate BETWEEN cupn.cupnStrtDt AND cupn.cupnEndDt").setParameter("id", Cust).setParameter("stDate", currentTimestamp).list();
		return custList;
	}*/
    @Override
    public List<CustCupnRelt> listOfCuppons(int custId) {
        final Session session = sessionF.getCurrentSession();
        return session.createQuery("FROM CustCupnRelt where cupn.cupnTypId=3 and custDetId=:id ").setParameter("id", custId).list();
    }

    @Override
    public List<PkgSizTyp> listOfFood() {
        final Session session = sessionF.getCurrentSession();
        @SuppressWarnings("unchecked") final List<PkgSizTyp> cities = session.createQuery("From PkgSizTyp").list();
        return cities;
    }

    @Override
    public List<FdbkQues> getFeedBackQuerys() {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From FdbkQues c where c.fdbkQuesF=:flag");
        query.setParameter("flag", 1);
        return query.list();
    }

    //where a.actAddrFlg=:flag
    @SuppressWarnings("unchecked")
    @Override
    public List<Address> getOtherAddressList(int id) {
        final Session session = sessionF.getCurrentSession();
        final Query query = session.createQuery("From Address a where a.actAddrFlg=:flag and a.custDetId=:id order by a.id DESC");
        query.setParameter("flag", 0);
        query.setParameter("id", id);
        query.setMaxResults(3);
        if (query.list().size() == 0)
            return null;
        return query.list();
    }
}
