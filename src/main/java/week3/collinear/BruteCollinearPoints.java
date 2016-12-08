package week3.collinear;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rain on 12/8/2016.
 */
public class BruteCollinearPoints {
    private List<LineSegment> segments;

    // precondition: points sorted
    private boolean checkDuplicate(Point[] points){
        int size = points.length;
        for(int i = 0; i < size - 1; i++){
            if(points[i].compareTo(points[i+1]) == 0){
                return true;
            }
        }
        return false;
    }
    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        segments = new ArrayList<LineSegment>();
        Point[] temp = Arrays.copyOf(points, points.length);
        Arrays.sort(temp);
        int size = temp.length;
        if(checkDuplicate(temp)){
            throw new IllegalArgumentException();
        }
        for (int i1 = 0; i1 < size; i1++) {
            for (int i2 = i1 + 1; i2 < size; i2++) {
                for (int i3 = i2 + 1; i3 < size; i3++) {
                    for (int i4 = i3 + 1; i4 < size; i4++) {
                        Point p1 = temp[i1];
                        Point p2 = temp[i2];
                        Point p3 = temp[i3];
                        Point p4 = temp[i4];
                        if (p3.slopeOrder().compare(p1, p2) == 0 && p4.slopeOrder().compare(p1, p2) == 0) {
                            LineSegment segment = new LineSegment(p1, p4);
                            segments.add(segment);
                        }
                    }
                }
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
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
