package com.phy.pxlibrary.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface PXMapper {
    /**
     * 登录验证
     */
    @Select(value = "select * from px_user where (user_name = #{username} and pass_word = #{password}) or (mobile = #{username} and pass_word = #{password})")
    Map<String, Object> verifyLogin(Map<String, Object> parameter);
}
