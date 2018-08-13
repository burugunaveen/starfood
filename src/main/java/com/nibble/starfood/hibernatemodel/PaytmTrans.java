package com.nibble.starfood.hibernatemodel;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "paytm_tranx")
@org.hibernate.annotations.Entity(dynamicUpdate=true)

public class PaytmTrans {
    private int paytmId;
    private String subscribtionId;
    private String merchantId;
    private String transcationId;
    private String applicationId;
    private String bankTranscationId;
    private String amount;
    private String currency;
    private String status;
    private String respcode;
    private String respMsg;
    private String transDate;
    private String gateWayName;
    private String bankName;
    private String paymentMode;
    private String promoId;
    private String promoStatus;
    private String promoResponse;
    private String Checksum;
    private Date crtTs;
    private Date updTs;
    private String crtId;
    private String updId;

    @Column(name = "amount")
    public String getAmount() {
	return amount;
    }

    @Column(name = "order_id")
    public String getApplicationId() {
	return applicationId;
    }

    @Column(name = "bank_n")
    public String getBankName() {
	return bankName;
    }

    @Column(name = "bank_trans_id")
    public String getBankTranscationId() {
	return bankTranscationId;
    }

    @Column(name = "checksum")
    public String getChecksum() {
	return Checksum;
    }

    @Column(name = "crt_id", nullable = false, length = 100)
    public String getCrtId() {
	return crtId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "crt_ts", nullable = false, length = 0)
    public Date getCrtTs() {
	return crtTs;
    }

    @Column(name = "cur")
    public String getCurrency() {
	return currency;
    }

    @Column(name = "gate_way_n")
    public String getGateWayName() {
	return gateWayName;
    }

    @Column(name = "mid")
    public String getMerchantId() {
	return merchantId;
    }

    @Column(name = "payment_mode")
    public String getPaymentMode() {
	return paymentMode;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "paytm_tranx_id", unique = true, nullable = false)
    public int getPaytmId() {
	return paytmId;
    }

    @Column(name = "promo_camp_id")
    public String getPromoId() {
	return promoId;
    }

    @Column(name = "promo_resp_code")
    public String getPromoResponse() {
	return promoResponse;
    }

    @Column(name = "promo_st")
    public String getPromoStatus() {
	return promoStatus;
    }

    @Column(name = "resp_code")
    public String getRespcode() {
	return respcode;
    }

    @Column(name = "resp_msg")
    public String getRespMsg() {
	return respMsg;
    }

    @Column(name = "st")
    public String getStatus() {
	return status;
    }

    @Column(name = "subs_id")
    public String getSubscribtionId() {
	return subscribtionId;
    }

    @Column(name = "txn_id")
    public String getTranscationId() {
	return transcationId;
    }

    @Column(name = "tranx_ts")
    public String getTransDate() {
	return transDate;
    }

    @Column(name = "upd_id", nullable = false, length = 100)
    public String getUpdId() {
	return updId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "upd_ts", nullable = false, length = 0)
    public Date getUpdTs() {
	return updTs;
    }

    public void setAmount(String amount) {
	this.amount = amount;
    }

    public void setApplicationId(String applicationId) {
	this.applicationId = applicationId;
    }

    public void setBankName(String bankName) {
	this.bankName = bankName;
    }

    public void setBankTranscationId(String bankTranscationId) {
	this.bankTranscationId = bankTranscationId;
    }

    public void setChecksum(String checksum) {
	Checksum = checksum;
    }

    public void setCrtId(String crtId) {
	this.crtId = crtId;
    }

    public void setCrtTs(Date crtTs) {
	this.crtTs = crtTs;
    }

    public void setCurrency(String currency) {
	this.currency = currency;
    }

    public void setGateWayName(String gateWayName) {
	this.gateWayName = gateWayName;
    }

    public void setMerchantId(String merchantId) {
	this.merchantId = merchantId;
    }

    public void setPaymentMode(String paymentMode) {
	this.paymentMode = paymentMode;
    }

    public void setPaytmId(int paytmId) {
	this.paytmId = paytmId;
    }

    public void setPromoId(String promoId) {
	this.promoId = promoId;
    }

    public void setPromoResponse(String promoResponse) {
	this.promoResponse = promoResponse;
    }

    public void setPromoStatus(String promoStatus) {
	this.promoStatus = promoStatus;
    }

    public void setRespcode(String respcode) {
	this.respcode = respcode;
    }

    public void setRespMsg(String respMsg) {
	this.respMsg = respMsg;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public void setSubscribtionId(String subscribtionId) {
	this.subscribtionId = subscribtionId;
    }

    public void setTranscationId(String transcationId) {
	this.transcationId = transcationId;
    }

    public void setTransDate(String tXNDATE) {
	transDate = tXNDATE;
    }

    public void setUpdId(String updId) {
	this.updId = updId;
    }

    public void setUpdTs(Date updTs) {
	this.updTs = updTs;
    }

}
