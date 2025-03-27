/**
 * 문제 : 백준 11047번 동전 0
 * 메모리 : 14216KB
 * 시간 : 112ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b11047 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		for(int i = N-1; i>=0; i--) {
			
			cnt += K/arr[i];
			K = K % arr[i];
			
			if(K==0) {
				break;
			}
		}
		
		System.out.println(cnt);
	}

}
