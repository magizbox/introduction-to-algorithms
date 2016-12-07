package week2.queues;

import junit.framework.TestCase;

/**
 * Created by rain on 12/7/2016.
 */
public class RandomizedQueueTest extends TestCase {

    public void testIterator() throws Exception {
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<>();
        randomizedQueue.enqueue(1);
        randomizedQueue.enqueue(2);
        randomizedQueue.enqueue(3);
        for(Integer item: randomizedQueue){
            System.out.println(item);
        }

    }
}