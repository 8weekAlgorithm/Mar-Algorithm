import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
//문제 :생태학  4358번
//메모리 :86908KB
//시간 :812MS
public class B4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 나무 이름과 그 빈도수를 저장할 TreeMap 선언 (알파벳 순으로 자동 정렬됨)
        TreeMap<String, Integer> trees = new TreeMap<>();

        // 첫 번째 나무 이름을 입력받음
        String treeName = br.readLine();

        // 나무의 총 개수를 세기 위한 변수
        int totalTree = 0;

        // 입력이 null이 아니고, 길이가 0이 아닐 때까지 반복
        while (treeName != null && treeName.length() != 0) {
            // 해당 나무의 이름이 이미 TreeMap에 존재하면 빈도수 증가, 아니면 1로 설정
            trees.put(treeName, trees.getOrDefault(treeName, 0) + 1);

            // 다음 나무 이름을 입력받음
            treeName = br.readLine();

            // 총 나무의 개수를 증가시킴
            totalTree++;
        }

        // TreeMap에 저장된 나무 이름을 알파벳 순으로 순회하며, 비율을 계산하여 출력
        for (String f : trees.keySet()) {
            // 현재 나무의 개수를 가져옴
            double num = trees.get(f);

            // 해당 나무의 출현 비율을 계산 (전체 나무 수 대비 비율)
            num = (num / totalTree) * 100;

            // 소수점 4자리까지 반올림 처리
            num = (double) Math.round(num * 10000.0) / 10000.0;

            // 나무 이름과 해당 나무의 비율을 StringBuilder에 추가
            sb.append(f).append(" ").append(String.format("%.4f", num)).append("\n");
        }

        // 결과 출력
        System.out.println(sb);
    }
}