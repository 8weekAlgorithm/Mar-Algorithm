// 문제: 백준 20291번 문제제목 : 파일 정리
// 링크: https://www.acmicpc.net/problem/20291
// 메모리 : 64480KB
// 시간: 700ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

public class B20291 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		String[] extension = null;
		// 확장자명을 저장할 String을 key값으로, 카운트를 저장할 integer를 value값으로 가질 Map을 생성함
        // 출력값이 key의 오름차순으로 정렬되야 하므로 Treemap 사용
		Map<String, Integer> treemap = new TreeMap<>();
		for (int i = 0; i < n; i++) {
            // 받은 문자열을 "."을 기준으로 앞뒤 배열로 나눔
            // put을 이용하여 특정 키값일때 값을 누적해서 더해줌
            // getOrDefault를 이용하여 키 값이 없으면 0, 있는 경우 키값에 해당하는 value를 불러온다
			extension = br.readLine().split("\\.");
			String ext = extension[1];
			treemap.put(ext, treemap.getOrDefault(ext, 0)+1);
		}

        // entrySet을 이용하여 전체 Map의 데이터를 Set으로 변경시킴
        // 이렇게 하면 for-each문을 이용하여 Key와 Value에 쉽게 접근이 가능함
		for (var s : treemap.entrySet()) {
			sb.append(s.getKey()).append(" ").append(s.getValue()).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}