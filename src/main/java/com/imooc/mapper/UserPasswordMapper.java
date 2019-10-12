package com.imooc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imooc.bean.UserPassword;
import org.apache.ibatis.annotations.Select;

public interface UserPasswordMapper extends BaseMapper<UserPassword> {

    @Select("select * from user_password where user_id=#{userId}")
    UserPassword selectByUserId(String userId);

}