package erchashubianli.digui;

/**
 * @author lqc
 * @date 2018/9/19 9:47
 */
public class DiguiGetHeight {
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
}
