package com.north.managesystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.north.managesystem.pojo.User;

import java.util.List;

public interface UserService extends IService<User> {
    List getList(User user);
}
