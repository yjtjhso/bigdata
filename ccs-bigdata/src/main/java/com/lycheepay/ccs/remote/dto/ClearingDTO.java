package com.lycheepay.ccs.remote.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/11/1.
 */
public class ClearingDTO implements Serializable{
    private OptType optType;
    private Date clearingDate;
    private String accIdType;
    private String accId;
    private List<Integer> clearingStatus;
    private ClearingType clearingType;

    public OptType getOptType() {
        return optType;
    }

    public void setOptType(OptType optType) {
        this.optType = optType;
    }

    public Date getClearingDate() {
        return clearingDate;
    }

    public void setClearingDate(Date clearingDate) {
        this.clearingDate = clearingDate;
    }

    public String getAccIdType() {
        return accIdType;
    }

    public void setAccIdType(String accIdType) {
        this.accIdType = accIdType;
    }

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId;
    }

    public List<Integer> getClearingStatus() {
        return clearingStatus;
    }

    public void setClearingStatus(List<Integer> clearingStatus) {
        this.clearingStatus = clearingStatus;
    }

    public ClearingType getClearingType() {
        return clearingType;
    }

    public void setClearingType(ClearingType clearingType) {
        this.clearingType = clearingType;
    }

    @Override
    public String toString() {
        return "ClearingDTO{" +
                "optType=" + optType +
                ", clearingDate=" + clearingDate +
                ", accIdType='" + accIdType + '\'' +
                ", accId='" + accId + '\'' +
                ", clearingStatus=" + clearingStatus +
                ", clearingType=" + clearingType +
                '}';
    }
    public enum OptType {
        SYNC_TRADE_RECORD, CLEARING, RECLEARING, GENSETTLEMENT
    }
    public enum ClearingType{
        AUTO(1), AFTER_RECON(2), ALL(null);
        private Integer type;
        ClearingType(Integer type){
            this.type=type;
        }
        public Integer getCode(){
            return type;
        }
    }
}
