
import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


/*
* 입력
주어지는 명령의 수 N (1 ≤ N ≤ 10,000)
둘째 줄~N개의 줄에는 명령어주어짐
정수는 1보다 크거나 같고, 100,000보다 작다
* *
*
* 출력
명령어가 주어질때마다 한줄에 하나씩 출력
* */

/* 문제해결
문자열의 추가,삭제가 커서의 왼쪽에서 이루어짐. => stack사용하여 stack의 맨 위라고 생각하기??
커서의 위치값은 인덱스로 접근
명령어가 수행되기 전에 커서는 문장의 맨 뒤에 위치 => 인덱스 값을 문자열 사이즈-1 로 받기
기존 문자열 저장 공간, stack에서 빼서 잠시 저장할 문자열 공간 필요

**매번 커서의 위치를 값으로 가져와서 임시로 저장했다가 추가해주니 시간초과
커서는 한칸씩 이동함.
커서가 뒤쪽에서 앞으로 한칸 이동(커서의 위치가 맨 앞이 아니여야함,0)-> 커서뒤에 하나의 문자가 생김 -> 임시 스택에 넣어줌,커서위치--
커서가 앞쪽에서 뒤쪽으로 한칸 이동 ->임시스택이 비어있다면 커서가 문장 맨뒤라는 의미, 아니면 임시스택의 값을 기존 스택에 넣고, 커서위치 ++ 
커서의 왼쪽 문자 삭제(커서의 위치가 0이 아니여야함)->기존스택의 값 pop,커서위치도 --
커서의 왼쪽에 문자 추가->기존스택에 push하고 커서위치는 ++
기본 스택값 먼저 sb에 추출,
임시스택의 값은 

* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        Stack<String> tmp = new Stack<>();

        String str = br.readLine(); //초기 문자열 저장
        for (String s : str.split("")) {
            stack.push(s);
        }
        int n = Integer.parseInt(br.readLine()); //명령어 입력 개수
        int cursor = stack.size() ; //커서의 위치, 인덱스가 3까지 있는 스택의 사이즈는 4니까, 커서의 위치는 사이즈값으로 지정

        for (int i = 0; i < n; i++) {
            String[] commend = br.readLine().split(" ");
            String s = commend[0];
            if (s.equals("L")) {
                if(cursor>0){
                    tmp.push(stack.pop()); //커서가 한칸씩 이동하는 순간 커서의 오른쪽 값은 나중에 뺴주어야하므로 미리 저장
                    cursor --;
                }

            } else if (s.equals("D")) {
                if(!tmp.isEmpty()){
                    stack.push(tmp.pop()); //stack+tmp의 커서위치 이기때문에 tmp에 값이 있다는것은 cursor가 tmp에 존재하고 있다는것
                    cursor ++;
                }

            } else if (s.equals("B")) {
                if(cursor>0){ //커서의 왼쪽 문자 삭제
                    stack.pop();
                    cursor --;
                }
            } else if (s.equals("P")) {
                stack.push(commend[1]);
                cursor ++;
            }

        }
        for (String s : stack) {
            sb.append(s);
        }
        while (!tmp.isEmpty()) {
            sb.append(tmp.pop());
        }
        System.out.println(sb);
    }

}




