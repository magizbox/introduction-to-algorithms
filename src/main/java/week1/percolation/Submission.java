package week1.percolation;

import java.io.File;
import java.io.IOException;

/**
 * Created by rain on 12/6/2016.
 */
public class Submission {
    public static void main(String[] args) {
        try {
            String current = new File( "." ).getCanonicalPath();
            System.out.println("hihi");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
