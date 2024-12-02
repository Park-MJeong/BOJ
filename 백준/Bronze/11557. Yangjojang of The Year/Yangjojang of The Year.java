import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
테스트 케이스 숫자T
학교 숫자N
N줄에 걸쳐 학교이름S 술의 양L
(같은 테스트 케이스 안에서 소비한 술의양이 같은 학교는 없음)
*
* 출력
각 테스트케이스마다 술 소비가 가장 많은 학교 이름 출력
* */

/* 문제해결
우선, 술소비가 가장 많은곳을 알려면 술소비를 내림차순 정렬할 수 있어야한다.
술 소비한 양이 같은 학교가 없다했으므로, 중복값저장하지않는 map을 사용하여
술의 양과 학교를 짝지어도 누락되는 학교가 없다.
map의 key로 술의 양,value에 학교이름
key를 내림차순 정렬 후
해당 key값을 가진 value값 출력

테스트케이스의 범위가 나와있지않으므로 매번 출력되는건 시간제한이 걸릴수 있어
StringBuilder에 저장후 한번에 출력

****입력시 자동 정렬하는 트리맵을 사용.
첫번째값 출력

* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t= Integer.parseInt(br.readLine()); //테스트 케이스
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine()); //학교의 수
            TreeMap<Integer,String> map = new TreeMap<>(Collections.reverseOrder());
            for (int j = 0; j < n; j++) {
                String [] str = br.readLine().split(" ");
                map.put(Integer.parseInt(str[1]),str[0]);
            }
            sb.append(map.firstEntry().getValue()).append("\n");
        }
        System.out.println(sb);


    }
}