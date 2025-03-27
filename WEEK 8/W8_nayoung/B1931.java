import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

//B1931 회의실 배정
//메모리 44936kb, 시간 484ms
public class B1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        //배열 정렬해주기
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==(o2[0])) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        //정렬확인용 출력
//        System.out.println(Arrays.deepToString(arr));

        //첫번째 회의는 일단 선택
        int minEnd = arr[0][1]; //최소 종료시간은 일단 첫번째 회의 종료시간으로 설정(뒤에 교체될 수도 있다.)
        int cnt = 1; //회의 하나 선택하고 시작하므로 1로 초기화
        for(int i=1;i<N;i++){ //첫번째 회의를 선택했으므로 i=1부터 시작
            int start = arr[i][0];
            int end = arr[i][1];
            if(start>=minEnd){ //최소종료시간보다 늦거나 같은 시작시간이면 해당 회의 선택(회의개수+1)
                cnt++;
                minEnd = end; //최소종료시간을 해당 회의의 종료시간으로 갱신
            }else{ //그게 아니라면
                if(minEnd>end) minEnd = end; //최소종료시간만 비교해서 더 짧은 종료시간의 회의로 교체
            }
        }
        bw.write(""+cnt);
        bw.flush();
        bw.close();
        br.close();
    }//main
}
