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
   
   public static void getSingleComp(ArrayList<Edge> [] graph, int src , boolean[]vis , ArrayList<Integer>single){
       single.add(src);  // src ko blank Al mn add krdia jse phle 0 krdia 
      vis[src] = true;      // vis vli array mn 0 ko true mnark krdia
      for(Edge e : graph[src]){       // 0 ke sbhi childs ke liye call lgai ab
          int nbr = e.nbr;         // neighbour nikala src ka
          if(!vis[nbr]){        // nbr visited ni h toh function ko call lgegi ab call lgi fir uss nbr ko add krenge true mark krenge and jb aur nbr ni honge toh usse comps vali AL mn simgle vali Al ko add krdenge
             getSingleComp(graph,nbr,vis,single); 
          }
      }
   }
   
   public static void gcc(ArrayList<Edge> [] graph,ArrayList<ArrayList<Integer>> comps){  
       boolean [] vis = new boolean[graph.length];  // vis array bnai tki visited ko mark krdo 
       for(int i=0;i<graph.length;i++){
           // unvisited src
           if(!vis[i]){  // mtlb vis array ke index pr T h agr h toh usse visit ni krskte or F h toh visit kro . By default false hota h
              ArrayList<Integer> single = new ArrayList<>();  //ek blank arralist bnai integer type ki naam dia single
               getSingleComp(graph,i,vis,single);   // function ko call kia ab upr call lgegi function ko
               comps.add(single);   // Single Al ko add krrhe hn comps vali mn
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

      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      
      gcc(graph,comps);

      System.out.println(comps);
   }
}