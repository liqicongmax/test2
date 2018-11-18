package erchashubianli;

import erchashubianli.feidigui.Stack;
import erchashubianli.feidigui.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


/**
 * @author lqc
 * @date 2018/9/20 8:38
 */
public class Test2 {
    public void preordertraversal(TreeNode node){
        Stack<TreeNode> stack=new Stack<>();
        TreeNode t=node;
        while(t!=null||!stack.isEmpty()){
            while(t!=null){
                System.out.println(t.value);
                stack.push(t);
                t=t.left;
            }
            if(!stack.isEmpty()){
                t=stack.pop();
                t=t.right;
            }
        }
    }
    public void inordertraversal(TreeNode node){
        Stack<TreeNode> stack=new Stack<>();
        TreeNode t=node;
        while(t!=null||!stack.isEmpty()){
            while(t!=null){
                stack.push(t);
                t=t.left;
            }
            if(!stack.isEmpty()){
                t=stack.pop();
                System.out.println(t.value);
                t=t.right;
            }
        }
    }
    public void afterordertraversal(TreeNode node){
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=null;
        TreeNode pre=null;
        TreeNode t=node;
        while(t!=null||!stack.isEmpty()){
            while(t!=null){
                stack.push(t);
                t=t.left;
            }
            cur=stack.top();
            if(cur.right!=null&&pre!=null&&cur.right!=pre){
                t=cur.right;
            }else {
                System.out.println(cur.value);
                stack.pop();
            }
            pre=cur;
        }
    }

    public int diguigetheight(TreeNode node){
        int leftheight;
        int rightheight;
        int maxheight;
        if(node!=null){
            leftheight=diguigetheight(node.left);
            rightheight=diguigetheight(node.right);
            maxheight=leftheight>rightheight?leftheight:rightheight;
            return maxheight+1;
        }
        return 0;
    }

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
