package com.swy.mapper;


import com.github.yulichang.base.MPJBaseMapper;
import com.swy.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: SMY
 * @time: 2025/6/11  22:30
 * @description:
 */

@Mapper
public interface UserMapper extends MPJBaseMapper<UserDO> {
}
