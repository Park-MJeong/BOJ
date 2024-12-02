import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
테스트 케이스 t
지원자 수 n
n개의 줄 각각 서류성적,면접성적의 순위
* 출력
한줄에 하나씩 선별할 수 있는 신입사원 최대인원수 출력
* */

/* 문제해결
두 성적 순위 모두 1위~n위까지 동석차없음
서류순위를 오름 차순 정렬한다.
서류순위가 1위인 면접자의 면접순위A를 구한다. ++1
면접1순위~ A순위까지의 서류순위를 확인

서류 n순위가  A보다 작고, 본인보다 서류순위가 작은 사람보다 면접순위가 더 작아야함
그러니. 이전 서류의 면접순위보다 작아야함 ++1
면접1순위를 만나면 거기까지 cnt 를 더하고 출력
왜냐면 서류1~n순위
면접n순위~1순위 까지만
적어도 하나가 다른 지원자보다 떨어지지않는 자에 포함되기 때문에
* */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new TreeMap<>();
        StringBuilder sb = new StringBuilder();


        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                String [] s = br.readLine().split(" ");
                map.put(Integer.parseInt(s[0]), Integer.parseInt(s[1]));

            }
            sunwi(map,n,sb);
        }
        System.out.println(sb);

    }

    static void sunwi(Map<Integer,Integer> map,int n,StringBuilder sb){
        int k = map.get(1); // 서류 1순위의 면접 순위
        int result = 1; // 서류 1순위는 항상 선발
        int minRank = k; // 현재까지의 최소 면접 순위

        for (int i = 2; i <= n; i++) {
            int temp = map.get(i);//서류2순위부터 면접순위 체크

            // 면접 순위가 1이라면 즉시 종료
            if (temp == 1) {
                result++;
                sb.append(result).append("\n");
                return;
            }

            // 현재 지원자의 면접 순위가 기준에 부합하면 선발
            if (temp < minRank) {
                result++;
                minRank = temp; // 최소 면접 순위 갱신
            }
        }
        // 최종 결과 추가
        sb.append(result).append("\n");

    }
}