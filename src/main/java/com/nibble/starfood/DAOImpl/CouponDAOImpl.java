package com.nibble.starfood.DAOImpl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nibble.starfood.DAOI.CouponDAO;
import com.nibble.starfood.hibernatemodel.Cupn;
import com.nibble.starfood.webservices.model.ApplyCoupon;

@Repository
public class CouponDAOImpl implements CouponDAO {
	
	@Autowired
	private SessionFactory sessionF;

	@SuppressWarnings("unchecked")
	@Override
	public List<Cupn> getCouponCodeDetails(ApplyCoupon cupn) {
		
		final Session session = sessionF.getCurrentSession();
		final Query query = session.createQuery("From Cupn c where c.cupnTypCode=:cupnCode");
		query.setParameter("cupnCode",cupn.getCouponCode());
		return query.list();
	}
////This Line is commented by Viofixer as a fix for Poor Logging Practice Use of a System Output Stream 
	@Override
	public Cupn getValidCoupons(Cupn cupndet, Date todayDate) {
		System.out.println("TODY DATE???????" + todayDate);
		final Session session = sessionF.getCurrentSession();
		final Cupn cupn = (Cupn) session
				.createQuery("FROM Cupn where date  BETWEEN :couponStartDate and :couponEndDate")
				.setParameter("couponStartDate", cupndet.getCupnStrtDt()).setParameter("date", "2015-08-15")
				.setParameter("couponEndDate", cupndet.getCupnEndDt()).list()
				.get(0);
		return cupn;
	}

	/*@Override
	public Long getCouponUsedCount(int couponId, ApplyCoupon cupn) {
		final Session session = sessionF.getCurrentSession();
		Query query = session.createQuery("select count(*) from CupnDet where cupnId=:coupnId and custDetId=:custId and cupnAmontF=:couponFlg");
		query.setParameter("custId", cupn.getCustomerId());
		query.setParameter("coupnId", cupn.getCouponId());
		query.setParameter("couponFlg",1);
		long count = (Long) query.uniqueResult();
		return count;
	}*/
	
	@Override
	public Long getCouponUsedCount(int couponId, ApplyCoupon cupn) {
		final Session session = sessionF.getCurrentSession();
		Query query = session.createQuery("select count(*)  from CupnDet where cupnId=:coupnId and custDetId=:custId and cupnAmontF=:couponFlg");
		query.setParameter("custId", cupn.getCustomerId());
		query.setParameter("coupnId", couponId);
		query.setParameter("couponFlg",1);
		Long count = (Long) query.uniqueResult();
		return count;
	}
	
	
}
