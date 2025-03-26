// 문제: 백준 13305번 주유소
// 메모리: 36600KB
// 시간: 332ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13305 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); //도시의 개수
		
		long[] dist = new long[N-1]; //두 도시를 연결하는 도로의 길이 저장할 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N-1; i++) {
			dist[i] = Long.parseLong(st.nextToken());
		}//배열에 값 입력
		
		long[] costs = new long[N]; //각 도시의 기름 리터당 가격 저장할 배열
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			costs[i] = Long.parseLong(st.nextToken());
		}//배열에 값 입력
		
		
		long totalCost = 0;//총 비용
		long minPrice = costs[0]; //최소 가격
		
		for(int i = 0; i < N-1; i++) {
			if(costs[i] < minPrice) {
				minPrice = costs[i];
			}
			totalCost += minPrice * dist[i];
		}
		
		System.out.println(totalCost);
	}
}
