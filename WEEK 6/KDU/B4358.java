// 문제: 백준 4358번 문제제목 : 생태학
// 링크: https://www.acmicpc.net/problem/4358
// 메모리 : 121152KB
// 시간: 628ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class B4358 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String tree;
		double count = 0;
        // 처음에는 HashMap으로 빠르게 저장하고, 나중에 저장된 Map을 TreeMap으로 바꿔주면
        // 정렬되는데 소요되는 시간을 최적화할 수 있음음
		Map<String, Double> map = new HashMap<>();
        // 문자열 입력값이 안들어올때까지(다음 입력값이 없는 값인 경우) 반복해서 문자열 입력받음
		while ((tree=br.readLine()) != null && !tree.isEmpty()) {
			map.put(tree, map.getOrDefault(tree, (double)0) + 1);
			count++;
		}
		
		TreeMap<String,Double> treemap = new TreeMap<>(map);

		for (var s : treemap.entrySet()) {
			double value = (s.getValue() / count)*100;
			String result = String.format("%.4f", value);
			sb.append(s.getKey()).append(" ").append(result).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}