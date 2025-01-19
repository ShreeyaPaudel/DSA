public class BST {
    public static class Node {
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data = data;
            this.left = this.right = null;

        }
    
        
    }

    Node insertBST(Node root, int data){
        if(root==null){
            return new Node(data);
        }
        if(root.data<data){
            root.right =insertBST(root.right, data);
        }
        else if(root.data>data){
            root.left=insertBST(root.left, data);

        }

        return root;

    }

    Node deleteBST (Node root, int data){
        if(data<root.data){
            root.left = deleteBST(root.left, data);
        }
        else if (data>root.data){
            root.right=deleteBST(root.right, data);
        }
        else{
            //desired node
            if(root.left==null){
                return root.right;
            }
            else if (root.right==null){
                return root.left;
            }
            else{
                // two children case
                root.data=findMin(root.right);
                root.right=deleteBST(root.right, root.data);
            }
        }
        return root;
    }

    int findMin(Node root){
        int min = root.data;
        while (root.left!=null) {
            root=root.left;
            min = root.data;
            
        }
        return min;

    }

    public static void main (String [] args){
        BST bst =  new BST();
        Node root = bst.insertBST (null,10);
        root = bst.insertBST(root,20);
    }
    
}
