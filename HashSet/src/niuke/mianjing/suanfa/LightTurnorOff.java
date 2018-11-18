package niuke.mianjing.suanfa;

/**
 * @author lqc
 * @date 2018/9/26 14:16
 */
public class LightTurnorOff {
    public static void main(String[] args){
        int[] light=new int[100];
        //亮灯总数
        int lighton=0;
        //初始化灯状态0为灭1为亮
        for(int i=0;i<100;i++){
            light[i]=0;
        }
        for(int i=1;i<=100;i++){//100轮
            for(int j=1;j<=100;j++){//100灯
                if(j%i==0){
                    if(light[j-1]==0){
                        light[j-1]=1;
                    }else {
                        light[j-1]=0;
                    }
                }
            }
        }
        for(int i=0;i<100;i++){
            if(light[i]==1){
                lighton++;
            }

        }
        System.out.println(lighton);
    }
}
