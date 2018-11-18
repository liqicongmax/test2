package erchashubianli.digui;

/**
 * @author lqc
 * @date 2018/9/18 22:00
 */
public class PreOrderTraversal {
    public void preOrderTraversal(TreeNode node){
        if(node!=null) {
            System.out.println(node.value);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }
}
