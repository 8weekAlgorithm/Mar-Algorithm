//문제 2644 촌수계산
//메모리 14212kb 14076kb
//시간   104ms   104ms
//       BFS     DFS



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2644 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(br.readLine());
		int[][] family = new int[n + 1][n + 1];
		boolean[] visited = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int temp1 = Integer.parseInt(st.nextToken());
			int temp2 = Integer.parseInt(st.nextToken());
			family[temp1][temp2] = 1;
			family[temp2][temp1] = 1;
		}
		// 1이 있으면 연결되어있다는 뜻 해서 나올때까지 a와 연결된 모든 노드로 이동해서 ->b까지 간 횟수가 촌수
		// 만약에 다 돌앗는데 없으면 -1
		// DFS? a넣고 연결된 노드 stack에 다 넣음 +1촌
		// 이후에는 하나씩 빼고 방문안햇으면 넣고
//		System.out.println(dfs(family, visited, a, b));
		System.out.println(bfs(family, visited, a, b));

	}

	private static int bfs(int[][] family, boolean[] visited, int start, int target) {
		// TODO Auto-generated method stub
		Queue<int[]> que = new ArrayDeque<>();
		que.add(new int[] { start, 0 });
		visited[start] = true;
		while (!que.isEmpty()) {
			int[] temp = que.poll();
			int num = temp[0];
			int depth = temp[1];
			if (num == target) {
				return depth;
			}
			for (int i = 1; i < family.length; i++) {
				if (family[num][i] == 1 && !visited[i]) {
					visited[i] = true;
					que.add(new int[] { i, depth + 1 });
				}
			}

		}

		return -1;
	}

//	private static int dfs(int[][] family, boolean[] visited, int start, int target) {
//		// TODO Auto-generated method stub
//		Stack<int[]> stack = new Stack<>();
//		stack.push(new int[] { start, 0 });
//		visited[start] = true;
//
//		while (!stack.isEmpty()) {
//			int[] temp = stack.pop();
//			int num = temp[0];
//			int depth = temp[1];
//
//			if (num == target) {
//				return depth;
//			}
//
//			for (int i = 1; i < family.length; i++) {
//				if (family[num][i] == 1 && !visited[i]) {
//					visited[i] = true;
//					stack.push(new int[] { i, depth + 1 });
//				}
//			}
//		}
//		return -1;
//	}
}
