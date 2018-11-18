package erchashubianli.feidigui;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lqc
 * @date 2018/9/18 22:06
 */
public class Stack<E> {
    public List<E> stack=new ArrayList<>();

    public void push(E object){
        stack.add(object);
    }

    public E pop(){
        if(stack!=null){
            return stack.remove(stack.size()-1);
        }
        return null;
    }
    public E top(){
        return stack.get(stack.size()-1);
    }
    public boolean isEmpty(){
        return stack.size()==0;
    }
}
