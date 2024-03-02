package com.north.managesystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.north.managesystem.common.PageVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
public class User extends PageVo {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    //姓名
    private String username;

    //年龄
    private int age;

    //性别
    private String gender;

    //电话
    private String phone;

    //身份证
    @TableField("IDNumber")
    private String IDNumber;

    @TableField("joinDate")
    //入职日期
    private Date joinDate;

    //邮件
    private String email;

    //密码
    private String password;

    //头像
    private String avatar;

}
