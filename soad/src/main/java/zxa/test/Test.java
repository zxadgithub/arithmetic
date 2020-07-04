package zxa.test;

/**
 * Created by shixi006 on 2017/8/18.
 */
public class Test {
    public static void main(String[] args) {
        Integer a = 56;
        Integer b = new Integer(56);
        Integer d = Integer.valueOf(128);
//        int c = 56;
//        System.out.println(a .equals(b) );
//        System.out.println(a == c);
        System.out.println(128 == d);
        System.out.println( b == 128);
//        System.out.println(f(12)
        
    
    }
    
    public static int f(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return f(n - 1) + f(n - 2);
        }
    }
    
    public static int test(int a, int b, int n) {
        if (n == 0)
            return b;
        System.out.print(b + "\t");
        return test(b, a + b, n - 1);
    }
    
    
}
