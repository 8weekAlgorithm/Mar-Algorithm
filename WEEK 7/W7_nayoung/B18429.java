import java.io.*;
import java.util.StringTokenizer;

//B18429 근손실
//메모리 14488kb, 시간 116ms
public class B18429 {
    static int[] arr;
    static int N;
    static int K;
    static int cnt; //중량 500 이상 유지하는 경우의 수
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0,500);
        bw.write(cnt+"");

        bw.flush();
        bw.close();
        br.close();
    }//main

    static void backtracking(int n, int weight){
        if(n==N){
            cnt++;
            return;
        }

        for(int i=0;i<N;i++){
            if(!visited[i]){ //방문 안 한 날이면
                int newWeight = weight+arr[i]-K;
                if(newWeight>=500){ //중량이 500이상이면
                    visited[i] = true; //그날 ok
                    backtracking(n+1, newWeight); //다음날로 넘어가
                    visited[i] = false; //그날 다시 not ok
                }
            }
        }
    }
}
