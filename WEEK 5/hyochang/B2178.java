//2178 미로와 탐색
//메모리 14624kb
//시간 112ms


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178 {
	static int n;
	static int m;
	static int[][] miro;
	static boolean[][] visited;
	static int[][] time;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		miro = new int[n][m];
		visited = new boolean[n][m];
		time = new int[n][m];
		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < m; j++) {
				miro[i][j] = temp.charAt(j)-'0';
			}
		}

		bfs();
		System.out.println(time[n-1][m-1]);
	}

	static void bfs() {
		// TODO Auto-generated method stub
		Queue<int[]> que = new ArrayDeque<>();
		que.add(new int[] { 0, 0 });
		time[0][0]=1;
		visited[0][0]=true;
		while (!que.isEmpty()) {
			int[] temp = que.poll();
			int y = temp[0];
			int x = temp[1];

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny >= 0 && ny < n && nx >= 0 && nx < m && miro[ny][nx] == 1 && !visited[ny][nx]) {
					que.add(new int[] { ny, nx });
					time[ny][nx]=time[y][x]+1;
					visited[ny][nx] = true;
				}
			}
		}
	}
}