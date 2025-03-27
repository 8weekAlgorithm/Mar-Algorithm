// 문제: 13305 주유소
// 메모리: 34264 KB
// 시간: 328 ms


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13305 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		// 거리 입력
		StringTokenizer distSt = new StringTokenizer(br.readLine());

		// 가격 입력
		StringTokenizer priceSt = new StringTokenizer(br.readLine());
		
		long totalCost = 0;                          // 총 비용
		long minPrice = Long.parseLong(priceSt.nextToken()); // 첫 번째 도시의 기름값

		for (int i = 0; i < N - 1; i++) {
			int dist = Integer.parseInt(distSt.nextToken()); // i번째 도로의 거리
			totalCost += minPrice * dist;                    // 현재까지 가장 싼 가격으로 주유

			long nextPrice = Long.parseLong(priceSt.nextToken()); // 다음 도시 기름값
			if (nextPrice < minPrice) {
				minPrice = nextPrice; // 더 싸면 갱신
			}
		}

		System.out.println(totalCost);
	}
}
