public class stacks{
    char[] stk;
    int top = -1;
    int size;
    stacks(int size){
        stk = new char [size];
        this.size = size;

    }

    void push (char data){
        if(isFull()){
            System.out.println("stack overflow");
        }
        else{
            stk[++top]=data;
            //prefix ma cha bhane paila top increase huncha//
        }




    }

    int pop(){
        if (isEmpty()){
            System.out.println("stack underflow");
            return -999;
        }
        //int temp =top;
        //top--
        //return stk[temp]

        return stk[top --];
        //suffix cha bhane paila value return garcha ani balla -- garcha//



    }

    char peek(){
        return stk[top];
    }

    boolean isEmpty(){
        return top ==-1;
    }

    
    boolean isFull(){
        return top == size-1;
    }

    // public static void main(String[] args) {
    //     stacks s= new stacks(5);
    //     s.push(10);
    //     s.push(20);
    //     System.out.println(s.pop());
    // }
}


// write an algorithm to convert infix expression to prefix and vice versa
// (tabulation)
//  write an algorithm to evaluate postfix expression 