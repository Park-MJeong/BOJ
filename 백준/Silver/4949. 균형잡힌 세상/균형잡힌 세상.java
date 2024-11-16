import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/* 입력
 마지막 글자를 제외하고 영문 알파벳, 공백, 소괄호("( )"), 대괄호("[ ]")로 이루어짐,
 길이는 100글자보다 작거나 같다.
입력의 종료조건으로 맨 마지막에 온점 하나(".").
* */

/* 출력
균형을 이루면 yes, 아니면 no
* */

/*
모든 오른쪽 괄호는 짝을 이루고 있음 -> 왼쪽괄호는 짝을 이루지 않을수도 있음
짝을 이루는 괄호사이 문자열은 균형잡혀야함
" ."와 같이 괄호가 하나도 없는 경우도 균형잡힌 문자열로 간주
온점으로 문자열이 끝남 -> 그전까지는 무한루프
* */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        char c;

        while (true){

            stack.clear(); //새로 입력받기전 스택을 비워줌
            String line = br.readLine();

            if (line.equals(".")){
                break;
            }

            for (int i = 0; i < line.length(); i++){
                c = line.charAt(i);
                if(c == '(' || c =='['){  //여는 괄호는 스택에 넣어줌
                    stack.push(c);
                } else if(c == ')'){
                    if(stack.isEmpty() || stack.peek()!='(') {
                        stack.push(c);
//                        sb.append("no\n");   //빈공간이거나 대괄호면 짝이루어지지 않음
                    }
                    else { //짝이 이루어 지면
                        stack.pop() ;
                    }
                } else if(c == ']'){
                    if(stack.isEmpty() || stack.peek()!='[') {
                        stack.push(c);
//                        sb.append("no\n");   //빈공간이거나 소괄호면 짝 이루어지지 않음
                    }
                    else { //짝이 이루어지면
                        stack.pop() ;
                    }
                }

            }
            sb.append(stack.isEmpty() ?"yes\n" : "no\n");
        }
        System.out.println(sb);
    }

}
