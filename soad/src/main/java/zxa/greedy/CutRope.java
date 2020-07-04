package zxa.greedy;

/**
 * Created by 张新安 on 2017/8/22.
 * P98 Q14 贪婪算法 剪绳子
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
        
        //尽可能的剪去长度为3的
        int timesof3 = length / 3;
        
        //当最后长度为4，不在剪去
        
        if(timesof3 * 3 + 1 == length){
            timesof3--;
        }
        
        int timesOf2 = (length - timesof3 * 3) / 2 ;
    
        return (int) Math.pow(3,timesof3) * (int)Math.pow(2,timesOf2);
        
        
    }
}
