package erchashubianli.feidigui;

/**
 * @author lqc
 * @date 2018/9/18 22:00
 */
public class InOrderTraversal {
    public void inOrderTraversal(TreeNode node){
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
}
