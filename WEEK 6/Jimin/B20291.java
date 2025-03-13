// 문제 : 20291 파일 정리
// 메모리 : 54488 KB
// 시간 : 752 ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

class B20291 {
	public static void main(String[] args) throws IOException {
		// 사전 순 정렬 -> TreeMap
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 바탕화면에 있는 파일의 개수
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> tm = new TreeMap<>();
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("\\.");
			// split(".") -> "."이 정규 표현식에서 **모든 문자(any character)**를 의미한다.
			tm.put(str[1], tm.getOrDefault(str[1], 0) + 1);
		}
		// 혹시나 여기 부분에서 에러가 발생한 적이 있으면 말씀해주세요.
		for(Map.Entry<String, Integer> entry : tm.entrySet()) {
			bw.write(entry.getKey() + " " + entry.getValue() + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}