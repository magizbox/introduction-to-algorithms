package week1.percolation;

/**
 * Created by LanAnh on 14/11/2016.
 */
public class Percolation{
   // create n-by-n grid, with all sites blocked
   private boolean[][] sites;
   public Percolation(int n){
      sites = new boolean[n+1][n+1];
      for(int i=1; i<=n; i++){
         for(int j=1; j<=n; j++){
            sites[i][j] = false;
         }
      }
   }

   // open site (row, col) if it is not open already
   public void open(int row, int col){
      sites[row][col] = true;
   }

   // is site (row, col) open?
   public boolean isOpen(int row, int col){
      return sites[row][col];

   }

   // is site (row, col) full?
   public boolean isFull(int row, int col){
      return sites[row][col];
   }

   // does the system percolate?
   public boolean percolates(){
      return true;
   }

   public static void main(String[] args){ // test client (optional)

   }

}
