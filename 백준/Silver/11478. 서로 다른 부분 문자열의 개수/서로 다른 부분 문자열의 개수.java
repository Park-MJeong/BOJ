import java.io.*;
import java.util.*;

/*
1)문제 분석
주어진 문자열을
1개씩 잘라서 중복비교
2개씩 잘라서 중복비교
...N개 길이만큼 잘라서비교
2)의사결정
길이를 증가시키면서 문자를 잘라야함 
->for문이용하여 위치값에 변동주고, substring이용


**중복허용x,입력순서대로 들어가는 set
*/
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <=input.length(); j++) {
                set.add(input.substring(i, j));
            }
        }
        System.out.println(set.size());

    }
}
