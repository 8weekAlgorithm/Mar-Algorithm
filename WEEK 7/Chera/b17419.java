/**
 * 지선생 ,,,,
 * 문제 : 17419번 비트가 넘쳐 흘러
 * 메모리 : 21988 KB
 * 시간 : 244ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b17419 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // N 입력 받음 (사용 안됨)
        String K_bin = br.readLine(); // 이진수 문자열 입력

        // **이진수 문자열에서 '1'의 개수 세기**
        int cnt = 0;
        for (char c : K_bin.toCharArray()) {
            if (c == '1') cnt++;
        }

        System.out.println(cnt);
    }
}
