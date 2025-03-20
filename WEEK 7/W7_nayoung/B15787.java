import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//B15787 기차가 어둠을 헤치고 은하수를
//메모리 38984kb, 시간 332ms
public class B15787 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1]; //기차 좌석 정보 저장 배열
        int M = Integer.parseInt(st.nextToken());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int trainNum = Integer.parseInt(st.nextToken());
            switch (order){
                case 1:
                    int x1 = Integer.parseInt(st.nextToken());
                    if((arr[trainNum] & (1<<x1))==0) arr[trainNum] = arr[trainNum] | (1<<x1);
                    break;
                case 2:
                    int x2 = Integer.parseInt(st.nextToken());
                    if((arr[trainNum] & (1<<x2))!=0) arr[trainNum] = arr[trainNum] & ~(1<<x2);
                    break;
                case 3:
                    arr[trainNum] = arr[trainNum] << 1;
                    if((arr[trainNum] & (1<<21)) != 0) arr[trainNum] = arr[trainNum] & ~(1<<21); //21번째 자리 검사
                    break;
                case 4:
                    arr[trainNum] = arr[trainNum] >> 1;
                    if((arr[trainNum] & 1) != 0) arr[trainNum] = arr[trainNum] & ~1; //0번째 자리 검사
                    break;
            }
        }

        HashSet<Integer> set = new HashSet<>(); //승객이 앉은 상태가 기록되지 않은 경우만 모으도록 set 이용
        for(int i=1;i<=N;i++){
            System.out.println(arr[i]);
            set.add(arr[i]);
        }

        bw.write(set.size()+"");
        bw.flush();
        bw.close();
        br.close();
    }//main
}
