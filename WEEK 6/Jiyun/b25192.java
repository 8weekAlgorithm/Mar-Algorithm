// 문제: 백준 25192 인사성 밝은 곰곰이
// 메모리: 25508 KB
// 시간: 248 ms

import java.io.*;
import java.util.*;

public class b25192 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		HashSet<String> set = new HashSet<>();
		int answer = 0;

		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			String input = br.readLine();

			if (input.equals("ENTER")) {
				answer += set.size();
				set.clear(); // 누군가 입장하면(ENTER) 초기화
			} else {
				set.add(input);
			}
		}

		answer += set.size();
		System.out.println(answer);
	}
}
