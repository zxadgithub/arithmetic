package zxa.linkedlist;

/**
 * Created by shixi006 on 2017/8/23.
 */
public class DeleteSameNode {
    
    public static void main(String[] args) {
        Node root = new DeleteSameNode().new Node(0);
        Node node = root;
        for(int i = 1; i < 10 ; i++){
            node.next = new DeleteSameNode().new Node(i);
            if(i>2&&i<6){
                node.next.data = 333;
            }
            node = node.next;
        }
        root = deleteDuplication(root);
        while (root!=null){
            System.out.print(root.data+"\t");
            root = root.next;
        }
    }
    
    private static Node deleteDuplication(Node<Integer> root) {
        if(root == null || root.next == null)
            return root;
        Node<Integer> preNode =null,pNode = root;//前驱节点
        while (pNode != null){
            Node<Integer> pNext = pNode.next;//重复元素的后一个节点
            boolean needDelete = false;
            if(pNext != null && pNext.data .equals(pNode.data) )
                needDelete = true;
            
            if(!needDelete){
                preNode = pNode;
                pNode = pNode.next;
            }else{
                
                int value = pNode.data;
                
                Node<Integer> toBeDelete = pNode;//被删除的点
                
                while (toBeDelete != null && toBeDelete.data == value){
                    pNext = toBeDelete.next;
                    toBeDelete = pNext;
                }
                //前置节点为空表示头结点被删除
                if(preNode == null)
                    root = pNext;
                else
                    preNode.next = pNext;
                
                //继续遍历下一个节点
                pNode = pNext;
                
                
            }
        }
        return root;
    }
    
    
    class Node<T>{
        T data;
        Node next;
        public Node(T data){
            this.data = data;
        }
    }
    
}
