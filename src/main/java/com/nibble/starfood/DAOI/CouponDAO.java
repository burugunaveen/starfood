package com.nibble.starfood.DAOI;

import java.util.Date;
import java.util.List;

import com.nibble.starfood.hibernatemodel.Cupn;
import com.nibble.starfood.webservices.model.ApplyCoupon;

public interface CouponDAO {

	public List<Cupn> getCouponCodeDetails(ApplyCoupon cupn);
	
	public Cupn getValidCoupons(Cupn cupndet, Date todayDate);

	public Long getCouponUsedCount(int couponId,ApplyCoupon cupn);
}
