// 문제: 백준 1620번 나는야 포켓몬 마스터 이다솜
// 메모리: 52560KB
// 시간: 672ms

import java.io.*;
import java.util.*;


public class B1620 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //포켓몬의 개수(1이상 100000이하)
        int M = Integer.parseInt(st.nextToken()); //맞춰야 하는 문제개수(1이상 100000이하)

        TreeMap<Integer,String> map1 = new TreeMap<>();
        TreeMap<String,Integer> map2 = new TreeMap<>();

        for(int i=1;i<=N;i++){
            String tmp = br.readLine(); //포켓몬 이름(2이상 20이하)
            map1.put(i,tmp); //번호-이름
            map2.put(tmp,i); //이름-번호
        }

        for(int i=0;i<M;i++){
            String tmp = br.readLine();
            if(tmp.charAt(0)>='0'&&tmp.charAt(0)<='9'){ //숫자로 들어옴
                bw.write(map1.get(Integer.parseInt(tmp))+"\n"); //tmp를 정수로 바꾼 키값에 해당하는 포켓몬 이름 출력
            }else{ //숫자로 들어오지 않으면 포켓몬 이름이 들어온 것
                bw.write(map2.get(tmp)+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }//main

}
