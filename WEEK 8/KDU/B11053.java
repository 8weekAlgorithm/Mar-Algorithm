// 문제: 백준 11053번 
// 문제제목 : 가장 긴 증가하는 부분 수열
// 링크: https://www.acmicpc.net/problem/11053
// 메모리 : 14560KB
// 시간: 120ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B11053 {

	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] dp = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1; //dp의 배열 값은 처음에 1
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (A[j] < A[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
		
		
	}

}
