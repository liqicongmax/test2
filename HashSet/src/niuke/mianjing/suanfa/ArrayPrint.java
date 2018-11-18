package niuke.mianjing.suanfa;

/**
 * 两个任意数组，如A{1,2,3}，B{A,B,C,D}，循环输出格式如{1A2B3C1D2A3B1C}
 * @author lqc
 * @date 2018/9/22 23:38
 */
public class ArrayPrint {
    public static void main(String[] args){
        int a=0;
        int temp=0;
        int b=0;
        int[] arr=new int[]{1,2,3};
        String[] brr=new String[]{"A","B","C","D"};
        while(temp<10){
            System.out.println(arr[a]);
            //a=a==(arr.length-1)?0:a;
            if(a==arr.length-1){
                a=0;
            }else {
                ++a;
            }
            System.out.println(brr[b]);
            if(b==brr.length-1){
                b=0;
            }else {
                ++b;
            }

            temp++;
        }
    }
}
