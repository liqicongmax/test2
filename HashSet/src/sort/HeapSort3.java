package sort;

/**
 * @author lqc
 * @date 2018/10/15 19:39
 */
public class HeapSort3 {
    public static void maxheapify(int[] arr,int currentnode,int size){
        if(currentnode<size){
            int left=currentnode*2+1;
            int right=currentnode*2+2;
            int max=currentnode;
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
            if(max!=currentnode){
                int temp=arr[max];
                arr[max]=arr[currentnode];
                arr[currentnode]=temp;
                maxheapify(arr,max,size);
            }
        }
    }

    public static void maxheapify(int[] arr,int size){
        for(int i=size-1;i>=0;i--){
            maxheapify(arr,i,size);
        }
    }

}
