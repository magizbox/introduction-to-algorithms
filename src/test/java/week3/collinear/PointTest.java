package week3.collinear;

import junit.framework.TestCase;

/**
 * Created by rain on 12/8/2016.
 */
public class PointTest extends TestCase {

    public void testSlopeTo() throws Exception {
        Point p = new Point(2, 3);
        Point q = new Point(2, 3);
        assertEquals(Double.NEGATIVE_INFINITY, p.compareTo(q));
    }
}