package com.phy.pxlibrary.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author 裴浩宇
 */
@Mapper
public interface PXMapper {
    /**
     * 登录验证
     */
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

    /**
     * 获取一个收藏夹文章数量
     *
     */
    int countOneCollection(String param);

    /**
     * 获取一个收藏夹的列表
     */
    List<Map<String, Object>> getOneCollectionList(Map<String, Object> parameter);

    /**
     * 添加一个收藏夹
     * @param param
     * @return
     */
    int addCollection(Map<String, Object> param);

    /**
     * 账号设置：密码，手机，邮箱
     * @param param
     * @return
     */
    int editor(Map<String, Object> param);

    /**
     * 根据条件查询论坛列表
     * @param param
     * @return
     */
    List<Map<String,Object>> getForumList(Map<String,Object> param);
}
