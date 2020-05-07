package com.phy.pxlibrary.service.impl;

import com.phy.pxlibrary.dao.PXMapper;
import com.phy.pxlibrary.service.PXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    @Override
    public Map<String, Object> register(Map<String, Object> parameter) {
        Map<String, Object> result = new HashMap<>();
        int res = 0;
        try {
            res = pxMapper.register(parameter);
        } catch (Exception e) {
            e.printStackTrace();
            res = 0;
        }
        result.put("data",res);
        result.put("success",true);
        return result;
    }

    @Override
    public List<Map<String, Object>> getBlogList(Map<String, Object> parameter) {
        List<Map<String, Object>> res = pxMapper.getBlogList(parameter);
        return res;
    }

    @Override
    public Map<String, Object> getBlogContent(Map<String, Object> parameter) {
        Map<String, Object> res = pxMapper.getBlogContent(parameter);
        return res;
    }

    @Override
    public Map<String, Object> modifyPersonalInfo(Map<String, Object> parameter) {
        Map<String, Object> result = new HashMap<>();
        int res = 0;
        try {
            res = pxMapper.modifyPersonalInfo(parameter.get("userInfo"));
        } catch (Exception e) {
            e.printStackTrace();
            res = 2;
        }
        result.put("data",res);
        result.put("success",true);
        return result;
    }

    @Override
    public Map<String, Object> getMyCollectionList(Map<String, Object> param) {
        Map<String,Object> result = new HashMap<>();
        List<Map<String,Object>> res = pxMapper.getMyCollectionList(param);
        for (int i = 0; i < res.size(); i++) {
            int number = pxMapper.countOneCollection((String) res.get(i).get("id"));
            res.get(i).put("number",number);
        }
        result.put("data",res);
        result.put("success",true);
        return result;
    }

    @Override
    public Map<String, Object> getOneCollectionList(Map<String, Object> param) {
        Map<String,Object> result = new HashMap<>();
        List<Map<String,Object>> res = pxMapper.getOneCollectionList(param);
        result.put("data",res);
        result.put("success",true);
        return result;
    }

    @Override
    public Map<String, Object> addCollection(Map<String, Object> param) {
        Map<String, Object> result = new HashMap<>();
        int res = 0;
        try {
            res = pxMapper.addCollection(param);
        } catch (Exception e) {
            e.printStackTrace();
            res = 0;
        }
        result.put("data",res);
        result.put("success",true);
        return result;
    }

    @Override
    public Map<String, Object> editor(Map<String, Object> param) {
        Map<String, Object> result = new HashMap<>();
        int res = 0;
        try {
            res = pxMapper.editor(param);
        } catch (Exception e) {
            e.printStackTrace();
            res = 0;
        }
        result.put("data",res);
        result.put("success",true);
        return result;
    }

    @Override
    public Map<String, Object> getForumList(Map<String, Object> param) {
        Map<String,Object> result = new HashMap<>();
        List<Map<String,Object>> res = pxMapper.getForumList(param);
        result.put("data",res);
        result.put("success",true);
        return result;
    }
}
