// 문제: 백준 1260번 DFS와 BFS
// 링크: https://www.acmicpc.net/problem/1260
// 시간: 208ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// 입력 처리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 정점 개수
		int M = Integer.parseInt(st.nextToken()); // 간선 개수
		int V = Integer.parseInt(st.nextToken()); // 시작 정점

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		// 간선 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		// 번호가 작은 정점부터 방문하도록 정렬
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}

//		// DFS 실행 (재귀 사용)
//		visited = new boolean[N + 1];
//		dfs_recur(V);
//		sb.append("\n");

		// DFS 실행 (스택 사용)
        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");
		
		// BFS 실행 (큐 사용)
		visited = new boolean[N + 1];
		bfs(V);

		// 결과 출력
		System.out.println(sb);
	}

//	// DFS (재귀)
//	static void dfs_recur(int node) {
//		visited[node] = true;
//		sb.append(node).append(" ");
//
//		for (int next : graph[node]) {
//			if (!visited[next]) {
//				dfs(next);
//			}
//		}
//	}
	
	// DFS (스택)
    static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int now = stack.pop();
            if (!visited[now]) {
                visited[now] = true;
                sb.append(now).append(" ");

                // 스택에 넣을 때는 내림차순으로 넣어야 pop할 때 오름차순으로 탐색됨
                for (int i = graph[now].size() - 1; i >= 0; i--) {
                    int next = graph[now].get(i);
                    if (!visited[next]) {
                        stack.push(next);
                    }
                }
            }
        }
    }

	// BFS (큐)
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int now = queue.poll();
			sb.append(now).append(" ");

			for (int next : graph[now]) {
				if (!visited[next]) {
					visited[next] = true;
					queue.offer(next);
				}
			}
		}
	}
}
