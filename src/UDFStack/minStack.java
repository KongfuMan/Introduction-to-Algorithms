package UDFStack;

import java.util.Stack;

public class minStack {
    private Stack<Integer> stack;
    private Stack<Integer> minvalStack;

    //constructor
    public minStack(){
        this.stack = new Stack<Integer>();
        this.minvalStack = new Stack<Integer>();
    }

    public void push(Integer element){
        stack.push(element);
        if (minvalStack.isEmpty()){
            minvalStack.push(element);
        }else{
            Integer minval = minvalStack.peek();
            minvalStack.push(Math.min(element,minval));
        }
    }

    public Integer pop(){
        if(stack.isEmpty()) {
            return null;
        }
        minvalStack.pop();
        return stack.pop();
    }

    public Integer getMinvalue(){
        if(minvalStack.isEmpty()){
            return null;
        }else {
            return minvalStack.peek();
        }
    }
}
