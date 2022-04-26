import java.io.*;
import java.util.*;

public class Main {
    static class dp{
        //dijkstra pair
        int s;      //source
        int cost;       //cost
        
        dp(int s, int cost){
            this.s = s;
            this.cost = cost;
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

    public static int[] dijkstraAlgo(ArrayList<Edge>[] graph){
        int src = 0;//source

        int n = graph.length;
        PriorityQueue<dp> pq = new PriorityQueue<>((a,b)->{
            return a.cost-b.cost;
        });
        
        boolean [] vis = new boolean[n];
        int []path = new int[n];
        


        //seeding
        pq.add(new dp(src, 0));
        
        
        while(pq.size() != 0){
            //remove
            dp rem = pq.remove();
        
            
            //work

            if(vis[rem.s] == false)
                path[rem.s] = rem.cost;

            //mark
            vis[rem.s] = true;
            
            //add
            for(Edge e : graph[rem.s]){
                int nbr = e.nbr;
                int cost = e.wt;
                if(vis[nbr] == false){
                    pq.add(new dp(nbr, rem.cost+cost));   // cummulative sum ayga isme 
                }
            }
        }
        return path;
        
        
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
      int []path = dijkstraAlgo(graph);
      for(int e : path){
          System.out.print(e + " ");
      }
     
   }

}