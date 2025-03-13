/**
 * 문제 : 백준 22252번 정보 상인 호석
 * 메모리 : 233788KB
 * 시간 : 1412ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b22252 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<String, PriorityQueue<Integer>> map = new HashMap<>();
		long sum = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int info = Integer.parseInt(st.nextToken());
			String go = st.nextToken();
			int length = Integer.parseInt(st.nextToken());
			
			if (info == 1) {
				for (int j = 0; j < length; j++) {
					map.put(go, map.getOrDefault(go, new PriorityQueue<>(Collections.reverseOrder())));
					map.get(go).add(Integer.parseInt(st.nextToken()));
				}

			} else {	
				map.put(go, map.getOrDefault(go, new PriorityQueue<>(Collections.reverseOrder())));
				if (map.get(go).isEmpty()) {
					continue;
				}
				for (int j = 0; j < length; j++) {
					sum += map.get(go).poll();
					if (map.get(go).isEmpty()) {
						break;
					}
				}
			}

		}
		System.out.println(sum);
	}

}
