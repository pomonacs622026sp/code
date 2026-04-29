import com.ginsberg.gatherers4j.Gatherers4j;

import java.util.Arrays;

public class WithStreams {

    static int sushiForTwo(int[] sushiArray) {
        return 2 * Arrays.stream(sushiArray)
                .boxed()
                .gather(Gatherers4j.group())
                .map(java.util.List::size)
                .gather(Gatherers4j.zipWithNext())
                .map(w -> Math.min(w.get(0), w.get(1)))
                .max(Integer::compare)
                .orElse(0);

        // I found `.toList()` helpful when debugging each step (i.e., call `.toList()`
        // and then print the result)
        // .toList();
    }

    public static void main(String[] args) {

        int[] arr1 = { 2, 2, 2, 1, 1, 2, 2 };
        int[] arr2 = { 1, 2, 1, 2, 1, 2 };
        int[] arr3 = { 2, 2, 1, 1, 1, 2, 2, 2, 2 };

        System.out.println(WithStreams.sushiForTwo(arr1) == 4);
        System.out.println(WithStreams.sushiForTwo(arr2) == 2);
        System.out.println(WithStreams.sushiForTwo(arr3) == 6);

    }
}
