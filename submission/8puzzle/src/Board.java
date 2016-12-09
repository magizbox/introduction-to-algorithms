import edu.princeton.cs.algs4.In;

import java.util.Stack;

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
        return blocks.length;
    }

    // number of blocks out of place
    public int hamming() {
        int n = this.dimension();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Point actual = new Point(i, j);
                Point expected = getPosition(blocks[i][j]);
                if (!actual.equals(expected) && blocks[i][j] != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distance(Point that) {
            return Math.abs(that.x - x) + Math.abs(that.y - y);
        }

        @Override
        public boolean equals(Object object) {
            Point that = (Point) object;
            return (this.x == that.x) && (this.y == that.y);
        }

        @Override
        public int hashCode() {
            int hash = 10000;
            return x + hash * y;
        }
    }

    private Point getPosition(int value) {
        int n = this.dimension();
        int row = (value - 1) / n;
        int col = (value - 1) % n;
        return new Point(row, col);

    }

    // sum of Manhattan distances between blocks and goal
    public int manhattan() {
        int n = this.dimension();
        int sum = 0;
        int expectedValue;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Point actual = new Point(i, j);
                Point expected = getPosition(blocks[i][j]);
                if (!actual.equals(expected) && blocks[i][j] != 0) {
                    sum += actual.distance(expected);
                }
            }
        }
        return sum;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return true;
    }

    // a board that is obtained by exchanging any pair of blocks
    public Board twin() {
        int[][] board = copy();
        int temp = board[1][0];
        board[1][0] = board[0][0];
        board[0][0] = temp;
        return new Board(board);
    }

    // does this board equal y?
    public boolean equals(Object y) {
        return true;
    }

    private int[][] copy() {
        int n = dimension();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = blocks[i][j];
            }
        }
        return board;
    }

    private Board moveLeft() {
        int n = dimension();
        Point blank = getBlankPosition();
        if (blank.y == n - 1) {
            return null;
        }
        int[][] board = copy();
        board[blank.x][blank.y] = board[blank.x][blank.y + 1];
        board[blank.x][blank.y + 1] = 0;
        return new Board(board);
    }

    private Board moveRight() {
        int n = dimension();
        Point blank = getBlankPosition();
        if (blank.y == 0) {
            return null;
        }
        int[][] board = copy();
        board[blank.x][blank.y] = board[blank.x][blank.y - 1];
        board[blank.x][blank.y - 1] = 0;
        return new Board(board);
    }

    private Board moveUp() {
        int n = dimension();
        Point blank = getBlankPosition();
        if (blank.x == n - 1) {
            return null;
        }
        int[][] board = copy();
        board[blank.x][blank.y] = board[blank.x + 1][blank.y];
        board[blank.x + 1][blank.y] = 0;
        return new Board(board);
    }

    private Board moveDown() {
        int n = dimension();
        Point blank = getBlankPosition();
        if (blank.x == 0) {
            return null;
        }
        int[][] board = copy();
        board[blank.x][blank.y] = board[blank.x - 1][blank.y];
        board[blank.x - 1][blank.y] = 0;
        return new Board(board);
    }

    private Point getBlankPosition() {
        int n = dimension();
        Point position = null;
        // find zero position
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (blocks[i][j] == 0) {
                    position = new Point(i, j);
                }
            }
        }
        return position;

    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        Stack<Board> neighbors = new Stack<Board>();
        Board left = moveLeft();
        Board right = moveRight();
        Board up = moveUp();
        Board down = moveDown();
        if (left != null) neighbors.push(left);
        if (right != null) neighbors.push(right);
        if (up != null) neighbors.push(up);
        if (down != null) neighbors.push(down);
        return neighbors;
    }

    private String oneDigitBoardString(int n) {
        String puzzle;
        puzzle = "" + n + "\n";
        String format = "";
        for (int i = 0; i < n; i++) {
            String line = "";
            for (int j = 0; j < n; j++) {
                line += String.format("%2d", blocks[i][j]);
            }
            if (i != n - 1) {
                line += "\n";
            }
            puzzle += line;
        }
        return puzzle;
    }

    private String multiDigitBoardString(int n) {
        String puzzle;
        puzzle = "" + n + "\n";
        int digits = (int) Math.log10(n * n - 1);
        String format = "%" + digits + "d";
        for (int i = 0; i < n; i++) {
            String line = "";
            for (int j = 0; j < n; j++) {
                line += String.format(format, blocks[i][j]);
                if (j != n - 1) {
                    line += " ";
                }
            }
            if (i != n - 1) {
                line += "\n";
            }
            puzzle += line;
        }
        return puzzle;
    }

    // string representation of this board (in the output format specified below)
    public String toString() {
        int n = this.dimension();
        if (n < 4) {
            return oneDigitBoardString(n);
        }
        return multiDigitBoardString(n);
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

