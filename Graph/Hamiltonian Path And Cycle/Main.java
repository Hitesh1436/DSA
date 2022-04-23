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
   
   public static void hamiltonian(ArrayList<Edge> []graph,boolean[]vis,int src ,int osrc,String asf){
        if(asf.length()==graph.length){
            System.out.print(asf);
            
            // path hoga ya cycle
            for(Edge e: graph[osrc]){
                int nbr = e.nbr;
                
                if(nbr == src){
                    System.out.println("*");
                    return;
                }
            }
            System.out.println(".");
            return;
        
       }
       
       vis[src]=true;
       for(Edge e: graph[src]){
           int nbr = e.nbr;
           
           if(!vis[nbr]){
            hamiltonian(graph,vis,nbr,osrc,asf+nbr);   
           }
       }
       vis[src] = false;  // tki sare path explore krske
   }

   // Approach 2 using HashSet
   public static void hamiltonian(ArrayList<Edge> []graph,HashSet<Integer>hs,int src ,int osrc,String asf){
    // bcz hs mn add krne se phle check krrhe hn agr base case mn fsa toh add ni hoga isliye graph.length-1 
     if(hs.size()==graph.length-1){
         System.out.print(asf);
         
         // path hoga ya cycle
         for(Edge e: graph[osrc]){
             int nbr = e.nbr;
             
             if(nbr == src){
                 System.out.println("*");
                 return;
             }
         }
         System.out.println(".");
         return;
     
    }
    
    // mark kro phle
    hs.add(src);
    
    for(Edge e: graph[src]){
        int nbr = e.nbr;
        
        if(!hs.contains(nbr)){
         hamiltonian(graph,hs,nbr,osrc,asf+nbr);   
        }
    }
    hs.remove(src);  // tki sare path explore krske
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

      int src = Integer.parseInt(br.readLine());

      // Code
      
       //   boolean [] vis = new boolean[vtces];
    HashSet<Integer> hs = new HashSet<>();
    // ek current src and ek original src 
    hamiltonian(graph,hs,src,src,src+"");
   }


}