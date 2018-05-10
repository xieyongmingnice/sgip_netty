package com.xunyu.sgip.dto;

import java.io.Serializable;

public class Deliver extends SGIPCommend implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4668547048815910421L;

    private String UserNumber;//发送短信的用户手机号
    private String SPNumber;//sp的接入号码
    private Integer TP_pid;
    private Integer TP_udhi;
    private Integer MessageCoding;
    private Integer MessageLength;
    private String MessageContent;
    private String Reserve;

    public String getUserNumber() {
        return UserNumber;
    }

    public void setUserNumber(String userNumber) {
        UserNumber = userNumber;
    }

    public String getSPNumber() {
        return SPNumber;
    }

    public void setSPNumber(String sPNumber) {
        SPNumber = sPNumber;
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
