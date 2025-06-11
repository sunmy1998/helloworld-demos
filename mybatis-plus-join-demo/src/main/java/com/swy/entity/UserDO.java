package com.swy.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.swy.enums.Sex;
import lombok.Data;
import lombok.ToString;

/**
 * @author: SMY
 * @time: 2025/6/11  22:27
 * @description:
 */

@Data
@ToString
@TableName("`user`")
public class UserDO {

    @TableId
    private Integer id;

    private String name;

    private Sex sex;

    private String headImg;

    private Integer addressId;

    @TableLogic
    private Boolean del;
}