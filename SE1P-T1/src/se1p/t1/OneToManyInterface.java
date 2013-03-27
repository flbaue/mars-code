/*
 * Florian Bauer
 * flbaue@gmail.com
 * Copyright 2013
 */
package se1p.t1;

import java.util.Collection;
import java.util.Iterator;

/**
 * OneToManyInterface
 * An reduced collection like interface
 * especuially for 1..* relationships
 * 
 * @author Florian Bauer
 */
public interface OneToManyInterface<E> {

    /**
     * Adds an Element to the Collection
     * @param e the element
     * @return true or false
     */
    boolean add(E e);
    
    /**
     * Adds all Elements of a given Collection to this Collection
     * @param e the Collection
     * @return true or false
     */
    boolean addAll(Collection<? extends E> e);
    
    /**
     * Deletes all Elements from this Collection
     */
    void clear();
    
    /**
     * Checks whether an given element is contained by this collection
     * @param o the element
     * @return true or false
     */
    boolean contains(E o);
    
    /**
     * Checks whether all elements of a given collection are contained by this collection
     * @param c the collection
     * @return true or false
     */
    boolean containsAll(Collection<? extends E> c);
    
    /**
     * Checks whether a given object is equal
     * @param o the object
     * @return true or false
     */
    @Override
    boolean equals(Object o);
    
    /**
     * Deletes a given object from this collection
     * @param o the object
     * @return true or false
     */
    boolean remove(E o);
    
    /**
     * Returns the current number of elements of this collection
     * @return the size
     */
    int size();
    
    /**
     * Returns an iterator for this collection
     * @return the iterator
     */
    Iterator<E> iterator();
    
}
