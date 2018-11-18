package proxymodel;

/**
 * @author lqc
 * @date 2018/9/13 23:38
 */
public class App1 {
    public static void main(String[] args){
        User user=new User();
        User proxy=(User) new CglibProxyFactory(user).getProxyInstance();
        proxy.get();
        proxy.save();
    }

}
