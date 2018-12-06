package com.hpu.lzl.linked.source;

import sun.tools.java.ClassFile;

import java.io.*;

/**
*   
* @author:awo  
* @time:2018/12/2  下午9:54 
* @Description: 自定义类类加载机制
**/  
public class CustomerClassLoader extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] result = getClassFromCustomerPath(name);
            if (result == null){
                throw new ClassNotFoundException();
            }
            return defineClass(name,result,0,result.length);
        }catch (Exception e){
            e.printStackTrace();
        }
        throw new ClassNotFoundException();
    }

    private byte[] getClassFromCustomerPath(String name) {
        //自定义类的路径
        InputStream is = getClass().getClassLoader().getResourceAsStream(name.replace(".", "/")+".class");
        ByteArrayOutputStream byteSt = new ByteArrayOutputStream();
        //write into byte
        int len =0;
        try {
            while((len=is.read())!=-1){
                byteSt.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //convert into byte array
        return byteSt.toByteArray();
    }

    public static void main(String[] args) {
        CustomerClassLoader customerClassLoader = new CustomerClassLoader();
        try {
            Class<?> clazz = customerClassLoader.findClass("com.hpu.lzl.linked.source.model.Animal");
            Object obj = clazz.newInstance();
            System.out.println(obj.getClass().getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}

