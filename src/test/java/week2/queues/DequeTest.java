package week2.queues;

import junit.framework.TestCase;

import java.util.NoSuchElementException;

/**
 * Created by rain on 12/7/2016.
 */
public class DequeTest extends TestCase {

    public void testDeque() throws Exception {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(2);
        int first = deque.removeFirst();
        assertEquals(first, 2);
        deque.addFirst(2);
        int last = deque.removeLast();
        assertEquals(last, 2);
    }

    public void testAddFirst() throws Exception {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        assertEquals(3, deque.size());
        int first = deque.removeFirst();
        int last = deque.removeLast();
        assertEquals(3, first);
        assertEquals(1, last);
    }

    public void testAddFirstNull() {
        try {
            Deque<Integer> deque = new Deque<>();
            deque.addFirst(null);
            fail();
        } catch (NullPointerException e) {
        }
    }

    public void testAddLast() throws Exception {
        Deque<Integer> deque = new Deque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        assertEquals(3, deque.size());
        int first = deque.removeFirst();
        int last = deque.removeLast();
        assertEquals(1, first);
        assertEquals(3, last);
    }

    public void testAddLast2() throws Exception {
        Deque<Integer> deque = new Deque<>();
        deque.addLast(0);
        deque.addLast(1);
        deque.removeLast();
        deque.addLast(3);
        int last = deque.removeLast();
        assertEquals(3, last);
    }

    public void testAddLastNull() {
        try {
            Deque<Integer> deque = new Deque<>();
            deque.addLast(null);
            fail();
        } catch (NullPointerException e) {
        }
    }

    public void testAdd() throws Exception {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addFirst(0);
        assertEquals(4, deque.size());
        int first = deque.removeFirst();
        int last = deque.removeLast();
        assertEquals(0, first);
        assertEquals(3, last);
    }


    public void testRemoveLast() throws Exception {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(2);
        int last = deque.removeLast();
        assertEquals(last, 2);
    }

    public void testRemoveLast2() throws Exception {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.removeLast();
        deque.removeLast();
        int last = deque.removeLast();
        assertEquals(3, last);
    }

    public void testRemoveLast3() throws Exception {
        Deque<Integer> deque = new Deque<>();
        deque.addLast(2);
        int last = deque.removeLast();
        assertEquals(last, 2);
    }

    public void testRemoveLastEmpty() throws Exception {
        try {
            Deque<Integer> deque = new Deque<>();
            deque.removeLast();
            fail();
        } catch (NoSuchElementException e) {

        }
    }

    public void testRemoveFirst() throws Exception {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(2);
        int first = deque.removeFirst();
        assertEquals(first, 2);
    }

    public void testRemoveFirst2() throws Exception {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(2);
        deque.addFirst(3);
        int first = deque.removeFirst();
        assertEquals(first, 3);
    }

    public void testRemoveFirstEmpty() throws Exception {
        try {
            Deque<Integer> deque = new Deque<>();
            deque.removeFirst();
            fail();
        } catch (NoSuchElementException e) {

        }
    }

    public void testIterator() throws Exception {
        Deque<Integer> deque = new Deque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        for(int item: deque){
            System.out.println(item);
        }
    }

    public void testIterator2() {
        Deque<Integer> deque = new Deque<>();
        for(int item: deque){
            System.out.println(item);
        }
    }

    public void testIterator3() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(3);
        deque.removeFirst();
        deque.removeLast();
        for(int item: deque){
            System.out.println(item);
        }
    }

}