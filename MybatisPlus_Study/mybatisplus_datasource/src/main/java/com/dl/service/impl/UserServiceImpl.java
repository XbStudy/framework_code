package com.dl.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dl.mapper.UserMapper;
import com.dl.pojo.User;
import com.dl.service.UserService;
import org.springframework.stereotype.Service;

@DS("master")  // 指定所操作的数据源
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
