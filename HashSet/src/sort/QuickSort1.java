package sort;

/**
 * @author lqc
 * @date 2018/10/15 19:24
 */
public class QuickSort1 {
    public static int partition(int[] arr,int start,int end){
        int base=arr[end];
        while(start<end){
            while(start<end&&arr[start]<=base){
                start++;
            }
            if(start<end){
                int temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                end--;
            }
            while(start<end&&arr[end]>=base){
                end--;
            }
            if(start<end){
                int temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                start++;
            }
        }
        return end;
    }
    public static void quicksort(int[] arr,int start,int end){
        if(start>end){
            return;
        }else {
            int partition = partition(arr, start, end);
            quicksort(arr, start, partition - 1);
            quicksort(arr, partition + 1, end);
        }
    }
    public static void main(String[] args){
        int[] arr=new int[]{4,2,1,3,6,5,0};
        quicksort(arr,0,6);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
