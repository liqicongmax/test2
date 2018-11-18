package erchashubianli;

import erchashubianli.digui.TreeNode;
import erchashubianli.feidigui.Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lqc
 * @date 2018/9/25 9:31
 */
public class Test4 {
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
        TreeNode pre=null;
        TreeNode cur=null;
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
        TreeNode t=node;
        int leftheight;
        int rightheight;
        int maxheight;
        if(t!=null){
            leftheight=diguigetheight(t.left);
            rightheight=diguigetheight(t.right);
            maxheight=leftheight>rightheight?leftheight:rightheight;
            return maxheight+1;
        }
        return 0;
    }
    public void breadthfirsttraversal(TreeNode node){
        TreeNode t=node;
        Queue<TreeNode> queue=new LinkedList<>();
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
    public static int partition(int[] arr,int start,int end){
        int base=arr[end];
        while(start<end){
            while(start<end&&base>=arr[start]){
                start++;
            }
            if(start<end){
                //exchange(base,arr[start]);
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                end--;
            }
            while(start<end&&base<=arr[end]){
                end--;
            }
            if(start<end){
                //exchange(base,arr[end]);
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
            }
        }
        return end;
    }
    public static void quicksort(int[] arr,int start,int end){
        if(start>end){
            return;
        }else {
            int divide=partition(arr,start,end);
            quicksort(arr,start,divide-1);
            quicksort(arr,divide+1,end);
        }

    }
    public static void exchange(int a,int b){
        a=a+b;
        b=a-b;
        a=a-b;
        //System.out.println("a:"+a+"//b:"+b);
    }
    public static void main(String[] args){
        //exchange(1,2);
        int[] arr=new int[]{4,2,1,3,6,5,0};
        quicksort(arr,0,6);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
