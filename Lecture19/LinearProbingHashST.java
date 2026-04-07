public class LinearProbingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 16;
    private static final double LOAD_FACTOR_THRESHOLD = 0.5;

    private int n; // number of key-value pairs
    private int m; // size of the table
    private Entry[] table;

    private class Entry {
        Key key;
        Value val;

        Entry(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }

    public LinearProbingHashST() {
        this(INIT_CAPACITY);
    }

    public LinearProbingHashST(int capacity) {
        m = capacity;
        table = (Entry[]) new LinearProbingHashST.Entry[m];
        n = 0;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("Key is null");

        if (n >= m * LOAD_FACTOR_THRESHOLD) resize(2 * m);

        int i = hash(key);
        while (table[i] != null) {
            if (key.equals(table[i].key)) {
                table[i].val = val;
                return;
            }
            i = (i + 1) % m;
        }

        table[i] = new Entry(key, val);
        n++;
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("Key is null");

        int i = hash(key);
        while (table[i] != null) {
            if (key.equals(table[i].key))
                return table[i].val;
            i = (i + 1) % m;
        }
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public int size() {
        return n;
    }

    private void resize(int capacity) {
        LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<>(capacity);
        for (int i = 0; i < m; i++) {
            if (table[i] != null) {
                temp.put(table[i].key, table[i].val);
            }
        }
        this.m = temp.m;
        this.table = temp.table;
    }

    public static void main(String[] args) {
        LinearProbingHashST<String, Integer> map = new LinearProbingHashST<>();

        map.put("cat", 4);
        map.put("dog", 7);
        map.put("bat", 9);
        map.put("dog", 12);

        System.out.println("cat: " + map.get("cat")); 
        System.out.println("dog: " + map.get("dog"));
        System.out.println("fox: " + map.get("fox")); // null

        System.out.println("Contains 'bat'? " + map.contains("bat"));
        System.out.println("Contains 'lion'? " + map.contains("lion"));

        System.out.println("Size: " + map.size()); // 3
    }
}
