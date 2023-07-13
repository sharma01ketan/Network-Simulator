//// A Java program for Bellman-Ford's single source shortest
//// path algorithm.
//
//import java.io.*;
//import java.lang.*;
//import java.util.*;
//
//// A class to represent a connected, directed and weighted
//// graph
//class Graph {
//
//	// A class to represent a weighted edge in graph
//	class Edge {
//		int src, dest, weight;
//		Edge() { src = dest = weight = 0; }
//	};
//
//	int V, E;
//	Edge edge[];
//
//	// Creates a graph with V vertices and E edges
//	Graph(int v, int e)
//	{
//		V = v;
//		E = e;
//		edge = new Edge[e];
//		for (int i = 0; i < e; ++i)
//			edge[i] = new Edge();
//	}
//
//	// The main function that finds shortest distances from
//	// src to all other vertices using Bellman-Ford
//	// algorithm. The function also detects negative weight
//	// cycle
//	void BellmanFord(Graph graph, int src)
//	{
//		int V = graph.V, E = graph.E;
//		int dist[] = new int[V];
//
//		// Step 1: Initialize distances from src to all
//		// other vertices as INFINITE
//		for (int i = 0; i < V; ++i)
//			dist[i] = Integer.MAX_VALUE;
//		dist[src] = 0;
//
//		// Step 2: Relax all edges |V| - 1 times. A simple
//		// shortest path from src to any other vertex can
//		// have at-most |V| - 1 edges
//		for (int i = 1; i < V; ++i) {
//			for (int j = 0; j < E; ++j) {
//				int u = graph.edge[j].src;
//				int v = graph.edge[j].dest;
//				int weight = graph.edge[j].weight;
//				if (dist[u] != Integer.MAX_VALUE
//					&& dist[u] + weight < dist[v])
//					dist[v] = dist[u] + weight;
//			}
//		}
//
//		// Step 3: check for negative-weight cycles. The
//		// above step guarantees shortest distances if graph
//		// doesn't contain negative weight cycle. If we get
//		// a shorter path, then there is a cycle.
//		for (int j = 0; j < E; ++j) {
//			int u = graph.edge[j].src;
//			int v = graph.edge[j].dest;
//			int weight = graph.edge[j].weight;
//			if (dist[u] != Integer.MAX_VALUE
//				&& dist[u] + weight < dist[v]) {
//				System.out.println(
//					"Graph contains negative weight cycle");
//				return;
//			}
//		}
//		printArr(dist, V);
//	}
//
//	// A utility function used to print the solution
//	void printArr(int dist[], int V)
//	{
//		System.out.println("Vertex Distance from Source");
//		for (int i = 0; i < V; ++i)
//			System.out.println(i + "\t\t" + dist[i]);
//	}
//
//	// Driver's code
//	public static void main(String[] args) {
////		int V = 5; // Number of vertices in graph
////		int E = 8; // Number of edges in graph
////
////		Graph graph = new Graph(V, E);
////
////		// add edge 0-1 (or A-B in above figure)
////		graph.edge[0].src = 0;
////		graph.edge[0].dest = 1;
////		graph.edge[0].weight = -1;
////
////		// add edge 0-2 (or A-C in above figure)
////		graph.edge[1].src = 0;
////		graph.edge[1].dest = 2;
////		graph.edge[1].weight = 4;
////
////		// add edge 1-2 (or B-C in above figure)
////		graph.edge[2].src = 1;
////		graph.edge[2].dest = 2;
////		graph.edge[2].weight = 3;
////
////		// add edge 1-3 (or B-D in above figure)
////		graph.edge[3].src = 1;
////		graph.edge[3].dest = 3;
////		graph.edge[3].weight = 2;
////
////		// add edge 1-4 (or B-E in above figure)
////		graph.edge[4].src = 1;
////		graph.edge[4].dest = 4;
////		graph.edge[4].weight = 2;
////
////		// add edge 3-2 (or D-C in above figure)
////		graph.edge[5].src = 3;
////		graph.edge[5].dest = 2;
////		graph.edge[5].weight = 5;
////
////		// add edge 3-1 (or D-B in above figure)
////		graph.edge[6].src = 3;
////		graph.edge[6].dest = 1;
////		graph.edge[6].weight = 1;
////
////		// add edge 4-3 (or E-D in above figure)
////		graph.edge[7].src = 4;
////		graph.edge[7].dest = 3;
////		graph.edge[7].weight = -3;
////
////		// Function call
////		graph.BellmanFord(graph, 0);
//
//		int V = 3;
//		int E = 6;
//		Graph graph = new Graph(V,E);
//		graph.edge[0].src = 0;
//		graph.edge[0].dest = 1;
//		graph.edge[0].weight = 1;
//
//		graph.edge[1].src = 1;
//		graph.edge[1].dest = 0;
//		graph.edge[1].weight = 1;
//
//		graph.edge[2].src = 1;
//		graph.edge[2].dest = 2;
//		graph.edge[2].weight = 5;
//
//		graph.edge[3].src = 2;
//		graph.edge[3].dest = 1;
//		graph.edge[3].weight = 5;
//
//		graph.edge[4].src = 2;
//		graph.edge[4].dest = 0;
//		graph.edge[4].weight = 1;
//
//		graph.edge[5].src = 0;
//		graph.edge[5].dest = 2;
//		graph.edge[5].weight = 1;
//
//		graph.BellmanFord(graph, 1);
//
//	}
//}
//// Contributed by Aakash Hasija


class Graph {
	class Edge {
		int src, dest, weight;
		Edge() { src = dest = weight = 0; }
	};

	int V, E;
	Edge edge[];

	Graph(int v, int e)
	{
		V = v;
		E = e;
		edge = new Edge[e];
		for (int i = 0; i < e; ++i)
			edge[i] = new Edge();
	}

	void BellmanFord(Graph graph, int src)
	{
		int V = graph.V, E = graph.E;
		int dist[] = new int[V];
		int pred[] = new int[V];

		for (int i = 0; i < V; ++i) {
			dist[i] = Integer.MAX_VALUE;
			pred[i] = -1;
		}
		dist[src] = 0;

		for (int i = 1; i < V; ++i) {
			for (int j = 0; j < E; ++j) {
				int u = graph.edge[j].src;
				int v = graph.edge[j].dest;
				int weight = graph.edge[j].weight;
				if (dist[u] != Integer.MAX_VALUE
						&& dist[u] + weight < dist[v]) {
					dist[v] = dist[u] + weight;
					pred[v] = u;
				}
			}
		}

		for (int j = 0; j < E; ++j) {
			int u = graph.edge[j].src;
			int v = graph.edge[j].dest;
			int weight = graph.edge[j].weight;
			if (dist[u] != Integer.MAX_VALUE
					&& dist[u] + weight < dist[v]) {
				System.out.println("Graph contains negative weight cycle");
				return;
			}
		}
		printSolution(dist, pred, V, src);
	}

	void printSolution(int dist[], int pred[], int V, int src) {
		System.out.println("0 -> Router1");
		System.out.println("1 -> Router2");
		System.out.println("2 -> Router3");
		System.out.println("Vertex\tDistance\tPath");
		for (int i = 0; i < V; ++i) {
			System.out.print(i + "\t\t" + dist[i] + "\t\t\t");
			printPath(pred, i, src);
			System.out.println();
		}
		System.out.println("Routing Table for Router1 ");

	}

	void printPath(int pred[], int v, int src) {
		if (v == src) {
			System.out.print(v);
			return;
		}
		printPath(pred, pred[v], src);
		System.out.print(" -> " + v);
	}

	public static void main(String[] args) {
//		int V = 3;
//		int E = 6;
//		Graph graph = new Graph(V,E);

//		graph.edge[0].src = 0;
//		graph.edge[0].dest = 1;
//		graph.edge[0].weight = 1;
//
//		graph.edge[1].src = 1;
//		graph.edge[1].dest = 0;
//		graph.edge[1].weight = 1;
//
//		graph.edge[2].src = 1;
//		graph.edge[2].dest = 2;
//		graph.edge[2].weight = 5;
//
//		graph.edge[3].src = 2;
//		graph.edge[3].dest = 1;
//		graph.edge[3].weight = 5;
//
//		graph.edge[4].src = 2;
//		graph.edge[4].dest = 0;
//		graph.edge[4].weight = 1;
//
//		graph.edge[5].src = 0;
//		graph.edge[5].dest = 2;
//		graph.edge[5].weight = 1;

		int V = 3;
		int E = 3;
		Graph graph = new Graph(V,E);

		graph.edge[0].src = 1;
		graph.edge[0].dest = 0;
		graph.edge[0].weight = 1;

		graph.edge[1].src = 0;
		graph.edge[1].dest = 2;
		graph.edge[1].weight = 1;

		graph.edge[2].src = 1;
		graph.edge[2].dest = 2;
		graph.edge[2].weight = 1;

		graph.BellmanFord(graph, 1);

//		System.out.println();
//		graph.BellmanFord(graph, 1);
//		System.out.println();
//		graph.BellmanFord(graph, 2);
	}
}

//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//class Graph {
//	private static final int INF = Integer.MAX_VALUE;
//
//	public static List<Integer> bellmanFord(int[][] graph, int source) {
//		int V = graph.length;
//		int[] distance = new int[V];
//		int[] predecessor = new int[V];
//
//		Arrays.fill(distance, INF);
//		Arrays.fill(predecessor, -1);
//
//		distance[source] = 0;
//
//		for (int i = 0; i < V - 1; ++i) {
//			for (int u = 0; u < V; ++u) {
//				for (int v = 0; v < V; ++v) {
//					if (graph[u][v] != 0 && distance[u] != INF && distance[u] + graph[u][v] < distance[v]) {
//						distance[v] = distance[u] + graph[u][v];
//						predecessor[v] = u;
//					}
//				}
//			}
//		}
//
//		for (int u = 0; u < V; ++u) {
//			for (int v = 0; v < V; ++v) {
//				if (graph[u][v] != 0 && distance[u] != INF && distance[u] + graph[u][v] < distance[v]) {
//					throw new RuntimeException("Graph contains negative weight cycle");
//				}
//			}
//		}
//
//		return getPath(predecessor, source, V);
//	}
//
//	private static List<Integer> getPath(int[] predecessor, int source, int V) {
//		List<Integer> path = new ArrayList<>();
//		for (int i = 0; i < V; ++i) {
//			if (i != source) {
//				path.add(i);
//				int prev = predecessor[i];
//				while (prev != -1 && prev != source) {
//					path.add(prev);
//					prev = predecessor[prev];
//				}
//				path.add(source);
//				reverse(path);
//				path.add(-1);
//			}
//		}
//		return path;
//	}
//
//	private static void reverse(List<Integer> path) {
//		int start = 0;
//		int end = path.size() - 1;
//		while (start < end) {
//			int temp = path.get(start);
//			path.set(start, path.get(end));
//			path.set(end, temp);
//			start++;
//			end--;
//		}
//	}
//
//	public static void main(String[] args) {
//		int[][] graph = {
//				{0, 1, 1},
//				{1, 0, 5},
//				{1, 5, 0}
//		};
//		int source = 0;
//
//		List<Integer> shortestPaths = bellmanFord(graph, source);
//
//		System.out.println("Shortest Paths from node " + source + ":");
//		for (int i = 0; i < shortestPaths.size(); ++i) {
//			int node = shortestPaths.get(i);
//			if (node == -1) {
//				System.out.println();
//			} else {
//				System.out.print(node + " ");
//			}
//		}
//	}
//}
//
