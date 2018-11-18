package erchashubianli.feidigui;

import java.util.ArrayList;
import java.util.Queue;

/**
 * @author lqc
 * @date 2018/9/18 22:01
 */
public class AfterOrderTraversal {
    public void afterOrderTraversal(TreeNode node){
        Stack<TreeNode> stack=new Stack<>();
        TreeNode t=node;//用于保存当前的node
        TreeNode cur=null;//设置当前结点
        TreeNode pre=null;//前一结点

        while(!stack.isEmpty()||t!=null){
            while(t!=null){
                stack.push(t);
                t=t.left;
            }
            cur=stack.top();
            if(cur.right!=null&&pre!=null&&cur.right!=pre){
                t=cur.right;
            }else{
                System.out.println(cur.value);
                stack.pop();
            }
            pre=cur;
        }
    }
}
