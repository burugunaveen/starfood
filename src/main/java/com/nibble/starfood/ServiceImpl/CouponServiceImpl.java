package com.nibble.starfood.ServiceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nibble.starfood.DAOI.CouponDAO;
import com.nibble.starfood.ServiceI.CouponService;
import com.nibble.starfood.hibernatemodel.Cupn;
import com.nibble.starfood.webservices.model.ApplyCoupon;

@Service
@Transactional
public class CouponServiceImpl implements CouponService {

	@Autowired
	CouponDAO cust;
	
	@Override
	public List<Cupn> getCouponCodeDetails(ApplyCoupon cupn) {
		
		return cust.getCouponCodeDetails(cupn);
	}

	@Override
	public Cupn getValidCoupons(Cupn cupndet, Date todayDate) {
		
		return cust.getValidCoupons(cupndet, todayDate);
	}

	@Override
	public Long getCouponUsedCount(int couponId, ApplyCoupon cupn) {
		
		return cust.getCouponUsedCount(couponId, cupn);
		
	}
	
	
}
