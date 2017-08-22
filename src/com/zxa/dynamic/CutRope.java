package com.zxa.dynamic;

/**
 * Created by shixi006 on 2017/8/22.
 */
public class CutRope {
    public static void main(String[] args) {
        int length = 7;
        CutRope cutRope = new CutRope();
        int max = cutRope.maxCuttingSolution(length);
        System.out.println(max);
    }
    
    private int maxCuttingSolution(int length) {
        if(length < 2)
            return 0;
        if(length == 2)
            return 1;
        if(length == 3){
            return 2;
        }
        
        int products[] = new int[length+1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        int max;
        for(int i = 4;i <= length;i++){
            max = 0;
            for(int j = 1;j<=i/2;j++){
                int product = products[j] * products[i-j];
                if(max < product)
                    max = product;
                products[i] = max;
            }
        }
        max = products[length];
        return max;
        
    }
}
