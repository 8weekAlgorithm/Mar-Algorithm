import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//B11053 가장 긴 증가하는 부분수열
//메모리 15000kb, 128ms
public class B11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N]; //수열A
        int[] dp = new int[N]; //각 원소까지의 가장 긴 증가하는 부분수열의 길이를 저장하는 배열
        Arrays.fill(dp,1); //부분수열은 자기 자신을 포함하므로 길이는 최소 1

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }//수열채우기 끝

        int max;
        for(int i=1;i<N;i++){ //두번째 원소부터 각 원소마다 점검
            max = 0;
            for(int j=0;j<i;j++){ //첫번째원소(인덱스0)부터 해당 원소 전까지의 원소들 중
                //해당 원소보다 작은 값이라면 해당 원소가 그 뒤에 붙을 수 있음. 이때 가장 긴 증가하는 부분수열에 붙도록 max 갱신
                if(arr[j]<arr[i] && max<dp[j]) max = dp[j];
            }
            dp[i] = max + 1; //가장 긴 증가하는 부분수열의 길이 + 1 (그 전의 원소들이 모두 해당 원소보다 작거나 같다면 max=0)
        }

        int maxLen = 0;
        for(int i=0;i<N;i++){
            if(maxLen<dp[i]) maxLen = dp[i];
        }//가장 긴 증가하는 부분수열의 길이 구하기

        bw.write(""+maxLen);
        bw.flush();
        bw.close();
        br.close();
    }//main
}
