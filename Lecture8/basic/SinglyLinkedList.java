package basic;

import java.util.Iterator;

/**
 * The {@code SinglyLinkedList} class represents a singly linked list. It has
 * been adapted based on Sedgewick and Wayne's Algorithms textbook (4th
 * edition).
 * 
 * @author Alexandra Papoutsaki
 * @author Aden Siebel
 *
 */
public class SinglyLinkedList<E> implements List<E>, Iterable<E>{
	private Node head; // head of the singly linked list
	private int size; // number of nodes in the singly linked list

	/**
	 * This nested class defines the nodes in the singly linked list with a value
	 * and pointer to the next node they are connected.
	 */
	private class Node {
		E element;
		Node next;
	}

	/**
	 * Returns true if the singly linked list does not contain any element.
	 * 
	 * @return true if the singly linked list does not contain any element
	 */
	public boolean isEmpty() {
		return head == null; // size() == 0
	}

	/**
	 * Returns the number of elements in the singly linked list.
	 * 
	 * @return the number of elements in the singly linked list
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns element at the specified index.
	 * 
	 * @param index
	 *            the index of the element to be returned
	 * @return the element at specified index
     * @pre: 0<=index<size
	 */
	public E get(int index) {
		if (index >= size || index < 0){
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }

        Node finger = head;
		// search for index-th element or end of list
		while (index > 0) {
			finger = finger.next;
			index--;
		}
		return finger.element;
	}

	/**
	 * Inserts the specified element at the head of the singly linked list.
	 * 
	 * @param element
	 *            the element to be inserted
	 */
	public void add(E element) {
		// Save the old node
		Node oldHead = head;

		// Make a new node and assign it to head. Fix pointers.
		head = new Node();
		head.element = element;
		head.next = oldHead;

		size++; // increase number of nodes in singly linked list.
	}

	/**
	 * Inserts the specified element at the specified index.
	 * 
	 * @param index
	 *            the index to insert the element
	 * @param element
	 *            the element to insert
     * @pre: 0<=index<=size()
	 */
	public void add(int index, E element) {
        if (index > size || index < 0){
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
		if (index == 0) {
			add(element);
		} else {

			Node previous = null;
			Node finger = head;
			// search for index-th position
			while (index > 0) {
				previous = finger;
				finger = finger.next;
				index--;
			}
			// create new value to insert in correct position.
			Node current = new Node();
			current.next = finger;
			current.element = element;
			// make previous value point to new value.
			previous.next = current;

			size++;
		}
	}

	/**
	 * Replaces the element at the specified index with the specified E.
	 * 
	 * @param index the index of the element to replace
	 * @param element element to be stored at specified index
	 * @return the old element that was replaced
	 * @pre: 0<=index<size
	 */
	public E set(int index, E element) {
		if (index >= size || index < 0){
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
		}

		Node finger = head;
		// search for index-th position
		while (index > 0) {
			finger = finger.next;
			index--;
		}
		// reference old element at index
		E old = finger.element;
		
		//replace element at finger with new element
		finger.element = element;

		return old;

	}

	/**
	 * Retrieves and removes the head of the singly linked list.
	 * 
	 * @return the head of the singly linked list.
	 */
	public E remove() {
		Node temp = head;
		// Fix pointers.
		head = head.next;

		size--;

		return temp.element;
	}

	/**
	 * Retrieves and removes the element at the specified index.
	 * 
	 * @param index
	 *            the index of the element to be removed
	 * @return the element previously at the specified index
     * @pre: 0<=index<size()
	 */
	public E remove(int index) {
        if (index >= size || index < 0){
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
		if (index == 0) {
			return remove();
		} else {
			Node previous = null;
			Node finger = head;
			// search for value indexed, keep track of previous
			while (index > 0) {
				previous = finger;
				finger = finger.next;
				index--;
			}
			previous.next = finger.next;

			size--;
			// finger's value is old value, return it
			return finger.element;
		}

	}

	/**
	 * Clears the singly linked list of all elements.
	 */
	public void clear() {
		head = null;
		size = 0;
	}

	/**
	 * Converts the singly linked list to a String.
	 */
	public String toString() {
		if (isEmpty()) {
			return "Singly Linked List: [] Head: null, Size :0";
		}

		String ret = "Singly Linked List: [";
		Iterator<E> i = this.iterator();
		while (i.hasNext()) {
			ret += i.next();
			ret += "->";
		}
		ret = ret.substring(0, ret.length() - 2);

		ret += "] Head: ";
		ret += head.element;
		ret += ", Size: " + size;
		return ret;
	}

	/**
	 * Constructs an iterator for the singly linked list.
	 */
	public Iterator<E> iterator() {
		return new SinglyLinkedListIterator();
	}

	/**
	 * A subclass that defines the iterator for the singly linked list.
	 */
	private class SinglyLinkedListIterator implements Iterator<E> {
		private Node current = head;

		public boolean hasNext() {
			return current != null;
		}

		public void remove() {
		}

		public E next() {
			E element = current.element;
			current = current.next;
			return element;
		}
	}

	public static void main(String args[]) {
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		sll.add(1);
		System.out.println(sll);
		sll.add(20);
		System.out.println(sll);
		sll.add(1, 2);
		System.out.println(sll);
		System.out.println(sll.set(1, 47));
		System.out.println(sll);
		sll.add(35);
		System.out.println(sll);
		sll.add(40);
		System.out.println(sll);
		System.out.println(sll.size());
		System.out.println(sll.remove());
		System.out.println(sll);
		System.out.println(sll.remove());
		System.out.println(sll);
		System.out.println(sll.remove());
		System.out.println(sll);
		sll.add(1);
		System.out.println(sll);
		sll.add(3);
		System.out.println(sll);
		System.out.println(sll.remove());
		System.out.println(sll);
		sll.clear();
		System.out.println(sll);
		System.out.println(sll.size());
		sll.add(1);
		System.out.println(sll);

	}

}