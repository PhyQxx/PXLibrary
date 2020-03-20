package com.phy.pxlibrary.service.impl;

import com.phy.pxlibrary.dao.PXMapper;
import com.phy.pxlibrary.service.PXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PXServiceImpl implements PXService {

    @Autowired
    PXMapper pxMapper;

    @Override
    public Map<String, Object> verifyLogin(Map<String, Object> parameter) {
        Map<String, Object> result = new HashMap<>();
        result = pxMapper.verifyLogin(parameter);
        return result;
    }
}
