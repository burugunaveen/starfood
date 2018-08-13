package com.nibble.starfood.webservices.model;

import java.util.List;



public class PackgSave {
	 	//private int customerId;
	    private List<orderDatesDet>  orderdates;
	    private int mealTimeId;
	    private int weekDur;
	    private int foodTypId;
	    private int pkgId;
	    private int pkgDurId;
	    private int menuTypeId;
	    private int weektyp;
	    private Integer addressId;
	    private float packageAmount;
		private String ordStDt;
		private String ordEndDt;
		private int pkgQunty;
		private byte payModId;
		private int mealTypeId;
		
		
		
		//private int mealType;
		
		
		
		/*public int getCustomerId() {
			return customerId;
		}
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}*/
		
		public List<orderDatesDet> getOrderdates() {
			return orderdates;
		}
		public void setOrderdates(List<orderDatesDet> orderdates) {
			this.orderdates = orderdates;
		}
		public float getPackageAmount() {
			return packageAmount;
		}
		public void setPackageAmount(float packageAmount) {
			this.packageAmount = packageAmount;
		}
		
		public int getMealTimeId() {
			return mealTimeId;
		}
		public void setMealTimeId(int mealTimeId) {
			this.mealTimeId = mealTimeId;
		}
		public int getWeekDur() {
			return weekDur;
		}
		public void setWeekDur(int weekDur) {
			this.weekDur = weekDur;
		}
		public int getFoodTypId() {
			return foodTypId;
		}
		public void setFoodTypId(int foodTypId) {
			this.foodTypId = foodTypId;
		}
		public int getPkgId() {
			return pkgId;
		}
		public void setPkgId(int pkgId) {
			this.pkgId = pkgId;
		}
		public int getPkgDurId() {
			return pkgDurId;
		}
		public void setPkgDurId(int pkgDurId) {
			this.pkgDurId = pkgDurId;
		}
	/*	public int getMenuType() {
			return menuType;
		}
		public void setMenuType(int menuType) {
			this.menuType = menuType;
		}*/
		
		public Integer getAddressId() {
			return addressId;
		}
		public void setAddressId(Integer addressId) {
			this.addressId = addressId;
		}
		public String getOrdStDt() {
			return ordStDt;
		}
		public void setOrdStDt(String ordStDt) {
			this.ordStDt = ordStDt;
		}
		public String getOrdEndDt() {
			return ordEndDt;
		}
		public void setOrdEndDt(String ordEndDt) {
			this.ordEndDt = ordEndDt;
		}
		public int getPkgQunty() {
			return pkgQunty;
		}
		public void setPkgQunty(int pkgQunty) {
			this.pkgQunty = pkgQunty;
		}

		public byte getPayModId() {
			return payModId;
		}
		public void setPayModId(byte payModId) {
			this.payModId = payModId;
		}
		public int getWeektyp() {
			return weektyp;
		}
		public void setWeektyp(int weektyp) {
			this.weektyp = weektyp;
		}
		/*public int getMealType() {
			return mealType;
		}
		public void setMealType(int mealType) {
			this.mealType = mealType;
		}*/
		public int getMenuTypeId() {
			return menuTypeId;
		}
		public void setMenuTypeId(int menuTypeId) {
			this.menuTypeId = menuTypeId;
		}
		public int getMealTypeId() {
			return mealTypeId;
		}
		public void setMealTypeId(int mealTypeId) {
			this.mealTypeId = mealTypeId;
		}
		
		
		
}
