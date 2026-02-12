package basic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The {@code LinkedStack} class represents a last-in-first-out (LIFO) stack of
 * generic items.
 * It supports the usual <em>push</em> and <em>pop</em> operations, along with
 * methods
 * for peeking at the top item, testing if the stack is empty, and iterating
 * through
 * the items in LIFO order.
 * <p>
 * This implementation uses a singly linked list with a non-static nested class
 * for
 * linked-list nodes.
 * The <em>push</em>, <em>pop</em>, <em>peek</em>, <em>size</em>, and
 * <em>is-empty</em>
 * operations all take constant time in the worst case.
 * <p>
 * The code has been adapted based on Sedgewick and Wayne's Algorithms textbook
 * (4th edition).
 *
 * @author Alexandra Papoutsaki
 */

public class LinkedStack<E> implements Stack<E>, Iterable<E> {

    private SinglyLinkedList<E> linkedList;

    /**
     * Initializes an empty stack.
     */
    public LinkedStack() {
        linkedList = new SinglyLinkedList<E>();
    }

    /**
     * Returns true if the stack does not contain any item.
     *
     * @return true if the stack does not contain any item
     */
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    /**
     * Returns the number of items in the stack.
     *
     * @return the number of items in the stack.
     */
    public int size() {
        return linkedList.size();
    }

    /**
     * Adds the item to this stack.
     *
     * @param item the item to add
     */
    public void push(E item) {
        linkedList.add(item);
    }

    /**
     * Removes and returns the item most recently added to this stack.
     *
     * @return the item most recently added
     * @throws java.util.NoSuchElementException if this stack is empty
     */
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        return linkedList.remove();
    }

    /**
     * Returns (but does not remove) the item most recently added to this stack.
     *
     * @return the item most recently added to this stack
     * @throws java.util.NoSuchElementException if this stack is empty
     */
    public E peek() {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");
        {
            return linkedList.get(0);
        }
    }

    /**
     * Returns a string representation of this stack.
     *
     * @return the sequence of items in the stack in LIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder("top -> ");
        for (E item : this)
            s.append(item + " ");
        return s.toString();
    }

    /**
     * Returns an iterator to this stack that iterates through the items in LIFO
     * order.
     *
     * @return an iterator to this stack that iterates through the items in LIFO
     *         order.
     */
    public Iterator<E> iterator() {
        return linkedList.iterator();
    }

    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<String>();
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
