public class DoubleLinkedList<T extends Comparable<T>> {
    private class Node {
        T data;
        Node prev, next;
        Node(T data) {this.data = data; }
    }

    private Node head, tail;
    private int size = 0;

    public void DoublyLinkedList() {}
}
