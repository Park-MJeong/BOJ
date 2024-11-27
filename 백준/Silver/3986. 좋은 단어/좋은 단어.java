import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
/*
* 입력
첫째줄에 단어 수 N (1<= N <=10000 )
둘째 줄~ N개 줄 A와 B로만 이루어진 단어가 한 줄에 하나씩
*
* 출력
좋은 단어의 수를 출력
* */

/* 문제해결
스택에 쌓아올려서 맞닿은것이 짝이면 삭제
문자열로 입력받으니까 위치값으로 해당 문자 넣어줌
=>빈스택이라면 좋은단어
문자열길이가 홀수면 좋은단어 절대로 불가능

* */
public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt=0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if(goodwords(s)) cnt++; //빈 스택이라면 ++
        }
        System.out.println(cnt);
        br.close();
    }

    public static boolean goodwords(String s) {
        Stack<Character> stack = new Stack<>();

        if (s.length() % 2 != 0) {
            return false;}

            stack.push(s.charAt(0)); //첫단어는 먼저 스택에 넣어둠
            for (int i = 1; i < s.length(); i++) {
                if (!stack.isEmpty() && stack.peek() == s.charAt(i)) { //맞닿아 있는것과 같으면 저장된거 꺼냄
                    stack.pop();
                } else { //같지않으면 스택에 넣어줌
                    stack.push(s.charAt(i));
                }
            }
            return stack.isEmpty(); //빈 스택인지아닌지 값 넘겨줌
    }
}
