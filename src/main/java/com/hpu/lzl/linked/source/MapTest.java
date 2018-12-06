package com.hpu.lzl.linked.source;

import java.util.concurrent.ConcurrentHashMap;

/**
*   
* @author:awo  
* @time:2018/10/19  下午2:04 
* @Description: info
**/  
public class MapTest {

    public static void main(String[] args) {

    }

    public static void concurrentHashMap(){
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("A","a");
        concurrentHashMap.put("A","a");
        concurrentHashMap.put("A","a");
        concurrentHashMap.put("A","a");
    }
}
