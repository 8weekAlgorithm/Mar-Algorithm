import java.io.*;
import java.util.StringTokenizer;

//B11723 집합
//메모리 299304kb, 시간 1020ms
public class B11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        int S = 0;

        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            switch (order){
                case "add":
                    int x1 = Integer.parseInt(st.nextToken());
                    if((S&(1<<x1))==0) S = S | (1<<x1); //S에 x가 없으면 추가
                    break;
                case "remove":
                    int x2 = Integer.parseInt(st.nextToken());
                    if((S&(1<<x2))!=0) S = S & ~(1<<x2); //S에 x가 있으면 삭제
                    break;
                case "check":
                    int x3 = Integer.parseInt(st.nextToken());
                    if((S&(1<<x3))!=0) bw.write(1+"\n"); //S에 x가 있으면 1 출력
                    else if((S&(1<<x3))==0) bw.write(0+"\n");  //S에 x가 있으면 0 출력
                    break;
                case "toggle":
                    int x4 = Integer.parseInt(st.nextToken());
                    if((S&(1<<x4))!=0) S = S & ~(1<<x4); //S에 x가 있으면 삭제
                    else if((S&(1<<x4))==0) S = S | (1<<x4); //없으면 추가
                    break;
                case "all":
                    S = ~S^S; //xor 연산 이용해서 비트를 모두 0으로 바꾼 후 not연산 이용해서 모두 1로 전환
                    break;
                case "empty":
                    S = 0;
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }//main

}
