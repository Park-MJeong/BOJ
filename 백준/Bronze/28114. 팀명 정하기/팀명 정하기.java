import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
첫번째 팀원의 문제해결개수 P1 입학년도Y1 성씨S1
두번째 팀원의 문제해결개수 P2 입학년도Y2 성씨S2
세번째 팀원의 문제해결개수 P3 입학년도Y3 성씨S3
*
*
* 출력
첫번째 방법으로 만든 팀명 출력
두번째 방법으로 만든 팀명 출력
* */

/* 문제해결
첫번째 방법:
세 참가자의 입학년도를 100으로 나눈 나머지를 오름차순으로 정렬해서 이어 붙인 문자열

두번째 방법:
성씨의 첫글자를 P가 큰 사람부터 차례대로 나열한 문자열

입학년도는 1차배열에 저장, 문재해결개수,성씨는 2차 배열에 함께저장
해당하는 값들이 모두 다르다는 조건이 있으므로 정렬시 따로 추가 조건을 주지 않아도 된다
성씨는 앞글자만 필요하므로 그것만 저장

1-1.입학년도가 저장된 배열은 각 값을 100으로 나눈후
1-2.오름차순 정렬
1-3.for문을 돌며 sb에 차례대로 저장
**입학년도를 여기서만 사용하기 때문에 처음부터 100으로 나눠서 저장후 정렬
그리고 차례대로 저장하기

2-1 [][0]문제해결개수를 내림차수 정렬
2-2 for문을 돌며 [0][]해당 값을 sb에 차례대로 저장
**문제해결개수가 중복되지않으므로 중복값을 저장하지 않는 map에 key:value로 저장
key내림차순 정렬후 해당 값으로 value를 찾아 sb에 저장

* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
//        String[][] ps = new String[3][3];
        Integer[] y = new Integer[3];
        Map<Integer, Character> ps = new HashMap<>();
        List<Integer> p = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            String []str = br.readLine().split(" ");
            y[i] = Integer.parseInt(str[1])%100; //입학년도
            ps.put(Integer.parseInt(str[0]),str[2].charAt(0));
            p.add(Integer.parseInt(str[0]));
//            str[0]; //문제해결개수
//            str[2]; //성
        }

        Arrays.sort(y);
        for(int i : y){
            sb.append(i);
        }
        sb.append("\n");

        p.sort(Collections.reverseOrder()); //문제해결 내림차순
        for(int i : p){
            sb.append(ps.get(i));
        }

        System.out.println(sb);
    }
}