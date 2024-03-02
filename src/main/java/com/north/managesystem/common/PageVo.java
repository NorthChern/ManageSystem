package com.north.managesystem.common;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * 获取前端传来的分页信息
 */
@Data
public class PageVo {

    //当前页
    @TableField(exist = false)
    private int page;

    //每页
    @TableField(exist = false)
    private int size;
}
