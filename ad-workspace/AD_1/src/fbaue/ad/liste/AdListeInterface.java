/**
 * 
 */
package fbaue.ad.liste;

/**
 * AdListeInterface is an typed interface to represent a custom list.
 * @author florianbauer
 * 
 */
public interface AdListeInterface<T> {

	/**
	 * Adds an element to the beginning of the list.
	 * @param elem the element to be added
	 */
	void cons(T elem);

	/**
	 * Removes the head element of the list and returns it.
	 * @return the head element
	 */
	T head();

	/**
	 * Returns the number of elements within the list.
	 * @return number of elements
	 */
	int length();

	/**
	 * Asks if the list is empty.
	 * @return true if empty, false if not empty
	 */
	boolean isEmpty();

	/**
	 * Inserts an element to a specified position with the list.
	 * If the list is empty, the element will be add as first element.
	 * If the position is higher then the list is long, the element will be 
	 * added as last element.
	 * @param elem the element to be added
	 * @param position the position on which the element shall be added
	 */
	void insert(T elem, int position);

}
