package structures.LinkedStructures;

import structures.Interfaces.CircularList;

public class CircularLinkedList<T> implements CircularList<T> {
    private Node<T> head;
    private int size;

    public CircularLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            head.next = head; // Circular link
        } else {
            Node<T> current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head; // Maintain circular link
        }
        size++;
    }

    @Override
    public void addAt(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        Node<T> newNode = new Node<>(data);
        if (index == 0) {
            if (isEmpty()) {
                head = newNode;
                head.next = head;
            } else {
                Node<T> tail = head;
                while (tail.next != head) {
                    tail = tail.next;
                }
                newNode.next = head;
                head = newNode;
                tail.next = head; // Update circular link
            }
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        T data;
        if (index == 0) {
            if (size == 1) {
                data = head.data;
                head = null;
            } else {
                Node<T> tail = head;
                while (tail.next != head) {
                    tail = tail.next;
                }
                data = head.data;
                head = head.next;
                tail.next = head; // Update circular link
            }
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            data = current.next.data;
            current.next = current.next.next;
        }
        size--;
        return data;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            sb.append(current.data);
            if (i < size - 1) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}
