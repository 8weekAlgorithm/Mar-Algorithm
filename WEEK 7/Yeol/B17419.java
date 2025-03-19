// 문제: 백준 17419번 비트가 넘쳐흘러
// 메모리: 21960KB
// 시간: 240ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B17419 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄 입력: N값이지만 실제로 사용할 필요 없음
        int N = Integer.parseInt(br.readLine()); 
        
        // 두 번째 줄 입력: 이진수 K
        String K = br.readLine();
        
        int count = 0; // 1의 개수를 저장할 변수
        
        // 문자열을 순회하면서 '1'의 개수를 센다.
        for (char bit : K.toCharArray()) {
            if (bit == '1') {
                count++; // '1'을 발견할 때마다 count 증가
            }
        }

        System.out.println(count);
    }
}
