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
온점으로 문자열이 끝남 -> 그전까지는 무한루프

짝을 이루려면 닫는괄호 입력전에 여는 괄호가 존재해야한다.
우선, 여는 괄호는 스택에 쌓아주고 닫는 괄호를 만나면 빼준다.

닫는괄호는 빈스택이거나 짝짓는 괄호가 아닌경우 넣어준다.
짝짓는 여는괄호를 만날경우 여는괄호를 빼준다.

" ."와 같이 괄호가 하나도 없는 경우도 균형잡힌 문자열로 간주
-> 괄호가 아닌경우 스택에 넣지 않으므로 빈스택이 된다.

마지막에, 모두 짝이 되었거나 괄호가 아닌값들만 입력받았을경우 스택에는 아무것도 없다.
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
                    }
                    else {
                        stack.pop() ;
                    }
                } else if(c == ']'){
                    if(stack.isEmpty() || stack.peek()!='[') {
                        stack.push(c);
                    }
                    else {
                        stack.pop() ;
                    }
                }

            }
            sb.append(stack.isEmpty() ?"yes\n" : "no\n");
        }
        System.out.println(sb);
    }

}
