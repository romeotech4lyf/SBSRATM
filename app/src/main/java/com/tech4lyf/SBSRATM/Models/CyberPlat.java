package com.tech4lyf.SBSRATM.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class CyberPlat implements Serializable, Parcelable {
    public String SD;
    public String AP;
    public String OP;
    public String SessionNo;
    public String RemitterID;
    public String BeneficiaryID;
    public String RoutingType;
    public String amount;
    public String charged_amt;
    public String locked_amt;
    public String TransferStatus;
    public String ipay_id;
    public String ref_no;
    public String opr_id;
    public String name;
    public String RemitterPhone;
    public String BeneficiaryPhone;
    public String trans_date;

    public String getTrans_date() {
        return trans_date;
    }

    public void setTrans_date(String trans_date) {
        this.trans_date = trans_date;
    }

    public CyberPlat(String SD, String AP, String OP, String sessionNo, String remitterID, String beneficiaryID, String routingType, String amount, String charged_amt, String locked_amt, String transferStatus, String ipay_id, String ref_no, String opr_id, String name, String RemitterPhone, String BeneficiaryPhone, String trans_date) {
        this.SD = SD;
        this.AP = AP;
        this.OP = OP;
        SessionNo = sessionNo;
        RemitterID = remitterID;
        BeneficiaryID = beneficiaryID;
        RoutingType = routingType;
        this.amount = amount;
        this.charged_amt = charged_amt;
        this.locked_amt = locked_amt;
        this.trans_date = trans_date;
        TransferStatus = transferStatus;
        this.ipay_id = ipay_id;
        this.ref_no = ref_no;
        this.opr_id = opr_id;
        this.name = name;
        this.RemitterPhone = RemitterPhone;
        this.BeneficiaryPhone = BeneficiaryPhone;
    }

    public CyberPlat() {
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
