// 문제: 백준 20291번 파일 정리
// 메모리: 64744KB
// 시간: 728ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 확장자별 개수를 저장할 TreeMap (자동 정렬)
        // key : 확장자, value : 개수
        TreeMap<String, Integer> map = new TreeMap<>();
        
        for (int i = 0; i < N; i++) {
            String fileName = br.readLine();
            String extension = fileName.split("\\.")[1]; // "."을 기준으로 나누고 확장자 가져오기
            
            // (확장자가 있으면 기존 개수, 없으면 0) + 1
            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }
        
        // 출력
        StringBuilder sb = new StringBuilder();
        for (String key : map.keySet()) { //keySet() : key 목록을 가져옴 /// map.entrySet()을 이용하는게 더 빠르다..
            sb.append(key).append(" ").append(map.get(key)).append("\n");
        }
        System.out.print(sb.toString());
    }
}