public class DoubleLinkedList<T extends Comparable<T>> {
    private class Node {
        T data;
        Node prev, next;
        Node(T data) {this.data = data; }
    }

    private Node head, tail;
    private int size = 0;

    public void DoublyLinkedList() {}

    public Node append(T data) {
        Node newNode = new Node(data);
        if (tail == null) head = tail = newNode;
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return head;
    }

    public Node insert(int index, T data) {
        if (index < 0 || index > size) throw new IllegalArgumentException("Invalid index");
        Node newNode = new Node(data);
        if (index == 0) {
            newNode.next = head;
            if (head != null) head.prev = newNode;
            head = newNode;
            if (tail == null) tail = newNode;
        } else if (index == size) {
            return append(data);
        } else {
            Node curr = getNode(index);
            newNode.prev = curr.prev;
            newNode.next = curr;
            curr.prev.next = newNode;
            curr.prev = newNode;
        }
        size++;
        return newNode;
    }

    public Node delete(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("Invalid index");
        Node toDelete = getNode(index);
        if (toDelete.prev != null) toDelete.prev.next = toDelete.next;
        else head = toDelete.next;
        if (toDelete.next != null) toDelete.next.prev = toDelete.prev;
        else tail = toDelete.prev;
        size--;
        return toDelete;
    }

    public int getIndex(T data) {
        Node current = head;
        int idx = 0;
        while (current != null) {
            if (current.data.equals(data)) return idx;
            current = current.next;
            idx++;
        }
        return -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data).append("->");
            current = current.next;
        }
        return sb.append("NULL").toString();
    }

    private Node getNode(int index) {
        Node curr = head;
        for (int i = 0; i < index; i++) curr = curr.next;
        return curr;
    }
}
