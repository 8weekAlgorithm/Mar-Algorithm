// 문제: 백준 20291 파일 정리
// 메모리: 65032 KB
// 시간: 676 ms

import java.io.*;
import java.util.*;

public class b20291 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		TreeMap<String, Integer> map = new TreeMap<>();

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			// 확장자(.)를 기준으로 분할
			String[] input = br.readLine().split("\\."); 

			if (map.containsKey(input[1])) {
				map.replace(input[1], map.get(input[1]) + 1);
			} else {
				map.put(input[1], 1);
			}
		}

		for (Map.Entry<String, Integer> m : map.entrySet())
			sb.append(m.getKey()).append(' ').append(m.getValue()).append('\n');

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
