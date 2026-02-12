package basic;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  The {@code ArrayListStack} class represents a last-in-first-out (LIFO) stack
 *  of generic items.
 *  It supports the usual <em>push</em> and <em>pop</em> operations, along with methods
 *  for peeking at the top item, testing if the stack is empty, and iterating through
 *  the items in LIFO order.
 *  <p>
 *  This implementation uses an ArrayList, which double the underlying array
 *  when it is full and halves the underlying array when it is one-quarter full.
 *  The <em>push</em> and <em>pop</em> operations take constant amortized time.
 *  The <em>size</em>, <em>peek</em>, and <em>is-empty</em> operations takes
 *  constant time in the worst case.
 *  <p>
 *  The code has been adapted based on Sedgewick and Wayne's Algorithms textbook (4th edition).
 * 
 *  @author Alexandra Papoutsaki
 */

 
public class ArrayListStack<E> implements Stack<E>, Iterable<E> {

    private ArrayList<E> arrayList;


    /**
     * Initializes an empty stack.
     */
    public ArrayListStack() {
        arrayList = new ArrayList<E>(2);
    }

    /**
     * Returns true if the stack does not contain any item.
     * 
     * @return true if the stack does not contain any item
     */
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

   /**
     * Returns the number of items in the stack.
     * 
     * @return the number of items in the stack.
     */
    public int size() {
        return arrayList.size();
    }

    /**
     * Adds the item to this stack.
     * @param item the item to add
     */
    public void push(E item) {
        arrayList.add(item);
    }

    /**
     * Removes and returns the item most recently added to this stack.
     * @return the item most recently added
     * @throws java.util.NoSuchElementException if this stack is empty
     */
    public E pop() {
        if (isEmpty()){
            throw new NoSuchElementException("Stack underflow");
        }
        return arrayList.remove(arrayList.size()-1);
    }


    /**
     * Returns (but does not remove) the item most recently added to this stack.
     * @return the item most recently added to this stack
     * @throws java.util.NoSuchElementException if this stack is empty
     */
    public E peek() {
        if (isEmpty()){
            throw new NoSuchElementException("Stack underflow");
        }
        return arrayList.get(arrayList.size()-1);
    }

    /**
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     * @return an iterator to this stack that iterates through the items in LIFO order.
     */
    public Iterator<E> iterator() {
        return new ReverseArrayIterator();
    }

    // a array iterator, in reverse order
    private class ReverseArrayIterator implements Iterator<E> {
        private int i;

        public ReverseArrayIterator() {
            i = arrayList.size()-1;
        }

        public boolean hasNext() {
            return i >= 0;
        }

        public E next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            E toReturn = arrayList.get(i);
            i--;
            return toReturn;
        }
    }
    
	public String toString() {

		String ret = "top -> ";

		Iterator<E> i = this.iterator();
		while (i.hasNext()) {
			ret += i.next();
			ret += " ";
		}
		return ret;
	}

    /**
     * Unit tests the {@code Stack} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        ArrayListStack<String> stack = new ArrayListStack<String>();
        stack.push("To");
        System.out.println(stack);
        stack.push("be");
        System.out.println(stack);
        stack.push("or");
        System.out.println(stack);
        stack.push("not");
        System.out.println(stack);
        stack.push("to");
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.push("be");
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.push("that");
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.push("is");
        System.out.println(stack);
    }

    
}