package erchashubianli.digui;

/**
 * @author lqc
 * @date 2018/9/18 22:00
 */
public class InOrderTraversal {
    public void inOrderTraversal(TreeNode node){
        if(node!=null) {
            inOrderTraversal(node.left);
            System.out.println(node.value);
            inOrderTraversal(node.right);
        }
    }
}
