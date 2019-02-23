
package dfs_bfs_Astar;

import java.io.*; 
import java.util.*; 
class Graph 
{ 
    class Edge{
		int vertex,weight;
               
		public Edge(int v,int w){
			this.vertex=v; this.weight=w;
		}
		@Override
		public String toString(){
			return "("+vertex+","+weight+")";
		}
	}
    private int V;   // No. of vertices 
    private LinkedList<Edge> adj[]; //Adjacency Lists 
  
    Graph(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
  
   
    void addEdge(int v,int dest,int weight) 
    { 
        Edge e=new Edge(dest,weight);
        adj[v].add(e);
        //System.out.println("( "+v+" , "+dest+" , "+weight+" )");
    } 
  @Override
	public String toString(){
		String result="";
               
		for(int i=0;i<adj.length;i++)
                       
			result+=i+"=>"+adj[i]+"\n";
		return result;
	}
    void BFS(int s,int goal) 
    { 
        
        boolean visited[] = new boolean[V]; 
  
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
        LinkedList<Integer> queue1 = new LinkedList<Integer>(); 
        queue1.addLast(0);
        visited[s]=true; 
        queue.add(s); 
        int cost=0,c=0;
        while (queue.size() != 0) 
        { 
            s = queue.poll(); 
            c= queue1.poll();
            System.out.print(s+" "); 
            cost+=c;
            if(s==goal)break;
           
            Iterator<Edge> i = adj[s].listIterator(); 
            int n;
            
            while (i.hasNext()) 
            { 
                Edge e = i.next();
                n=e.vertex;
                
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    queue.add(n);
                    queue1.add(e.weight);
                    //cost+=e.w;
                } 
                
            } 
            
        } 
        System.out.println("\nPath cost: "+cost);
    } 
    void DFS(int s,int goal) 
        { 
           
            Vector<Boolean> visited = new Vector<Boolean>(V); 
            for (int i = 0; i < V; i++) 
                visited.add(false); 
                  Stack<Integer> stack = new Stack<>(); 
             Stack<Integer> stack1 = new Stack<>();   
            
            stack.push(s);
            stack1.push(0);
            int cost=0,c; 
            while(stack.empty() == false) 
            { 
                s = stack.peek();
                c= stack1.peek();
                stack.pop(); 
                stack1.pop();
                cost+=c;
                
                if(visited.get(s) == false) 
                { 
                    System.out.print(s + " "); 
                    visited.set(s, true); 
                } 
                if(s==goal)break; 
                
                Iterator<Edge> iterator = adj[s].iterator(); 
                  
                while (iterator.hasNext())  
                { 
                    
                    Edge e = iterator.next();
                    int v=e.vertex;
                    if(!visited.get(v)){
                        stack.push(v); 
                        stack1.push(e.weight);
                    } 
                        
                } 
                  
            }
            System.out.println("\nPath cost: "+cost);
        } 
    
    // Driver method to 
    public static void main(String args[]) 
    { 
        Graph RomaniaMap = new Graph(20); 
        //0= Arad
        //1=Timisioara
        //2=Sibiu
        //3=Zerind
        //4=Lugoj
        //5=Riminucu Vilcea
        //6=Fagarus
        //7=Oradea
        //8=Mehadia
        //9=Craiova
        //10=Pitesti
        //11=Bucharest
        //12=Dr obdeta
        //13=Giurgia
        //14=Ur zieemi
        //15=Hirsova
        //16=Eforie
        //17=Vasiui
        //18=Iasi
        //19=Neamut
        RomaniaMap.addEdge(0, 1, 118);
        RomaniaMap.addEdge(0, 2, 140);
        RomaniaMap.addEdge(0, 3, 75);
        
        RomaniaMap.addEdge(1, 0, 118);
        RomaniaMap.addEdge(1, 4, 111);
        
        RomaniaMap.addEdge(2, 0, 140);
        RomaniaMap.addEdge(2, 5, 80);
        RomaniaMap.addEdge(2, 6, 99);
        RomaniaMap.addEdge(2, 7, 151);
        
        RomaniaMap.addEdge(3, 0, 75);
        RomaniaMap.addEdge(3, 7, 71);
        
        RomaniaMap.addEdge(4, 1, 111);
        RomaniaMap.addEdge(4, 8, 70);
        
        RomaniaMap.addEdge(5, 2, 80);
        RomaniaMap.addEdge(5, 9, 146);
        RomaniaMap.addEdge(5, 10, 97);
        
        RomaniaMap.addEdge(6, 2, 99);
        RomaniaMap.addEdge(6, 11, 211);
        
        RomaniaMap.addEdge(7, 3, 71);
        RomaniaMap.addEdge(7, 2, 151);
        
        RomaniaMap.addEdge(8, 4, 70);
        RomaniaMap.addEdge(8, 12, 75);
        
        RomaniaMap.addEdge(9, 12, 120);
        RomaniaMap.addEdge(9, 10, 138);
        RomaniaMap.addEdge(9, 5, 146);
        
        
        
        RomaniaMap.addEdge(10, 9, 138);
        RomaniaMap.addEdge(10, 11, 101);
        RomaniaMap.addEdge(10, 5, 97);
        
        RomaniaMap.addEdge(11, 10, 101);
        RomaniaMap.addEdge(11, 6, 211);
        RomaniaMap.addEdge(11, 13, 90);
        RomaniaMap.addEdge(11, 14, 85);
     
        RomaniaMap.addEdge(12, 8, 75);
        RomaniaMap.addEdge(12, 9, 120);
        
        RomaniaMap.addEdge(13, 11, 90);
        
        RomaniaMap.addEdge(14, 11, 85);
        RomaniaMap.addEdge(14, 15, 98);
        RomaniaMap.addEdge(14, 17, 142);
        
        RomaniaMap.addEdge(15, 14, 98);
        RomaniaMap.addEdge(15, 16, 86);
        
        RomaniaMap.addEdge(16, 15, 86);
        
        RomaniaMap.addEdge(17, 14, 142);
        RomaniaMap.addEdge(17, 18, 92);
        
        RomaniaMap.addEdge(18, 17, 92);
        RomaniaMap.addEdge(18, 19, 87);
        
        RomaniaMap.addEdge(19, 18, 87);
       
        System.out.println("ROMANIA MAP ADJACENCY LIST:\n"+RomaniaMap);

        System.out.println("");
        System.out.println("Following is Breadth First Traversal "+ 
                           "\n(starting from vertex 0 (Arad) to reach goal i.e. vertex 11 (Bucharest)"); 
  
        RomaniaMap.BFS(0,11); 
        System.out.println("");
        
        System.out.println("Following is Depth First Traversal "+ 
                           "\n(starting from vertex 0 (Arad) to reach goal i.e. vertex 11 (Bucharest)"); 
  
        RomaniaMap.DFS(0,11); 
        
        
    } 
} 
