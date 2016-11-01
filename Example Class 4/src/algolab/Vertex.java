package algolab;

import java.util.ArrayList;

public class Vertex {
	protected ArrayList<Integer> edges;
	protected boolean marked;
	
	public Vertex(){
		edges = new ArrayList<>();
		marked = false;
	}

	public void printVertex() {
		for (int i=0;i<edges.size();i++)
			System.out.print(edges.get(i) + ",");
	}
}
