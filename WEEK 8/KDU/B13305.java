// 문제: 백준 13305번 
// 문제제목 : 주유소
// 링크: https://www.acmicpc.net/problem/13305
// 메모리 : 40532KB
// 시간: 408ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		List<Integer> dist = new ArrayList<>();
		List<Integer> price = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			dist.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		// 비용 배열 저장하면서 가장 작은 값이 먼저 나오는 인덱스를 minindex에 저장함
		// 가장 작은 값은 min에 저장함
		for (int i = 0; i < N; i++) {
			price.add(Integer.parseInt(st.nextToken()));
		}
		long total = 0;
		long minprice = price.get(0);
        // 노드를 지나가면서 최솟값을 만나면 갱신해주면서 dist의 값들과 곱해줌
		for (int i = 0; i < N-1; i++) {
			if (price.get(i) < minprice) {
				minprice = price.get(i);
			}
			total += minprice * dist.get(i);
		}
		System.out.println(total);
	}

}
