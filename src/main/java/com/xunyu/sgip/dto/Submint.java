package com.xunyu.sgip.dto;

import java.io.Serializable;
import java.util.List;

public class Submint extends SGIPCommend implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -2599845582007266427L;
    private String SPNumber;//sp的接入号码
    private String ChargeNumber;//付费号码
    private Integer UserCount;//接收短信息的手机数量
    private List<String> UserNumber;//接收短信息的手机号
    private String CorpId;//企业代码
    private String ServiceType;//业务代码
    private Integer FeeType;//计费类型
    private String FeeValue;//取值范围  收费
    private String GivenValuel;//取值范围  送给用户的话费
    private Integer AgentFlag;//代收费标志，0：应收；1：实收
    private Integer MorelatetoMTFlag;
    private Integer Priority;
    private String ExpireTime;
    private String ScheduleTime;
    private String ReportFlag;
    private Integer TP_pid;
    private Integer TP_udhi;
    private Integer MessageCoding;
    private Integer MessageType;
    private Integer MessageLength;
    private String MessageContent;
    private String Reserve;

    public String getSPNumber() {
        return SPNumber;
    }

    public void setSPNumber(String sPNumber) {
        SPNumber = sPNumber;
    }

    public String getChargeNumber() {
        return ChargeNumber;
    }

    public void setChargeNumber(String chargeNumber) {
        ChargeNumber = chargeNumber;
    }

    public Integer getUserCount() {
        return UserCount;
    }

    public void setUserCount(Integer userCount) {
        UserCount = userCount;
    }

    public List<String> getUserNumber() {
        return UserNumber;
    }

    public void setUserNumber(List<String> userNumber) {
        UserNumber = userNumber;
    }

    public String getCorpId() {
        return CorpId;
    }

    public void setCorpId(String corpId) {
        CorpId = corpId;
    }

    public String getServiceType() {
        return ServiceType;
    }

    public void setServiceType(String serviceType) {
        ServiceType = serviceType;
    }

    public Integer getFeeType() {
        return FeeType;
    }

    public void setFeeType(Integer feeType) {
        FeeType = feeType;
    }

    public String getFeeValue() {
        return FeeValue;
    }

    public void setFeeValue(String feeValue) {
        FeeValue = feeValue;
    }

    public String getGivenValuel() {
        return GivenValuel;
    }

    public void setGivenValuel(String givenValuel) {
        GivenValuel = givenValuel;
    }

    public Integer getAgentFlag() {
        return AgentFlag;
    }

    public void setAgentFlag(Integer agentFlag) {
        AgentFlag = agentFlag;
    }

    public Integer getMorelatetoMTFlag() {
        return MorelatetoMTFlag;
    }

    public void setMorelatetoMTFlag(Integer morelatetoMTFlag) {
        MorelatetoMTFlag = morelatetoMTFlag;
    }

    public Integer getPriority() {
        return Priority;
    }

    public void setPriority(Integer priority) {
        Priority = priority;
    }

    public String getExpireTime() {
        return ExpireTime;
    }

    public void setExpireTime(String expireTime) {
        ExpireTime = expireTime;
    }

    public String getScheduleTime() {
        return ScheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        ScheduleTime = scheduleTime;
    }

    public String getReportFlag() {
        return ReportFlag;
    }

    public void setReportFlag(String reportFlag) {
        ReportFlag = reportFlag;
    }

    public Integer getTP_pid() {
        return TP_pid;
    }

    public void setTP_pid(Integer tP_pid) {
        TP_pid = tP_pid;
    }

    public Integer getTP_udhi() {
        return TP_udhi;
    }

    public void setTP_udhi(Integer tP_udhi) {
        TP_udhi = tP_udhi;
    }

    public Integer getMessageCoding() {
        return MessageCoding;
    }

    public void setMessageCoding(Integer messageCoding) {
        MessageCoding = messageCoding;
    }

    public Integer getMessageType() {
        return MessageType;
    }

    public void setMessageType(Integer messageType) {
        MessageType = messageType;
    }

    public Integer getMessageLength() {
        return MessageLength;
    }

    public void setMessageLength(Integer messageLength) {
        MessageLength = messageLength;
    }

    public String getMessageContent() {
        return MessageContent;
    }

    public void setMessageContent(String messageContent) {
        MessageContent = messageContent;
    }

    public String getReserve() {
        return Reserve;
    }

    public void setReserve(String reserve) {
        Reserve = reserve;
    }


}
