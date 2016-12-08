import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rain on 12/8/2016.
 */
public class FastCollinearPoints {
    private List<LineSegment> segments;

    // precondition: points sorted
    private boolean checkDuplicate(Point[] points) {
        int size = points.length;
        for (int i = 0; i < size - 1; i++) {
            if (points[i].compareTo(points[i + 1]) == 0) {
                return true;
            }
        }
        return false;
    }

    // finds all line segments containing 4 points
    public FastCollinearPoints(Point[] points) {
        segments = new ArrayList<LineSegment>();
        Point[] temp = Arrays.copyOf(points, points.length);
        Arrays.sort(temp);
        int size = temp.length;
        if (checkDuplicate(temp)) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < size - 3; i++) {
            Arrays.sort(temp);
            Arrays.sort(temp, temp[i].slopeOrder());

            for (int p = 0, first = 1, last = 2; last < size; last++) {
                // find last collinear to p point
                while (last < size
                        && Double.compare(temp[p].slopeTo(temp[first]), temp[p].slopeTo(temp[last])) == 0) {
                    last++;
                }
                // if found at least 3 elements, make segment if it's unique
                if (last - first >= 3 && temp[p].compareTo(temp[first]) < 0) {
                    segments.add(new LineSegment(temp[p], temp[last - 1]));
                }
                // Try to find next
                first = last;
            }
        }
    }

    // the number of line segments
    public int numberOfSegments() {
        return segments.size();
    }

    // the line segments
    public LineSegment[] segments() {
        return segments.toArray(new LineSegment[segments.size()]);
    }

    public static void main(String[] args) {
        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
