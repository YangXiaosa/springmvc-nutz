/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beyondb.yf.controllers;

import com.beyondb.yf.services.TestService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.nutz.dao.Dao;
import org.nutz.dao.entity.Record;
import org.nutz.lang.util.NutMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Retror
 */
@Controller
@CrossOrigin
@RequestMapping("/test")
@ResponseBody
public class TestController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Dao nutDao;
    @Autowired
    private TestService testService;

    @RequestMapping("/showData")
    public Object showData() {
        NutMap map = new NutMap();
        List<Record> data = testService.showData();
        return map.setv("data", data);
    }
    
    @RequestMapping("testCache")
    public Object testCache(){
        Map<String,Integer> result = new HashMap();
        result.put("mycache1", testService.getCacheData1());
        result.put("mycache2", testService.getCacheData2());
        return result;
    }
    
    @RequestMapping("clearCache")
    public Object clearCache(){
        return testService.clearCacheData();
    }
    
    @RequestMapping("clearAllCache")
    public Object clearAllCache(){
        return testService.clearAllCacheData();
    }
}
