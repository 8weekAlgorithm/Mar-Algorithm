import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//문제 :추월 2002번
//메모리 :17060KB
//시간 :184MS
public class B2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 첫 번째 입력으로 자동차의 개수 carNum을 받음
        int carNum = Integer.parseInt(br.readLine());

        // 들어가는 자동차들
        Queue<String> inCar = new LinkedList<>();

        // 나가는 자동차들
        Deque<String> outCar = new LinkedList<>();

        // 임시로 보관할 "감옥" Stack
        Stack<String> temp = new Stack<>();

        // 입차 순서대로 자동차를 입력받음
        for (int i = 0; i < carNum; i++) {
            inCar.offer(br.readLine());  // 입차 대기열에 자동차 추가
        }

        // 출차 순서대로 자동차를 입력받음
        for (int i = 0; i < carNum; i++) {
            outCar.offer(br.readLine()); // 출차 대기열에 자동차 추가
        }

        // 감옥 역할을 하는 TreeSet. 중복을 제거하기 위해 사용
        TreeSet<String> prison = new TreeSet<>();

        // 입차 대기열이 비지 않을 때까지 처리
        while (!inCar.isEmpty()) {
            String car = inCar.poll(); // 입차 대기열에서 첫 번째 자동차를 꺼냄
            int len = outCar.size();  // 출차 대기열의 크기

            // 출차 큐를 순차적으로 확인
            for (int i = 0; i < len; i++) {
                // 입차한 자동차가 출차 대기열의 첫 번째 자동차와 다르면
                if (!car.equals(outCar.peek())) {
                    // 출차 큐에서 자동차를 스택에 저장
                    prison.add(outCar.peek());
                    // 해당 자동차를 (Stack)에 넣기 위해 출차 큐 꺼내고 Stack에 저장
                    temp.push(outCar.poll());
                } else {
                    // 자동차가 맞으면 출차 대기열에서 해당 자동차를 빼고
                    outCar.poll();
                    // 스택에 저장된 자동차들을 다시 출차 큐에 되돌려 놓음
                    int lenTemp = temp.size();
                    for (int j = 0; j < lenTemp; j++) {
                        outCar.addFirst(temp.pop());  // Stack에서 꺼낸 자동차를 출차 큐 앞에 추가
                    }
                    break;  // 출차 큐에서 첫 번째 자동차가 맞았으므로 더 이상 진행하지 않음
                }
            }
        }
        // 감옥에 저장된 자동차의 수를 출력
        sb.append(prison.size());
        System.out.println(sb);
    }
}

