package com.phy.pxlibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/px")
public class PXController {

    @RequestMapping("/index")
    @ResponseBody
    public String goIndex() {
        return "index";
    }
}
