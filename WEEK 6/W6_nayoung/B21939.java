// 문제: 백준 21939번 문제추천시스템Ver1
// 메모리: 60580KB
// 시간: 576ms

import java.io.*;
import java.util.*;

public class B21939 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); //문제 개수(1<=N<=100,000)
        HashMap<Integer,Integer> mapPL = new HashMap<>(); //문제번호-난이도 쌍
        HashMap<Integer, TreeMap<Integer,Integer>> mapLP = new HashMap<>(); //난이도-문제번호 쌍
        int[] count = new int[101]; //1~100까지의 난이도에 해당하는 문제 개수 저장하는 카운팅배열
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken()); //문제번호(1<=P<=100,000)
            int L = Integer.parseInt(st.nextToken()); //난이도(1<=L<=100)
            mapPL.put(P,L);
            mapLP.putIfAbsent(L, new TreeMap<>());
            mapLP.get(L).put(P,P);
            count[L]++;
        }

        int M = Integer.parseInt(br.readLine()); //명령문 개수(1<=M<=10,000)
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            String query = st.nextToken();
            if(query.equals("recommend")){
                int x = Integer.parseInt(st.nextToken());
                if(x==1){
                    for(int j=100;j>=1;j--){
                        if(count[j]==1){
                            bw.write(mapLP.get(j).firstKey()+"\n");
                            break;
                        }else if(count[j]>1){
                            bw.write(mapLP.get(j).lastKey()+"\n"); //가장 어려운 문제가 여러 개라면 문제 번호가 큰 것 출력
                            break;
                        }
                    }
                }else if(x==-1){
                    for(int j=1;j<=100;j++){
                        if(count[j]==1){
                            bw.write(mapLP.get(j).firstKey()+"\n");
                            break;
                        }else if(count[j]>1){
                            bw.write(mapLP.get(j).firstKey()+"\n"); //가장 쉬운 문제가 여러 개라면 문제 번호가 작은 것 출력
                            break;
                        }
                    }
                }
            }else if(query.equals("add")){
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                mapPL.put(P,L);
                mapLP.putIfAbsent(L, new TreeMap<>());
                mapLP.get(L).put(P,P);
                count[L]++;
            }else if(query.equals("solved")){
                int P = Integer.parseInt(st.nextToken());
                int L = mapPL.get(P);
                count[L]--;
                mapPL.remove(P);
                mapLP.get(L).remove(P);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }//main

}
