package com.zxa.tree;

import java.util.NoSuchElementException;

/**
 * Created by 张新安 on 2017/8/18.
 * 根据遍历确定二叉树
 * p63 Q7
 */
public class Construct {
    static final int []pre = {1,2,4,7,3,5,6,8};//前序遍历结果
    static final  int mid[] = {4,7,2,1,5,3,8,6};//中序遍历结果
    public static void main(String[] args) {
        Construct construct = new Construct();
        BinaryeTree binaryeTree = new BinaryeTree();
//        BinaryeTree.Node root = construct.constructTree(0,pre.length-1,0,mid.length-1);
        BinaryeTree.Node root = construct.cons(0,pre.length-1,0,mid.length-1);
       binaryeTree.midTraversal(root);
    }
    
    private BinaryeTree.Node constructTree(int startPre,int endPre,int startMid,int endMid){
        BinaryeTree.Node root = new BinaryeTree().new Node(pre[startPre]);
        if(startPre == endPre && startMid == endMid)
            return root;
        int rootIndexInMid = startMid;
        while (rootIndexInMid<=endMid && mid[rootIndexInMid] != pre[startPre])
            ++rootIndexInMid;
        //找不到根节点
    
//        System.out.println(rootIndexInMid);
        
        if(rootIndexInMid == endMid && mid[rootIndexInMid] != pre[startPre])
            throw new NoSuchElementException("根节点在中序遍历未找到");
        
        //中序遍历根节点左边元素格式
        int leftLongth = rootIndexInMid - startMid;
        
        //前序遍历根节点左子树的结束位置。
        int leftPreend = startPre+leftLongth;
        if(leftLongth > 0) {
//            System.out.println("左子树");
            root.left = constructTree(startPre + 1, leftPreend, startMid, rootIndexInMid - 1);
        }
        
        if(leftLongth < endPre-startPre){
//            System.out.println("右");
            root.right = constructTree(leftPreend+1,endPre,rootIndexInMid+1,endMid);
        }
        return root;
    }
    
    
    
    
    
    BinaryeTree.Node cons(int startPre,int endPre,int startMid, int endMid){
        BinaryeTree.Node root = new BinaryeTree().new Node(pre[startPre]);
        
        //如果就一个元素返回
        if(pre[startPre] ==pre[endPre] && mid[endMid]== mid[startMid])
            return root;
        int rootIndexInMid = startMid;
        
        //找出中序遍历中跟节点的索引
        while (rootIndexInMid <= endMid && pre[startPre] != mid[rootIndexInMid])
            rootIndexInMid++;
        
        //当前根节点左子树的长度
        int Leftlength = rootIndexInMid - startMid;
        //当前左子树在前序遍历的结束位置
        int endOfPre = startPre + Leftlength;
        
        if(Leftlength > 0){
            root.left = cons(startPre+1,endOfPre,startMid,rootIndexInMid-1);
        }
        
        if(endMid - rootIndexInMid > 0){
            root.right = cons(endOfPre+1,endPre,rootIndexInMid+1,endMid);
        }
        
        
        
        
        return root;
    }
    
    
    
    
}
