//문제 : 15655 n과m(6)
//메모리 : 14280kb
//시간 : 104ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15655 {

	static int n;
	static int m;
	static int[] arr;
//	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());// 배열 크기
		m = Integer.parseInt(st.nextToken());// 조합수
		arr = new int[n];
//		visited = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		recursion(0, 0, new int[m]);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void recursion(int cur, int start, int[] select) {// 조합 앞뒤 같으면 중복허용 x
		// TODO Auto-generated method stub
		if (cur == m) {
			for (int a : select) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < n; i++) {
			select[cur] = arr[i];
			recursion(cur + 1, i + 1, select);

		}
	}
}
