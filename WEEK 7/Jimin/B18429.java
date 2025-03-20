// 문제: 18429 근손실
// 메모리: 14368 KB
// 시간: 116 ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B18429 {
	static int N, K, count;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 운동 키트 개수
		K = Integer.parseInt(st.nextToken()); // 중량 감소량
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		count = 0;
		recur(0, 500);
		bw.write(String.valueOf(count));
		
		br.close();
		bw.flush();
		bw.close();
	}

	public static void recur(int day, int kg) {
		if (day == N) {
			count++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i] || kg + arr[i] - K < 500)
				continue;
			visited[i] = true;
			recur(day + 1, kg + arr[i] - K);
			visited[i] = false;
		}
	}
}