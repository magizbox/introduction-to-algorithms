package week3.collinear;

import junit.framework.TestCase;

/**
 * Created by rain on 12/8/2016.
 */
public class PointTest extends TestCase {

    public void testSlopeTo() throws Exception {
        Point p = new Point(2, 3);
        Point q = new Point(2, 3);
        assertEquals(Double.NEGATIVE_INFINITY, p.slopeTo(q));
    }

    public void testSlopeTo2() throws Exception {
        Point p = new Point(172, 192);
        Point q = new Point(84, 463);
        assertEquals(-3.079, p.slopeTo(q), 0.001);
    }

    public void testCompareTo() throws Exception {
        Point p = new Point(261, 89);
        Point q = new Point(425, 89);
        assertEquals(-1, p.compareTo(q));
        assertEquals(1, q.compareTo(p));
    }

    public void testCompareTo2() throws Exception {
        Point p = new Point(172, 192);
        Point q = new Point(84, 463);
        assertEquals(-1, p.compareTo(q));
    }

    public void testSlopeOrder() throws Exception {
        Point p = new Point(172, 192);
        Point q = new Point(84, 463);
        Point r = new Point(475, 411);
        assertEquals(-1, p.slopeOrder().compare(q, r));
    }

    public void testSlopeOrder2() throws Exception {
        Point p = new Point(0, 1);
        Point q = new Point(0, 2);
        Point r = new Point(0, 3);
        assertEquals(0, p.slopeOrder().compare(q, r));
    }

    public void testSlopeOrder3() throws Exception {
        Point p = new Point(1, 1);
        Point q = new Point(2, 2);
        Point r = new Point(3, 3);
        assertEquals(0, p.slopeOrder().compare(q, r));
    }
}