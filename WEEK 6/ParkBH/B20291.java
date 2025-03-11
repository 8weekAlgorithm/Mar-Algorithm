import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;


//문제 :파일정리  20291번
//메모리 :65148KB
//시간 :700MS
public class B20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 첫 번째 입력으로 테스트 케이스의 개수 T를 받음
        int T = Integer.parseInt(br.readLine());

        // 확장자별 파일 개수를 저장할 TreeMap 선언
        TreeMap<String, Integer> files = new TreeMap<>();

        // T번만큼 파일 이름을 입력받고 확장자를 추출하여 개수를 세기
        for (int i = 0; i < T; i++) {
            // 파일 이름을 입력받음
            String file = br.readLine();

            // 파일 이름을 '.' 기준으로 나누어 확장자를 추출
            String[] split = file.split("\\.");

            // 두 번째 부분 (확장자)만 사용
            String extension = split[1];

            // 확장자별로 개수를 저장. 만약 이미 존재하면 기존 값에 1을 더하고, 없으면 1을 넣음
            files.put(extension, files.getOrDefault(extension, 0) + 1);
        }

        // 확장자별로 저장된 파일 개수를 알파벳 순으로 출력
        for (String extension : files.keySet()) {
            // 확장자와 그에 해당하는 파일 개수를 StringBuilder에 추가
            sb.append(extension).append(" ").append(files.get(extension)).append("\n");
        }

        // 결과를 출력
        System.out.println(sb);
    }
}