package algolab;

public class LastAlgoLabApp {
	public static void main (String[] args){
		int[] edges = {1000,5000,10000,50000,100000-1};
		long start,time;
		
		/*for (int i=1;i<=2;i++){
			int n = 5000*i;//number of vertices
			for (int j=0; j<5;j++){
				Graph graph = new Graph(n);//create new graph with new vertices
				graph.createGraph(edges[j]);//input number of edges
				
				//start stopwatch
				start = System.nanoTime();
				
				graph.performBFSearchAllVertexes();
				
				//stop stopwatch
				time = System.nanoTime() - start;
				
				System.out.println("Time taken for " + n + " vertices with " + edges[j] + " edges: \t"+(time/Math.pow(10, 9))+" seconds");
			}
		}*/
		
		Graph graph = new Graph(10);//create new graph with new vertices
		graph.createGraph(10);//input number of edges
		
		graph.performBFSearchAllVertexes();
		graph.printGraph();
		graph.printPathsArray();
		System.out.println("");
		graph.printParentsArray();
	}
}
