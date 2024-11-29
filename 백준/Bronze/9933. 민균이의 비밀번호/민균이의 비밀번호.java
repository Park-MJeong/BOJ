
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
단어의 수 N
두번째 줄 ~N개줄에는 알파벳소문자와 홀수길이인 단어
*
* 출력
비밀번호의 길이와 가운데 글자 출력
* */

/* 문제해결
문자를 입력받고, 입력받은 문자를 뒤집어 새로운 변수에 저장해준다.
입력받은 문자는 set에 저장 (중복된값 저장하지 않기 위해서)
만약, 입력받은 문자를 뒤집었는데 기존 set에 존재한다면
그 길이와, 중간값을 가져오고 정답출력
* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set = new HashSet<>();
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            String str = br.readLine();
            String reverse = new StringBuilder(str).reverse().toString();

            set.add(str);

            if(set.contains(reverse)){ 
                int cnt = reverse.length();
                char result = reverse.charAt(cnt/2);

                System.out.print(cnt + " "+ result);
            }

        }
    }
}



