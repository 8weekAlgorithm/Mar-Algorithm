/**
 * 문제 : 백준 18429번 근손실
 * 메모리 : 14884KB
 * 시간 : 120 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b18429 {
	static int N, K, cnt;
	static int[] arr, res;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		res = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		visited = new boolean[N];
		cnt = 0;
		kits(0);
		System.out.println(cnt);
		
	}
	
	static void kits(int idx) {
		if(idx==N) {
			boolean plus = true;
			int muscle = 500;
			for(int i = 0; i<N; i++) {
				muscle += res[i]-K;
				if(muscle<500) {
					plus= false;
					break;
				}
			}
			if(plus) {
				cnt++;
			}

			return;
		}
		
		for(int i = 0; i<N; i++) {
			if(!visited[i]) {
				res[idx]=arr[i];
				visited[i] = true;
				kits(idx+1);
				visited[i] = false;
			}
		}
	}
}
