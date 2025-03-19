// 문제: 백준 17419번 
// 문제제목 : 비트가 넘쳐흘러
// 링크: https://www.acmicpc.net/problem/17419
// 메모리 : 20148KB
// 시간: 216ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17419 {
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		String bit = br.readLine();
		int count = 0;
        // K = K - (K&((-K)+1))
        // 이 연산은 2진수에서 가장 오른쪽에 있는 1을 빼는 연산이다.(Brian Kernighan’s Algorithm)
        // 결국 0이 될때까지 빼야된다는 말은 이 숫자를 2진수로 표현했을때 1이 몇개있는지를 체크하는 과정임
		for (int i = 0; i < N; i++) {
			if (bit.charAt(i) == '1') {
				count++;
			}
		}

		System.out.println(count);
	}

}
