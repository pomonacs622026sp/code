package basic;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The {@code LinkedQueue} class represents a first-in-first-out (FIFO)
 * queue of generic items.
 * It supports the usual <em>enqueue</em> and <em>dequeue</em>
 * operations, along with methods for peeking at the first item,
 * testing if the queue is empty, and iterating through
 * the items in FIFO order.
 * <p>
 * This implementation uses a doubly linked list with a non-static nested class
 * for linked-list nodes.
 * The code has been adapted based on Sedgewick and Wayne's Algorithms textbook (4th edition).
 * 
 * @author Alexandra Papoutsaki
 */

public class LinkedQueue<E> implements Queue<E>, Iterable<E> {

    private DoublyLinkedList<E> linkedList;
    /**
     * Initializes an empty queue.
     */
    public LinkedQueue() {
        linkedList = new DoublyLinkedList<E>();
    }

    /**
     * Returns true if the queue does not contain any item.
     * 
     * @return true if the queue does not contain any item
     */
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    /**
     * Returns the number of items in this queue.
     * 
     * @return the number of items in this queue
     */
    public int size() {
        return linkedList.size();
    }

    /**
     * Returns the item least recently added to this queue.
     * 
     * @return the item least recently added to this queue
     * @throws java.util.NoSuchElementException if this queue is empty
     */
    public E peek() {
        if (isEmpty()){
            throw new NoSuchElementException("Queue underflow");
        }
        return linkedList.get(0);
    }

    /**
     * Adds the item to this queue.
     * 
     * @param item the item to add
     */
    public void enqueue(E item) {
        linkedList.addLast(item);
    }

    /**
     * Removes and returns the item on this queue that was least recently added.
     * 
     * @return the item on this queue that was least recently added
     * @throws java.util.NoSuchElementException if this queue is empty
     */
    public E dequeue() {
        if (isEmpty()){
            throw new NoSuchElementException("Queue underflow");
        }
        return linkedList.removeFirst();
    }

    /**
     * Returns a string representation of this queue.
     * 
     * @return the sequence of items in FIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder("front -> ");
        for (E item : this)
            s.append(item + " ");
        s.append("<- end");
        return s.toString();
    }

    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     * 
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    public Iterator<E> iterator() {
        return linkedList.iterator();
    }
    
    /**
     * Unit tests the {@code LinkedQueue} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        LinkedQueue<String> queue = new LinkedQueue<String>();
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