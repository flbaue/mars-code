package fbaue.ad.liste;

public class AdListeImpl<T> implements AdListeInterface<T> {

	AdListeElement head;

	@Override
	public void cons(T elem) {
		if (head == null) {
			head = new AdListeElement(elem, null);
		} else {
			AdListeElement newHead = new AdListeElement(elem, head);
			head = newHead;
		}
	}

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

	@Override
	public boolean isEmpty() {
		return (head == null) ? true : false;
	}

	@Override
	public void insert(T elem, int position) {
		if(head == null || position > length()){
			//TODO maybe change?
			throw new IllegalArgumentException("Cannot insert element");
		}
		
		//TODO
	}

	private class AdListeElement {
		private T data;
		private AdListeElement next;

		private AdListeElement(T data, AdListeElement next) {
			setData(data);
			setNext(next);
		}

		private T getData() {
			return data;
		}

		private void setData(T data) {
			this.data = data;
		}

		private AdListeElement getNext() {
			return next;
		}

		private void setNext(AdListeElement next) {
			this.next = next;
		}

		private boolean hasNext() {
			return (getNext() == null) ? false : true;
		}

	}

}
