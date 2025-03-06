// 문제: 백준 1260번 DFS와 BFS
// 메모리: 20988 KB
// 시간: 260 ms

import java.io.*;
import java.util.*;

public class b1260 {
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);

		int n = Integer.parseInt(st.nextToken()); // 정점
		int m = Integer.parseInt(st.nextToken()); // 간선
		int v = Integer.parseInt(st.nextToken()); // 시작

		// 그래프 생성
		List<List<Integer>> graph = new ArrayList<>();

		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			graph.get(n1).add(n2);
			graph.get(n2).add(n1);
		}
		br.close();

		// 풀이 시작
		stackDFS(graph, n, v);
		sb.append('\n');
		BFS(graph, n, v);

		// 출력
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	// 스택을 사용한 DFS
	static void stackDFS(List<List<Integer>> graph, int nodes, int start) {

		boolean[] visited = new boolean[nodes + 1];
		Deque<Integer> stack = new ArrayDeque<>();

		stack.add(start);

		while (!(stack.isEmpty())) {
			int node = stack.removeLast();
			if (!(visited[node])) {
				visited[node] = true;
				sb.append(node).append(' ');
			}

			List<Integer> neighbors = graph.get(node);
			Collections.sort(neighbors, Collections.reverseOrder());
			for (int n : neighbors) {
				if (!(visited[n])) {
					stack.addLast(n);
				}
			}
		}
	}

	// 큐를 사용한 BFS
	static void BFS(List<List<Integer>> graph, int nodes, int start) {

		boolean[] visited = new boolean[nodes + 1];
		Deque<Integer> queue = new ArrayDeque<>();

		queue.addLast(start);
		visited[start] = true;
		sb.append(start).append(' ');

		while (!queue.isEmpty()) {
			int node = queue.removeFirst();

			List<Integer> neighbors = graph.get(node);
			Collections.sort(neighbors);
			for (int n : neighbors) {
				if (!(visited[n])) {
					queue.addLast(n);
					visited[n] = true;
					sb.append(n).append(' ');
				}
			}

		}

	}
}