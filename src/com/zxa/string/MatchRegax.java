package com.zxa.string;

/**
 * Created by shixi006 on 2017/8/23.
 */
public class MatchRegax {
    public static void main(String[] args) {
        MatchRegax matchRegax = new MatchRegax();
//        String s = "afgga";
        System.out.println(matchRegax.match("aasdffg","a.*g"));
    }


    public boolean match(String str,String pattern){
        if(str.equals("") || pattern.equals(""))
            return true;
        return mactchCore(str,pattern);
    }
    
    public boolean mactchCore(String str,String pattern){
     
        if(str.equals("") && pattern.equals("")){
            return true;
        }
        if(!str.equals("") && pattern.equals("")){
            return false;
        }
        if(str.equals("") && !pattern.equals("")){
            return false;
        }
        
        if(pattern.length() > 1 && pattern.charAt(1) == '*'){
            if(pattern.charAt(0) == str.charAt(0) || (pattern.charAt(0) == '.' && !str.equals(""))){
                return mactchCore(str.substring(1,str.length()),pattern.substring(2,pattern.length()))
                        ||mactchCore(str.substring(1,str.length()),pattern)
                        ||mactchCore(str,pattern.substring(2,pattern.length()));
                
            }else
                return mactchCore(str,pattern.substring(2,pattern.length()));
            
        }
        if(str.charAt(0) == pattern.charAt(0) ||
                (pattern.charAt(0) == '.' && !str.equals("")))
            return mactchCore(str.substring(1,str.length()),pattern.substring(1,pattern.length()));
        return false;
    
    
    }
    
}
