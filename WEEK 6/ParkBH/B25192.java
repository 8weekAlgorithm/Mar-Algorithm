
// 문제: 백준 25192번 곰곰
// 링크: https://www.acmicpc.net/problem/25192
// 시간: 248ms 메모리:25904

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
//문제 :곰곰이  25192번
//메모리 :26072KB
//시간 :244MS

public class B25192 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int chat=Integer.parseInt(br.readLine());
        String enter=br.readLine();    //첫번쨰 입력 엔터 고정이라 그냥 여기서 받고 넘김
        int cnt=0;
        HashSet<String> bbeeaarr=new HashSet<>();
        for(int i=0;i<chat-1;i++) {
            String hi=br.readLine();
            if(hi.equals("ENTER")) {   //엔터 있으면 트리 크기 더해주고 클리어
                cnt+=bbeeaarr.size();
                bbeeaarr.clear();
            }else {
                bbeeaarr.add(hi);
            }
        }
        cnt+=bbeeaarr.size();  //포문 나왔을떄 트리 크기 더해줌
        System.out.println(cnt);
    }

}
