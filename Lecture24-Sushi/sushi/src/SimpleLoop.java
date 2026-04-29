public class SimpleLoop {

    static int sushiForTwo(int[] sushiArray) {
        int currentSushi = 0;
        int sushiInARow = 0;
        int prevSushiInARow = 0;
        int maxOfMins = 0;

        for (int sushi : sushiArray) {
            if (sushi == currentSushi) {
                sushiInARow++;
            } else {
                if (prevSushiInARow == 0) {
                    prevSushiInARow = sushiInARow;
                    sushiInARow = 1;
                } else {
                    var min = Math.min(sushiInARow, prevSushiInARow);
                    maxOfMins = Math.max(maxOfMins, min);
                    prevSushiInARow = sushiInARow;
                    sushiInARow = 1;
                }
                currentSushi = sushi;
            }
        }

        var min = Math.min(sushiInARow, prevSushiInARow);
        maxOfMins = Math.max(maxOfMins, min);

        return maxOfMins * 2;
    }

    public static void main(String[] args) {

        int[] arr1 = { 2, 2, 2, 1, 1, 2, 2 };
        int[] arr2 = { 1, 2, 1, 2, 1, 2 };
        int[] arr3 = { 2, 2, 1, 1, 1, 2, 2, 2, 2 };

        System.out.println(SimpleLoop.sushiForTwo(arr1) == 4);
        System.out.println(SimpleLoop.sushiForTwo(arr2) == 2);
        System.out.println(SimpleLoop.sushiForTwo(arr3) == 6);

    }
}
