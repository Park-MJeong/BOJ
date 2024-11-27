import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/*
* 입력
각 문자열은 마지막 글자를 제외하고 영문 알파벳, 공백, 소괄호("( )"), 대괄호("[ ]")로 이루어져 있으며, 온점(".")으로 끝나고,
길이는 100글자보다 작거나 같다.
입력의 종료조건으로 맨 마지막에 온점 하나(".")가 들어온다.
*
* 출력
문자열이 균형을 이루면 yes, 아니면 no
* */

/* 문제해결
각 문자열은 온점으로 끝난다.
입력은 온점하나만 입력되는 순간 끝이난다

여는 소괄호와 여는 대괄호는 스택에 쌓아준다.
닫는 괄호와 짝이 맞으면 스택에서 여는 괄호를 꺼내준다.
빈스택에서 닫는괄호를 만나면 균형아님
빈스택이면 균형잡힌 문자열이다.
괄호가 하나도 없는경우는 균형잡힌 문자열이다.


* */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        while (true){
            String str = br.readLine(); //문자열을 입력받는다.
            if(str.equals(".")){ //온점이라면 while문을 탈출한다.
                break;
            }
            for(char c : str.toCharArray()){
                if(c=='(' || c=='['){
                    stack.push(c);
                }else if(c==')'){
                    if(stack.isEmpty() || stack.peek() != '('){
                        stack.push(c);
                        break; //해당조건이면 균형을 이루지 못하므로 반복문 탈출
                    }else stack.pop();
                }else if(c==']'){
                    if(stack.isEmpty() || stack.peek() != '['){
                        stack.push(c);
                        break;//해당조건이면 균형을 이루지 못하므로 반복문 탈출
                    }else stack.pop();
                }
            }
            sb.append(stack.isEmpty()?"yes\n" : "no\n");
            stack.clear(); //다음 문자열을 입력받기전에 스택을 비워준다.


        }
        System.out.println(sb);
    }

}
