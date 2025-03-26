import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//메모리 43236kb 시간 500ms
//https://www.acmicpc.net/problem/1931
public class B1941 { //가장 효율적으로 회의실을 배정하기 위해 먼저 든 생각이 가장 일찍 끝나면서 시작 시간이 큰 것부터 넣어야 한다고 생각
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int N=Integer.parseInt(br.readLine());
        Pair[] arr = new Pair[N];
        for (int i = 0; i <N; i++) {  //그래서 값을 입력 받을 때 key ,value 로 거꾸로 넣은 건 그게 생각하기 편해서
            StringTokenizer st=new StringTokenizer(br.readLine());
            int value=Integer.parseInt(st.nextToken());
            int key=Integer.parseInt(st.nextToken());
            arr[i]=new Pair(key,value);
        }
        Arrays.sort(arr, new Comparator<Pair>() { //끝나는 시간은 작은 것 부터 시작시간은 큰 것부터 보고 싶어서 이렇게 정렬
            @Override
            public int compare(Pair p1, Pair p2) {
                if (p1.key != p2.key) {
                    return Integer.compare(p1.key, p2.key); // key 오름차순
                } else {
                    return Integer.compare(p2.value, p1.value); // value 내림차순
                }
            }
        });

        int a=0;
        int b=0;
        int cnt=0;
        for (int i = 0; i <arr.length ; i++) {
            Pair pair=arr[i];
            if (a <= pair.key&&b<= pair.value) { //회의실을 배정하려면 시작,종료 시간이 이전 회의 보다 나중에 끝나야 한다. 
                if (pair.key== pair.value) { //다만 문제에서 찍턴하는 회의도 케이스로 있다고 했기에 그걸 따로 처리해줘야 한다.
                    if(i!=arr.length-1) { 
                        if (arr[i + 1].key == pair.key) {// 다음 값도 종료시간이 같은 경우에는 종료 시간만 바꿔주고 비교해줄 수 있게 해줌
                            a = pair.key;
                            cnt++;
                        } else {  //아니라면  시작 시간도 바꿔줌
                            a = pair.key;
                            b = pair.value;
                            cnt++;
                        }
                    }else{
                        cnt++;
                    }
                } else {
                    a = pair.key;
                    b = pair.key;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    static class Pair {  //값을 정렬하기 위해 클래스 만듬
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
