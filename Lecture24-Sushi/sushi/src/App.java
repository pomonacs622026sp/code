public class App {
    public static void main(String[] args) throws Exception {
        final int n = 10_000_000;
        var sushiArray = new int[n];

        for (int i = 0; i < n; i++) {
            sushiArray[i] = (int) (Math.random() * 2) + 1;
        }

        var start = System.nanoTime();
        var totalFromSimpleLoop = SimpleLoop.sushiForTwo(sushiArray);
        var simpleLoopTimeNs = System.nanoTime() - start;

        start = System.nanoTime();
        var totalFromStreams = WithStreams.sushiForTwo(sushiArray);
        var streamsTimeNs = System.nanoTime() - start;

        System.out.printf("Simple loop time: %.3f ms%n", simpleLoopTimeNs / 1_000_000.0);
        System.out.printf("Streams time: %.3f ms%n", streamsTimeNs / 1_000_000.0);

        System.out.println("\nTotal from simple loop: " + totalFromSimpleLoop);
        System.out.println("Total from streams: " + totalFromStreams);

    }
}
