public class SeparateChainingLiteHashST<Key, Value> {
    private static final int INIT_CAPACITY = 128;
    private static final int LOAD_FACTOR_THRESHOLD = 4;

    private int m;                 // number of buckets
    private int n;                 // number of key-value pairs
    private Node[] table;        // array of linked-list chains - the table itself

    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public SeparateChainingLiteHashST() {
        this(INIT_CAPACITY);
    }

    public SeparateChainingLiteHashST(int capacity) {
        m = capacity;
        table = (Node[]) new SeparateChainingLiteHashST.Node[m];
        n = 0;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public Value get(Key key) {
        int i = hash(key);
        for (Node x = table[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("Key is null");

        int i = hash(key);
        for (Node x = table[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }

        table[i] = new Node(key, val, table[i]);
        n++;

        if (n > LOAD_FACTOR_THRESHOLD * m)
            resize(2 * m);
    }

    private void resize(int newCapacity) {
        SeparateChainingLiteHashST<Key, Value> temp = new SeparateChainingLiteHashST<>(newCapacity);
        for (int i = 0; i < m; i++) {
            for (Node x = table[i]; x != null; x = x.next)
                temp.put(x.key, x.val);
        }
        this.m = temp.m;
        this.table = temp.table;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public int size() {
        return n;
    }

    public static void main(String[] args) {
        SeparateChainingLiteHashST<String, Integer> map = new SeparateChainingLiteHashST<>();

        map.put("apple", 5);
        map.put("banana", 3);
        map.put("orange", 7);
        System.out.println("apple: " + map.get("apple"));     
        System.out.println("banana: " + map.get("banana"));   
        System.out.println("grape: " + map.get("grape"));     // null

        map.put("banana", 9);
        System.out.println("banana (updated): " + map.get("banana")); // 9

        System.out.println("Contains 'orange'? " + map.contains("orange")); // true
        System.out.println("Contains 'peach'? " + map.contains("peach"));   // false

        System.out.println("Size: " + map.size()); // 3
    }
}
