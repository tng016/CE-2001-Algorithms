package algolab;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	private Vertex[] vertices;
	private Queue<Integer> queue;;
	private int[][] paths;
	private int[][] parents;
	private int n;//number of vertices
	
	public Graph(int n){
		this.n = n;
		vertices = new Vertex[n];
		queue = new LinkedList<Integer>();
		paths = new int[n][n];
		parents = new int [n][n];
		for (int i=0;i<n;i++)
			vertices[i] = new Vertex();
	}
	
	public void createGraph(int required_number_of_edges){
		int number_of_edges=0;
		while (number_of_edges<required_number_of_edges){
			//generate two random vertex numbers to be linked
			int j = (int)(Math.random()*n);
			int k = (int)(Math.random()*n);
			
			//exclude case when both random numbers are same
			if (j == k)
				continue;
			
			//exclude case when edge has already been formed
			if(vertices[j].edges.contains(k))
				continue;
			
			//add edges
			vertices[j].edges.add(k);
			vertices[k].edges.add(j);
			
			number_of_edges++;
		}
	}
	
	public void printGraph(){
		for (int i=0;i<n;i++){
			System.out.print("Vertex "+i+": ");
			vertices[i].printVertex();
			System.out.println("");
		}
	}
	
	public void performBFSearch(){
		//create queue and marked list
		queue = new LinkedList<Integer>();
		
		//while some vertex has not been marked - in cases where there are more than one independent graphs
		while(!isDone()){
			//generate random starting point
			int random = (int)(Math.random()*n);
			//exclude case when starting point has already been visited
			if (vertices[random].marked==true)
				continue;
			//perform BFS on random starting point
			BFSearch(random);
		}
		
	}
	
	public void performBFSearchAllVertexes(){
		for (int i=0;i<n;i++){
			//create queue and clear markings on all vertices
			queue = new LinkedList<Integer>();
			//removeMarkings();
			//perform BFS on starting vertex i
			BFSearch(i);
		}
	}
	
	public void BFSearch(int first){
		//add first vertex to the queue
		queue.add(first);
		while (!queue.isEmpty()){
			//current holds the current vertex number, remove it from queue
			int current = queue.remove();
			
			//for every edge that current has
			for(int i=0;i<vertices[current].edges.size();i++){
				//if the next vertex of that edge is unmarked
				Integer next_vertex = vertices[current].edges.get(i);
				if(vertices[next_vertex].marked == false){
					//add that vertex to the queue and mark it
					vertices[next_vertex].marked = true;
					queue.add(next_vertex);
					//add path length to paths matrix
					paths[first][next_vertex] = 1 + paths[first][current];
					//add current to parents matrix
					parents[first][next_vertex] = current;
				}//end if
			}//end for
		}//end while
	}//end BFSearch
	
	public void removeMarkings(){
		for (int i=0;i<n;i++)
			vertices[i].marked=false;
	}
	
	public int returnPaths(int a, int b){
		return paths[a][b];
	}
	
	public int returnParents(int a, int b){
		return parents[a][b];
	}
	
	public void printPathsArray(){
		for (int i=0;i<n;i++){
			for (int j=0; j<n ;j++){
				System.out.print("["+paths[i][j]+"]");
			}//end second for
			System.out.println("");
		}//end first for
	}//end method
	
	public void printParentsArray(){
		for (int i=0;i<n;i++){
			for (int j=0; j<n ;j++){
				System.out.print("["+parents[i][j]+"]");
			}//end second for
			System.out.println("");
		}//end first for
	}//end method
	
	private boolean isDone(){
		for (int i=0;i<n;i++){
			if (vertices[i].marked==true)
				continue;
			else
				return false;
		}
		return true;
	}
}
