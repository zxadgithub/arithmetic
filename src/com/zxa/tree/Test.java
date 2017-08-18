package com.zxa.tree;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by shixi006 on 2017/8/7.
 */
class Product {
    private String name;
    private double price;
    private int num;
    public double total(){
        return price*num;
    }
    
    public  String myTest(String test){
        return test+"myTest";
    }
    
    
}

public class Test{
    public static void main(String[] args) {
        Class c = null;
        Object o = null;
        c  =  Product.class;
        try {
          o = c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Field[] field = c.getDeclaredFields();
        for(int i = 0; i<field.length;i++){
            System.out.println("第"+i+"个参数"+field[i]);
        }
        try {
            Field f = c.getDeclaredField("price");
            System.out.println("参数pricce"+f);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    
    
        Method[] methods = c.getMethods();
    
        for(int i = 0; i<methods.length;i++){
            System.out.println("第"+i+"个方法"+methods[i]);
        }
    
    
        try {
            Method m = c.getDeclaredMethod("myTest", String.class);
            String s = (String)m.invoke(o,"测试");
            System.out.println(s);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    
    
    }
}







