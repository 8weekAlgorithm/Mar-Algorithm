import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//B2339 스도쿠 -> 불가핑....
//메모리 kb, 시간 ms
public class B2339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] arr = new char[9][9];

        for(int i=0;i<9;i++){
            String tmp = br.readLine();
            for(int j=0;j<9;j++){
                arr[i][j] = tmp.charAt(j);
            }
        }


//        bw.write();
        bw.flush();
        bw.close();
        br.close();
    }//main
}
