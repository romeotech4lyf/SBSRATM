package com.tech4lyf.SBSRATM.Models;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

@SuppressLint("ParcelCreator")
public class DMT implements Serializable, Parcelable {

    private String bcid;
    private String kioskid;
    private String trans_date;
    private String trans_time;
    private String SD;
    private String AP;
    private String OP;
    private String SessionNo;
    private String RemitterID;
    private String BeneficiaryID;
    private String RoutingType;
    private String charged_amt;
    private String locked_amt;
    private String TransferStatus;
    private String ipay_id;
    private String ref_no;
    private String opr_id;
    private String name;
    private String RemitterPhone;
    private String BeneficiaryPhone;

    public DMT(String bcid, String kioskid, String trans_date, String trans_time, String SD, String AP, String OP, String sessionNo, String remitterID, String beneficiaryID, String routingType, String charged_amt, String locked_amt, String transferStatus, String ipay_id, String ref_no, String opr_id, String name, String remitterPhone, String beneficiaryPhone) {
        this.bcid = bcid;
        this.kioskid = kioskid;
        this.trans_date = trans_date;
        this.trans_time = trans_time;
        this.SD = SD;
        this.AP = AP;
        this.OP = OP;
        SessionNo = sessionNo;
        RemitterID = remitterID;
        BeneficiaryID = beneficiaryID;
        RoutingType = routingType;
        this.charged_amt = charged_amt;
        this.locked_amt = locked_amt;
        TransferStatus = transferStatus;
        this.ipay_id = ipay_id;
        this.ref_no = ref_no;
        this.opr_id = opr_id;
        this.name = name;
        RemitterPhone = remitterPhone;
        BeneficiaryPhone = beneficiaryPhone;
    }

    public DMT() {
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

    public String getSD() {
        return SD;
    }

    public void setSD(String SD) {
        this.SD = SD;
    }

    public String getAP() {
        return AP;
    }

    public void setAP(String AP) {
        this.AP = AP;
    }

    public String getOP() {
        return OP;
    }

    public void setOP(String OP) {
        this.OP = OP;
    }

    public String getSessionNo() {
        return SessionNo;
    }

    public void setSessionNo(String sessionNo) {
        SessionNo = sessionNo;
    }

    public String getRemitterID() {
        return RemitterID;
    }

    public void setRemitterID(String remitterID) {
        RemitterID = remitterID;
    }

    public String getBeneficiaryID() {
        return BeneficiaryID;
    }

    public void setBeneficiaryID(String beneficiaryID) {
        BeneficiaryID = beneficiaryID;
    }

    public String getRoutingType() {
        return RoutingType;
    }

    public void setRoutingType(String routingType) {
        RoutingType = routingType;
    }

    public String getCharged_amt() {
        return charged_amt;
    }

    public void setCharged_amt(String charged_amt) {
        this.charged_amt = charged_amt;
    }

    public String getLocked_amt() {
        return locked_amt;
    }

    public void setLocked_amt(String locked_amt) {
        this.locked_amt = locked_amt;
    }

    public String getTransferStatus() {
        return TransferStatus;
    }

    public void setTransferStatus(String transferStatus) {
        TransferStatus = transferStatus;
    }

    public String getIpay_id() {
        return ipay_id;
    }

    public void setIpay_id(String ipay_id) {
        this.ipay_id = ipay_id;
    }

    public String getRef_no() {
        return ref_no;
    }

    public void setRef_no(String ref_no) {
        this.ref_no = ref_no;
    }

    public String getOpr_id() {
        return opr_id;
    }

    public void setOpr_id(String opr_id) {
        this.opr_id = opr_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemitterPhone() {
        return RemitterPhone;
    }

    public void setRemitterPhone(String remitterPhone) {
        RemitterPhone = remitterPhone;
    }

    public String getBeneficiaryPhone() {
        return BeneficiaryPhone;
    }

    public void setBeneficiaryPhone(String beneficiaryPhone) {
        BeneficiaryPhone = beneficiaryPhone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }


}
