// 문제: 백준 25192번 문제제목 : 인사성 밝은 곰곰이
// 링크: https://www.acmicpc.net/problem/25192
// 메모리 : 25484KB
// 시간: 252ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class B25192 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		Set<String> set = new HashSet<>();
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		for (int t = 0; t < n; t++) {
			String chat = br.readLine();
            // ENTER가 들어오지 않으면 : set에 넣어줌
			if (!chat.equals("ENTER")) {
				set.add(chat);
			} else { 
                // ENTER가 들어오면 : 현재 set에 저장된 사이즈를 저장해주고 set을 초기화
				count += set.size();
				set.clear();
			}
		}
        //set이 초기화되고 이후 한번도 ENTER가 들어오지 않을수도 있으므로
        //마지막에 count를 한번 더 저장해준다.
		count += set.size();
		sb.append(count);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}