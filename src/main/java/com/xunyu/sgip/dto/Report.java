package com.xunyu.sgip.dto;

import java.io.Serializable;

public class Report extends SGIPCommend implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -1611906337209622455L;

    private Integer SubmitSequenceNumber;
    private Integer ReportType;
    private String UserNumber;
    private Integer State;
    private Integer ErrorCode;
    private String Reserve;

    public Integer getSubmitSequenceNumber() {
        return SubmitSequenceNumber;
    }

    public void setSubmitSequenceNumber(Integer submitSequenceNumber) {
        SubmitSequenceNumber = submitSequenceNumber;
    }

    public Integer getReportType() {
        return ReportType;
    }

    public void setReportType(Integer reportType) {
        ReportType = reportType;
    }

    public String getUserNumber() {
        return UserNumber;
    }

    public void setUserNumber(String userNumber) {
        UserNumber = userNumber;
    }

    public Integer getState() {
        return State;
    }

    public void setState(Integer state) {
        State = state;
    }

    public Integer getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(Integer errorCode) {
        ErrorCode = errorCode;
    }

    public String getReserve() {
        return Reserve;
    }

    public void setReserve(String reserve) {
        Reserve = reserve;
    }


}
