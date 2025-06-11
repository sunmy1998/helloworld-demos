package com.swy.service.impl;


import com.github.yulichang.base.MPJBaseServiceImpl;
import com.swy.entity.UserDO;
import com.swy.mapper.UserMapper;
import com.swy.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author: SMY
 * @time: 2025/6/11  22:33
 * @description:
 */

@Service
public class UserServiceImpl extends MPJBaseServiceImpl<UserMapper, UserDO> implements UserService {
}
