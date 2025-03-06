// 문제: 백준 15655번 N과 M(6) => 중복x조합문제!
// 메모리: 14444KB
// 시간: 108ms

import java.io.*;
import java.util.*;

public class B15655 {
    static int[] arr; // 입력받은 배열
    static int N, M;  // N개의 수 중 M을 뽑는다
    static int[] sel; // 뽑은 M개의 수를 저장하는 배열
    static Set<String> result; // 결과를 저장할 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 배열을 정렬하여 사전 순으로 출력
        Arrays.sort(arr);

        // 조합을 뽑기 위한 배열 초기화
        sel = new int[M];
        result = new LinkedHashSet<>();

        // 조합을 구하는 메서드 호출
        comb(N,M);

        String[] resultArr = new String[result.size()];
        int idx = 0;
        for(String e: result){
            resultArr[idx++] = e;
        }
        Arrays.sort(resultArr); //문자열 요소들에 대해 사전순으로 오름차순 정렬

        // 결과 출력
        for (String e : resultArr) {
            bw.write(e + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 조합을 구하는 메서드
    static void comb(int n, int m) {
        if (m==0) {
            // M개의 숫자를 고른 경우, 결과를 String 형태로 set에 저장
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(sel[i]).append(" ");
            }
            result.add(sb.toString().trim()); // set에 추가
            return;
        }else if(n<m){
        }else{
            sel[m-1] = arr[n-1];
            comb(n-1,m-1);
            comb(n-1,m);
        }
    }
}
