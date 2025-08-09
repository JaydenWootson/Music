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
}
