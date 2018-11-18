package proxymodel;

/**
 * @author lqc
 * @date 2018/9/13 22:22
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("------已保存数据-------");
    }
    @Override
    public void get(){
        System.out.println("--------已获得数据--------");
    }
    @Override
    public void getInteger(Integer i){
        System.out.println("---------已获得"+i+"---------");
    }
}
