// error arha h resolve krna h
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
   static class pair{
       int vtx;
       int clr;
       pair(int vtx,int clr){
           this.vtx=vtx;
           this.clr=clr;
       }
   }
   
   /* -1 -> unvisited , 0->blue , 1->red*/
   
   public static boolean isBipartite(ArrayList<Edge> []graph){
       int n = graph.length;
       int[]vis = new int[n];
       Arrays.fill(vis,-1);
       
       for(int v=0;v<n;v++){
           if(vis[v]==-1){  // unvisited honge toh
               Queue<pair> qu = new LinkedList<>();
               qu.add(new pair(v,0));
               
               while(qu.size()>0){
                   int size = qu.size();
                   while(size-- >0){
                       pair rem = qu.remove();
                       
                       if(vis[rem.vtx]!=-1){ // mtlb visited h 
                           if(vis[rem.vtx]== rem.clr){
                               continue;
                           }else{
                               return false;
                           }
                       }
                       // mark kro
                       vis[rem.vtx] = rem.clr;
                       int src = rem.vtx;
                       for(int e : graph[src]){
                           if(vis[e]==-1){
                               qu.add(new pair(e,1-rem.clr));
                           }
                       }
                   }
               }
           }
           return true;
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
      
       int[]vis = new int[graph.length]; 
      boolean ans = isBipartite(graph);
      for(int v=0;v<vtces;v++){
          if(vis[v]!=-1){
            System.out.println(true);  
          }
      }
      System.out.println(false);
    
   }
}


// Sumeet Sir's Approach
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
   
   static class  pair {
       int v;
       String psf;
       int level;
       pair(int v , String psf, int level){
           this.v =v;
           this.psf=psf;
           this.level = level;
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

      // Code From Here
      
      int []vis = new int[vtces];
      Arrays.fill(vis,-1);
      
      for(int v=0;v<vtces;v++){
        if(vis[v]==-1){
            boolean isComponentBipartite = checkComponentForBipartiteness(graph,v,vis);
            if(isComponentBipartite== false){
                System.out.println(false);
                return;
            }
      }
   }
   System.out.println(true);
}

    public static boolean checkComponentForBipartiteness(ArrayList<Edge> []graph,int src , int[]vis){
        Queue<pair> qu = new LinkedList<>();
        qu.add(new pair(src,src+"",0));
        
        while(qu.size()!=0){
            pair rem = qu.remove();
            
            if(vis[rem.v]!=-1){
                if(rem.level !=vis[rem.v]){
                    return false;
                }
            }else{
                vis[rem.v]=rem.level;
            }
            for(Edge e : graph[rem.v]){
                int nbr = e.nbr;
                if(vis[nbr]==-1){
                    qu.add(new pair(e.nbr,rem.psf + e.nbr ,rem.level+1));
                }
            }
        }
        return true;
    }
}

























