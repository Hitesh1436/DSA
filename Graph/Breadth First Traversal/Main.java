import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
   // u --> v
   // pair bnya ek 
   static class pair {
      int u;
      String asf;

      pair(int u, String asf) {
         this.u = u;
         this.asf = asf;
      }
   }
   
   public static void bft(ArrayList<Edge> []graph , int src){
       boolean []vis = new boolean[graph.length];
       
       // queue bnai 
       Queue<pair> qu = new LinkedList<>();
       // seeding 
       qu.add(new pair(src , src+""));
       
       // kbtk krenge kaam
       
       while(qu.size()!=0){
           // remove kro pair ko 
           
           pair rem = qu.remove();  
           
           if(vis[rem.u]){  // jo remove krrhe hn vo mark h toh kuch ni krenge
               continue;
           }
           //agr true n toh work kro and sbse phle true mark kro
           
           vis[rem.u]=true; 
           
           System.out.println(rem.u + "@" +rem.asf);
           
           // vertex ke sare edge ke liye same kaam krna h ab
           
           for(Edge e : graph[rem.u]){
               int nbr = e.nbr;
               
               // age vis ni h toh 
               if(!vis[nbr]){
                   qu.add(new pair(nbr,rem.asf +nbr));
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
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());

      bft(graph,src);
   }
}