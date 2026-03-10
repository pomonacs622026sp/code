import java.util.Arrays;

public class HeapSort {
    public static <E extends Comparable<E>> void sort(E[] input) {
        int n = input.length;

        // create a 1-indexed array to make the math cleaner for this demo
        // (though you shouldn't do this in practice)
        @SuppressWarnings("unchecked")
        E[] a = (E[]) new Comparable[n + 1];
        System.arraycopy(input, 0, a, 1, n);

        // Heap construction in O(n)
        for (int k = n / 2; k >= 1; k--) {
            sink(a, k, n);
        }
        System.out.println("Intermediate established heap: " + Arrays.toString(a));

        // Sorting in O(nlogn)
        while (n > 1) {
            swap(a, 1, n--);
            sink(a, 1, n);
        }

        // Copy sorted elements back to input array - again, you shouldn't do this in
        // practice
        System.arraycopy(a, 1, input, 0, input.length);
    }

    // a new sink that takes a & n in addition to k, since we want all our sorting
    // methods to be static
    private static <E extends Comparable<E>> void sink(E[] a, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && a[j].compareTo(a[j + 1]) < 0)
                j++;
            if (a[k].compareTo(a[j]) >= 0)
                break;
            swap(a, k, j);
            k = j;
        }
    }

    private static <E> void swap(E[] a, int i, int j) {
        E temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] a = { 2, 7, 26, 25, 19, 17, 1, 90, 3, 36 };
        System.out.println("Unsorted: " + Arrays.toString(a));

        sort(a);

        System.out.println("Sorted: " + Arrays.toString(a));
    }
}
