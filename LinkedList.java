package structures;

public class LinkedList<T> {
    private class Node {
        T value;
        Node next;

        Node(T value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void add(T value) {
        Node node = new Node(value);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }

        size++;
    }

    public boolean contains(T value) {
        Node current = head;

        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.value;
    }

    public boolean remove(T value) {
        Node current = head;
        Node previous = null;

        while (current != null) {
            if (current.value.equals(value)) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }

                if (current == tail) {
                    tail = previous;
                }

                size--;
                return true;
            }

            previous = current;
            current = current.next;
        }

        return false;
    }

    public int size() {
        return size;
    }
}
