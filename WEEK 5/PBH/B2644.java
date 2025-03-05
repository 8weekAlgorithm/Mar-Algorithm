import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Imyour { //시간 100ms

    static List<Integer>[] family;    //관계들을 저장할  리스트 1차원 배열 -자식들 수가 다 달라서
    static int[] notSon;              //방문 체크겸 값 누적을 위한 배열
    static int father;                //시작값
    static int son;                  //찾을 값
    static int blood;              //정점 수
    static int your = -1;          //친자 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());     //스태틱 변수 값 하나하나 입력
        family = new List[T + 1];
        notSon = new int[T + 1];
        StringTokenizer relation = new StringTokenizer(br.readLine());
        father = Integer.parseInt(relation.nextToken());
        son = Integer.parseInt(relation.nextToken());
        blood = Integer.parseInt(br.readLine());
        for (int i = 0; i < T + 1; i++) {
            family[i] = new ArrayList<>();
        }
        for (int i = 0; i < blood; i++) {
            StringTokenizer real = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(real.nextToken());
            int num2 = Integer.parseInt(real.nextToken());
            family[num1].add(num2);
            family[num2].add(num1);
        }
        checkDNA(father);    //메서드 실행 후 출력
        sb.append(your);
        System.out.println(sb);
    }

    static void checkDNA(int father1) {  //최소 촌수를 구한다고 생각해 BFS로 접근했음
        Queue<Integer> q = new LinkedList<>();
        q.offer(father1);
        notSon[father1] = 0;      //첫 시작 방문 배열에 값 넣어줌
        while (!q.isEmpty()) {
            int a = q.poll();
            if (!family[a].isEmpty()) {
                for (int idx : family[a]) {          //방문 배열에 자식이 있으면 자식을 쓱 둘러봄
                    if (idx == son) {                //찾던 자식이 있으면  촌수 계산 해서 저장
                        your = notSon[a] + 1;
                        break;
                    } else {
                        if (notSon[idx] == 0) {    //찾던 자식은 아니지만 방문하지 않았으면 그 전의 값+1해서 방문 배열에 저장 후 큐에 추가
                            notSon[idx] = notSon[a] + 1;
                            q.offer(idx);
                        }
                    }
                }
            }
            if (your != -1) {        //반복 끝에 친자체크가 되었으면 최단 거리 일테니 나가라
                break;
            }
        }
    }

}
