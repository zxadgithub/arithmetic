package zxa.sort;

/**
 * Created by shixi006 on 2017/8/18.
 */
public class QuickSort {
    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
//        Integer []a = {2,4,6,7,8,1,76,843,2,5};
        Integer []a = {4,6,8,4,5,7,3};
        qs.sort(a);
        
        for(int i:a){
            System.out.print(i+"\t");
        }
    }
    
    public static void sort(Comparable []a){
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable [] a,int lo,int hi){
        if(lo>=hi)
            return;
        int point = partition(a,lo,hi);
        sort(a,lo,point-1);
        sort(a,point+1,hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int left = lo, right = hi + 1;
        Comparable point = a[lo];
        while (true) {
            while (less(a[++left],point )) {
                if (left == hi)
                    break;
            }
            while (less( point,a[--right])) {
                if (right == lo)
                    break;
            }
            if(left>=right)
                break;
            swap(left, right, a);



        }
        swap(lo,right,a);
        return right;
    }
    public static boolean less(Comparable a,Comparable b){
        int com = a.compareTo(b);
        if(com>=0)
            return false;
        else
            return true;
    }

    public static void swap(int i,int j,Comparable []a){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

//    public void sort(int []array){
//        sort(array,0,array.length-1);
//    }
//
//    private void sort(int []array,int lo,int hi){
//        if(lo>=hi)
//            return;
//        int cut = partition(array,lo,hi);
//        sort(array,cut+1,hi);
//        sort(array,lo,cut-1);
//    }
//    private int  partition(int []array,int lo,int hi){
//        int index = array[lo];
//        int left = lo,right = hi+1;
//        while (true) {
//            while (array[++left] < index){
//                if(left == hi)
//                    break;
//            }
//            while (array[--right] > index) {
//                if (right == lo)
//                    break;
//            }
//            if(left>=right)
//                break;
//            swap(left,right,array);
//
//        }
//        swap(lo,right,array);
//
//        return right;
//    }
//
//    private void swap(int i,int j,int []array){
//        int temp = array[i];
//
//        array[i] = array[j];
//        array[j] = temp;
//    }



}
