
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
첫 번째 줄에는 막대기의 개수를 나타내는 정수 N (2 ≤ N ≤ 100,000)
이어지는 N줄 각각에는 막대기의 높이를 나타내는 정수 h(1 ≤ h ≤ 100,000)
*
* 출력
오른쪽에서 N개의 막대기를 보았을 때, 보이는 막대기의 개수를 출력
* */

/* 문제해결
스택에 입력받은 수를 넣어준다.
스택이 비어 있지않고, 입력받은 값이 이전에 입력받은 수보다 크거나 같으면 이전 값을 스택에서 꺼낸다
==>최근에 입력받은 값이 크거나 같다면, 반대에서 보이지 않음
마지막 값은 따로 비교
* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine()); //막대기 개수
        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(br.readLine());
            while (!stack.isEmpty() && h >= stack.peek()) {
                stack.pop();
            }
            stack.push(h);
        }
        System.out.println(stack.size());

    }
}



