package com.zxa.linkedlist;

/**
 * Created by 张新安on 2017/8/18.
 * 链表的从翻转输出
 * p58,Q6
 */
public class ReverseLinkedList {
    class Node<T> {
        private T data;
        private Node next = null;
        
        public Node(T data) {
            this.data = data;
        }
        
    }
    
    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        Node<Integer> node = list.new Node<Integer>(10);
        node.next = list.new Node(3);
        node.next.next = list.new Node(323);
//        while (node!=null){
//            System.out.println(node.data);
//            node = node.next;
//        }
        reverse(node);
    }
    
    
    //递归实现
    static void reverse(Node node) {
        if (node == null) {
            return;
        }
        
        reverse(node.next);
        
        System.out.println(node.data);
    }
    
    
}
