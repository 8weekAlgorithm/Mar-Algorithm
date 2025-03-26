import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

//B13305 주유소
//메모리 62884kb, 시간 452ms
public class B13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] Edge = new int[N-1];
        int[] Node = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N-1;i++){
            Edge[i] = Integer.parseInt(st.nextToken());
        }//간선채우기 끝
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            Node[i] = Integer.parseInt(st.nextToken());
        }//노드채우기 끝

        int minPrice = Integer.MAX_VALUE;
        BigInteger sum = BigInteger.valueOf(0); //큰 수 처리를 위해 총비용을 BigInteger로 선언
        for(int i=0;i<N-1;i++){
            if(minPrice>Node[i]) minPrice=Node[i]; //새로운 최소 리터값이 나오기 전까지 가장 최소 리터값을 사용
            sum = sum.add(BigInteger.valueOf(minPrice).multiply(BigInteger.valueOf(Edge[i])));
        }

        bw.write(""+sum);
        bw.flush();
        bw.close();
        br.close();
    }//main
}
