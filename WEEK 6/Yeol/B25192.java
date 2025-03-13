// 문제: 백준 25192번 인사성 밝은 곰곰이
// 메모리: 25368KB
// 시간: 240ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); //채팅방 기록 수
		
		HashSet<String> set = new HashSet<>();
		
		int cnt = 0; //곰곰티콘이 나온 횟수
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			
			if(str.equals("ENTER")) {
				cnt += set.size(); //지금까지 나온 곰곰티콘 횟수 더함
				set.clear(); //set 지우기
			}
			else {
				set.add(str); //set 추가		
			}
		}
		
		//다 수행하고 남은 set의 수만큼 곰곰티콘이 나온 횟수에 더함
		cnt += set.size();
		
		//최종 결과 출력
		System.out.println(cnt);
	}
}
