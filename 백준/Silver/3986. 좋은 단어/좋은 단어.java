import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/* 입력
첫 줄에 단어의 수 N
A,와 B로 이루어지 단어가 한줄에 하나씩
* */

/* 출력
좋은 단어 갯수 출력
* */

/*
A는A,B는B와 각각 연결
연결선이 교차하지 않고, 각 글자를 다른위치의 같은 글자와 짝이 지어져야한다
=>남는 글자가 있다. 좋은단어 xx
==> 스택에 쌓아 올려서 맞닿아있는것이 겹치면 둘다 삭제.
==>스택에 아무것도 없어야 좋은단어
* */
public class Main {
    static int cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            goodwords(s);

        }
        System.out.println(cnt);
    }
    static void goodwords(String s){
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0)); //첫단어는 스택에 먼저 넣어줌
        for (int i = 1; i < s.length(); i++) {
            if(!stack.isEmpty() && stack.peek() == s.charAt(i)){
                //스택이 0이 아니고 맞닿아있는거와 같으면
                //기존것 스택에서 꺼내줘야함
                stack.pop();
            } else{
                stack.push(s.charAt(i)); //다르면 스택에 쌓아줌
            }
        }
        if(stack.isEmpty()){
            cnt++;
        }

    }

}
