package com.xunyu.sgip.dto;

import java.io.Serializable;

public class BindResp extends SGIPCommend implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 941358578966996557L;

    private Integer Result;//0：执行成功 其他值：错误码
    private String Reserve;//扩展字段
    private byte[] resultByte;

    public byte[] getResultByte() {
        return resultByte;
    }

    public void setResultByte(byte[] resultByte) {
        this.resultByte = resultByte;
    }

    public Integer getResult() {
        return Result;
    }

    public void setResult(Integer result) {
        Result = result;
    }

    public String getReserve() {
        return Reserve;
    }

    public void setReserve(String reserve) {
        Reserve = reserve;
    }


}
