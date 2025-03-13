// 문제: 백준 4358번 생태학
// 메모리: 87652KB
// 시간: 896ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Map<String, Integer> map = new TreeMap<>();
		
		String tree; // 나무 입력 준비
		int totalCnt = 0; // 전체 나무 종 수
		
		// 나무 입력이 없을 때까지(=입력이 있는 동안)
		while((tree = br.readLine()) != null && !tree.isEmpty()){ //!tree.isEmpty()는 공백으로 들어온 tree를 무시하겠다는 뜻
			map.put(tree, map.getOrDefault(tree, 0) + 1); // 입력된 종이 이미 map에 있으면 기존 개수 + 1, 없으면 1로 초기화)
			totalCnt++;
		}
		
		//entrySet()은 Set<Map.Entry<K, V>> 타입을 반환
		//for (Map.Entry<K, V> entry : map.entrySet()) 형태로 써야 entry.getKey(), entry.getValue()를 쓸 수 있음.
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey(); // 나무 종(이름)
			int cnt = entry.getValue(); // 나무 종별 수
			double percentage = (cnt * 100.0) / totalCnt; // 종이 차지하는 비율
			sb.append(String.format("%s %.4f\n", key, percentage));
		}
		
		System.out.println(sb.toString());
	}
}
