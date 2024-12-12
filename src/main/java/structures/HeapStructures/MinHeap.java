package structures.HeapStructures;

import java.util.ArrayList;

import structures.Interfaces.Heap;

public class MinHeap<T extends Comparable<T>> implements Heap<T> {
    private final ArrayList<T> heap; // Underlying data structure

    // Constructor
    public MinHeap() {
        this.heap = new ArrayList<>();
    }

    @Override
    public void insert(T value) {
        heap.add(value); // Add at the end
        heapifyUp(heap.size() - 1); // Fix the heap property
    }

    @Override
    public T extract() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        T root = heap.get(0); // Smallest element (root of heap)
        T last = heap.remove(heap.size() - 1); // Remove last element
        if (!heap.isEmpty()) {
            heap.set(0, last); // Move the last element to the root
            heapifyDown(0); // Fix the heap property
        }
        return root;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0); // Return the root
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // Helper method to restore heap property after insertion
    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        if (parentIndex >= 0 && heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
            swap(index, parentIndex);
            heapifyUp(parentIndex); // Recursively fix the heap
        }
    }

    // Helper method to restore heap property after extraction
    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int smallest = index;

        if (leftChild < heap.size() && heap.get(leftChild).compareTo(heap.get(smallest)) < 0) {
            smallest = leftChild;
        }

        if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(smallest)) < 0) {
            smallest = rightChild;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest); // Recursively fix the heap
        }
    }

    // Helper method to swap two elements in the heap
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
