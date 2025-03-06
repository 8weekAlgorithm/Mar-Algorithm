//문제 : 1260 BFS와 DFS
//메모리 : 24444kb
//시간 : 360ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1260 {

	static int[][] link;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());// 정점(노드)의 수
		link = new int[n + 1][n + 1];
		int m = Integer.parseInt(st.nextToken());// 간선의 수

		int v = Integer.parseInt(st.nextToken());// 시작점

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());

			link[node][target] = 1;// 서로 연결이 되어있으니 둘다 1처리
			link[target][node] = 1;
		}

		Stack<Integer> stack = new Stack<>();
		boolean[] stackv = new boolean[n + 1];
		stack.add(v);
		while (!stack.isEmpty()) {
			int num = stack.pop();
			if (!stackv[num]) {
				stackv[num] = true;
				sb.append(num).append(" ");
			}
			for (int i = n; i >= 1; i--) { // 조건에 있는 작은 순서대로 방문
				if (!stackv[i] && link[num][i] == 1) {
					stack.add(i);
				}
			}

		}
		sb.append("\n");

		Queue<Integer> que = new ArrayDeque<Integer>();
		boolean[] queuev = new boolean[n + 1];

		que.add(v);
		queuev[v]=true;
		while(!que.isEmpty()) {
			int num = que.poll();
			sb.append(num).append(" ");
			for(int i=1;i<=n;i++) {
				if(!queuev[i]&&link[num][i]==1) {
					que.add(i);
					queuev[i]=true;
				}
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}

