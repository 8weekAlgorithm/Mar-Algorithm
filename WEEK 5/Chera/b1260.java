/**
 * 문제 : 백준 1260번 DFS와 BFS 
 * 메모리 : 23744KB
 * 시간 : 260ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1260 {
	static int[][] graph;
	static boolean[] visited;
	static StringBuilder sb;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선 수
		int V = Integer.parseInt(st.nextToken()); // 탐색 시작 번호

		visited = new boolean[N + 1];
		graph = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph[u][v] = graph[v][u] = 1;
		}
		sb = new StringBuilder();
		dfs(V);
		System.out.println(sb.toString().trim());

		
		bfs(V);
		System.out.println(sb.toString().trim());

	}

	static void dfs(int node) {
		visited[node] = true;
		sb.append(node + " ");

		for (int i = 1; i <= N; i++) {
			if (!visited[i] && graph[node][i] != 0) {
				dfs(i);
			}
		}
	}

	static void bfs(int node) {
		visited = new boolean[N + 1];
		sb = new StringBuilder();
		Queue<Integer> qu = new LinkedList<>();
		
		qu.add(node);
		visited[node] = true;
		
		while(!qu.isEmpty()) {
			int n = qu.poll();
			sb.append(n + " ");
			
			for(int i = 1; i<=N; i++) {
				if(!visited[i] && graph[n][i]==1) {
					qu.add(i);
					visited[i] = true;
				}
			}
		}
	}
}
