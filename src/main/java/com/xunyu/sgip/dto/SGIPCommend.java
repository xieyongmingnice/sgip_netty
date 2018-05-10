package com.xunyu.sgip.dto;

import com.xunyu.sgip.utils.SGIPSeq;
import com.xunyu.sgip.utils.SGIPUtils;

import java.io.Serializable;
import java.math.BigInteger;

public class SGIPCommend implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2588404542651932371L;

    public static Integer MessageLength = 41;//消息总长度
    private Integer CommandID;//命令ID
    private String SequenceNumber;//完整序列号
    private Integer nodeId;//序列号第一部分
    private String commandGenerateDate;//序列号第二部分（时间戳）
    private Integer commandNumber;//序列号第三部分
    private Integer commandNodeIdDate;//序列号第二部分（时间戳）
    //----Integer类型对应的字节变量begin----
    //private byte[] commandIDType;//
    private byte[] nodeIdByte;
    private byte[] commandNodeIdDateByte;
    private byte[] commandNumberByte;
    private byte[] MessageLengthByte;
    //----Integer类型对应的字节变量end----


    public byte[] getNodeIdByte() {
        return nodeIdByte;
    }

    public byte[] getMessageLengthByte() {
        return MessageLengthByte;
    }

    public void setMessageLengthByte(byte[] messageLengthByte) {
        MessageLengthByte = messageLengthByte;
    }

    public Integer getMessageLength() {
        return MessageLength;
    }

    public void setMessageLength(Integer messageLength) {
        MessageLength = messageLength;
    }

    public void setCommandNodeIdDate(Integer commandNodeIdDate) {
        this.commandNodeIdDate = commandNodeIdDate;
    }

    public void setNodeIdByte(byte[] nodeIdByte) {
        this.nodeIdByte = nodeIdByte;
    }

    public byte[] getCommandNodeIdDateByte() {
        return commandNodeIdDateByte;
    }

    public void setCommandNodeIdDateByte(byte[] commandNodeIdDateByte) {
        this.commandNodeIdDateByte = commandNodeIdDateByte;
    }

    public byte[] getCommandNumberByte() {
        return commandNumberByte;
    }

    public void setCommandNumberByte(byte[] commandNumberByte) {
        this.commandNumberByte = commandNumberByte;
    }

    public SGIPCommend() {
        //初始化序列号
        generateSequenceNumber();
    }

    public Integer getCommandNumber() {
        return commandNumber;
    }

    public void setCommandNumber(Integer commandNumber) {
        this.commandNumber = commandNumber;
    }

    public Integer getCommandNodeIdDate() {
        commandNodeIdDate = new BigInteger(this.commandGenerateDate).intValue();
        return commandNodeIdDate;
    }

    public Integer getCommandID() {
        return CommandID;
    }

    public void setCommandID(Integer commandID) {
        CommandID = commandID;
    }

    private void generateDate() {
        this.commandGenerateDate = String.valueOf(SGIPUtils.getCurrentDate());
    }

    private void generateSeq() {
        this.commandNumber = SGIPSeq.getSeq();
    }


    public String getSequenceNumber() {
        return SequenceNumber;
    }

    public void setSequenceNumber(String sequenceNumber) {
        SequenceNumber = sequenceNumber;
    }

    public Integer getNodeId() {

        return new BigInteger(SGIPUtils.NODEID).intValue();
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * 产生命令序列号
     */
    private void generateSequenceNumber() {
        generateDate();
        generateSeq();
        StringBuffer strBuff = new StringBuffer();

        strBuff.append(SGIPUtils.NODEID).append(this.commandGenerateDate).append(this.commandNumber);
        //this.SequenceNumber = new BigInteger(strBuff.toString()).intValue();
        this.SequenceNumber = strBuff.toString();
    }

    public static final int SGIP_BIND = 0x1;
    public static final int SGIP_BIND_RESP = 0x80000001;
    public static final int SGIP_UNBIND = 0x2;
    public static final int SGIP_UNBIND_RESP = 0x80000002;
    public static final int SGIP_SUBMIT = 0x3;
    public static final int SGIP_SUBMIT_RESP = 0x80000003;
    public static final int SGIP_DELIVER = 0x4;
    public static final int SGIP_DELIVER_RESP = 0x80000004;
    public static final int SGIP_REPORT = 0x5;
    public static final int SGIP_REPORT_RESP = 0x80000005;
    public static final int SGIP_USERRPT = 0x11;
    public static final int SGIP_USERRPT_RESP = 0x80000011;
    public static final int SGIP_TRACE = 0x1000;
    public static final int SGIP_TRACE_RESP = 0x80001000;


}
