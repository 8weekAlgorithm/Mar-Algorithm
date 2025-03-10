// 문제 : 25192 인사성 밝은 곰곰이
// 메모리 : 25348 KB
// 시간 : 232 ms

package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class B25192 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		int count = 0;
		
		for(int i = 0; i < N; i++) { 
			String chat = br.readLine();
			if(chat.equals("ENTER")) set.clear();
			else if(set.add(chat)) count++;
		}
		System.out.println(count);
	}
}
