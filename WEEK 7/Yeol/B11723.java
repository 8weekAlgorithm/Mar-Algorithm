// 문제: 백준 11723번 집합
// 메모리: 314952KB
// 시간: 1032ms

import java.io.*;
import java.util.*;

public class B11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        int S = 0; // 비트마스킹을 위한 정수

        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int x = 0; // all이나 empty이면 x를 쓰지 않음
            if (!command.equals("all") && !command.equals("empty")) {
                x = Integer.parseInt(st.nextToken());
            }

            switch (command) {
                case "add":
                    S |= (1 << x); // x번째 비트를 1로 설정
                    break;
                case "remove":
                    S &= ~(1 << x); // x번째 비트를 0으로 설정
                    break;
                case "check":
                    sb.append((S & (1 << x)) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle":
                    S ^= (1 << x); // x번째 비트를 반전
                    break;
                case "all":
                    S = (1 << 21) - 1; // {1~20}을 모두 포함한 값
                    break;
                case "empty":
                    S = 0; // 공집합
                    break;
            }
        }
        System.out.print(sb.toString());
    }
}
