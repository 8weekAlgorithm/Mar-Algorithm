/**
 * 문제 : 백준 25192번 인사성 밝은 곰곰이
 * 메모리 : 28580KB
 * 시간 : 244ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class b25192 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Set<String> set = new HashSet<>();
		int cnt = 0;
		
		for(int i = 0; i<N; i++) {
			String input = br.readLine();
			if(input.equals("ENTER")) {
				cnt+=set.size();
				set = new HashSet<>();
			}else {
				set.add(input);
			}
		}
		cnt+=set.size();
		
		System.out.println(cnt);
		
	}

}
