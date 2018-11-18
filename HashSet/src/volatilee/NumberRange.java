package volatilee;

/**
 * @author lqc
 * @date 2018/9/12 20:46
 */
public class NumberRange {
    private volatile int lower, upper;
    NumberRange(int lower,int upper){
        this.lower=lower;
        this.upper=upper;
    }
    public int getLower() { return lower; }
    public int getUpper() { return upper; }

    public void setLower(int value) {
        if (value > upper)
            throw new IllegalArgumentException("值不能大于顶");
        lower = value;
    }

    public void setUpper(int value) {
        if (value < lower)
            throw new IllegalArgumentException("值不能小于底");
        upper = value;
    }
    public static void main(String[] args){
        NumberRange n=new NumberRange(0,5);
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                n.setLower(4);
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                n.setUpper(3);
            }
        });
        t1.start();
        t2.start();
    }
}