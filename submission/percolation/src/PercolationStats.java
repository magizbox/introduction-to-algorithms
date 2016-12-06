import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Created by LanAnh on 14/11/2016.
 */
public class PercolationStats {

    private double[] thresholds;
    private double mean;
    private double stddev;
    private double confidenceLo;
    private double confidenceHi;

    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }
        thresholds = new double[trials];
        for (int i = 0; i < trials; i++) {
            int count = 0;
            int row, col;
            Percolation perc = new Percolation(n);
            while (!perc.percolates()) {
                count++;
                do {
                    row = StdRandom.uniform(1, n + 1);
                    col = StdRandom.uniform(1, n + 1);
                } while (perc.isOpen(row, col));
                perc.open(row, col);
            }
            double threshold = count * 1.0 / (n * n);
            thresholds[i] = threshold;
        }
        mean = StdStats.mean(thresholds);
        stddev = StdStats.stddev(thresholds);
        double confidenceFraction = (1.96 * stddev) / Math.sqrt(trials);
        confidenceLo = mean - confidenceFraction;
        confidenceHi = mean + confidenceFraction;
    }

    // sample mean of percolation threshold
    public double mean() {
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return stddev;
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        return confidenceLo;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return confidenceHi;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }
        PercolationStats percolationStats = new PercolationStats(n, trials);
        System.out.println("mean                    = " + percolationStats.mean());
        System.out.println("stddev                  = " + percolationStats.stddev());
        System.out.println("95% confidence interval = " + percolationStats.confidenceLo() +
                ", " + percolationStats.confidenceHi());
    }
}
