public class Trees {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node (int data ){
            this.left=this.right=null;
            this.data=data;
        }
    
        
    }

    public void preorder(Node root){
        if(root ==null){
            return;
        }
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    public void inorder(Node root){
        if(root ==null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data);       
        inorder(root.right);
    }

     

    public static void main(String [] args){
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left=new Node(40);
        root.left.right = new Node(50);  
    }
    
}
