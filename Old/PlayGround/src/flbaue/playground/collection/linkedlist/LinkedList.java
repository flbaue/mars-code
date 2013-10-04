package flbaue.playground.collection.linkedlist;

/**
 * Florian Bauer
 * flo.bauer@gmx.net
 * Date: 13.06.13
 * Time: 19:06
 */
public class LinkedList<E> {

    private Node head;
    private Node tail;
    private int size;

    public int getSize(){
        return size;
    }

    public void addElement(E element) {
        Node newNode = new Node(null, null, element);
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
        size++;
    }

    /** CAUTION: not verified! */
    public void addElementAtIndex(final int index, final E element) {
        assertIndex(index);

        Node newNode = new Node(null, null, element);
        Node oldNode = getNodeAtIndex(index);

        if(oldNode != head) oldNode.getPrevious().setNext(newNode);
        if(oldNode == head) head = newNode;
        newNode.setPrevious(oldNode.getPrevious());
        newNode.setNext(oldNode);
        oldNode.setPrevious(newNode);

        size++;
    }

    public E getElementAtIndex(final int index) {
        assertIndex(index);

        return (E) getNodeAtIndex(index).getData();
    }

    private Node getNodeAtIndex(final int index) {
        return ((size / 2) >= index) ? getNodeFromHead(index) : getNodeFromTail(index);
    }

    private Node getNodeFromTail(final int index) {
        Node currentNode = tail;

        for (int pos = size - 1; pos > index; pos--) currentNode = currentNode.getPrevious();

        return currentNode;
    }

    private Node getNodeFromHead(final int index) {
        Node currentNode = head;

        for (int pos = 0; pos < index; pos++) currentNode = currentNode.getNext();

        return currentNode;
    }

    private void assertIndex(int index) {
        if(index > size - 1 || index < 0) throw new IllegalArgumentException("Index is out of range");
    }
}
