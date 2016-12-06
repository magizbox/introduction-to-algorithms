package week1.dynamic_connectivity;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;
/**
 * Created by rain on 12/6/2016.
 */
public class WeightedUFTest {
    @Test
    public void testUF() throws Exception {
        assertTrue(true);
    }

    @Test
    public void testWeighted() throws Exception {
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(10);
        uf.union(1, 2);
        uf.union(1, 3);
        uf.union(4, 6);
        assertTrue(uf.connected(2, 3));
        assertFalse(uf.connected(1, 4));
    }
}


