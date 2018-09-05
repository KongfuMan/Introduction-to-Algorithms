package UDFStack;

import java.util.Stack;

public class QueueByTwoStacks {
    private Stack<Integer> firstStack;
    private Stack<Integer> secondStack;

    public QueueByTwoStacks(){
        this.firstStack = new Stack<Integer>();
        this.secondStack = new Stack<Integer>();
    }

    public void push(Integer element){
        firstStack.push(element);
    }

    public Integer pop(){
        if (secondStack.isEmpty()){ //只需将stack1的元素转移到stack2 一次
            while(!firstStack.isEmpty()){
                secondStack.push(firstStack.pop());
            }
        }

        return secondStack.pop();
    }

    public Integer top(){
        if (secondStack.isEmpty()){ //只需将stack1的元素转移到stack2 一次
            while(!firstStack.isEmpty()){
                secondStack.push(firstStack.pop());
            }
        }

        return secondStack.peek();
    }
}
