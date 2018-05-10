package com.xunyu.sgip.dto;

import java.io.Serializable;

public class SubmitResp extends SGIPCommend implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -2218800872841325746L;

    private Integer Result;

    public Integer getResult() {
        return Result;
    }

    public void setResult(Integer result) {
        Result = result;
    }

}
