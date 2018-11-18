package erchashubianli;

import erchashubianli.digui.TreeNode;
import erchashubianli.feidigui.Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lqc
 * @date 2018/10/7 7:57
 */
public class Test6 {
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
            if(cur.right!=null&&pre!=null&&pre!=cur.right){
                t=cur.right;
            }else {
                System.out.println(cur.value);
                stack.pop();
            }
            cur=pre;
        }
    }
    public void breadthfirsttraversal(TreeNode node){
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode t=node;
        queue.offer(t);
        while(!queue.isEmpty()){
            t=queue.poll();
            System.out.println(t.value);
            if(t.left!=null){
                breadthfirsttraversal(t.left);
            }
            if(t.right!=null){
                breadthfirsttraversal(t.right);
            }
        }
    }
    public int diguiheight(TreeNode node){
        int leftheight;
        int rightheight;
        int maxheight;
        if(node!=null){
            leftheight=diguiheight(node.left);
            rightheight=diguiheight(node.right);
            maxheight=leftheight>rightheight?leftheight:rightheight;
            return maxheight+1;
        }
        return 0;
    }
}
