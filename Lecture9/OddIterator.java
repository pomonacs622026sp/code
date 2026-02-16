import java.util.*;

public class OddIterator implements Iterator<Integer> {

    // The array whose odd values are to be enumerated
    private ArrayList<Integer> myArrayList;

    // any other instance variables you might need
    int counter;

    // An iterator over the odd values of myArrayList
    public OddIterator(ArrayList<Integer> myArrayList) {
        this.myArrayList = myArrayList;
        counter = 0;
    }

    // runs in O(n) time
    public boolean hasNext() {
        for (int i = counter; i < myArrayList.size(); i++) {
            if (myArrayList.get(i) % 2 == 1) {
                counter = i;
                return true;
            }
        }
        return false;
    }

    // runs in O(1) time
    public Integer next() {
        return myArrayList.get(counter++);
    }

    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<Integer>();
        myList.add(7);
        myList.add(4);
        myList.add(1);
        myList.add(3);
        myList.add(0);

        System.out.println("using odd iterator");

        OddIterator oi = new OddIterator(myList);
        while (oi.hasNext()) { // have to explicitly use the iterator methods to just get the odds
            System.out.println(oi.next());
        }

        System.out.println("using default");

        for (int odd : myList) {
            System.out.println(odd); // prints out all the numbers
            // since we are using the default arraylist iterator,
            // not our custom one!
        }
    }
}
