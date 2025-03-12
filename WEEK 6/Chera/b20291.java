/**
 * 문제 : 백준 20291번 파일 정리
 * 메모리 : 67224KB
 * 시간 : 660ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

public class b20291 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		TreeMap<String, Integer> map = new TreeMap<>();
		
		for(int i = 0; i<N; i++) {
			String file = br.readLine();
			int idx = file.indexOf('.');
			String exten = file.substring(idx+1);
			map.put(exten, map.getOrDefault(exten, 0)+1);
			
		}
		
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			sb.append(entry.getKey() + " " + entry.getValue()+"\n");

		}
		
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
	}
}
