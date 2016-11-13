package week1.dynamic_connectivity;

/**
 * Created by rain on 11/12/2016.
 */
public class QuickFindUF {
    private int[] id;
    public QuickFindUF(int N) {
        id = new int[N];
        for(int i = 0; i < N; i++){
            id[i] = i;
        }
    }

    public boolean connected(int p, int q){
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        for(int i = 0; i < id.length; i++){
           if(id[i] == p){
               id[i] = id[q];
           }
        }
    }
}
