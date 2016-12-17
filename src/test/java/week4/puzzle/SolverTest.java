package week4.puzzle;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by rain on 12/14/2016.
 */
public class SolverTest {

    protected Board board2;
    protected Board board3;

    @Before
    public void runOnceBeforeClass() {
        board2 = TestHelper.loadBoard("puzzle02.txt");
        board3 = TestHelper.loadBoard("puzzle03.txt");
    }

    @Test
    public void testMoves() throws Exception {
        Solver solver2 = new Solver(board2);
        assertEquals(2, solver2.moves());
    }

    @Test
    public void testMoves2() throws Exception {
        Solver solver3 = new Solver(board3);
        assertEquals(3, solver3.moves());
    }

    @Test
    public void testMoves3() throws Exception {
        Board board11 = TestHelper.loadBoard("puzzle11.txt");
        Solver solver11 = new Solver(board11);
        assertEquals(11, solver11.moves());
    }
}