// 문제: 백준 1260번 문제제목 : DFS와 BFS
// 링크: https://www.acmicpc.net/problem/1260
// 시간: 220ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260 {

	static ArrayList<Integer>[] graph; //인접 그래프 생성(각 노드 별 생성되는 간선을 연결하기 위한 그래프)
	static boolean[] visited; //방문 배열 생성(재귀 후 백트래킹을 위한 확인 boolean 배열이 필요함)
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n + 1];
		visited = new boolean[n + 1];

		// 그래프 초기화
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int t = 1; t <= m; t++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			//양방향으로 탐색이 가능하도록 양쪽으로 그래프를 연결시켜 줘야됨
			graph[a].add(b);
			graph[b].add(a);
		}
		
		//작은 숫자부터 방문하려고 하면 인접 그래프를 입력받은 후 정렬이 필요함
		for (int i = 1; i <= n; i++) {
			Collections.sort(graph[i]);
		}

		dfs(v);
		sb.append("\n");
		Arrays.fill(visited, false); //방문 배열을 초기화하여 BFS 사용함
		bfs(v);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs(int node) {
		/* DFS 동작원리
		 * 1. 방문 체크
		 * 2. 원하는 작업 진행
		 * 3. 반복을 통해 dfs 재귀 시작
		 * ※ 단, 방문을 했는지 확인 필요!
		 * */
		
		visited[node] = true;
		sb.append(node + " ");

		for (int next : graph[node]) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}

	public static void bfs(int node) {
		/* BFS 동작원리
		 * 1. 방문 체크
		 * 2. 큐를 생성하여 처음 노드 삽입
		 * 3. 큐가 빌 때까지 작업 진행
		 * - 큐 안에 있는 앞 내용물을 뽑고, 인접 그래프를 반복문으로 돌면서 나와 연결된 노드들을 큐에 삽입함
		 * ※ 단, 방문을 했는지 확인 필요!
		 * */
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(node); // 처음 노드 삽입
		visited[node] = true;

		while (!queue.isEmpty()) {
			int start = queue.poll();
			sb.append(start + " ");

			for (int next : graph[start]) {
				if (!visited[next]) {
					queue.add(next);
					visited[next] = true;
				}
			}
		}

	}
}