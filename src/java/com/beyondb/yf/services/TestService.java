/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beyondb.yf.services;

import java.util.List;
import org.nutz.dao.entity.Record;

/**
 *
 * @author Retror
 */
public interface TestService {
    /**
     * 测试数据
     * @return 
     */
    List<Record> showData();
    
    /**
     * 测试缓存
     * @return 
     */
    int getCacheData1();
    int getCacheData2();
    
    /**
     * 清空缓存测试
     * @return 
     */
    boolean clearCacheData();
    boolean clearAllCacheData();
}
