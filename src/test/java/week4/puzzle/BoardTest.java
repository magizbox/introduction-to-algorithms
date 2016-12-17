package week4.puzzle;

import com.google.common.collect.Iterables;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rain on 12/9/2016.
 */


public class BoardTest {

    protected Board board4;
    protected Board board7;
    protected Board board8;
    protected Board board17;
    protected Board board23;
    protected Board board27;


    @Before
    public void runOnceBeforeClass() {
        board4 = TestHelper.loadBoard("puzzle04.txt");
        board7 = TestHelper.loadBoard("puzzle07.txt");
        board8 = TestHelper.loadBoard("puzzle08.txt");
        board17 = TestHelper.loadBoard("puzzle17.txt");
        board27 = TestHelper.loadBoard("puzzle27.txt");
        board23 = TestHelper.loadBoard("puzzle23.txt");
    }

    @Test
    public void testBoard() throws Exception {
        assertEquals(3, board4.dimension());
    }

    @Test
    public void testHamming() throws Exception {
        assertEquals(4, board4.hamming());
        assertEquals(4, board7.hamming());
        assertEquals(8, board17.hamming());
    }

    @Test
    public void testManhattan() throws Exception {
        assertEquals(4, board4.manhattan());
        assertEquals(7, board7.manhattan());
        assertEquals(17, board27.manhattan());
    }

    @Test
    public void testToString() throws Exception {
        String puzzle4 = "3\n"
                + " 0 1 3\n"
                + " 4 2 5\n"
                + " 7 8 6";
        assertEquals(puzzle4, board4.toString());
    }

    @Test
    public void testToStringNull() throws Exception {
        Board board = new Board(null);
        assertEquals("", board.toString());
    }

    @Test
    public void testEqualsNull() throws Exception {
        Board x = new Board(null);
        Board y = new Board(null);
        assertEquals(true, x.equals(y));
    }

    @Test
    public void testNeighbors() throws Exception {
        assertEquals(2, Iterables.size(board4.neighbors()));
        assertEquals(4, Iterables.size(board8.neighbors()));
        assertEquals(3, Iterables.size(board23.neighbors()));
    }

    @Test
    public void testTwin() throws Exception {
        Board twin = board4.twin();
        assertEquals(3, twin.dimension());
    }
}