package niuke.mianjing.suanfa;

import java.util.Stack;

/**
 * @author lqc
 * @date 2018/10/22 8:38
 */
public class StackToQueue {
    static Stack<String> stack1=new Stack<>();
    static Stack<String> stack2=new Stack<>();
    public static void toQueue(){

    }
    StackToQueue(Stack<String> stack){
        stack1=stack;
    }
    public static void offer(String s){
        stack1.push(s);

    }
    public static String poll(Stack s1,Stack s2){
        if(stack1.isEmpty()){
            if(stack2.isEmpty()){
                return null;
            }
            transfer();
        }
        return stack2.pop();
    }
    public static void transfer(){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }
}
