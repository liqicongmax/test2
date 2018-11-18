package sort;

import com.company.Hero;
import com.sun.jmx.snmp.SnmpStatusException;

/**
 * @author lqc
 * @date 2018/9/29 10:55
 */
public class Heapify1 {
    public static void heapifyformax(int[] arr,int cur,int size){
        if(cur<size){
            int max=cur;
            int left=cur*2+1;
            int right=cur*2+2;
            if(left<size){
                if(arr[left]>arr[max]){
                    max=left;
                }
            }
            if(right<size){
                if(arr[right]>arr[max]){
                    max=right;
                }
            }
            if(max!=cur){
                int temp=arr[max];
                arr[max]=arr[cur];
                arr[cur]=temp;
                heapifyformax(arr,max,arr.length);
            }
        }
    }
    public static void heapifyformin(int[] arr,int cur,int size){
        if(cur<size){
            int min=cur;
            int left=cur*2+1;
            int right=cur*2+2;
            if(left<size){
                if(arr[left]<arr[min]){
                    min=left;
                }
            }
            if(right<size){
                if(arr[right]<arr[min]){
                    min=right;
                }
            }
            if(min!=cur){
                int temp=arr[min];
                arr[min]=arr[cur];
                arr[cur]=temp;
                heapifyformax(arr,min,arr.length);
            }
        }
    }
    public static void maxheapify(int[] arr,int size){
        for(int i=size-1;i>=0;i--){
            heapifyformax(arr,i,size);
        }
    }
    public static void minheapify(int[] arr,int size){
        for(int i=size-1;i>=0;i--){
            heapifyformin(arr,i,size);
        }
    }
    @Override
    protected void finalize()throws Throwable{
        super.finalize();
        System.out.println("finalize");
    }
    public static void main(String[] args){
        Hero hero=new Hero("xiaoming",2);
        hero=null;
        System.gc();
        try {
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        int[] arr={4,3,1,2,7,6,5};
        maxheapify(arr,7);
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println("");
        minheapify(arr,7);
        for(int i:arr){
            System.out.print(i+" ");
        }
        String s="a";
        StringBuffer sb=new StringBuffer("a");
        StringBuilder sbd=new StringBuilder("a");
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("aaa");
            }
        }));
    }
}
