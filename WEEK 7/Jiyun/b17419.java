// 문제: 17419 비트가 넘쳐흘러
// 메모리: 20112 KB
// 시간: 220 ms

import java.io.*;

// K - (K & (~K + 1))는 가장 오른쪽에 있는 1을 제거한다
// 즉, K의 1의 개수를 세면 해결할 수 있는 문제 
public class b17419 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));

		int N = Integer.parseInt(br.readLine());
		String K = br.readLine();

		int answer = 0;

		for (int i = 0; i < N; i++) {
			if (K.charAt(i) == '1')
				answer++;
		}

		System.out.println(answer);
	}
}
