package niuke.mianjing.suanfa;

/**
 * @author lqc
 * @date 2018/10/10 20:35
 */
public class ArrayToStack {
    public static class MyStack{
        private int size;//指针位置，也表示栈已经压了多少
        private int[]arr;
        MyStack(int iniSize){//构造方法初始化数组
            arr = new int[iniSize];
            size = 0;
        }
        public void push(int num){
            if(size == arr.length){
                throw new RuntimeException("栈下标越界！");
            }
            arr[size++] = num;
        }
        public int pop(){
            if(size == 0){
                throw new RuntimeException("栈中已经没有元素可以弹出！");
            }
            return arr[--size];
        }
        public int peek(){
            if(size == 0){
                throw new RuntimeException("栈中已经没有元素可以弹出！");
            }
            return arr[size];
        }
    }
    public static void main(String[] args) {
        int len = 13;
        MyStack myStack = new MyStack(len);
        for (int i = 0; i < len; i++) {
            myStack.push(i);
        }
        for (int i = 0; i < len; i++) {
            System.out.println(myStack.pop());
        }
    }
}
