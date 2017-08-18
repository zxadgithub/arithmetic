package com.zxa.tree;

/**
 * Created by shixi006 on 2017/8/4.
 */
public class BinaryeTree {
    
    class Node<T> {
        
         T data;
        Node left;
        Node right;
        
        public Node(T data) {
            this.data = data;
        }
        
        void setLeft(Node node) {
            this.left = node;
        }
        
        void setRight(Node node) {
            this.right = node;
        }
        
        ;
        
    }
    
    public static void main(String[] args) {
        BinaryeTree constructTree = new BinaryeTree();
        Node<Integer> root = constructTree.new Node(10);
        Node<Integer> root6 = constructTree.new Node(6);
        Node<Integer> root4 = constructTree.new Node(4);
        Node<Integer> root8 = constructTree.new Node(8);
        Node<Integer> root14 = constructTree.new Node(14);
        Node<Integer> root12 = constructTree.new Node(12);
        Node<Integer> root16 = constructTree.new Node(16);
        root.setLeft(root6);
        root.setRight(root14);
        root6.setLeft(root4);
        root6.setRight(root8);
        root14.setLeft(root12);
        root14.setRight(root16);
        System.out.println("=============前序遍历============");
        constructTree.preTraversal(root);
        System.out.println("\n=============中序遍历============");
        constructTree.midTraversal(root);
        System.out.println("\n=============后序遍历============");
        constructTree.afterTraversal(root);
    }
    
    
    public void preTraversal(Node root) {
        if (root != null) {
            System.out.print(root.data + "\t");
            preTraversal(root.left);
            preTraversal(root.right);
        }
        
    }
    
    public void midTraversal(Node root) {
        if (root != null) {
            midTraversal(root.left);
            
            System.out.print(root.data + "\t");
            midTraversal((root.right));
        }
    }
    public void afterTraversal(Node root) {
        if (root != null) {
            afterTraversal(root.left);
    
            afterTraversal((root.right));
            System.out.print(root.data + "\t");
        }
    }
    
    public void widTraversal(Node root) {
        if (root != null) {
            widTraversal(root.left);
            
            System.out.print(root.data + "\t");
            widTraversal((root.right));
        }
    }
    
    
}
