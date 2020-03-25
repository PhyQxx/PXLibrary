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

}
