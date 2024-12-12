package structures.HeapStructures;

import java.util.ArrayList;

import structures.Interfaces.Heap;

public class MaxHeap<T extends Comparable<T>> implements Heap<T> {
    private final ArrayList<T> heap;

    // Constructor
    public MaxHeap() {
        this.heap = new ArrayList<>();
    }

    @Override
    public void insert(T value) {
        heap.add(value);
        heapifyUp(heap.size() - 1); // Restore the max-heap property
    }

    @Override
    public T extract() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        T root = heap.get(0); // Get the root element (max element)
        T last = heap.remove(heap.size() - 1); // Remove the last element

        if (!heap.isEmpty()) {
            heap.set(0, last); // Move the last element to the root
            heapifyDown(0); // Restore the max-heap property
        }

        return root;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0); // Return the root element
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // Helper method to restore max-heap property after insertion
    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;

        if (parentIndex >= 0 && heap.get(index).compareTo(heap.get(parentIndex)) > 0) {
            swap(index, parentIndex);
            heapifyUp(parentIndex); // Recursively fix the heap
        }
    }

    // Helper method to restore max-heap property after extraction
    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int largest = index;

        // Compare with left child
        if (leftChild < heap.size() && heap.get(leftChild).compareTo(heap.get(largest)) > 0) {
            largest = leftChild;
        }

        // Compare with right child
        if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(largest)) > 0) {
            largest = rightChild;
        }

        // If largest is not the current index, swap and continue heapifying down
        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    // Helper method to swap two elements in the heap
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}