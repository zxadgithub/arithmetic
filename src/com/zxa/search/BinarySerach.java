package com.zxa.search;

import com.zxa.sort.QuickSort;

/**
 * Created by shixi006 on 2017/8/21.
 */
public class BinarySerach {
    
    
    public static void main(String[] args) {
        Integer []a = {2,4,6,7,8,1,76,843,2,5};
        QuickSort.sort(a);
        for(int i : a){
            System.out.print(i+"\t");
        }
        System.out.println("\n");
        System.out.println(find(a,76)+"ceshi");
    }
    
    
    public static  Comparable find(Comparable [] a,Comparable key){
//        if(a == null && a.length<1 )
//            return -1;
//        if(a.length == 1){
//            return a[0];
//        }
        
        int lo = 0, hi = a.length - 1;
        while (lo <= hi){
            
            int mid = lo + (hi - lo >>1);
            if( key.compareTo(a[mid]) < 0)
                hi = mid - 1;
            else if(key.compareTo(a[mid] )> 0){
                lo = mid  +1 ;
            }
            else
                return  mid;
        }
        return  -1;
    }
    
    
    
    
}
