class Solution {
    
    // Approach 1 -->

    /*
    -1 unvis
    1 blue
    0 red
    
    */
    
    public class pair{
        int vtx;
        int clr;
        
        pair(){}
        pair(int vtx, int clr){
            this.vtx = vtx;
            this.clr = clr;
        }
        
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int [] vis = new int[n];
        Arrays.fill(vis, -1);
        
        
        for(int v = 0; v < n; v++){
            if(vis[v] == -1){
                
                
                Queue<pair> qu = new LinkedList<>();
                qu.add(new pair(v,0));

                while(qu.size()!= 0){
                    int size = qu.size();
                    while(size-- > 0){
                        pair rem = qu.remove();

                        if(vis[rem.vtx] != -1){
                            //vis
                            if(vis[rem.vtx] == rem.clr)
                                continue;
                            else{
                                return false;
                            }
                        }
                        vis[rem.vtx] = rem.clr;
                        int src = rem.vtx;
                        for(int e : graph[src]){
                            if(vis[e] == -1){
                                qu.add(new pair(e, 1 - rem.clr));       //(1+rem.clr)%2;
                            } 
                        }   

                    }
                }
            }
        }
        
        
        
       return true; 
        
    }
}


// Appoach 2 -->

class Solution {
    public boolean isBipartite(int[][] graph) {
        int arr[]=new int[graph.length];
        for(int i=0;i<arr.length;i++)
        {arr[i]=-1;}
        for(int i=0;i<graph.length;i++)
        {
            if(arr[i]==-1)
            {
                if(!helper(graph,i,arr))
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean helper(int [][]graph,int k,int []arr)
    {
        Queue<Integer>q= new LinkedList<>();
        q.add(k);
        arr[k]=1;
        while(!q.isEmpty())
        {
           int c=q.poll();
            for(int i=0;i<graph[c].length;i++)
            {
                if(arr[graph[c][i]]==-1)
                {
                    arr[graph[c][i]]=1-arr[c];
                    q.add(graph[c][i]);
                }
               if(arr[c]==arr[graph[c][i]])
                    {
                        return false;
                    }
            }
        }
        return true;
    }
}

// Approach 3 -->

class Solution {
    public boolean checkBFS(int node, int[][] graph, int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node]=1;
        while(!q.isEmpty()){
            int n = q.poll();
            for(int i: graph[n]){
                if(color[i]==-1){
                    color[i]=1-color[n];
                    q.add(i);
                }
                if(color[i]==color[n])
                    return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] color = new int[v];
        Arrays.fill(color,-1);
        for(int i = 0;i<v;i++){
            if(color[i]==-1&&!checkBFS(i, graph, color)){
                    return false;
            }
        }
        return true;
    }
}