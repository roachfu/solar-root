package com.roachfu.solar.client.user.service.impl;

import com.roachfu.solar.client.user.mapper.UserMapper;
import com.roachfu.solar.client.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by roach on 08/08/2017.
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

}
