public class SinglyLinkedList<E> implements List<E> {

    private class Node {
        E element;
        Node next;
    }

    private Node head;
    private int size;

    // adds to the head of the list
    public void add(E element) {
        // Save the old node
        Node oldHead = head;

        // Make a new node and assign it to head. Fix pointers.
        head = new Node();
        head.element = element;
        head.next = oldHead;

        // increment size
        size++;
    };

    // adds to the tail of the list
    public void addLast(E element) {

        Node finger = head;
        while (finger.next != null) {
            finger = finger.next;
        }

        Node n = new Node();
        n.element = element;
        finger.next = n;
        size++;
    };

    /**
     * Inserts the specified element at the specified index.
     *
     * @param index   the index to insert the element
     * @param element the element to insert
     * @pre: 0<=index<=size()
     */
    public void add(int index, E element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        if (index == 0) {
            add(element); // can call already implemented add
        } else {
            Node previous = null;
            Node finger = head;
            // search for index-th position
            for (int i = 0; i < index; i++) {
                previous = finger;
                finger = finger.next;
            }
            // create new value to insert in correct position
            Node current = new Node();
            current.next = finger;
            current.element = element;
            // make previous value point to new value
            previous.next = current;

            size++;
        }

    }

    /**
     * Clears the singly linked list of all elements.
     */
    public void clear() {
        head = null;
        size = 0;
    }

    public E get(int index) {
        Node finger = head;

        // search for index-th element or end of list
        // through following next pointers
        for (int i = 0; i < index; i++) {
            finger = finger.next;
        }
        return finger.element;
    };

    public boolean isEmpty() {
        return head == null;
    };

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
     * @param index the index of the element to be removed
     * @return the element previously at the specified index
     * @pre: 0<=index<size()
     */
    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        if (index == 0) {
            return remove();
        } else {
            Node previous = null;
            Node finger = head;
            // search for value indexed, keep track of previous
            for (int i = 0; i < index; i++) {
                previous = finger;
                finger = finger.next;
            }
            previous.next = finger.next;

            size--;
            // finger's value is old value, return it
            return finger.element;
        }
    }

    /**
     * Replaces the element at the specified index with the specified E.
     *
     * @param index   the index of the element to replace
     * @param element element to be stored at specified index
     * @return the old element that was replaced
     * @pre: 0<=index<size
     */
    public E set(int index, E element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }

        Node finger = head;
        // search for index-th position
        for (int i = 0; i < index; i++) {
            finger = finger.next;
        }
        // reference old element at index
        E old = finger.element;

        // replace element at finger with new element
        finger.element = element;

        return old;

    }

    // returns size of list that starts at node node
    private int size(Node node) {
        // base case - nothing
        if (node == null) {
            return 0;
        }
        // recursive case - 1 for current node + size of next chain
        return 1 + size(node.next);
    }

    public int sizeV1() {
        return size(head);
    };

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        sll.add(4);
        sll.add(10);
        System.out.println(sll);
        System.out.println(sll.get(0).toString()); // 10 - add to head
        System.out.println(sll.get(1).toString()); // 4
        sll.addLast(5);
        System.out.println(sll.get(2).toString()); // 5
        System.out.println(sll.size());

    }

}
