// 문제: 백준 1620번 문제제목 : 나는야 포켓몬 마스터 이다솜
// 링크: https://www.acmicpc.net/problem/1620
// 메모리 : 128844KB
// 시간: 712ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B1620 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

        //num_string : 숫자-문자열로 저장하여 숫자를 입력받았을 때 그에 해당하는 문자열을 뽑아내기 위한 Map
        //string_num : 문자열-숫자로 저장하여 문자열을 입력받았을 때 그에 해당하는 숫자를 뽑아내기 위한 Map
		Map<Integer, String> num_string = new HashMap<>();
		Map<String, Integer> string_num = new HashMap<>();

        //문자열을 받고 각 Map에 key, value로 저장함함
		for (int tc = 1; tc <= n; tc++) {
			String temp = br.readLine();
			num_string.put(tc, temp);
			string_num.put(temp, tc);
		}

		for (int i = 0; i < m; i++) {
			String temp = br.readLine();
			if (temp.matches("\\d+")) { //문자열 형태의 숫자로 받을 경우 정규표현식으로 체크함함
				sb.append(num_string.get(Integer.parseInt(temp))).append("\n");
			} else { //문자열을 받을 경우
				sb.append(string_num.get(temp)).append("\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

//    public static boolean isNumeric(String str) {
//    	return str.matches("\\d+");
//    }
}