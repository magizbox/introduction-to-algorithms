package week1.percolation;

import junit.framework.TestCase;

/**
 * Created by rain on 12/6/2016.
 */
public class PercolationTest extends TestCase {

    public void testGetNeighbors() throws Exception {
        Percolation perc1 = new Percolation(10);
        perc1.open(1, 1);
//        assertEquals(1, perc1.getOpenNeighbors(1, 2).size());
    }

    public void testGetNeighbors2() throws Exception {
        Percolation perc2 = new Percolation(10);
        perc2.open(1, 1);
        perc2.open(1, 3);
        perc2.open(2, 2);
//        assertEquals(3, perc2.getOpenNeighbors(1, 2).size());

    }
}