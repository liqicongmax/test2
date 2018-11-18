package factorymodel;

import java.util.List;

/**
 * @author lqc
 * @date 2018/9/13 20:17
 */
public class HairFactory {
    public Hair getHair(String key){
        if("left".equals(key)){
            return new LeftHair();
        }
        if("right".equals(key)){
            return new RightHair();
        }
        return null;
    }
    public static Hair getHairByClass(String type)throws Exception{
        TypeEnum[] typeEnums=TypeEnum.values();
        for(TypeEnum typeEnum:typeEnums){
            if(typeEnum.getType().equals(type)){
                return (Hair)Class.forName(typeEnum.getClassname()).newInstance();
            }
        }

        return null;

    }
    public static void main(String[] args)throws Exception{
        Hair hair=HairFactory.getHairByClass("right");
        hair.draw();
    }
}
