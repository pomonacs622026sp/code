package basic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The {@code ResizingArrayQueue} class represents a first-in-first-out (FIFO)
 * queue of generic items.
 * It supports the usual <em>enqueue</em> and <em>dequeue</em>
 * operations, along with methods for peeking at the first item,
 * testing if the queue is empty, and iterating through
 * the items in FIFO order.
 * <p>
 * This implementation uses a resizing array, which double the underlying array
 * when it is full and halves the underlying array when it is one-quarter full.
 * The <em>enqueue</em> and <em>dequeue</em> operations take constant amortized
 * time.
 * The <em>size</em>, <em>peek</em>, and <em>is-empty</em> operations takes
 * constant time in the worst case.
 * <p>
 * The code has been adapted based on Sedgewick and Wayne's Algorithms textbook (4th edition).
 * 
 * @author Alexandra Papoutsaki
 */
public class ArrayListQueue<Item> implements Queue<Item>, Iterable<Item> {

    private ArrayList<Item> arrayList;


    /**
     * Initializes an empty queue.
     */
    public ArrayListQueue() {
        arrayList = new ArrayList<Item>(2);
    }

    /**
     * Returns true if the queue does not contain any item.
     * 
     * @return true if the queue does not contain any item
     */
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    /**
     * Returns the number of items in the queue.
     * 
     * @return the number of items in the queue.
     */
    public int size() {
        return arrayList.size();
    }

    /**
     * Adds the item to this queue.
     * 
     * @param item the item to add
     */
    public void enqueue(Item item) {
        arrayList.add(item);
    }

    /**
     * Removes and returns the item on this queue that was least recently added.
     * 
     * @return the item on this queue that was least recently added
     * @throws java.util.NoSuchElementException if this queue is empty
     */
    public Item dequeue() {
        if (isEmpty()){
            throw new NoSuchElementException("Queue underflow");
        }
        return arrayList.remove(0);
    }

    /**
     * Returns the item least recently added to this queue.
     * 
     * @return the item least recently added to this queue
     * @throws java.util.NoSuchElementException if this queue is empty
     */
    public Item peek() {
        if (isEmpty()){
            throw new NoSuchElementException("Queue underflow");
        }
        return arrayList.get(0);
    }

    public Iterator<Item> iterator() {
        return arrayList.iterator();
    }
    
	public String toString() {

		String ret = "front -> ";

		Iterator<Item> i = this.iterator();
		while (i.hasNext()) {
			ret += i.next();
			ret += " ";
		}
        ret += " <- end";
		return ret;
	}

    /**
     * Unit tests the {@code ResizingArrayQueue} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        ArrayListQueue<String> queue = new ArrayListQueue<String>();
        queue.enqueue("To");
        System.out.println(queue);
        queue.enqueue("be");
        System.out.println(queue);
        queue.enqueue("or");
        System.out.println(queue);
        queue.enqueue("not");
        System.out.println(queue);
        queue.enqueue("to");
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.enqueue("be");
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.enqueue("that");
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.enqueue("is");
        System.out.println(queue);
    }

}