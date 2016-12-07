import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by LanAnh on 07/12/2016.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    // construct an empty randomized queue
    private ArrayList<Item> items;

    public RandomizedQueue() {
        items = new ArrayList<Item>();
    }

    // is the queue empty?
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // return the number of items on the queue
    public int size() {
        return items.size();
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        items.add(item);
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int index = StdRandom.uniform(size());
        Item item = items.get(index);
        items.remove(index);
        return item;
    }

    // return (but do not remove) a random item
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int index = StdRandom.uniform(size());
        return items.get(index);
    }

    private class RandomQueueIterator implements Iterator<Item> {
        private Item[] collections;
        private int current = 0;
        private int size = 0;

        public RandomQueueIterator() {
            collections = (Item[]) items.toArray();
            StdRandom.shuffle(collections);
            size = collections.length;
        }

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public Item next() {
            if (current >= size || size == 0) {
                throw new NoSuchElementException();
            }
            Item item = collections[current];
            current++;
            return item;
        }

        @Override
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomQueueIterator();
    }

    // unit testing
    public static void main(String[] args) {
    }
}
