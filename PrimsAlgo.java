import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PrimsAlgo {

    // Complete the prims function below.
    static int prims(int n, int[][] edges, int start) {
        //visited array created with size n+1
        int visited[]=new int[n+1];
        //adjacency matrix to store the graph
        int adj[][]=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            visited[i]=0;
            for(int j=1;j<=n;j++){
                adj[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<edges.length;i++){
                adj[edges[i][0]][edges[i][1]]=edges[i][2];
        }  
        //Implementation of prims algorithm     
        int min=0,u=0,v=0,total=0;
        visited[start]=1;
        //iterating for number of nodes times
        for(int count=0;count<n-1;count++){
            min=Integer.MAX_VALUE;
            for(int i=1;i<=n;i++){
                if(visited[i]==1){
                    for(int j=1;j<=n;j++){
                        if(visited[j]!=1){
                            if(min>adj[i][j]){
                                min=adj[i][j];
                                u=i;
                                v=j;
                                //System.out.println(i+" "+j+" "+min);
                            }
                            else if(min>adj[j][i]){
                                min=adj[j][i];
                                u=j;
                                v=i;
                            }
                        }
                    }
                }
            }
            //v,u nodes are visisted so placing 1 in visited array
            visited[v]=1;
            visited[u]=1;
            //total is to store total minimum cost
            total=total+min;            
        }
        return total;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] edges = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] edgesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int edgesItem = Integer.parseInt(edgesRowItems[j]);
                edges[i][j] = edgesItem;
            }
        }

        int start = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = prims(n, edges, start);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
