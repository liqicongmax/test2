package erchashubianli.digui;

/**
 * @author lqc
 * @date 2018/9/18 22:01
 */
public class AfterOrderTraversal {
    public void afterOrderTraversal(TreeNode node){
        if(node!=null) {
            afterOrderTraversal(node.left);
            afterOrderTraversal(node.right);
            System.out.println(node.value);
        }
    }
}
