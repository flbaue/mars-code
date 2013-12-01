package de.flbaue.list;

/**
 * User: flbaue
 * Date: 25.11.13
 * Time: 20:17
 */
public class LinkedList<T> implements List<T> {

    private LinkedListElement<T> listHead;
    private LinkedListElement<T> listEnd;
    private int size;
    public boolean optimizeGet;

    public LinkedList() {
        listHead = null;
        listEnd = null;
        size = 0;
        optimizeGet = true;
    }

    public LinkedList(List list) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(T element) {

        LinkedListElement<T> newElement = new LinkedListElement<>(element, null, null);

        if (listHead == null) {
            listHead = newElement;
            listEnd = newElement;
        } else {
            newElement.setPrevious(listEnd);
            listEnd.setNext(newElement);
            listEnd = newElement;
        }
        size++;
    }

    @Override
    public void insert(T element, int index) {
        LinkedListElement<T> currentElement = getElement(index);
        LinkedListElement<T> previous = currentElement.getPrevious();
        LinkedListElement<T> newElement = new LinkedListElement<>(element, previous, currentElement);
        if (previous != null) {
            previous.setNext(newElement);
            currentElement.setPrevious(newElement);
        } else {
            listHead = newElement;
        }
        size++;
    }

    @Override
    public T get(int index) {
        LinkedListElement<T> currentElement = getElement(index);
        if (currentElement != null) {
            return currentElement.getData();
        } else {
            return null;
        }
    }

    @Override
    public T remove(int index) {
        LinkedListElement<T> elementToDelete = getElement(index);
        LinkedListElement<T> previous = elementToDelete.getPrevious();
        LinkedListElement<T> next = elementToDelete.getNext();

        previous.setNext(next);
        if (next != null) {
            next.setPrevious(previous);
        }
        size--;
        return elementToDelete.getData();
    }

    private LinkedListElement<T> getElement(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        if (optimizeGet) {
            int middle = size() / 2;
            if (index <= middle) {
                return getLow(index);
            } else {
                return getHigh(index);
            }
        } else {
            return getLow(index);
        }
    }

    private LinkedListElement<T> getLow(int index) {
        LinkedListElement<T> currentElement = listHead;
        for (int i = 0; i < index; i++) {
            currentElement = currentElement.getNext();
        }
        return currentElement;
    }

    private LinkedListElement<T> getHigh(int index) {
        LinkedListElement<T> currentElement = listEnd;
        for (int i = size - 1; i > index; i--) {
            currentElement = currentElement.getPrevious();
        }
        return currentElement;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>(listHead);
    }

    public String toString() {
        if (listHead == null) {
            return "null";
        }

        StringBuilder string = new StringBuilder();

        LinkedListElement<T> current = listHead;
        string.append(current.getData());
        string.append(" -> ");

        while (current.hasNext()) {
            current = current.getNext();
            string.append(current.getData());
            string.append(" -> ");
        }

        return string.toString();
    }

    public void initializeCounter() {
        LinkedListElement.startCounter();
    }

    public void clearCounter() {
        LinkedListElement.clearCounter();
    }

    public long ticks() {
        return LinkedListElement.ticks();
    }

    private class Iterator<E> implements java.util.Iterator<E> {

        private LinkedListElement<E> currentElement;

        private Iterator(LinkedListElement<E> head) {
            currentElement = head;
        }

        @Override
        public boolean hasNext() {
            return currentElement.hasNext();
        }

        @Override
        public E next() {
            E data = currentElement.getData();
            currentElement = currentElement.getNext();
            return data;
        }

        @Override
        public void remove() {
            LinkedListElement<E> previous = currentElement.getPrevious();
            LinkedListElement<E> next = currentElement.getNext();
            previous.setNext(next);
            if (next != null) {
                next.setPrevious(previous);
            }
            size--;
        }
    }
}
