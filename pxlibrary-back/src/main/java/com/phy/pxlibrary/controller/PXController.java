package com.phy.pxlibrary.controller;

import com.phy.pxlibrary.service.PXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/px")
public class PXController {

    @Autowired
    PXService pxService;

    //判断登录
    @RequestMapping(value = "/login", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Map<String,Object> verifyLogin(@RequestBody Map<String,Object> param) {
        Map<String,Object> result = new HashMap<>();
        result.put("data",pxService.verifyLogin(param));
        result.put("success",true);
        return result;
    }
}
