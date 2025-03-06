//문제 : 15663 n과m(9)
//메모리 : 21356kb
//시간 : 168ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15563 {

	static int n;
	static int m;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());// 배열 크기
		m = Integer.parseInt(st.nextToken());// 조합수
		arr = new int[n];
		visited = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		recursion(0, new int[m]);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void recursion(int cur, int[] select) {
		// TODO Auto-generated method stub
		if (cur == m) {
			for (int a : select) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
			return;
		}
		int pre = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i] && arr[i] != pre) {
				visited[i] = true;
				select[cur] = arr[i];
				recursion(cur + 1, select);
				visited[i] = false;
				pre = arr[i];
			}
		}
	}
}