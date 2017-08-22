package com.zxa.bitoperation;


/**
 * Created by 张新安 on 2017/8/22.
 * 位运算
 * & 与 1&1 = 1；其他0；
 * 或 | 0|0 = 0，其他1，
 * 异或 ^ 1^0 = 1,0^1 = 1;
 * 左移<< 右移>>
 *
 */
public class Count1 {
    
    public static void main(String[] args) {
        int n = 1024;
        int count = numberOf1(n);
        System.out.println(count);
        System.out.println(swif(n));
        
        //相关题目
        //判断一个数是否为2的整数次方
            System.out.println((n-1&n) == 0);
    }
    
    
    //十进制转换二进制
    static String swif(int n){
        if(n<=0)
            return "";
        String res =  n%2 + "";
        res += swif(n/2) ;
        return res;
    }
    
    
    //解法3最优解
    static int numberOf1(int n){
        int count = 0;
        while (n != 0){
            ++count;
            n = (n-1) & n;
        }
        return count;
    }
    
    //解法2 常规解法 避免死循环
//    static int numberOf1(int n){
//        int count = 0;
//        int flag = 1;
//        while (flag != 0){
//            if((n&flag) != 0)
//                count++;
//            flag = flag << 1;
//        }
//        return count;
//    }
    
    
    /*
    *解法1：可能引起死循环，当数字为负数时
     */
     /*
     static int numberOf11(int n){
        int count = 0;
        while (n>0){
            if( (n&1) == 0 )
                count++;
            n = n>>1;
        }
        return  count;
    }
    */
    
    
}
