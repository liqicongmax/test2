package niuke.mianjing.suanfa;

import javax.annotation.Resource;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lqc
 * @date 2018/10/9 9:08
 */
public class Wgl {
    static int totalweight=0;
    public int wpl(TreeNode node){
        return getwgl(node,0);
    }
    public int getwgl(TreeNode node,int height){
        if(node.left==null&&node.right==null){
            totalweight+=height*node.weight;
        }
        if(node.left!=null){
            getwgl(node.left,height+1);
        }
        if(node.right!=null){
            getwgl(node.right,height+1);
        }
        return totalweight;
    }
}
