import java.io.*;
import java.util.*;

public class Main {
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
   
   static class triplet{
       // prims ke liye triplet
       int s;  // source
       int p;  // parent 
       int cost ; // cost
       triplet(int s,int p,int cost){
           this.s = s;
           this.p = p;
           this.cost = cost;
       }
   }
   
   public static void minWire(ArrayList<Edge> []graph){
       int n = graph.length;
       PriorityQueue<triplet> pq = new PriorityQueue<>((a,b)->{
           return a.cost- b.cost;             // yh pq ko cost ke basis pr dega hume inc. 
       });
       
       boolean []vis = new boolean[n];
       
       //seeding
       pq.add(new triplet(0,-1,0));
       
       while(pq.size()!=0){
           // remove
           triplet rem = pq.remove();
           // work 
           if(vis[rem.s]==false && rem.p !=-1){
               System.out.println("["+rem.s + "-" + rem.p + "@" +rem.cost+"]");
           }
           
           // mark
           vis[rem.s]=true;
           
           //add
           for(Edge e : graph[rem.s]){
               int nbr = e.nbr;
               if(!vis[nbr]){
                   pq.add(new triplet(nbr,rem.s,e.wt));
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

      // write your code here
      minWire(graph);
   }

}