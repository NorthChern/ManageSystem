package com.north.managesystem.common;

import lombok.Data;

@Data
public class CommonDto<T> {

    //成功与否，默认为true
    private Boolean success = true;

    //返回信息
    private String message;

    //返回数据
    private T content;
}
