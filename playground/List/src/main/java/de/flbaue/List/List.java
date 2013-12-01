package de.flbaue.list;

/**
 * User: flbaue
 * Date: 25.11.13
 * Time: 20:10
 */
public interface List<T> extends Iterable<T> {

    void add(T element);
    void insert(T element, int index);
    T get(int index);
    T remove(int index);
    int size();

}
