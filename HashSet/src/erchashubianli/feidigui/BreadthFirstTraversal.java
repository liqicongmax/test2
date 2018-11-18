package erchashubianli.feidigui;

import sun.reflect.generics.tree.Tree;

import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lqc
 * @date 2018/9/19 10:39
 */
public class BreadthFirstTraversal {
    public void breadthfirsttraversal(TreeNode node){
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode t=node;
        queue.offer(t);
        while(!queue.isEmpty()){
            t=queue.poll();
            System.out.println(t.value);
            if(t.left!=null){
                queue.offer(t.left);
            }
            if(t.right!=null){
                queue.offer(t.right);
            }
        }
    }
}
