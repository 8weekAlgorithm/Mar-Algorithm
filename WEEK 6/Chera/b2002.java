/**
 * 문제 : 백준 2002번 추월
 * 메모리 : 14456KB
 * 시간 : 116ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class b2002 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<String, LinkedList<String>> map = new HashMap<>();

		map.put("DG", new LinkedList<>()); //대근이
		map.put("YS", new LinkedList<>()); //영식이
		
		for(int i = 1; i<=N; i++) {
			map.get("DG").add(br.readLine());
		}
		for(int i = 1; i<=N; i++) {
			map.get("YS").add(br.readLine());
		}
		int cnt = 0;
		for(int i = 1; i<N; i++) {
			String car = map.get("YS").getFirst();
			if(!car.equals(map.get("DG").getFirst())) {
				cnt++;
			}
			map.get("DG").remove(car);
			map.get("YS").remove(car);
			
		}
		System.out.println(cnt);
	}
}
