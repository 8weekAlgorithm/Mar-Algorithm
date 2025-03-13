import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
//문제 :포마 이다솜  1620번
//메모리 :97184KB
//시간 :620MS
public class B1620 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 첫 번째 입력으로 포켓몬의 수와 질문의 수를 받음
        String first = br.readLine();
        String[] firstList = first.split(" ");

        // 첫 번째 입력에서 포켓몬 수와 질문 수를 각각 추출
        int pokemon = Integer.parseInt(firstList[0]);
        int question = Integer.parseInt(firstList[1]);

        // 포켓몬 이름을 저장할 배열 선언
        String[] pokemonBook = new String[pokemon];

        // 포켓몬 이름과 번호를 매핑할 HashMap 선언
        HashMap<String, Integer> pokeHash = new HashMap<>();

        // 포켓몬 이름과 번호를 입력받아서 배열과 HashMap에 저장
        for (int i = 0; i < pokemon; i++) {
            // 포켓몬 이름을 입력받음
            String poke = br.readLine();

            // pokemonBook 배열에 포켓몬 이름 저장
            pokemonBook[i] = poke;

            // pokeHash에 포켓몬 이름과 그 번호(1부터 시작)를 저장
            pokeHash.put(poke, i + 1);
        }

        // 질문의 수만큼 반복하여 답을 구함
        for (int i = 0; i < question; i++) {
            // 각 질문을 입력받음
            String q = br.readLine();

            // 질문이 숫자인지 아닌지 판별하기 위한 변수
            boolean num = false;
            try {
                // 질문이 숫자인지 시도
                Integer.parseInt(q);
                num = true; // 숫자라면 num을 true로 설정
            } catch (NumberFormatException e) {
                // 숫자가 아니면 그냥 넘어감
            }

            // 결과를 저장할 변수 선언
            String result = "";

            // 숫자일 경우 포켓몬 번호를 이름으로 변환
            if (num == true) {
                int number = Integer.parseInt(q) - 1; // 1번부터 시작하는 번호를 0-based index로 변환
                result = pokemonBook[number]; // 배열에서 해당 포켓몬 이름을 찾음
            } else {
                // 숫자가 아니면 포켓몬 이름을 번호로 변환
                int a = pokeHash.get(q); // 이름에 해당하는 번호를 찾음
                result = Integer.toString(a); // 번호를 문자열로 변환
            }

            // 결과를 StringBuilder에 추가
            sb.append(result).append("\n");
        }

        // 최종적으로 결과를 출력
        System.out.println(sb);
    }
}
