// 문제: 백준 11047번 동전 0
// 메모리: 14240KB
// 시간: 104ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11047 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//동전의 종류
		
		int K = Integer.parseInt(st.nextToken()); //만들 금액
		
		int[] coins = new int[N];
		for(int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
//		System.out.println(Arrays.toString(coins));
		
		int cnt = 0; //필요한 동전 수
		
		for(int i = N-1; i >= 0; i--) {//큰 동전부터 탐색
			if(coins[i] <= K) {
				cnt += K / coins[i]; //K를 monies[i]로 나눈 몫만큼 i번째 동전 필요
				K %= coins[i];//나눈 나머지가 남은 금액
			}
		}
		System.out.println(cnt);
	}
}
