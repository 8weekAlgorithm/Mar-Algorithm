// 문제: 백준 20291번 파일 정리
// 메모리: 54860KB
// 시간: 736ms

import java.io.*;
import java.util.TreeMap;


public class B20291 {
    //파일을 확장자 별로 정리해서 몇개씩 있는지 알려주기
    //보기 편하게 확장자들을 사전순으로 정렬하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); //파일의 개수(1이상 50000이하)

        TreeMap<String, Integer> map = new TreeMap<>(); //treemap 사용시 자동으로 사전순 정렬됨.
        for(int i=0;i<N;i++){
            /*
            정규 표현식에서 comma (.) 는 임의의 문자열을 의미한다.
            정규식에서는 특수문자를 대괄호 [] 로 감싸거나,  \\ 를 앞에 붙여주어야만 한다.
             */
            String[] tmp = br.readLine().split("\\."); //파일의 이름의 길이는 최소3, 최대 100
            map.put(tmp[1],map.getOrDefault(tmp[1],0)+1);
        }

        for(String e: map.keySet()){
            bw.write(e+" "+map.get(e)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }//main

}
