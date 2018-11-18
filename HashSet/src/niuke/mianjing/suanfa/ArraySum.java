package niuke.mianjing.suanfa;

/**
 * @author lqc
 * @date 2018/10/9 19:52
 */
public class ArraySum {
    public static float getArraySum(int start,int length){
        float sum=0;
        float[] arr=new float[length];
        arr[0]=start;
        for(int i=1;i<length;i++){
            arr[i]=(float)Math.sqrt(arr[i-1]);
        }
        for(float i:arr){
            sum=sum+i;
        }
        return sum;
    }
    public static void main(String[] args){
        float a=1.23213f;
        System.out.println(String.format("%.2f",a));
        System.out.println(String.format("%.2f",getArraySum(81,4)));
    }
}
