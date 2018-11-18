package reflect;

/**
 * @author lqc
 * @date 2018/9/13 22:57
 */
public class Hero {
    public String name;
    private Integer hp;

//    public Hero(String name, Integer hp) {
//        this.name = name;
//        this.hp = hp;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                '}';
    }
}
