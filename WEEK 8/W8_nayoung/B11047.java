import java.io.*;
import java.util.StringTokenizer;

//B11047 동전0
//메모리 17188kb, 시간 164ms
public class B11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for(int i=N-1;i>=0;i--){
            while(arr[i]<=K){
                K -= arr[i];
                cnt++;
            }
        }

        bw.write(cnt+"");

        bw.flush();
        bw.close();
        br.close();
    }
}
