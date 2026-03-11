public class BinaryHeap<E extends Comparable<E>> {
    private E[] a; //actual array
    private int n; //size of array

    @SuppressWarnings("unchecked")
    public BinaryHeap(int capacity) {
        a = (E[]) new Comparable[capacity + 1]; // Index 0 is unused
        n = 0;
    }

    private void swim(int k) {
        while (k > 1 && a[k / 2].compareTo(a[k]) < 0) {
            E temp = a[k];
            a[k] = a[k / 2];
            a[k / 2] = temp;
            k = k / 2;
        }
    }

    public void insert(E x) {
        a[++n] = x;
        swim(n);
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && a[j].compareTo(a[j + 1]) < 0) j++;
            if (a[k].compareTo(a[j]) >= 0) break;
            E temp = a[k];
            a[k] = a[j];
            a[j] = temp;
            k = j;
        }
    }

    /* @pre: n > 0 */
    public E deleteMax() {
        E max = a[1]; //max element is always the root
        a[1] = a[n--]; //swap with the last element and decrement size
        sink(1);
        return max;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public static void main(String[] args) {
        BinaryHeap<Integer> heap = new BinaryHeap<>(10);
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        heap.insert(30);
        
        System.out.println(heap.deleteMax()); // 30
        System.out.println(heap.deleteMax()); // 20
        System.out.println(heap.deleteMax()); // 10
    }
}
