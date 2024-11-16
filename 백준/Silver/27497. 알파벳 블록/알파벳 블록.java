import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/* 입력
1 c : 문자열 맨 뒤에 c가 적힌 블록 추가
2 c : 문자열 맨 앞에 c가 적힌 블록 추가
3 : 문자열을 구성하는 블록 중 가장 나중에 추가된 블록 제거
처음에 빈 문자열로 시작 -> 이때, 3을 입력 받으면 아무동작이 일어나지 않는다.
* */

/* 출력
완성된 문자열 출력, 문자열이 빈 문자열이면 0 출력
* */

/*
먼저, 버튼을 누르는 횟수 N을 입력받는다.
알파벳은 대,소문자가 구분된다.
* 문자열이 앞,뒤에서 모두 입출력이 가능하므로 deque 사용*/
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> deque = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            int button = Integer.parseInt(str[0]);
            if (button == 3 && deque.size() == 0) {
                continue;
            }
            switch (button) {
                case 1:
                    deque.addLast(str[1]);
                    stack.push(1);
                    break;
                case 2:
                    deque.addFirst(str[1]);
                    stack.push(2);
                    break;
                case 3:
                    int lastButton = stack.pop();
                    if(lastButton==1){
                        deque.removeLast();
                    }
                    else if(lastButton==2){
                        deque.removeFirst();
                    }
                    break;
            }
        }

        if (!deque.isEmpty()) {
            for (String s : deque) {
                sb.append(s);
            }
            System.out.println(sb);
        } else {
            System.out.println(0);
        }

    }
}
