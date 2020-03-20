package com.phy.pxlibrary.service;

import java.util.Map;

public interface PXService {
    /**
     * 登录验证
     */
    Map<String, Object> verifyLogin(Map<String, Object> parameter);

}
