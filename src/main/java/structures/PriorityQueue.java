package structures;

import java.util.ArrayList;

public class PriorityQueue<T extends Comparable<T>> {
    private final ArrayList<T> heap;

    public PriorityQueue() {
        this.heap = new ArrayList<>();
    }

    public void insert(T value) {
        heap.add(value);
        bubbleUp(heap.size() - 1);
    }

    public T remove() {
        if (isEmpty()) {
            throw new RuntimeException("Priority queue is empty");
        }
        T root = heap.get(0);
        T last = heap.remove(heap.size() - 1);
        if (!isEmpty()) {
            heap.set(0, last);
            bubbleDown(0);
        }
        return root;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Priority queue is empty");
        }
        return heap.get(0);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void bubbleUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            }
            else {
                break;
            }
        }
    }

    public void bubbleDown(int index) {
        int size = heap.size();
        while (true) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int smallest = index;

            if (leftChild < size && heap.get(leftChild).compareTo(heap.get(smallest)) < 0) {
                smallest = leftChild;
            }

            if (rightChild < size && heap.get(rightChild).compareTo(heap.get(smallest)) < 0) {
                smallest = rightChild;
            }

            if (smallest == index) {
                break;
            }

            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
