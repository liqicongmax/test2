package sort;

/**
 * @author lqc
 * @date 2018/9/29 10:26
 */
public class Heapify {
    public static void heapify(int[] arr,int cur,int size){
        if(cur<size){//如果当前结点位置在size内
            int left=cur*2+1;//左结点位置
            int right=cur*2+2;//右结点位置
            int max=cur;
            if(left<size){
                if(arr[max]<arr[left]) {
                    max = left;
                }
            }
            if(right<size){
                if(arr[max]<arr[right]) {
                    max = right;
                }
            }
            if(max!=cur){
                int temp=arr[cur];
                arr[cur]=arr[max];
                arr[max]=temp;
                heapify(arr,max,arr.length);
            }

        }
    }
    public static void maxheapify(int[] arr,int size){
        for(int i=size-1;i>=0;i--){
            heapify(arr,i,size);
        }
    }
    public static void main(String[] args){
        int[] arr={4,3,1,2,7,6,5};
        maxheapify(arr,7);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
