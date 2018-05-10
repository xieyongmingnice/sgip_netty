package com.xunyu.sgip.dto;

import java.io.Serializable;

public class DeliverResp extends SGIPCommend implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -9163204868353149347L;

    private Integer Result;

    public Integer getResult() {
        return Result;
    }

    public void setResult(Integer result) {
        Result = result;
    }

}
