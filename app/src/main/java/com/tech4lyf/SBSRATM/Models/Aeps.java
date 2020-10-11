package com.tech4lyf.SBSRATM.Models;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

@SuppressLint("ParcelCreator")
public class Aeps implements Serializable, Parcelable {
    private String transdate;
    private String transtime;
    private String bcid;
    private String kioskid;
    private String serviceProviderId;
    private String totalAmount;
    private String amount;
    private String retailerId;
    private String transactionId;
    private String transactionType;
    private String allowed;
    private String OperatorTransID;
    private String DealerTransI;
    private String DateTime;
    private String ErrorDesc;
    private String ErrorCode;
    private String errorForAgent;
    private String status;
    private String flag;

    public Aeps() {
    }

    public Aeps(String transdate, String transtime, String bcid, String kioskid, String serviceProviderId, String totalAmount, String amount, String retailerId, String transactionId, String transactionType, String allowed, String operatorTransID, String dealerTransI, String dateTime, String errorDesc, String errorCode, String errorForAgent, String status, String flag) {
        this.transdate = transdate;
        this.transtime = transtime;
        this.bcid = bcid;
        this.kioskid = kioskid;
        this.serviceProviderId = serviceProviderId;
        this.totalAmount = totalAmount;
        this.amount = amount;
        this.retailerId = retailerId;
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.allowed = allowed;
        OperatorTransID = operatorTransID;
        DealerTransI = dealerTransI;
        DateTime = dateTime;
        ErrorDesc = errorDesc;
        ErrorCode = errorCode;
        this.errorForAgent = errorForAgent;
        this.status = status;
        this.flag = flag;
    }

    public String getTransdate() {
        return transdate;
    }

    public void setTransdate(String transdate) {
        this.transdate = transdate;
    }

    public String getTranstime() {
        return transtime;
    }

    public void setTranstime(String transtime) {
        this.transtime = transtime;
    }

    public String getBcid() {
        return bcid;
    }

    public void setBcid(String bcid) {
        this.bcid = bcid;
    }

    public String getKioskid() {
        return kioskid;
    }

    public void setKioskid(String kioskid) {
        this.kioskid = kioskid;
    }

    public String getServiceProviderId() {
        return serviceProviderId;
    }

    public void setServiceProviderId(String serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(String retailerId) {
        this.retailerId = retailerId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getAllowed() {
        return allowed;
    }

    public void setAllowed(String allowed) {
        this.allowed = allowed;
    }

    public String getOperatorTransID() {
        return OperatorTransID;
    }

    public void setOperatorTransID(String operatorTransID) {
        OperatorTransID = operatorTransID;
    }

    public String getDealerTransI() {
        return DealerTransI;
    }

    public void setDealerTransI(String dealerTransI) {
        DealerTransI = dealerTransI;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public String getErrorDesc() {
        return ErrorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        ErrorDesc = errorDesc;
    }

    public String getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(String errorCode) {
        ErrorCode = errorCode;
    }

    public String getErrorForAgent() {
        return errorForAgent;
    }

    public void setErrorForAgent(String errorForAgent) {
        this.errorForAgent = errorForAgent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
