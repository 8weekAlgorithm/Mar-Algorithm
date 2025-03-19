import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

//B15661 링크와 스타트
//메모리 253628kb, 시간 916ms
public class B15661 {
    static int[][] arr;
    static int N;
    static List<Integer> link;
    static List<Integer> start;
    static int linkSum;
    static int startSum;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        link = new ArrayList<>();
        start = new ArrayList<>();
        min = Integer.MAX_VALUE;
        linkSum = 0;
        startSum = 0;
        for(int i=1;i<(1<<N)-1;i++){
            for(int j=0;j<N;j++){
                if((i&(1<<j))!=0){
                    link.add(j);
                }else{
                    start.add(j);
                }
            }
            for(int m=0;m<link.size()-1;m++){
                for(int n=m+1;n<link.size();n++){
                    linkSum += arr[link.get(m)][link.get(n)]+arr[link.get(n)][link.get(m)];
                }
            }
            for(int m=0;m<start.size()-1;m++){
                for(int n=m+1;n<start.size();n++){
                    startSum += arr[start.get(m)][start.get(n)]+arr[start.get(n)][start.get(m)];
                }
            }
            min = Math.min(Math.abs(linkSum-startSum),min);
            //다시 초기화
            linkSum = 0;
            startSum = 0;
            link = new ArrayList<>();
            start = new ArrayList<>();
        }

        System.out.println(min);

//        bw.write(min+"");
//        bw.flush();
//        bw.close();
        br.close();
    }//main
}
