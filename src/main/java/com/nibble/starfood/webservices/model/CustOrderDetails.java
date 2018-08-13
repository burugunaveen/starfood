package com.nibble.starfood.webservices.model;
import java.util.List;

public class CustOrderDetails {
	    
	    private List<PackgSave> savePkg;
	    
	    private int customerId;
	    private int cupnId;
	    private int walletAmount;
		private Float subAmnt;
		private Float taxAmnt;
		private float delChrg;
		private float grndTot;
		private float vatTax;
		private float schTax;
		private float serTax;
		private float gstTax;
		private float cupnDiscAmnt;
		private float redeemCancelAmnt;
		//private int paymentGatewayTypId;
		private String transactionId;
		private int payModId;
		private float subGrandTotal;
		private int orderStatusId;
		
		
		
		
		public int getCustomerId() {
			return customerId;
		}
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		
		/*public int getPaymentGatewayTypId() {
			return paymentGatewayTypId;
		}
		public void setPaymentGatewayTypId(int paymentGatewayTypId) {
			this.paymentGatewayTypId = paymentGatewayTypId;
		}*/
		public String getTransactionId() {
			return transactionId;
		}
		public void setTransactionId(String transactionId) {
			this.transactionId = transactionId;
		}
		public int getPayModId() {
			return payModId;
		}
		public void setPayModId(int payModId) {
			this.payModId = payModId;
		}
		public Float getSubAmnt() {
			return subAmnt;
		}
		public void setSubAmnt(Float subAmnt) {
			this.subAmnt = subAmnt;
		}
		public Float getTaxAmnt() {
			return taxAmnt;
		}
		public void setTaxAmnt(Float taxAmnt) {
			this.taxAmnt = taxAmnt;
		}

		public float getDelChrg() {
			return delChrg;
		}
		public void setDelChrg(float delChrg) {
			this.delChrg = delChrg;
		}
		public float getGrndTot() {
			return grndTot;
		}
		public void setGrndTot(float grndTot) {
			this.grndTot = grndTot;
		}
		public float getVatTax() {
			return vatTax;
		}
		public void setVatTax(float vatTax) {
			this.vatTax = vatTax;
		}
		public float getSchTax() {
			return schTax;
		}
		public void setSchTax(float schTax) {
			this.schTax = schTax;
		}
		public float getSerTax() {
			return serTax;
		}
		public void setSerTax(float serTax) {
			this.serTax = serTax;
		}
		public float getGstTax() {
			return gstTax;
		}
		public void setGstTax(float gstTax) {
			this.gstTax = gstTax;
		}
		public float getCupnDiscAmnt() {
			return cupnDiscAmnt;
		}
		public void setCupnDiscAmnt(float cupnDiscAmnt) {
			this.cupnDiscAmnt = cupnDiscAmnt;
		}
		public float getRedeemCancelAmnt() {
			return redeemCancelAmnt;
		}
		public void setRedeemCancelAmnt(float redeemCancelAmnt) {
			this.redeemCancelAmnt = redeemCancelAmnt;
		}
	
		public List<PackgSave> getSavePkg() {
			return savePkg;
		}
		public void setSavePkg(List<PackgSave> savePkg) {
			this.savePkg = savePkg;
		}
		public int getWalletAmount() {
			return walletAmount;
		}
		public void setWalletAmount(int walletAmount) {
			this.walletAmount = walletAmount;
		}
		public int getCupnId() {
			return cupnId;
		}
		public void setCupnId(int cupnId) {
			this.cupnId = cupnId;
		}
		public float getSubGrandTotal() {
			return subGrandTotal;
		}
		public void setSubGrandTotal(float subGrandTotal) {
			this.subGrandTotal = subGrandTotal;
		}
		public int getOrderStatusId() {
			return orderStatusId;
		}
		public void setOrderStatusId(int orderStatusId) {
			this.orderStatusId = orderStatusId;
		}
		
	   
	    
	    

}
