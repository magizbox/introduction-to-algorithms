import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by LanAnh on 14/11/2016.
 */
public class Percolation {
    // create n-by-n grid, with all sites blocked
    private boolean[][] sites;
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF fuf;
    private int n;
    private int top;
    private int bottom;
    private int count;

    private class Point {
        private int row;
        private int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return this.row;
        }

        public int getCol() {
            return this.col;
        }
    }

    public Percolation(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        top = 0;
        bottom = n * n + 1;
        count = 0;
        uf = new WeightedQuickUnionUF(n * n + 2);
        fuf = new WeightedQuickUnionUF(n * n + 2);
        sites = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sites[i][j] = false;
            }
        }
    }

    private List<Point> getOpenNeighbors(int row, int col) {
        List<Point> points = Arrays.asList(new Point(0, 1), new Point(0, -1), new Point(1, 0), new Point(-1, 0));
        List<Point> neighbors = new ArrayList<Point>();
        for (Point point : points) {
            int nrow = row + point.getRow();
            int ncol = col + point.getCol();
            if (nrow > 0 && nrow <= this.n && ncol > 0 && ncol <= this.n) {
                if (sites[nrow][ncol]) {
                    neighbors.add(new Point(nrow, ncol));
                }
            }
        }
        return neighbors;
    }

    private int getIndex(int row, int col) {
        return col + this.n * (row - 1);
    }

    private boolean checkIndex(int row, int col) {
        return row >= 1 && row <= n && col >= 1 && col <= n;
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        if (!checkIndex(row, col)) {
            throw new IndexOutOfBoundsException();
        }
        count++;
        sites[row][col] = true;
        List<Point> neighbors = getOpenNeighbors(row, col);
        for (Point neighbor : neighbors) {
            uf.union(getIndex(row, col), getIndex(neighbor.getRow(), neighbor.getCol()));
            fuf.union(getIndex(row, col), getIndex(neighbor.getRow(), neighbor.getCol()));
        }
        if (row == 1) {
            uf.union(top, getIndex(row, col));
            fuf.union(top, getIndex(row, col));
        }
        if (row == n) {
            uf.union(bottom, getIndex(row, col));
        }
    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (!checkIndex(row, col)) {
            throw new IndexOutOfBoundsException();
        }
        return sites[row][col];
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        if (!checkIndex(row, col)) {
            throw new IndexOutOfBoundsException();
        }
        if (!sites[row][col]) {
            return false;
        }
        if (row == 1) {
            return true;
        }
        return fuf.connected(top, getIndex(row, col));
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.connected(top, bottom);
    }

    public static void main(String[] args) { // test client (optional)

    }

}
