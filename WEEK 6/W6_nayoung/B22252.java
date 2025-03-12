// 문제: 백준 22252번 정보 상인 호석
// 메모리: 159848KB
// 시간: 1196ms

import java.io.*;
import java.util.*;

//기본 아이디어: 이름(키), 정보들(값)으로 하는 map 생성. 값의 경우 우선순위큐 이용.
public class B22252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int Q = Integer.parseInt(br.readLine()); //쿼리 개수(1<=Q<=100,000)
        HashMap<String, PriorityQueue<Integer>> map = new HashMap<>();
        long minusSum = 0;
        StringTokenizer st;
        for(int i=0;i<Q;i++){
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            if(query==1){
                String name = st.nextToken();
                int k = Integer.parseInt(st.nextToken());
                map.putIfAbsent(name, new PriorityQueue<>()); //new PriorityQueue<>(Collections.reverseOrder())로 설정시 기본 최대힙
                for(int j=0;j<k;j++){
                    map.get(name).add(Integer.parseInt(st.nextToken())*-1); //우선순위큐는 최소힙이 기본이므로 -1 곱해서 저장
                }
//                System.out.println(map.toString());
            }else{
                String name = st.nextToken();
                int b = Integer.parseInt(st.nextToken());
                if(map.keySet().contains(name)){
                    PriorityQueue<Integer> pq = map.get(name);
//                    System.out.println(pq.toString());
                    int size = pq.size();
                    if(size<=b){
                        for(int j=0;j<size;j++){
                            minusSum += pq.poll();
                        }
                    }else{
                        for(int j=0;j<b;j++){
                            minusSum += pq.poll();
                        }
                    }
                }

            }
        }

        bw.write(minusSum*-1+"");
        bw.flush();
        bw.close();
        br.close();
    }//main

}
