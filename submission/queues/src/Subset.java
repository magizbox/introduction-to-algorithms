import edu.princeton.cs.algs4.StdIn;

/**
 * Created by LanAnh on 07/12/2016.
 */

public class Subset {
    public static void main(String[] args) {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<String>();
        int k = Integer.parseInt(args[0]);
        while (!StdIn.isEmpty()) {
            randomizedQueue.enqueue(StdIn.readString());
        }
        while (k > 0) {
            System.out.println(randomizedQueue.dequeue());
            k--;
        }
        return;
    }
}
