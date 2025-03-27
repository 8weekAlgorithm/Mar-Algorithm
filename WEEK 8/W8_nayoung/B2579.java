import java.io.*;
import java.util.StringTokenizer;

//B2579 계단 오르기
//메모리 14276kb, 시간 104ms
public class B2579 {
    static int[] memo;
    static int[] arr;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        memo = new int[N+1];

        bw.write(dp(N)+"");
        bw.flush();
        bw.close();
        br.close();
    }//main

    static int dp(int n){
        if(n>=0 && n<=1){
            memo[n] = arr[n];
            return memo[n];
        }else if(n==2){
            memo[2] = arr[1]+arr[2];
            return memo[2];
        }else if(memo[n]!=0){
            return memo[n];
        }else {
            memo[n] = Math.max(dp(n - 3) + arr[n - 1] + arr[n], dp(n - 2) + arr[n]);
            return memo[n];
        }
    }//dp
}
