package week_1.tests;

import org.junit.Test;
import week_1.QuickFindUF;

import static org.junit.Assert.*;

/**
 * Created by rain on 11/12/2016.
 */
public class QuickFindUFTest {

    @Test
    public void testConnected() throws Exception {
        QuickFindUF quickFind = new QuickFindUF(10);
        assertFalse(quickFind.connected(8, 9));
    }

    @Test
    public void testConnected1() throws Exception {
        QuickFindUF quickFind = new QuickFindUF(10);
        assertFalse(quickFind.connected(4, 3));
        quickFind.union(4, 3);
        assertTrue(quickFind.connected(4, 3));
    }

    @Test
    public void testUnion() throws Exception {
        QuickFindUF quickFind = new QuickFindUF(10);
        quickFind.union(4, 3);
        quickFind.union(3, 8);
        assertTrue(quickFind.connected(4, 8));
    }
}