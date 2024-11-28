
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


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
명령어가 pop,front,back 중 하나이고 큐가 공백이면 -1 출력
그리고,해당명령어에서는 정수를 따로저장한 값과,StringBuilder를 파라미터로 넘겨주는 함수를 따로 만들어
최대한 중복코드를 줄인다.

push X: q.add(X)
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력
size: 큐에 들어있는 정수의 개수를 출력
empty: 큐가 비어있으면 1, 아니면 0을 출력
front: 큐의 가장 앞에 있는 정수를 출력한다
back: 큐의 가장 뒤에 있는 정수를 출력한다
* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String [] str = br.readLine().split(" ");
            String s = str[0];
            int k;
            if((s.equals("pop")||s.equals("front")||s.equals("back")) && q.isEmpty()){
                sb.append(-1).append("\n");
                continue;
            }
            if(s.equals("push")) {
                q.add(Integer.parseInt(str[1]));
            }else if(s.equals("pop")) {
                k=q.pop();
                empty(sb,k);
            }else if(s.equals("size")) {
                sb.append(q.size()).append("\n");
            }else if(s.equals("empty")) {
                sb.append(q.isEmpty()?1:0).append("\n");
            }else if(s.equals("front")) {
                k=q.getFirst();
                empty(sb,k);
            }else if(s.equals("back")) {
                k=q.getLast();
                empty(sb,k);
            }
        }
        System.out.println(sb);
    }
    public static void empty(StringBuilder sb,int k){
        sb.append(k).append("\n");
    }
}



