package week4.puzzle;

import edu.princeton.cs.algs4.In;

/**
 * Created by rain on 12/14/2016.
 */
public class TestHelper {

    protected static String dataFolder = "D:\\PycharmProjects\\introduction-to-algorithms\\src\\test\\java\\week4\\puzzle\\data\\";

    public static Board loadBoard(String filename) {
        In in = new In(dataFolder + filename);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board board = new Board(blocks);
        return board;
    }
}
