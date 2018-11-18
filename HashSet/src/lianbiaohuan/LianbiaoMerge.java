package lianbiaohuan;

import java.util.ArrayList;

/**
 * @author lqc
 * @date 2018/10/15 21:39
 */
public class LianbiaoMerge {
    public static Node lianbiaomerge(Node t1,Node t2){
        if(t1==null){
            return t2;
        }
        if(t2==null){
            return t1;
        }
        if(t1.value<=t2.value){
            t1.next=lianbiaomerge(t1.next,t2);
            return t1;
        }else {
            t2.next=lianbiaomerge(t1,t2.next);
            return t2;
        }
    }
}
