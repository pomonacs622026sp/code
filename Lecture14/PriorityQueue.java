public class PriorityQueue<E extends Comparable<E>> {
    private BinaryHeap<E> heap;

    public PriorityQueue(int capacity) {
        heap = new BinaryHeap<>(capacity);
    }

    public void enqueue(E item) {
        heap.insert(item);
    }

    /*@pre: queue is not empty */
    public E dequeue() {
        return heap.deleteMax();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(10);
        pq.enqueue(10);
        pq.enqueue(20);
        pq.enqueue(5);
        pq.enqueue(30);
        
        System.out.println("Dequeue: " + pq.dequeue()); // 30
        System.out.println("Dequeue: " + pq.dequeue()); // 20
        System.out.println("Dequeue: " + pq.dequeue()); // 10
        System.out.println("Dequeue: " + pq.dequeue()); // 5
    }
}
