// 문제: 백준 2002번 추월
// 메모리: 51020KB
// 시간: 588ms

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

//기본 아이디어: 들어갈때 특정 차보다 앞에 있던 애들이 나갈때 특정차보다 뒤에 있다면 특정차는 추월차!!
public class B2002 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); //차의 대수(1<=N<=1000)
        LinkedHashMap<Integer,String> carset1 = new LinkedHashMap<>();
        LinkedHashMap<Integer,String> carset2 = new LinkedHashMap<>();
        LinkedHashMap<String, List<String>> map1 = new LinkedHashMap<>();
        LinkedHashMap<String, List<String>> map2 = new LinkedHashMap<>();

        for(int i=0;i<N;i++) {
            String carNum = br.readLine();
            carset1.put(i,carNum);
        }

        for(int i=N-1;i>=0;i--) {
            // map1에 새로운 리스트를 생성하여 넣어줌
            String tmpCar = carset1.get(i);
            map1.put(tmpCar, new ArrayList<>());
            for(int j=0;j<i;j++) {
                // tmpCar에 해당하는 리스트에 새로운 값 추가
                map1.get(tmpCar).add(carset1.get(j));
            }
        }

//		System.out.println(map1.toString());

        for(int i=0;i<N;i++) {
            String carNum = br.readLine();
            carset2.put(i,carNum);
        }

        for(int i=0;i<N;i++) {
            // map2에 새로운 리스트를 생성하여 넣어줌
            String tmpCar = carset2.get(i);
            map2.put(tmpCar, new ArrayList<>());
            for(int j=i+1;j<N;j++) {
                // tmpCar에 해당하는 리스트에 새로운 값 추가
                map2.get(tmpCar).add(carset2.get(j));
            }
        }

//		System.out.println(map2.toString());

        int cnt = 0;
        for(String e: map2.keySet()) {
            for(String e2: map2.get(e)) {
                if(map1.get(e).contains(e2)) {
                    cnt++;
                    break;
                }
            }
        }

//		for(String e: set1.keySet()) {
//			if(set1.get(e) > set2.get(e)) cnt++;
//		}

        bw.write(cnt+"");

        bw.flush();
        bw.close();
        br.close();

    }//main
}
