package bjiashu;
/**
 * author: shuly
 * create: 2018-09-11 上午11:38
 * Description: 和 b+tree 的区别是 没有 维护叶子结点的 链表结构
 */

@SuppressWarnings("unchecked")
public class SimpleBPTree<K extends Comparable<K>,V> {
    private static final class Node {
        int m;
        Entry[] children;
        Node(int max) {
            this.m = 0;
            children = new Entry[max];
        }

        Entry popHead() {
            Entry ans = children[0];
            for(int i = 0; i < m - 1; ++i){
                children[i] = children[i+1];
            }
            children[--m] = null;
            return ans;
        }

        void pushHead(Entry key) {
            for(int i = m ; i > 0 ; --i) {
                children[i] = children[i-1];
            }
            children[0] = key;
            ++m;
        }

        Entry popBack() {
            Entry ans = children[--m];
            children[m] = null;
            return ans;
        }

        void pushBack(Entry key) {
            children[m++] = key;
        }

        void pushBack(Node one) {
            for(int i = 0 ; i < one.m; ++i) {
                children[m++] = one.children[i];
            }
        }


        Entry pop(int i) {
            Entry ans = children[i];
            for(; i + 1< m; ++i) {
                children[i] = children[i+1];
            }
            children[--m] = null;
            return ans;
        }
    }

    private static class Entry {
        private Comparable key;
        private Object val;
        private Node next; // 里面结点的值大于等于 Key
        public Entry(Comparable key, Object val, Node next) {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }

    private static int M = 6;
    private static int MIN = M / 2;
    private int     size;
    private int     height;
    private Node    root;

    public SimpleBPTree() {
        root = new Node(M);
        size = 0;
        height = 1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void put(K k, V v) {
        assert k != null;
        Node aha = insert(root, k, v, 1);
        ++ size;
        if (aha != null) {
            Node R = new Node(M);
            R.children[0] = new Entry(root.children[0].key, null, root);
            R.children[1] = new Entry(aha.children[0].key, null, aha);
            R.m = 2;
            this.root = R;
            ++ height;
        }
    }

    public V get(K key) {
        assert key != null;
        return find(root, key, 1);
    }

    public V remove(K key) {
        assert key != null;
        V ans =  delete(root, key, 1);
        if (root.m == 1 && height != 1) {
            root = root.children[0].next;
            -- height;
        }
        return ans;
    }

    private V delete(Node now, K k, int h) {
        if (h == height) {
            for(int i = 0 ; i < now.m; ++i) {
                int ret = k.compareTo((K) now.children[i].key);
                if (ret == 0) {
                    size--;
                    return (V) now.pop(i).val;
                }
                else if (ret < 0) return null;
            }
            return null;
        } else {
            for(int i = 0; i < now.m; ++i) {
                if (i + 1 == now.m || k.compareTo((K) now.children[i + 1].key) < 0) {
                    V ans = delete(now.children[i].next, k, h + 1);
                    now.children[i].key = now.children[i].next.children[0].key;
                    if (now.children[i].next.m < MIN) { // 想办法凑凑, 凑不够就 合并
                        if(i + 1 != now.m && now.children[i + 1].next.m > MIN) {
                            // 右侧的失主！ 请把第一个给我
                            Entry key = now.children[i + 1].next.popHead();
                            now.children[i+1].key = now.children[i+1].next.children[0].key;

                            now.children[i].next.pushBack(key);
                        } else if (i != 0 && now.children[i - 1].next.m > MIN) {
                            // 左侧的失主！ 请把最后一个给我
                            Entry key = now.children[i - 1].next.popBack();

                            now.children[i].next.pushHead(key);
                            now.children[i].key = now.children[i].next.children[0].key;
                        } else {
                            // 找一个老实人 一起过
                            int start;
                            if (i + 1 != now.m) {
                                now.children[i].next.pushBack(now.children[i+1].next);
                                start = i + 1;
                                now.pop(start);
                            } else if (i != 0) {
                                now.children[i-1].next.pushBack(now.children[i].next);
                                start = i;
                                now.pop(start);
                            }
                            // 根 的缩水没有枚举
                        }
                    }
                    return ans;
                }
            }
            // BKN
            return null;
        }
    }

    private Node insert(Node now, K k, V v, int h) {
        Entry in = new Entry(k, v, null);
        int pos;
        if (h == height) { // leaf
            for(pos = 0; pos < now.m; ++pos) {
                if (k.compareTo((K) now.children[pos].key) <= 0) break;
            }
        } else {
            for(pos = 0 ; pos < now.m; ++pos) {
                if (pos+1 == now.m || (k.compareTo((K) now.children[pos+1].key) < 0)) {
                    Node one = insert(now.children[pos].next, k, v, h + 1);
                    if (one == null) return null;
                    in.key = one.children[0].key;
                    in.next = one;
                    in.val  = null;
                    ++ pos;
                    break;
                }
            }
        }
        for(int j = now.m; j > pos; --j) {
            now.children[j] = now.children[j-1];
        }
        now.children[pos] = in;
        ++ now.m;
        if (now.m < M) return null;
        else return split(now);
    }

    private Node split(Node node) {
        Node next = new Node(M);
        next.m = node.m =  MIN;
        for (int j = 0; j < MIN; j++) {
            next.children[j] = node.children[MIN + j];
            node.children[MIN + j] = null;
        }
        return next;
    }

    private V find(Node now, K key, int h){
        Entry[] children = now.children;
        if (h == height) {
            for (int j = 0; j < now.m; j++) {
                if (key.compareTo((K) children[j].key) == 0 ) {
                    return (V) children[j].val;
                }
            }
        } else {
            for (int j = 0; j < now.m; j++) {
                if (j+1 == now.m || (key.compareTo((K) children[j+1].key) < 0)) {
                    return find(children[j].next, key, h + 1);
                }
            }
        }
        return null;
    }

    public String toString() {
        return toString(root, 1, "") + "\n";
    }

    private String toString(Node h, int ht, String indent) {
        StringBuilder s = new StringBuilder();
        Entry[] children = h.children;
        if (ht == height) {
            for (int j = 0; j < h.m; j++) {
                s.append(indent).append(children[j].key).append(" ").append((children[j]).val).append("\n");
            }
        } else {
            for (int j = 0; j < h.m; j++) {
                s.append(indent).append("(").append(children[j].key).append(")").append("\n");
                s.append(toString((children[j]).next, ht + 1, indent + "     "));
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
        SimpleBPTree<Integer, String> map = new SimpleBPTree<>();


        for(int i = 1 ; i <= 10; ++ i) {
            map.put(i, i + "");
        }
        for(int i = 20; i >= 11; --i) {
            map.put(i, i + "");
        }
        for(int i = 21; i <= 30 ;++i) {
            map.put(i, i + "");
        }
        map.remove(1);
        map.remove(3);

        map.remove(12);
        map.remove(11);
        map.remove(10);

        map.remove(2);
        map.remove(4);
        map.remove(5);
        map.remove(6);

        map.remove(18);
        map.remove(13);
        map.remove(14);
        map.remove(15);
        map.remove(16);
        map.remove(17);
        map.remove(19);
        map.remove(7);
        map.remove(8);
        map.remove(9);
        map.remove(20);

        map.remove(21);
        map.remove(22);
        map.remove(23);
        map.remove(27);

        map.remove(28);
        map.remove(29);
        map.remove(30);
        map.remove(24);
        map.remove(25);
        map.remove(26);

        System.out.println(map.toString());
    }
}