public class doublyLikedList {

    public static class Node{
        Node prev;
        Node next;
        int data;
        Node(int data){
            this.data = data;
            this.next = this.prev=null;
        }

    }
    Node head = null;
    Node tail = null;


    void insert(int data ){
        Node newnode= new Node(data);
        if(head==null){
            head=tail=newnode;
        }
        else{
            tail.next=newnode;
            newnode.prev=tail;
            tail=newnode;
        }

    }

    void printList(){
        Node current = head;
        while (current!=null){
            System.out.println(current.data);
            current = current.next;
        }
    
}
}
