import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
* Adapted from https://raw.githubusercontent.com/reneargento/algorithms-sedgewick-wayne/master/src/chapter2/section2/Exercise6.java
*/

public class ArrayAccesses {

    private static int numberOfArrayAccesses;

    public static void main(String[] args) {

        int initialArraySize = 1;
        int numberOfExperiments = 512;

        Map<Integer, Comparable[]> allInputArrays = generateAllArrays(initialArraySize, numberOfExperiments);

        System.out.printf("%6s %15s %11s\n", "N", "Array Accesses", "Upper Bound");
        System.out.println("MergeSort");
        doExperiments(1, 512, allInputArrays);    
    }

    private static void doExperiments(int arrayLength, int numberOfExperiments,
                                      Map<Integer, Comparable[]> allInputArrays) {

        for (int i = 0; i < numberOfExperiments; i++) {

            numberOfArrayAccesses = 0;

            Comparable[] originalArray = allInputArrays.get(i);
            Comparable[] array = new Comparable[originalArray.length];
            System.arraycopy(originalArray, 0, array, 0, originalArray.length);
            mergeSort(array);
            printExperiment(arrayLength);

            arrayLength++;
        }
    }

    private static Map<Integer, Comparable[]> generateAllArrays(int initialArraySize, int numberOfExperiments) {

        Map<Integer, Comparable[]> allArrays = new HashMap<>();

        int arraySize = initialArraySize;

        for (int i = 0; i < numberOfExperiments; i++) {
            Comparable[] array = generateRandomArray(arraySize);
            allArrays.put(i, array);

            arraySize++;
        }

        return allArrays;
    }

    private static Comparable[] generateRandomArray(int arrayLength) {
        Comparable[] array = new Comparable[arrayLength];
        Random rand = new Random();
        for (int i = 0; i < arrayLength; i++) {
            array[i] = rand.nextInt();
        }

        return array;
    }


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
            numberOfArrayAccesses += 2;
		}
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) { // ran out of elements in the left subarray
				a[k] = aux[j++];
                numberOfArrayAccesses += 2;

			} else if (j > hi) { // ran out of elements in the right subarray
				a[k] = aux[i++];
                numberOfArrayAccesses += 2;

			} else if (aux[j].compareTo(aux[i]) < 0) {
				a[k] = aux[j++];
                numberOfArrayAccesses += 4;

			} else {
				a[k] = aux[i++];
                numberOfArrayAccesses += 4;

			}

		}
	}


    private static void printExperiment(int arrayLength) {
        double upperBound = 6 * arrayLength * (Math.log10(arrayLength) / Math.log10(2));

        System.out.printf("%6d %15d %11.0f\n", arrayLength, numberOfArrayAccesses, upperBound);
    }
}