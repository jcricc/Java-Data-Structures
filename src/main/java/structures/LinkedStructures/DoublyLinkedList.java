package structures.LinkedStructures;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value, null, head);
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size++;
    }

    public void addLast(T value) {
        Node<T> newNode = new Node<>(value, tail, null);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = newNode;
        }
        size++;
    }

    public T removeFirst() {
        if (head == null) {
            throw new RuntimeException("Empty list");
        }
        T value = head.value;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        else {
            tail = null;
        }
        size--;
        return value;
    }

    public T removeLast() {
        if (tail == null) {
            throw new RuntimeException("Empty list");
        }
        T value = tail.value;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        }
        else {
            head = null;
        }
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void traverseForward() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void traverseBackward() {
        Node<T> current = tail;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.prev;
        }
        System.out.println();
    }

    private static class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        Node(T value, Node<T> prev, Node<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
