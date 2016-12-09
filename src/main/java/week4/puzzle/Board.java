package week4.puzzle;

import edu.princeton.cs.algs4.In;

/**
 * Created by rain on 12/9/2016.
 */
public class Board {
    // construct a board from an n-by-n array of blocks
    private int[][] blocks;

    public Board(int[][] blocks) {
        this.blocks = blocks;
    }
    // (where blocks[i][j] = block in row i, column j)

    // board dimension n
    public int dimension() {
        return 0;
    }

    // number of blocks out of place
    public int hamming() {
        return 0;
    }

    // sum of Manhattan distances between blocks and goal
    public int manhattan() {
        return 0;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return true;
    }

    // a board that is obtained by exchanging any pair of blocks
    public Board twin() {
        return null;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        return null;
    }

    // string representation of this board (in the output format specified below)
    public String toString() {
        return "";
    }

    // unit tests (not graded)
    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);
    }
}

