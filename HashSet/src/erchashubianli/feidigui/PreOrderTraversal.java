package erchashubianli.feidigui;

/**
 * @author lqc
 * @date 2018/9/18 22:00
 */
public class PreOrderTraversal {
    public void preOrderTraversal(TreeNode node){
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
}
