import java.util.Arrays;

public class QuickSort {

    private static int indentLevel = 1;

    /*
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param a array to be sorted
     */
    public static <E extends Comparable<E>> void quickSort(E[] a) {
        quickSort(a, 0, a.length - 1);
    }

    /*
     * Private helper method that sorts **subarray** from lo to hi
     */
    private static <E extends Comparable<E>> void quickSort(E[] a, int lo, int hi) {
        if (lo < hi) {
            System.out.print(" ".repeat(indentLevel * 2));
            System.out.println("quickSort called on subarray: " + Arrays.toString(Arrays.copyOfRange(a, lo, hi + 1)));
            int pivotIndex = partition(a, lo, hi);
            System.out.print(" ".repeat(indentLevel * 2));
            System.out.println("subarray after partitioning: " + Arrays.toString(Arrays.copyOfRange(a, lo, hi + 1)));
            System.out.print(" ".repeat(indentLevel * 2));
            System.out.println("pivotIndex=" + pivotIndex);
            indentLevel++;
            quickSort(a, lo, pivotIndex - 1);
            quickSort(a, pivotIndex + 1, hi);
            indentLevel--;
        } else {
            System.out.print(" ".repeat(indentLevel * 2));
            System.out.println("base case reached for subarray: " + Arrays.toString(Arrays.copyOfRange(a, lo, hi + 1)));
        }
    }

    /*
     * Partitions the subarray a[lo..hi] by choosing a[lo] as pivot. After
     * partitioning, a[lo..j-1] <= a[j] <= a[j+1..hi]. Returns the index of the
     * pivot element after partitioning.
     */
    private static <E extends Comparable<E>> int partition(E[] a, int lo, int hi) {
        E pivot = a[lo]; // Choose leftmost element as pivot
        int i = lo + 1; // Start from the next element
        int j = hi;

        System.out.print(" ".repeat(indentLevel * 2));
        System.out.println("partitioning around '" + pivot + "'");

        while (true) {
            // Move right until we find an element >= pivot
            while (i <= j && a[i].compareTo(pivot) <= 0) {
                i++;
            }
            // Move left until we find an element < pivot
            while (j >= i && a[j].compareTo(pivot) > 0) {
                j--;
            }
            // If pointers cross, break
            if (i > j) {
                break;
            }

            // Swap elements to ensure correct partitioning
            E temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            System.out.print(" ".repeat(indentLevel * 2));
            System.out.println("swapping '" + a[i] + "' and '" + a[j] + "'");
        }

        // Swap pivot into its correct position
        E temp = a[lo];
        a[lo] = a[j];
        a[j] = temp;
        System.out.print(" ".repeat(indentLevel * 2));
        System.out.println("partition complete, swapping pivot '" + a[j] + "' with '" + a[lo] + "'");

        // Return the index of the pivot element after partitioning
        return j;
    }

    public static void main(String[] args) {
        String[] a = { "S", "O", "R", "T", "M", "E" };

        System.out.println("Unsorted array: " + Arrays.toString(a));
        quickSort(a);
        System.out.println("Sorted array: " + Arrays.toString(a));

        Integer[] array1 = { 4, 1, 9, 3, 8, 2 };
        System.out.println(Arrays.toString(array1));
        quickSort(array1);
        System.out.println(Arrays.toString(array1));

        Integer[] array2 = { 5, 3, 6, 2, 4, 0, 4 };
        System.out.println(Arrays.toString(array2));
        quickSort(array2);
        System.out.println(Arrays.toString(array2));
    }
}
