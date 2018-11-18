package lianbiaohuan;

/**
 * @author lqc
 * @date 2018/9/17 20:43
 */
public class NodeTest{
    public boolean hasCycle(Node node){
        Node a=node;
        Node b=node;
        while(a.next!=null&&b.next!=null){
            a=a.next;
            b=b.next.next;
            if(a==b){
                return true;
            }
        }
        return false;
    }
    public Integer huanLength(Node node){
        Node a=node;
        Node b=node;
        int count =0;
        while(a.next!=null&&b.next!=null){
            a=a.next;
            b=b.next.next;
            if(a==b){
                Node temp1=a;
                Node temp2=a;
                while(temp1.next!=null&&temp2.next!=null){
                    temp1=temp1.next;
                    temp2= temp2.next.next;
                    count++;
                    if(temp1==temp2){
                        return count;
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args){
        Node node=new Node(1);
        node.next=new Node(2);
        node.next.next=node;
        NodeTest nt=new NodeTest();
        System.out.println(nt.hasCycle(node));
        System.out.println(nt.huanLength(node));
        //System.out.println(node.next.value);


    }
}
