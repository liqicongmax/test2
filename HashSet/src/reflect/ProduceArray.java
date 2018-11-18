package reflect;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author lqc
 * @date 2018/9/26 13:28
 */
public class ProduceArray {
    public static void main(String[] args){
        int[] a={1,2,3};
        a=(int[])goodCopyOf(a,a.length);
        System.out.println(Arrays.toString(a));

        String[] b={"a","b","c"};
        b=(String[])goodCopyOf(b,b.length);
        System.out.println(Arrays.toString(b));
        //方法定义为Object[]类型，只能接受引用数据类型的数组，也就是我们自己创建的一些类,几种基本数据类型和包装类型都不行
        String[] c={"a","b","c"};
        c=(String[])badCopyOf(c,c.length);
        System.out.println(Arrays.toString(c));
    }
    public static Object[] badCopyOf(Object[] a,int newlength){
        Object[] newarr=new Object[newlength];
        System.arraycopy(a,0,newarr,0,Math.min(a.length,newlength));
        return newarr;
    }
    public static Object goodCopyOf(Object a,int newlength){
        Class cl=a.getClass();
        if(!cl.isArray()){
            return null;
        }
        //获得组成数组的元素类型
        Class componentType=cl.getComponentType();
        int length= Array.getLength(a);
        Object newarr=Array.newInstance(componentType,length);
        System.arraycopy(a,0,newarr,0,Math.min(length,newlength));
        return newarr;
    }

}
