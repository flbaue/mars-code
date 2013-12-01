package de.flbaue.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * User: flbaue
 * Date: 26.11.13
 * Time: 00:15
 */
public class LinkedListTest {

    private List<Integer> list;

    @Before
    public void setUp() throws Exception {
        list = new LinkedList<>();
    }

    @Test
    public void testAdd() throws Exception {
        assertNull(list.get(0));
        assertEquals(0, list.size());

        int elements = 5;
        for (int i = 0; i < elements; i++) {
            list.add(i);
        }

        assertEquals(elements, list.size());
        assertNotNull(list.get(0));
        assertNotNull(list.get(elements - 1));
        assertEquals(elements - 1, (long) list.get(elements - 1));


    }

    @Test
    public void testInsert() throws Exception {

        int elements = 5;
        for (int i = 0; i < elements; i++) {
            list.add(i);
        }

        assertEquals(elements, list.size());

        list.insert(10, 0);
        assertEquals(10, (long) list.get(0));
        System.out.println(list.toString());

        int index = list.size() - 1;
        list.insert(10 + index, index);
        assertEquals(10 + index, (long) list.get(index));
        System.out.println(list.toString());

        int middle = list.size() / 2;
        list.insert(98, middle);
        assertEquals(98, (long) list.get(middle));
        System.out.println(list.toString());

        middle = list.size() / 2;
        list.insert(99, middle + 1);
        assertEquals(99, (long) list.get(middle + 1));
        System.out.println(list.toString());
    }

    @Test
    public void testGet() throws Exception {
        int elements = 750;

        for (int i = 0; i < elements; i++) {
            list.add(i);
        }

        int count = 0;
        System.out.println(list.toString());
        ((LinkedList)list).optimizeGet = true;

        for (int i = 0; i < elements; i++) {
            ((LinkedList) list).initializeCounter();
            list.get(i);
            //System.out.println(((LinkedList) list).ticks());
            count += ((LinkedList) list).ticks();
        }

        System.out.println("total:" + count);

    }

    @Test
    public void testRemove() throws Exception {

    }

    @Test
    public void testSize() throws Exception {

    }

    @Test
    public void testIterator() throws Exception {

    }

    @Test
    public void testMass() throws Exception {
        int elements = 6;
        ((LinkedList) list).initializeCounter();
        for (int i = 0; i < elements; i++) {
            list.add(i);
        }
        System.out.println(((LinkedList) list).ticks());
        ((LinkedList) list).clearCounter();

        assertEquals(0, (long) list.get(0));
        assertEquals(elements - 1, (long) list.get(elements - 1));


        ((LinkedList) list).initializeCounter();
        for (int i = 0; i < list.size(); i++) {
            assertEquals(i, (long) list.get(i));
        }
        System.out.println(((LinkedList) list).ticks());
        ((LinkedList) list).clearCounter();

        ((LinkedList) list).optimizeGet = false;
        ((LinkedList) list).initializeCounter();
        for (int i = 0; i < list.size(); i++) {
            assertEquals(i, (long) list.get(i));
        }
        System.out.println(((LinkedList) list).ticks());
    }
}
