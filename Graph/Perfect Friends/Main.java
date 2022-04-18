import java.io.*;
import java.util.*;

public class Main {
    
    static class Edge{
        int src;
        int nbr;
        // wt ki bt ni ki toh hum ni lenge
        
        Edge(int src, int nbr){
            this.src = src;
            this.nbr = nbr;
        }
    }
    
    public static void getSingleComp(ArrayList<Edge> []graph ,int src ,boolean []vis ,ArrayList<Integer>single){
        single.add(src);    // 0 add kia 
        vis[src] = true;   // True mark krdia
        
        for(Edge e : graph[src]){
            int nbr = e.nbr;
            if(!vis[nbr]){  // iska mtlb jse 0 ka nbr 1 h vo visited ni h toh yeh if chlega
                getSingleComp(graph,nbr,vis,single);
            }
        }
    }
    
    public static void getComp(ArrayList<Edge> []graph ,ArrayList<ArrayList<Integer>>comps){
        boolean []vis = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                ArrayList<Integer> single = new ArrayList<>();   // new bnai tki isme single comp mile hume 
                getSingleComp(graph,i,vis,single);
                comps.add(single);
            }
        }
    }
    
    public static void solve(ArrayList<Edge> []graph){
        
     ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      
      getComp(graph,comps);
      
      int ans = 0;
        for(int i=0;i<comps.size();i++){
            for(int j=i+1;j<comps.size();j++){
                int size1 = comps.get(i).size();
                int size2 = comps.get(j).size();
                
                ans += size1*size2;
            }
        }

      System.out.println(ans);
    }
    
   

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      Scanner scn = new Scanner(System.in);

      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());
      
      ArrayList<Edge>[] graph = new ArrayList[n];
      for (int i = 0; i < n; i++) {
         graph[i] = new ArrayList<>();
      }

      for (int i = 0; i < k; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
        
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

        solve(graph);
      
   }
}