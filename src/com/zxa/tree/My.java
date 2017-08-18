package com.zxa.tree;

import java.lang.reflect.Field;

/**
 * Created by shixi006 on 2017/8/7.
 */
public class My {
    
    public static void main(String[] args) {
        Integer a = 2, b = 1;
        
        System.out.println("a的值:"+a+"\tb的值："+b);
//        switchInt(a,b);
        switchInt1(a,b);
        System.out.println("a的值:"+a+"\tb的值："+b);
    }
    
    public  static void switchInt(Integer a, Integer b){
        Integer temp;
        temp = a;
        a = b;
        b = temp;
    }
    
    public  static void switchInt1(Integer a, Integer b){
        Integer aCopy = new Integer(a);
        try {
            Field f1 = Integer.class.getDeclaredField("value");
            f1.setAccessible(true);
            f1.set(a,b);
            f1.set(b,aCopy);
//            Field f2 = b.getClass().getDeclaredField("value");
//            f2.setAccessible(true);
//            f2.set(b,aCopy);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
}
