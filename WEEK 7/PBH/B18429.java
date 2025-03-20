import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//메모리 14380 시간 112ms
//https://www.acmicpc.net/problem/18429
public class B18429 {
    static int [][]health;
    static boolean[]visit;
    static int three=500;
    static int K;
    static int cnt=0;;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer NK=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(NK.nextToken());
        K=Integer.parseInt(NK.nextToken());
        health=new int[N][2];
        StringTokenizer up=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            health[i][1]=Integer.parseInt(up.nextToken());
        }
        visit=new boolean[N];
        tired(0,500);
        System.out.println(cnt);
    }
    static void tired(int healthNum,int weight) {
        if(healthNum==health.length) {  //운동을 잘 끝냈으면 카운트
            cnt++;
            return;
        }else {
            for(int i=0;i<visit.length;i++) {   //경우의 수를 돌리다가
                if(!visit[i]) {   //방문체크
                    int current=weight-K+health[i][1];
                    if(current>=500) {    //500이 넘는 경우만 재귀
                        visit[i]=true;
                        tired(healthNum+1,current);
                        visit[i]=false;
                    }
                }
            }
        }
    }
}
