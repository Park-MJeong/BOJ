
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
케이스 개수 N
각 케이스는 스페이스로 띄어진 단어들
*
* 출력
케이스 번호가 x일때  "Case #x: " 를 출력한 후 그 후에 이어서 단어들을 반대 순서로 출력
* */

/* 문제해결
한줄을 입력받고, 공백을 기준으로 stack에 넣어줌
stack에서 꺼내면서 문자열에 저장
* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine()); //케이스개수
        for (int i = 1; i <= n; i++) {
            sb.append("Case #"+i+":");
            String[] strings = br.readLine().split(" ");
            for (String s : strings) {
                stack.push(s); //문자열을 스택에 넣어줌
            }
            
            int size = stack.size(); 
            
            for (int j = 0; j < size; j++) {
                sb.append(" "+stack.pop());
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}



