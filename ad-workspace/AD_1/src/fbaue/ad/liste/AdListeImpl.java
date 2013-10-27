/**
 * FLorian Bauer
 * fbaue@posteo.de
 * 03.10.2013
 */
package fbaue.ad.liste;

/**
 * AdListeImpl implements the {@link AdListeInterface} as a simple linked list.
 * 
 * @author Florian Bauer
 * 
 * @param <T>
 */
public class AdListeImpl<T> implements AdListeInterface<T> {

    private AdListeElement<T> head;
    private RefCounter counter;

    /**
     * {@inheritDoc}
     */
    @Override
    public void cons(T elem) {
	head = new AdListeElement<T>(elem, head);
	count();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T head() {
	if (head == null) {
	    return null;
	}
	T headData = head.getData();
	count();
	head = head.getNext();
	count();
	return headData;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int length() {

	if (head == null) {
	    return 0;
	}

	AdListeElement<T> currentElement = head;
	int numberOfElements = 1;
	while (currentElement.hasNext()) {
	    count();
	    numberOfElements++;
	    currentElement = currentElement.getNext();
	    count();
	}
	count();
	return numberOfElements;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
	return head == null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insert(T elem, int position) {

	AdListeElement<T> newElement = new AdListeElement<T>(elem, null);
	if (head == null) {
	    head = newElement;
	} else if (position <= 0) {
	    newElement.setNext(head);
	    count();
	    head = newElement;
	} else if (position >= length()) {
	    AdListeElement<T> currentElement = head;
	    while (currentElement.hasNext()) {
		count();
		currentElement = currentElement.getNext();
		count();
	    }
	    count();
	    currentElement.setNext(newElement);
	    count();
	} else {
	    AdListeElement<T> currentElement = head.getNext();
	    count();
	    AdListeElement<T> previousElement = head;
	    int currentPosition = 1;
	    while (currentPosition < position) {
		previousElement = currentElement;
		currentElement = currentElement.getNext();
		count();
		currentPosition++;
	    }
	    previousElement.setNext(newElement);
	    count();
	    newElement.setNext(currentElement);
	    count();
	}
    }
    
    public RefCounter refCounter() {
	if(counter == null) {
	    counter = new RefCounter();
	}
	return counter;
    }
    
    private void count() {
	if(counter != null) {
	    counter.step();
	}
    }

    /**
     * AdListeElement is a private inner class to represent an linked element
     * within the {@link AdListeImpl}
     * 
     * @author florianbauer
     * 
     */
    private class AdListeElement<E> {
	private E data;
	private AdListeElement<E> next;

	/**
	 * Constructs an list element
	 * 
	 * @param data
	 *            the containing typed data
	 * @param next
	 *            the link to the following element. Can be null.
	 */
	private AdListeElement(E data, AdListeElement<E> next) {
	    setData(data);
	    setNext(next);
	}

	/**
	 * Returns the containing data.
	 * 
	 * @return the typed data object
	 */
	private E getData() {
	    return data;
	}

	/**
	 * Sets a new data object.
	 * 
	 * @param data
	 *            the object
	 */
	private void setData(E data) {
	    this.data = data;
	}

	/**
	 * Returns the reference to the following linked object. Can be null.
	 * 
	 * @return the following liked object
	 */
	private AdListeElement<E> getNext() {
	    return next;
	}

	/**
	 * Sets the reference to the following linked element.
	 * 
	 * @param next
	 *            the following element
	 */
	private void setNext(AdListeElement<E> next) {
	    this.next = next;
	}

	/**
	 * Asks whether an link to a following element exists.
	 * 
	 * @return true if a following element is linked, false if not
	 */
	private boolean hasNext() {
	    return getNext() != null;
	}

    }

}
