// 문제: 백준 18429번 집합
// 메모리: 14372KB
// 시간: 116ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B18429 {
	static int[] gains;
	static int N;
	static int K;
	static int cnt;
	static int[] result;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		gains = new int[N];
		result = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			gains[i] = Integer.parseInt(st.nextToken());
		}
		
		perm(500, 0);
		System.out.println(cnt);
		
	}//end of main
	
	static void perm(int weight, int day) {
		//기저조건
		if(day == N) {
			cnt++;
			return;
		}
		
		//재귀부분
		for(int i = 0; i < N; i++) {
			if(visited[i] || weight + gains[i] - K < 500) continue;
			result[day] = gains[i];
			visited[i] = true;
			perm(weight + gains[i] - K, day+1);
			visited[i] = false;
		}
	}
	
}//end of class
