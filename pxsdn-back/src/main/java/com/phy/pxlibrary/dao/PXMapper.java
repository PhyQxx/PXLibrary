package com.phy.pxlibrary.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface PXMapper {
    /**
     * 登录验证
     */
//    @Select(value = "select * from px_user where (user_name = #{username} and pass_word = #{password}) or (mobile = #{username} and pass_word = #{password})")
    Map<String, Object> verifyLogin(Map<String, Object> parameter);

    /**
     * 注册
     */
    int register(Map<String,Object> param);

    /**
     * 获取博客列表
     */
    List<Map<String,Object>> getBlogList(Map<String,Object> param);

    /**
     * 获取一条博客详情
     */
    Map<String,Object> getBlogContent(Map<String,Object> param);

    /**
     * 修改个人信息
     */
    int modifyPersonalInfo(Object parameter);

    /**
     * 获取我的收藏列表
     */
    List<Map<String, Object>> getMyCollectionList(Map<String, Object> parameter);
}
