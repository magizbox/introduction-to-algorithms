package week1.dynamic_connectivity;

import org.junit.Test;

import static junit.framework.TestCase.*;

/**
 * Created by rain on 11/12/2016.
 */
public class QuickUnionUFTest {

    @Test
    public void testUF() throws Exception {
        QuickUnionUF uf = new QuickUnionUF(10);
        uf.union(4, 3);
        uf.union(3, 8);
        uf.union(6, 5);
        assertTrue(uf.connected(4, 3));
    }
}