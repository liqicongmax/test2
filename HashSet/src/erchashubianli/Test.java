package erchashubianli;

import erchashubianli.feidigui.Stack;
import erchashubianli.feidigui.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.WeakHashMap;

/**
 * @author lqc
 * @date 2018/9/19 15:10
 */
public class Test {
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

    /**
     * 非递归前序遍历
     * @param node
     */
    public void preordertraversal(TreeNode node){
        TreeNode t=node;
        Stack<TreeNode> stack=new Stack<>();
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

    /**
     * 非递归中序遍历
     * @param node
     */
    public void inordertraversal(TreeNode node){
        TreeNode t=node;
        Stack<TreeNode> stack=new Stack<>();
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
            while(t!=null) {
                stack.push(t);
                t = t.left;
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
    public static void main(String[] args){
        HashMap<String,String> map=new HashMap<>();
        WeakHashMap<String,String> wmap=new WeakHashMap<>();
        String s="xiaoming";
        wmap.put(s,"man");
        System.out.println(wmap.isEmpty());
        s=null;
        System.out.println(wmap.isEmpty());
        System.out.println(wmap.get(null));
        //map.put(null,"asd");
        //System.out.println(map.get(null));
    }
}
