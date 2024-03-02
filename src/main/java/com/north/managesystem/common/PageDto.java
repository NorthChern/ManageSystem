package com.north.managesystem.common;

import lombok.Data;

import java.util.List;

/**
 * 往前端发送数据的dto
 * @param <T>
 */
@Data
public class PageDto<T> {

    //总数
    private Long total;

    //数据
    private List<T> list;
}
