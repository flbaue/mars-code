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

	AdListeElement head;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void cons(T elem) {
		if (head == null) {
			head = new AdListeElement(elem, null);
		} else {
			AdListeElement newHead = new AdListeElement(elem, head);
			head = newHead;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T head() {
		if (head == null) {
			return null;
		}
		AdListeElement oldHead = head;
		if (head.hasNext()) {
			head = head.getNext();
		} else {
			head = null;
		}
		return oldHead.getData();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int length() {

		if (head == null) {
			return 0;
		}

		AdListeElement currentElement = head;
		int numberOfElements = 1;
		while (currentElement.hasNext()) {
			numberOfElements++;
			currentElement = currentElement.getNext();
		}
		return numberOfElements;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		return (head == null) ? true : false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insert(T elem, int position) {

		AdListeElement newElement = new AdListeElement(elem, null);
		if (head == null) {
			head = newElement;
		} else if (position == 0) {
			newElement.setNext(head);
			head = newElement;
		} else if (position >= length()) {
			AdListeElement currentElement = head;
			while (currentElement.hasNext()) {
				currentElement = currentElement.getNext();
			}
			currentElement.setNext(newElement);
		} else {
			AdListeElement currentElement = head.getNext();
			AdListeElement previousElement = head;
			int currentPosition = 1;
			while (currentPosition < position) {
				previousElement = currentElement;
				currentElement = currentElement.getNext();
				currentPosition++;
			}
			previousElement.setNext(newElement);
			newElement.setNext(currentElement);
		}
	}

	/**
	 * AdListeElement is a private inner class to represent an linked element
	 * within the {@link AdListeImpl}
	 * 
	 * @author florianbauer
	 * 
	 */
	private class AdListeElement {
		private T data;
		private AdListeElement next;

		/**
		 * Constructs an list element
		 * 
		 * @param data
		 *            the containing typed data
		 * @param next
		 *            the link to the following element. Can be null.
		 */
		private AdListeElement(T data, AdListeElement next) {
			setData(data);
			setNext(next);
		}

		/**
		 * Returns the containing data.
		 * 
		 * @return the typed data object
		 */
		private T getData() {
			return data;
		}

		/**
		 * Sets a new data object.
		 * 
		 * @param data
		 *            the object
		 */
		private void setData(T data) {
			this.data = data;
		}

		/**
		 * Returns the reference to the following linked object. Can be null.
		 * 
		 * @return the following liked object
		 */
		private AdListeElement getNext() {
			return next;
		}

		/**
		 * Sets the reference to the following linked element.
		 * 
		 * @param next
		 *            the following element
		 */
		private void setNext(AdListeElement next) {
			this.next = next;
		}

		/**
		 * Asks whether an link to a following element exists.
		 * 
		 * @return true if a following element is linked, false if not
		 */
		private boolean hasNext() {
			return (getNext() == null) ? false : true;
		}

	}

}
