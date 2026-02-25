import java.util.Arrays;

public class MergeSort {

	@SuppressWarnings("unchecked")
	public static <E extends Comparable<E>> void mergeSort(E[] a) {
		E[] aux = (E[]) new Comparable[a.length];
		mergeSort(a, aux, 0, a.length - 1);
	}
	private static <E extends Comparable<E>> void mergeSort(E[] a, E[] aux, int lo, int hi) {
		if (hi <= lo){
	        return;
		}
		int mid = lo + (hi - lo) / 2;
		mergeSort(a, aux, lo, mid);
		mergeSort(a, aux, mid+1, hi);
		merge(a, aux, lo, mid, hi);
	}

	private static <E extends Comparable<E>> void merge(E[] a, E[] aux, int lo, int mid, int hi) {
		for (int k = lo; k <= hi; k++){
			aux[k] = a[k];
		}
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) { // ran out of elements in the left subarray
				a[k] = aux[j++];
			} else if (j > hi) { // ran out of elements in the right subarray
				a[k] = aux[i++];
			} else if (aux[j].compareTo(aux[i]) < 0) {
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}
		}
	}


	public static void main(String[] args) {
		String[] array = { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
		System.out.println(Arrays.toString(array));
		mergeSort(array);
		System.out.println(Arrays.toString(array));
	}
}