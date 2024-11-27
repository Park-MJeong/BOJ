import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
* 입력
괄호열을 나타내는 문자열(스트링)이 주어진다. 단 그 길이는 1 이상, 30 이하
*
* 출력
첫째 줄에 그 괄호열의 값을 나타내는 정수를 출력한다. 만일 입력이 올바르지 못한 괄호열이면 반드시 0을 출력
* */

/* 문제해결
() =>2, [] =>3
괄호의 짝이 맞지 않으면 0 출력
여는 괄호는 스택에 넣어준다.
2 또는 3이라는 값을 곱해주는값을 저장하는곳에 넣어준다.

닫는괄호는 짝인 여는괄호를 만나면
곱해주는값에 있는 수를 결과값에 더해주고,
곱해주는값은 다시 초기화
아니라면 0출력

* */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String str=br.readLine();
        int result =0;
        int multiply =1;


//        if(str.length()%2 != 0){ //홀수면 올바른 괄호열이 아님
//            System.out.println(0);
//            return ;
//        }
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c=='(') {
                stack.push(c);
                multiply *= 2;
            }else if(c=='[') {
                stack.push(c);
                multiply *= 3;
            }else if(c==')'){
                if(stack.isEmpty() ||stack.peek()!='('){
                    System.out.println(0);
                    return;
                }
                if(str.charAt(i-1)=='('){
                    result+=multiply;
                }
                stack.pop();
                multiply /= 2;
                
            }else if(c==']'){
                if(stack.isEmpty() ||stack.peek()!='['){
                    System.out.println(0);
                    return;
                }
                if(str.charAt(i-1)=='['){
                    result+=multiply;
                }
                stack.pop();
                multiply /= 3;
            }
        }
        System.out.println(stack.isEmpty()?result:0);
    }

}
