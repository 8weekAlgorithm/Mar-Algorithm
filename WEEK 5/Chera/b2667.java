/**
 * 문제 : 백준 2667번 단지번호붙이기
 * 메모리 : 15788KB
 * 시간 : 120ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class b2667 {
	static int N;
	static int[][] graph;
	static PriorityQueue<Integer> sortCnt;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static boolean[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		for(int i = 0; i<N; i++) {
			String[] str = br.readLine().split("");
			for(int j = 0; j<N; j++) {
				graph[i][j] = Integer.valueOf(str[j]) ;
			}
		}

		sortCnt = new PriorityQueue<>();
		visit = new boolean[N][N];
		bfs();
		int size = sortCnt.size();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<size; i++) {
			sb.append(sortCnt.poll());
			sb.append("\n");
		}
		System.out.println(size);
		System.out.println(sb.toString());
	}
	
	static void bfs() {
		Queue<int[]> qu = new LinkedList<>();
		
		label : for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(!visit[i][j] && graph[i][j] == 1) {
					qu.add(new int[]{i, j});
					break label;
				}
			}
		}
		
		if(qu.isEmpty()) return;
		
		int cnt = 1;
		while(!qu.isEmpty()) {
			int[] n = qu.poll();
			int nx = n[0];
			int ny = n[1];
			visit[nx][ny] = true;
			for(int i = 0; i<dx.length; i++) {
				int x = nx + dx[i];
				int y = ny + dy[i];
				
				if(x<0 || y<0 || x>=N || y>=N) {
					continue;
				}
				
				if(!visit[x][y] && graph[x][y]==1) {
					qu.add(new int[] {x, y});
					visit[x][y] = true;
					cnt ++;
				}
			}
		}
		sortCnt.add(cnt);
		bfs();
	}
}
