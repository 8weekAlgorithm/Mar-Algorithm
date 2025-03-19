import java.io.*;

//B17419 비트가 넘쳐흘러
//메모리 14184kb, 시간 100ms
public class B17419 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine(),2); //문자열을 2진수로 인식하고 변환
        int cnt = 0;
        while(K!=0){
            K = K-(K&((~K)+1));
            cnt++;
        }

        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }//main
}
