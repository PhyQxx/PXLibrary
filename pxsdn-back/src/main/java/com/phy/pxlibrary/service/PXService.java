package com.phy.pxlibrary.service;

import java.util.List;
import java.util.Map;

public interface PXService {
    /**
     * 登录验证
     */
    Map<String, Object> verifyLogin(Map<String, Object> parameter);

    /**
     * 注册
     */
    Map<String, Object> register(Map<String, Object> parameter);

    /**
     * 获取博客列表
     */
    List<Map<String, Object>> getBlogList(Map<String, Object> parameter);

    /**
     * 获取一条博客详情
     */
    Map<String, Object> getBlogContent(Map<String, Object> parameter);

    /**
     * 修改个人信息
     */
    Map<String, Object> modifyPersonalInfo(Map<String, Object> parameter);

    /**
     * 获取我的收藏列表
     */
    Map<String, Object> getMyCollectionList(Map<String, Object> parameter);

    /**
     * 获取一个收藏夹的列表
     */
    Map<String, Object> getOneCollectionList(Map<String, Object> parameter);

    /**
     * 添加一个收藏夹
     */
    Map<String,Object> addCollection(Map<String,Object> param);

    /**
     * 账号设置：密码，手机，邮箱
     * @param param
     * @return
     */
    Map<String, Object> editor(Map<String, Object> param);

    /**
     * 根据条件查询论坛列表
     * @param param
     * @return
     */
    Map<String, Object> getForumList(Map<String, Object> param);
}
