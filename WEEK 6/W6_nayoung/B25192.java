// 문제: 백준 25192번 인사성 밝은 곰곰이
// 메모리: 28188KB
// 시간: 240ms

import java.io.*;
import java.util.HashSet;


public class B25192 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); //채팅방의 기록 수(1이상 100000이하)

        HashSet<String> set = new HashSet<>();
        int cnt = 0;
        for(int i=1;i<=N;i++){
            String tmp = br.readLine();
            if(!tmp.equals("ENTER")){
                set.add(tmp); //1<=문자열길이<=20
            }else{
                cnt += set.size();
                set = new HashSet<>();
            }

        }
        cnt+=set.size();

        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }//main

}
