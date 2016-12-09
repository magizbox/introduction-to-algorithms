package week4.puzzle;

import com.google.common.collect.Iterables;
import edu.princeton.cs.algs4.In;
import org.junit.*;

import static org.junit.Assert.*;

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

    protected String dataFolder = "D:\\PycharmProjects\\introduction-to-algorithms\\src\\test\\java\\week4\\puzzle\\data\\";

    public Board loadBoard(String filename) {

        In in = new In(dataFolder + filename);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board board = new Board(blocks);
        return board;
    }

    @Before
    public void runOnceBeforeClass() {
        board4 = loadBoard("puzzle04.txt");
        board7 = loadBoard("puzzle07.txt");
        board8 = loadBoard("puzzle08.txt");
        board17 = loadBoard("puzzle17.txt");
        board27 = loadBoard("puzzle27.txt");
        board23 = loadBoard("puzzle23.txt");
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