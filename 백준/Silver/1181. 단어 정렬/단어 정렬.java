import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
첫째 줄에 단어의 개수 N
둘째 줄 부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어짐
문자열의 길이는 50을 넘지 않음
*
* 출력
조건에 따라 정렬하여 단어 출력
* */

/* 문제해결
1.길이가 짧은것 부터
2.길이가 같으면 사전순(오름차 순)으로
중복되는 단어는 하나만 남기고 제거
중복되는 값이 저장되지 않는 set에저장
set을 list에 담아 정렬
=>길이가 작은것이 먼저옴
=>길이가 긴것은 뒤로
=>길이가 같다면 오름차순
* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        HashSet set = new HashSet<>();
        // set은 중복을 허용하지 않기때문에 중복 제거를 위해 set을 사용.
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        List<String> list = new ArrayList<>();

        Iterator<String> iter = set.iterator();
        while(iter.hasNext()) //리스트에 담아주기
            list.add(iter.next());


        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() > s2.length())  //먼저입력받은 길이가 길다면
                    return s1.length() - s2.length();  //두번째 입력값 뒤로, 양수 :오름차순, 긴것이 뒤로감
                else if (s1.length() < s2.length())  //먼저 입력받은 길이가 작다면
                    return s1.length() - s2.length(); //두번째입력값 앞으로,  음수 :내림차순 , 작은것이 앞으로
                else  //길이가 길지도 작지도 않다 ==길이가 같다
                    return s1.compareTo(s2); //오름차순
            }
        });

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);

    }

}