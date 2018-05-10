package com.xunyu.sgip.dto;

import java.io.Serializable;

public class ReportResp extends SGIPCommend implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8395224090508233734L;

    private Integer Result;

    public Integer getResult() {
        return Result;
    }

    public void setResult(Integer result) {
        Result = result;
    }


}
