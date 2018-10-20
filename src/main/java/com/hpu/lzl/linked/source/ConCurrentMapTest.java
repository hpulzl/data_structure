package com.hpu.lzl.linked.source;

import java.util.concurrent.ConcurrentHashMap;

/**
*   
* @author:awo  
* @time:2018/10/19  下午2:04 
* @Description: info
**/  
public class ConCurrentMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("A","a");
        concurrentHashMap.put("A","a");
        concurrentHashMap.put("A","a");
        concurrentHashMap.put("A","a");
    }
}
