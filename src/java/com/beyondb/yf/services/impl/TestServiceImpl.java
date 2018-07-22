/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beyondb.yf.services.impl;

import com.beyondb.yf.services.TestService;
import java.util.ArrayList;
import java.util.List;
import org.nutz.dao.Dao;
import org.nutz.dao.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

/**
 *
 * @author Retror
 */
@Service("testService")
@EnableCaching
public class TestServiceImpl implements TestService{

    private static int i = 0;
    
    @Autowired
    private Dao dao;

    @Override
    public List<Record> showData() {
        ;
        List<Record> list = new ArrayList<>();
        Record r = new Record();
        r.put("id",++i);
        r.put("name","小张");
        r.put("age",18);
        list.add(r);
        return list;
    }
    
    @Override
    @Cacheable(value = "helloworld", key = "'mycache1'")
    public int getCacheData1(){
        return i;
    }
    
     @Override
    @Cacheable(value = "helloworld", key = "'mycache2'")
    public int getCacheData2(){
        return i;
    }
    
    @Override
    @CacheEvict(value = "helloworld", key = "'mycache1'")
    public boolean clearCacheData(){
        return true;
    }
    
    @Override
    @CacheEvict(value = "helloworld", allEntries = true)
    public boolean clearAllCacheData(){
        return true;
    }
    
}
