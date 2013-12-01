package de.flbaue.list;

/**
 * User: flbaue
 * Date: 25.11.13
 * Time: 20:20
 */
class LinkedListElement<T> {

    private static Counter counter;
    private LinkedListElement<T> nextElement;
    private LinkedListElement<T> previousElement;
    private T data;

    public LinkedListElement() {
        nextElement = null;
        previousElement = null;
        data = null;
    }

    public LinkedListElement(T data, LinkedListElement previous, LinkedListElement next) {
        this.data = data;
        nextElement = next;
        previousElement = previous;
    }

    public static void startCounter() {
        counter = new Counter();
    }

    public static void clearCounter() {
        counter = null;
    }

    public static long ticks() {
        return counter.ticks();
    }

    public LinkedListElement<T> getNext() {
        if(counter != null) {
            counter.tick();
        }
        return nextElement;
    }

    public void setNext(LinkedListElement<T> nextElement) {
        this.nextElement = nextElement;
    }

    public LinkedListElement<T> getPrevious() {
        if(counter != null) {
            counter.tick();
        }
        return previousElement;
    }

    public void setPrevious(LinkedListElement<T> previousElement) {
        this.previousElement = previousElement;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean hasNext() {
        return nextElement != null;
    }
}
