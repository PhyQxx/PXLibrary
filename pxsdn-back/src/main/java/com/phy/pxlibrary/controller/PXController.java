package com.phy.pxlibrary.controller;

import com.phy.pxlibrary.service.PXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/px")
public class PXController {

    @Autowired
    PXService pxService;

    /**判断登录 */
    @RequestMapping(value = "/login", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Map<String,Object> verifyLogin(@RequestBody Map<String,Object> param) {
        Map<String,Object> result = new HashMap<>();
        result.put("data",pxService.verifyLogin(param));
        result.put("success",true);
        return result;
    }

    /**注册 */
    @RequestMapping(value = "/register", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Map<String,Object> register(@RequestBody Map<String,Object> param) {
        Map<String,Object> result = new HashMap<>();
        result = pxService.register(param);
        return result;
    }

    /**获取博客列表 */
    @RequestMapping(value = "/getBlogList", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Map<String,Object> getBlogList(@RequestBody Map<String,Object> param) {
        Map<String,Object> result = new HashMap<>();
        List<Map<String,Object>> res = pxService.getBlogList(param);
        result.put("data",res);
        result.put("success",true);
        return result;
    }

    //获取一条博客详情
    @RequestMapping(value = "/getBlogContent", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Map<String,Object> getBlogContent(@RequestBody Map<String,Object> param) {
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> res = pxService.getBlogContent(param);
        result.put("data",res);
        result.put("success",true);
        return result;
    }

    //修改个人信息
    @RequestMapping(value = "/modifyPersonalInfo", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Map<String,Object> modifyPersonalInfo(@RequestBody Map<String,Object> param) {
        Map<String,Object> result = pxService.modifyPersonalInfo(param);
        return result;
    }

    /**获取我的收藏列表*/
    @RequestMapping(value = "/getMyCollectionList", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Map<String,Object> getMyCollectionList(@RequestBody Map<String,Object> param) {
        Map<String,Object> result = pxService.getMyCollectionList(param);
        return result;
    }

    /**获取一个收藏夹的列表*/
    @RequestMapping(value = "/getOneCollectionList", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Map<String,Object> getOneCollectionList(@RequestBody Map<String,Object> param) {
        Map<String,Object> result = pxService.getOneCollectionList(param);
        return result;
    }

    /**添加一个收藏夹*/
    @RequestMapping(value = "/addCollection", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Map<String,Object> addCollection(@RequestBody Map<String,Object> param) {
        Map<String,Object> result = pxService.addCollection(param);
        return result;
    }

    /**账号设置：密码，手机，邮箱*/
    @RequestMapping(value = "/editor", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Map<String,Object> editor(@RequestBody Map<String,Object> param) {
        Map<String,Object> result = pxService.editor(param);
        return result;
    }

    /**根据条件查询论坛列表*/
    @RequestMapping(value = "/getForumList", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Map<String,Object> getForumList(@RequestBody Map<String,Object> param) {
        Map<String,Object> result = pxService.getForumList(param);
        return result;
    }

}
