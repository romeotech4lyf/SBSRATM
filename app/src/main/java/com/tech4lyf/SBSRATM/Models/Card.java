package com.tech4lyf.SBSRATM.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Card implements Serializable, Parcelable {

    public String SessionNo;
    public String DeviceId;
    public String MobileNo;
    public String Amount;
    public String TransactionStatus;
    public String AuthCode;
    public String RRNo;
    public String MID;
    public String TID;
    public String TransactionDate;
    public String cardHolderName;
    public String cardFirstSixDigits;
    public String expiryDate;
    public String maskedPAN;

    public Card() {
    }

    public Card(String sessionNo, String deviceId, String mobileNo, String amount, String transactionStatus, String authCode, String RRNo, String MID, String TID, String transactionDate, String cardHolderName, String cardFirstSixDigits, String expiryDate, String maskedPAN) {
        SessionNo = sessionNo;
        DeviceId = deviceId;
        MobileNo = mobileNo;
        Amount = amount;
        TransactionStatus = transactionStatus;
        AuthCode = authCode;
        this.RRNo = RRNo;
        this.MID = MID;
        this.TID = TID;
        TransactionDate = transactionDate;
        this.cardHolderName = cardHolderName;
        this.cardFirstSixDigits = cardFirstSixDigits;
        this.expiryDate = expiryDate;
        this.maskedPAN = maskedPAN;
    }

    public String getSessionNo() {
        return SessionNo;
    }

    public void setSessionNo(String sessionNo) {
        SessionNo = sessionNo;
    }

    public String getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(String deviceId) {
        DeviceId = deviceId;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getTransactionStatus() {
        return TransactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        TransactionStatus = transactionStatus;
    }

    public String getAuthCode() {
        return AuthCode;
    }

    public void setAuthCode(String authCode) {
        AuthCode = authCode;
    }

    public String getRRNo() {
        return RRNo;
    }

    public void setRRNo(String RRNo) {
        this.RRNo = RRNo;
    }

    public String getMID() {
        return MID;
    }

    public void setMID(String MID) {
        this.MID = MID;
    }

    public String getTID() {
        return TID;
    }

    public void setTID(String TID) {
        this.TID = TID;
    }

    public String getTransactionDate() {
        return TransactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        TransactionDate = transactionDate;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardFirstSixDigits() {
        return cardFirstSixDigits;
    }

    public void setCardFirstSixDigits(String cardFirstSixDigits) {
        this.cardFirstSixDigits = cardFirstSixDigits;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getMaskedPAN() {
        return maskedPAN;
    }

    public void setMaskedPAN(String maskedPAN) {
        this.maskedPAN = maskedPAN;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
