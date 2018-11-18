package proxymodel;

/**
 * @author lqc
 * @date 2018/9/13 22:29
 */
public class App {
    public static void main(String[] args) {
        IUserDao target = new UserDao();
        //UserDao target=new UserDao();
        System.out.println(target.getClass());

        IUserDao proxy=(IUserDao) new ProxyFactory(target).getProxyInstance();
        //IUserDao proxy=(IUserDao)
        System.out.println(proxy.getClass());

        proxy.save();
        proxy.get();
        proxy.getInteger(1);
    }

}
