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
        if (index < 0 || index > size) throw new IllegalArgumentException("Invaild index");
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
}
