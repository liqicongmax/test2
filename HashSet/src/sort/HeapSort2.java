package sort;

/**
 * @author lqc
 * @date 2018/10/8 10:14
 */
public class HeapSort2 {
    public static void heapify(int[] arr,int currentRootNode,int size){
        if(currentRootNode<size){
            int left=currentRootNode*2+1;
            int right=currentRootNode*2+2;
            int max=currentRootNode;
            if(left<size){
                if(arr[max]<arr[left]){
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
        for(int i=arr.length-1;i>=0;i--){
            heapify(arr,i,size);
        }
    }
    public static void main(String[] args){
        int[] arr={1,2,3,4,5,6,7};
        maxheapify(arr,7);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
