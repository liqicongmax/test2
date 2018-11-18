package sort;

/**
 * @author lqc
 * @date 2018/10/7 9:38
 */
public class HeapSort1 {
    public static void heapify(int[] arr,int currentRootNode,int size){
        if(currentRootNode<size){
            int left=2*currentRootNode+1;
            int right=2*currentRootNode+2;
            int max=currentRootNode;
            if(left<size){
                if(arr[left]>arr[max]){
                    max=left;
                }
            }
            if(right<size){
                if(arr[max]<arr[right]){
                    max=right;
                }
            }
            if(max!=currentRootNode){
                int temp = arr[max];
                arr[max] = arr[currentRootNode];
                arr[currentRootNode] = temp;
                heapify(arr,max,size);
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
