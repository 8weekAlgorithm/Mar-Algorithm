// 문제: 백준 2002 추월
// 메모리: 15736 KB
// 시간: 160 ms

// 문제이해못해서GPT선생님께여쭤봤습니다
// 근데이것도이해못함ㅎㅎ;;

import java.io.*;
import java.util.*;

public class b2002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));

		int n = Integer.parseInt(br.readLine());

		Map<String, Integer> entrance = new HashMap<>();
		String[] exit = new String[n];

		// 터널 입구에서 확인한 차량 번호 매핑
		for (int i = 0; i < n; i++)
			entrance.put(br.readLine(), i);

		// 터널 출구에서 확인한 차량 번호 목록
		for (int i = 0; i < n; i++)
			exit[i] = br.readLine();

		int count = 0;
		// 출구 순서대로 탐색하며, 이후에 등장하는 차량 중 입구 순서가 더 앞선 차량이 있는지 확인
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (entrance.get(exit[i]) > entrance.get(exit[j])) {
					count++;
					break;
				}
			}
		}

		// 결과 출력
		System.out.println(count);
	}
}