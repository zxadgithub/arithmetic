package zxa.linkedlist;

/**
 * Created by 张新安 on 2017/8/23.
 * p119 QS18
 * 删除链表的节点
 */
public class DeleteNode {
    
    public static void main(String[] args) {
        Node node = new DeleteNode().new Node<Integer>(10);
        Node root = node;
        for(int i = 0;i<10;i++){
            node.next = new DeleteNode().new Node<Integer>(i);
            node = node.next;

        }
        /*
        *因为Java是值传递，所以传入跟节点，需要再返回，维持一个引用，不然删除头结点时候会出错
         */
        root = delete(root,node);//删除尾节点
        root = delete(root,root.next);//删除其他
        root = delete(root,root);//删除头节点
    
        while (root!=null){
            System.out.print(root.data+"\t");
            root = root.next;
        }
    }
    
    private static Node delete(Node root, Node toBeDelete) {
        if(null == root || toBeDelete == null)
            return null;
        //要删除的节点不是尾节点
        if(toBeDelete.next != null){
            Node node = toBeDelete.next;
            toBeDelete.data = node.data;
            toBeDelete.next = node.next;
            
        }
        
        //  删除只有一个节点
        else if(root == toBeDelete){
            return null;
            
        }
        
        //多个节点，且是尾节点
        else{
            Node node = root;
            while (node.next != toBeDelete)
                node = node.next;
            node.next = null;
        }
        return root;
    }
    
    
    class Node<T> {
        T data;
        Node next = null;
        public Node(T data){
            this.data = data;
        }
    
        @Override
        public int hashCode() {
            int result = 17;
            return 31 * result + data.hashCode();
        }
    
        @Override
        public boolean equals(Object obj) {
            if(obj == null)
                return false;
            if(!(obj instanceof Node)){
            return false;
            }
            Node node = (Node)obj;
            return this.data.equals(node.data);
        }
    }
}
