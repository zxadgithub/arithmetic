package com.zxa.common;

import java.util.Arrays;

/**
 * Created by 张新安 on 2017/8/23.
 * p114 QS17
 * 打印从1到N最大N位数
 */
public class Print1ToMaxN {
    public static void main(String[] args) {
//        printf1ToNDigits(33);
        
        Print1ToMaxN.Inner inner = new Print1ToMaxN().new Inner();
        inner.Print1ToN(2);
    }
    
    /*
    *递归实现
     */
    class Inner{
        public void Print1ToN(int n){
            if(n<=0)
                return;
            char number[] = new char[n];
            for(int i = 0;i<10;i++){
                number[0] = (char)(i + '0');
                print1ToNRecursicely(number,n,0);
            }
        }
    
        private void print1ToNRecursicely(char[] number, int length, int index) {
            if(length - 1 == index) {
                printfNumber(number);
                return;
                
            }
            for(int i = 0;i<10;i++){
                number[index + 1] = (char)(i+'0');
                print1ToNRecursicely(number,length,index + 1);
            }
        }
    }
    
    
    
    
    
    
    
    
    
    /*
    *考虑数字溢出
     */
    static void printf1ToNDigits(int n){
        if(n <= 0){
            return;
        }
        char []number = new char[n];
        Arrays.fill(number,'0');
        
        while(!increate(number,n)){
            printfNumber(number);
        }
    }
    
    
    static  int count = 0;
    
    private static void printfNumber(char[] number) {
        
        boolean isBegining = false;
        
        for(int i = 0;i<number.length;i++){
            if(!isBegining)
            if(number[i]=='0') {
                continue;
            }else {
                isBegining = true;
            }
            System.out.print(number[i]);
        }
        System.out.print("\t");
        if(++count%20  == 0)
            System.out.println("\n");
    }
    
    private static boolean increate(char[] number,int n) {
        boolean isOverFlow = false;//是否溢出n位
        int nTakeOver = 0;//进位
        for(int i = number.length - 1;i >= 0;i--){
            int nSum = number[i] - '0' + nTakeOver ;//保存当前位的值
            //第一次加1
            if( i == number.length - 1)
                nSum++;
            //解决进位
            if(nSum >= 10){
                if(i == 0)
                    isOverFlow = true;
                else {
                    nTakeOver = 1;
                    nSum -= 10;
                    number[i] = (char)('0' + nSum);
                    
                }
                }
                
            
            else {
                number[i] = (char)(nSum+'0');
                break;
            }
        }
        return isOverFlow;
    }
    
    
}
