public class DoublyLinkedList<E> implements List<E> {
	private Node head; // head of the doubly linked list
	private Node tail; // tail of the doubly linked list
	private int size; // number of nodes in the doubly linked list

	/**
	 * This nested class defines the nodes in the doubly linked list with a value
	 * and pointers to the previous and next node they are connected.
	 */
	private class Node {
		E element;
		Node next;
		Node prev;
	}

	/**
	 * Returns true if the doubly linked list does not contain any element.
	 * 
	 * @return true if the doubly linked list does not contain any element
	 */
	public boolean isEmpty() {
		return size == 0; // return head == null && tail == null;
	}

	/**
	 * Returns the number of elements in the doubly linked list.
	 * 
	 * @return the number of elements in the doubly linked list
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns element at the specified index.
	 * 
	 * @param index
	 *              the index of the element to be returned
	 * @return the element at specified index
	 * @pre: 0<=index<size
	 */
	public E get(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
		}
		if (index == 0) {
			return head.element;
		} else if (index == size - 1) {
			return tail.element;
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
	 * Inserts the specified element at the head of the doubly linked list.
	 * 
	 * @param element
	 *             the element to be inserted
	 */
	public void addFirst(E element) {
		// Save the old node
		Node oldHead = head;

		// Make a new node and assign it to head. Fix pointers.
		head = new Node();
		head.element = element;
		head.next = oldHead;
		head.prev = null;

		// if first node to be added, adjust tail to it.
		if (tail == null) {
			tail = head;
		} else {
			oldHead.prev = head;
		}
		size++; // increase number of nodes in doubly linked list.
	}

	/**
	 * Inserts the specified element at the tail of the doubly linked list.
	 * 
	 * @param element
	 *             the element to be inserted
	 */
	public void addLast(E element) {
		// Save the old node
		Node oldTail = tail;

		// Make a new node and assign it to tail. Fix pointers.
		tail = new Node();
		tail.element = element;
		tail.next = null;
		tail.prev = oldTail;

		// if first node to be added, adjust head to it.
		if (head == null) {
			head = tail;
		} else {
			oldTail.next = tail;
		}
		size++;
	}

	/**
	 * Inserts the specified element at the tail of the doubly linked list.
	 * 
	 * @param element
	 *             the element to be inserted
	 */
	public void add(E element) {
		addLast(element);
	}

	

	/**
	 * Inserts the specified element at the specified index.
	 * 
	 * @param index
	 *              the index to insert the element
	 * @param element
	 *              the element to insert
	 * @pre: 0<=index<=size
	 */
	public void add(int index, E element) {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
		}
		if (index == 0) {
			addFirst(element);
		} else if (index == size) {
			addLast(element);
		} else {

			Node previous = null;
			Node finger = head;
			// search for index-th position
			while (index > 0) {
				previous = finger;
				finger = finger.next;
				index--;
			}
			// create new value to insert in correct position
			Node current = new Node();
			current.element = element;
			current.next = finger;
			current.prev = previous;
			previous.next = current;
			finger.prev = current;

			size++;
		}
	}

	/**
	 * Replaces the element at the specified index with the specified E.
	 * 
	 * @param index
	 *              the index to insert the element
	 * @param element
	 *              the element to insert
	 * @pre: 0<=index<size
	 */
	public E set(int index, E element) {
		if (index >= size || index < 0) {
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
		//replace element at finer with new element
		finger.element = element;

		return old;

	}

	/**
	 * Retrieves and removes the head of the doubly linked list.
	 * 
	 * @return the head of the doubly linked list.
	 */
	public E removeFirst() {
		Node oldHead = head;
		// Fix pointers.
		head = head.next;
		// if there was only one node in the doubly linked list.
		if (head == null) {
			tail = null; // remove final node.
			
		} else {
			head.prev = null;
		}
		size--;

		return oldHead.element;
	}

	/**
	 * Retrieves and removes the tail of the doubly linked list.
	 * 
	 * @return the tail of the doubly linked list.
	 */
	public E removeLast() {

		Node temp = tail;
		tail = tail.prev;

		// if there was only one node in the doubly linked list.
		if (tail == null) {
			head = null;
		} else {
			tail.next = null;
		}
		size--;
		return temp.element;
	}

	/**
	 * Retrieves and removes the head of the doubly linked list.
	 * 
	 * @return the head of the doubly linked list.
	 */
	public E remove() {
		return removeFirst();
	}

	/**
	 * Retrieves and removes the element at the specified index.
	 * 
	 * @param index
	 *              the index of the element to be removed
	 * @return the element previously at the specified index
	 * @pre: 0<=index<size
	 */
	public E remove(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
		}
		if (index == 0) {
			return removeFirst();
		} else if (index == size - 1) {
			return removeLast();
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
			finger.next.prev = previous;

			size--;
			// finger's value is old value, return it
			return finger.element;
		}

	}

	/**
	 * Clears the doubly linked list of all elements.
	 */
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}


	public static void main(String args[]) {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
		dll.addFirst(1);
		dll.addFirst(2);
		System.out.println(dll.get(1));

	}
}