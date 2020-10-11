package com.tech4lyf.SBSRATM.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Mswipe implements Parcelable, Serializable {
    private String trans_date;
    private String trans_time;
    private String SessionNo;
    private String DeviceId;
    private String MobileNo;
    private String Amount;
    private String TransactionStatus;
    private String AuthCode;
    private String RRNo;
    private String MID;
    private String TID;
    private String TransactionDate;
    private String cardHolderName;
    private String cardFirstSixDigits;
    private String expiryDate;
    private String maskedPAN;
    private String bcid;
    private String kioskid;

    public Mswipe(String trans_date, String trans_time, String sessionNo, String deviceId, String mobileNo, String amount, String transactionStatus, String authCode, String RRNo, String MID, String TID, String transactionDate, String cardHolderName, String cardFirstSixDigits, String expiryDate, String maskedPAN, String bcid, String kioskid) {
        this.trans_date = trans_date;
        this.trans_time = trans_time;
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
        this.bcid = bcid;
        this.kioskid = kioskid;
    }

    public Mswipe() {
    }

    protected Mswipe(Parcel in) {
        trans_date = in.readString();
        trans_time = in.readString();
        SessionNo = in.readString();
        DeviceId = in.readString();
        MobileNo = in.readString();
        Amount = in.readString();
        TransactionStatus = in.readString();
        AuthCode = in.readString();
        RRNo = in.readString();
        MID = in.readString();
        TID = in.readString();
        TransactionDate = in.readString();
        cardHolderName = in.readString();
        cardFirstSixDigits = in.readString();
        expiryDate = in.readString();
        maskedPAN = in.readString();
        bcid = in.readString();
        kioskid = in.readString();
    }

    public static final Creator<Mswipe> CREATOR = new Creator<Mswipe>() {
        @Override
        public Mswipe createFromParcel(Parcel in) {
            return new Mswipe(in);
        }

        @Override
        public Mswipe[] newArray(int size) {
            return new Mswipe[size];
        }
    };

    public String getTrans_date() {
        return trans_date;
    }

    public void setTrans_date(String trans_date) {
        this.trans_date = trans_date;
    }

    public String getTrans_time() {
        return trans_time;
    }

    public void setTrans_time(String trans_time) {
        this.trans_time = trans_time;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(trans_date);
        parcel.writeString(trans_time);
        parcel.writeString(SessionNo);
        parcel.writeString(DeviceId);
        parcel.writeString(MobileNo);
        parcel.writeString(Amount);
        parcel.writeString(TransactionStatus);
        parcel.writeString(AuthCode);
        parcel.writeString(RRNo);
        parcel.writeString(MID);
        parcel.writeString(TID);
        parcel.writeString(TransactionDate);
        parcel.writeString(cardHolderName);
        parcel.writeString(cardFirstSixDigits);
        parcel.writeString(expiryDate);
        parcel.writeString(maskedPAN);
        parcel.writeString(bcid);
        parcel.writeString(kioskid);
    }
}

