package zxa.common;

/**
 * Created by shixi006 on 2017/8/22.
 */
public class Power {
    public static void main(String[] args) {
        double a = 0.0001,b = 1.0001;
        System.out.println(power(-2,23));
        System.out.println(bestPower(2,23));
    }
    
    //最高效  避免重复做乘法
    static double bestPower(int base ,int exponent){
        if(exponent == 0){
            return 1;
        }
        if(exponent == 1){
            return base;
        }
        double res = bestPower(base,exponent>>1);
        res *= res;
        if((exponent & 1) == 1){
            res *= base;
        }
        return  res;
    }
    
    //需要考虑负数情况
    static double power(int base,int exponent){
        if(base == 0 && exponent < 0 )
            return 0.0;
        int absExponent = Math.abs(exponent);
        double res = 1;
        for(int i = 1;i<= exponent; i++){
            res *= base;
        }
        if(exponent < 0)
            res = 1.0/res;
        return res;
    }
    
}

