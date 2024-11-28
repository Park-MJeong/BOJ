
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
명령어가 pop,top 중 하나이고 스택이 공백이면 -1 출력
그리고,해당명령어에서는 정수를 따로저장한 값과,StringBuilder를 파라미터로 넘겨주는 함수를 따로 만들어
최대한 중복코드를 줄인다.

push X: q.add(X)
pop: 스택에서 가장 위에있는 정수를 빼고, 그 수를 출력
size: 스택에 들어있는 정수의 개수를 출력
empty: 스택이 비어있으면 1, 아니면 0을 출력
top: 스택 가장위에 있는 정수 출력

* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String [] str = br.readLine().split(" ");
            String s = str[0];
            int k;
            if((s.equals("pop")||s.equals("top")) && stack.isEmpty()){
                sb.append(-1).append("\n");
                continue;
            }
            if(s.equals("push")) {
                stack.push(Integer.parseInt(str[1]));
            }else if(s.equals("pop")) {
                k=stack.pop();
                empty(sb,k);
            }else if(s.equals("size")) {
                sb.append(stack.size()).append("\n");
            }else if(s.equals("empty")) {
                sb.append(stack.isEmpty()?1:0).append("\n");
            }else if(s.equals("top")) {
                k=stack.peek();
                empty(sb,k);
            }
        }
        System.out.println(sb);
    }
    public static void empty(StringBuilder sb,int k){
        sb.append(k).append("\n");
    }
}



