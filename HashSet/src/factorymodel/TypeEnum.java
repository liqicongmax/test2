package factorymodel;

/**
 * @author lqc
 * @date 2018/9/13 20:33
 */
public enum TypeEnum {
    LEFT("left","factorymodel.LeftHair"),
    RIGHT("right","factorymodel.RightHair")
    ;
    private String type;
    private String classname;

    TypeEnum(String type, String classname) {
        this.type = type;
        this.classname = classname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }
}
