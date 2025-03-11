// 문제: 백준 4358 생태학
// 메모리: 84740 KB
// 시간: 816 ms

import java.io.*;
import java.util.*;

public class b4358 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		TreeMap<String, Integer> map = new TreeMap<>();
		int N = 0;

		String input;
		while ((input = br.readLine()) != null) {
			N++;
			map.put(input, map.getOrDefault(input, 0) + 1);
		}

		for (Map.Entry<String, Integer> m : map.entrySet()) {
			double per = (m.getValue() / (double) N) * 100;

			sb.append(m.getKey()).append(' ');
			sb.append(String.format("%.4f", per)).append('\n');
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
