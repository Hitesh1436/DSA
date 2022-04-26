import java.io.*;
import java.util.*;

public class Main {
    static class dp{
        //dijkstra triplet
        int s;          //source
        String psf;       //path so far
        int wsf;      // weight so far
        
        dp(int s, String psf,int wsf){
            this.s = s;
            this.psf = psf;
            this.wsf = wsf;
        }
        
    }
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

    public static void shortestpath(ArrayList<Edge>[] graph){
        int src = 0;   //source
        int n = graph.length;

        PriorityQueue<dp> pq = new PriorityQueue<>((a,b)->{   // lambda function h yeh ()->
            return a.wsf-b.wsf;    // increasing order on the basis of wsf
        });
        
        boolean [] vis = new boolean[n];

        //seeding
        pq.add(new dp(src,src +"",0));      // s=0 , psf = 0 and wsf =0 start kia h abi 0 se
        
        while(pq.size() != 0){
            //remove
            dp rem = pq.remove();
            
            //work

            if(vis[rem.s] == false){
                System.out.println(rem.s + " via " + rem.psf + " @ " + rem.wsf);
            }

            //mark
            vis[rem.s] = true;
            
            //add
            for(Edge e : graph[rem.s]){
                int nbr = e.nbr;
                int wsf = e.wt;
                if(vis[nbr] == false){
                    pq.add(new dp(nbr,rem.psf+nbr,rem.wsf+wsf));   // cummulative sum ayga isme 
                }
            }
        }
       
    }
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      //code starts here
      shortestpath(graph);
    //   int []path = dijkstraAlgo(graph);
    //   for(int e : path){
    //       System.out.print(e + " ");
    //   }
     
   }

}