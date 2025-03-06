// 문제: 백준 15663번 N과 M(9) => 중복없는순열
// 메모리: 39592KB
// 시간: 300ms


import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B15663 {
    static int[] arr; //입력받은 배열 -> 여기서 M개의 수를 뽑는다!(data)
    static int N, M; //N개의 수 중 M을 뽑는다.
    static int[] sel; //뽑은 M개의 수를 저장하는 배열
    static StringBuilder sb;
    static Set<String> result; //중복 제거해서 저장해두는 집합(set)
    static boolean[] visited; //각 수에 대한 방문배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); //데이터 오름차순 정렬

        //순열 뽑기
        sel = new int[M];
        visited = new boolean[N];
        result = new LinkedHashSet<>();
        per(0); //순열메서드 호출 - result에 모든 경우의 수 저장되어 있음(set이므로 중복되는 수열 제외)

        //결과 출력
        for(String e: result){
            bw.write(e+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }//main

    //순열 메서드
    static void per(int depth) {
        if (depth == M) {
            // M개의 숫자를 고른 경우, 결과를 String 형태로 Set에 저장
            sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(sel[i]).append(" ");
            }
            result.add(sb.toString().trim()); // Set에 추가
            return;
        }

        //데이터의 모든 수에 대해 순회
        for (int i = 0; i < N; i++) {
            if(!visited[i]){ //이미 방문한 수가 아닌 경우만
                visited[i]=true;
                sel[depth] = arr[i]; //새로운 배열값으로 넣기
                per(depth + 1); // 재귀 호출
                visited[i] = false; //백트래킹
            }
        }
    }

}
