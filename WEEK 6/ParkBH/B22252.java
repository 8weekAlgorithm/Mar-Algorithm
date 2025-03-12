import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

//문제 :파일정리  22252번
//메모리 :174904KB
//시간 :1428MS

public class B22252 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 빠르게 받기 위한 BufferedReader 사용
        int Q = Integer.parseInt(br.readLine()); // 쿼리 개수 입력 받기
        HashMap<String, List<Integer>> slave = new HashMap<>(); // 문자열(String) 키를 가지는 리스트(HashMap) 선언
        long sum = 0; // 최종 합계를 저장할 변수

        for (int i = 0; i < Q; i++) { // Q번의 쿼리 실행
            StringTokenizer st = new StringTokenizer(br.readLine()); // 한 줄 입력 받아 공백 단위로 분리
            int num = Integer.parseInt(st.nextToken()); // 첫 번째 입력값: 명령 종류 (1 또는 2)

            switch (num) {
                case 1: // 명령 1: 특정 키에 대해 정수 리스트 추가
                    String go = st.nextToken(); // 키 값 (예: "A", "B" 같은 문자열)

                    if (slave.containsKey(go)) { // 키가 이미 존재하는 경우
                        List<Integer> list = slave.get(go); // 기존 리스트 가져오기
                        int length = Integer.parseInt(st.nextToken()); // 추가할 정수 개수
                        for (int j = 0; j < length; j++) { // 정수 개수만큼 반복하여 추가
                            list.add(Integer.parseInt(st.nextToken()));
                        }
                        Collections.sort(list, Collections.reverseOrder()); // 내림차순 정렬 (큰 값이 앞에 오도록)
                        break;
                    } else { // 키가 존재하지 않는 경우
                        int len = Integer.parseInt(st.nextToken()); // 새 리스트의 길이 입력 받기
                        List<Integer> info = new ArrayList<>(); // 새로운 리스트 생성
                        for (int j = 0; j < len; j++) { // 입력받은 정수 추가
                            info.add(Integer.parseInt(st.nextToken()));
                        }
                        Collections.sort(info, Collections.reverseOrder()); // 내림차순 정렬
                        slave.put(go, info); // HashMap에 추가
                        break;
                    }

                case 2: // 명령 2: 특정 키에서 가장 큰 값을 꺼내서 합산
                    String go2 = st.nextToken(); // 키 값
                    if (slave.containsKey(go2)) { // 해당 키가 존재하면
                        int a = Integer.parseInt(st.nextToken()); // 꺼낼 개수
                        List<Integer> list = slave.get(go2); // 해당 키의 리스트 가져오기
                        for (int j = 0; j < a; j++) { // a번 반복하며 가장 큰 값부터 꺼냄
                            if (!list.isEmpty()) { // 리스트가 비어있지 않으면
                                sum += list.get(0); // 첫 번째(가장 큰 값) 더하기
                                list.remove(0); // 첫 번째 값 제거
                            } else {
                                break; // 리스트가 비어 있으면 종료
                            }
                        }
                    }
                    break;
            }
        }
        System.out.println(sum); // 최종 합 출력
    }
}