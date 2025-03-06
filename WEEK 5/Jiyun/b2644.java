// 문제: 백준 2644번 촌수계산
// 메모리: 14056 KB
// 시간: 104 ms

import java.io.*;
import java.util.*;

class Family {
	int who;
	int cnt;

	Family(int who, int cnt) {
		this.who = who;
		this.cnt = cnt;
	}
}

public class b2644 {
	static List<List<Integer>> graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // 전체 사람 수

		// 그래프 생성
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++)
			graph.add(new ArrayList<>());
		visited = new boolean[n + 1];

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		// BFS 풀이
		Deque<Family> stack = new ArrayDeque<>();

		// start에서 시작
		stack.add(new Family(start, 0));
		visited[start] = true;

		boolean relation = false; // 친척이 맞는지 확인

		while (!(stack.isEmpty())) {
			Family node = stack.removeLast();

			// end에 도착했으면 종료
			if (node.who == end) {
				System.out.println(node.cnt);
				relation = true;
				break;
			}

			for (int go : graph.get(node.who)) {
				if (!(visited[go])) {
					stack.addLast(new Family(go, node.cnt + 1));
					visited[go] = true;
				}
			}
		}

		// 친척이 아니면
		if (!(relation))
			System.out.println(-1);
	}
}
