public class infixtopostfix {
    int precedence(char ch){
        if(ch=='+' || ch=='-'){
        return 1;
    }
    if(ch=='*' || ch=='/'){
        return 2;
    }
    if(ch =='^'){
        return 3;
    }
    return -1;
}

String covertToPostfix(String exp){
    String res="";
    stacks stk = new stacks(exp.length());
    for (int i = 0; i <exp.length(); i++){
        char ch=exp.charAt(i);
        if(precedence(ch)>0){
            // operator
            while(!stk.isEmpty() && precedence(stk.peek())>= precedence(ch) ){
                res = res+stk.pop();
                // exponent ko kasari handle garcha extra if statement lekhna parcha exp ho ki haina bhanera
            }
            stk.push(ch);
        
        }
        else{
            // bracket or operend
            if(ch =='('){
                stk.push(ch);
            }
            else if(ch== ')'){
                char x=stk.pop();
                while (x! = '('){
                    res=res+x;
                    x= stk.pop();
                }
            }
            else {
                // operend case
                res=res+ch;
            }
        }
    }
    return res;
}

    
}

