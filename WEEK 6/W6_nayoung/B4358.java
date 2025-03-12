// 문제: 백준 4358번 생태학
// 메모리: 94604KB
// 시간: 968ms

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;


public class B4358 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        TreeMap<String, Integer> map = new TreeMap<>();
        int cnt=0; //전체 나무 수
        String str = "";
        while((str = br.readLine())!=null && !str.isEmpty()){
            map.put(str,map.getOrDefault(str,0)+1);
            cnt++;
        }

//        while(true){
//            String str = br.readLine();
//            if(str==null || str.isEmpty())break;
//            else{
//                map.put(str.strip(),map.getOrDefault(str,0)+1);
//                cnt++;
//            }
//        }

        for(String e: map.keySet()){
            float tmp = Math.round(((float)map.get(e)/cnt)*1000000)/(float)10000.0;
            System.out.print(e+" ");
            System.out.printf("%.4f\n",tmp);
//            bw.write(e+" "+tmp+"\n");    //위의 두 줄 대신 얘로 출력했을때 틀리게 나옴... WHY???
        }

        bw.flush();
        bw.close();
        br.close();
    }//main

}
