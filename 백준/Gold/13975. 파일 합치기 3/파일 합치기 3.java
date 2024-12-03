import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
태스트수 T
소설구성하는 장의수 k
1~k까지 파일크기
*
* 출력
테스트마다 한행에 출력
* 모든 장을 합치는데 필요한 최소비용 출력
* */

/* 문제해결
작은값끼리 먼저 계속 더해져야한다.a=b<c<d
c<(a+b)<d
d<(a+b+c)
(a+b)+(a+b+c)+(a+b+c+d)
우선순위 큐에 내림차순으로 저장하고
큐에서 두개의 값을 저장한 후
다시 큐에 넣어준다.
더해진값을 저장하는 변수도 필요.
더한값을 출력할 변수에 더해준다.
큐의 사이즈가 1이되면 변수를출력한다.
* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            PriorityQueue<Long> pq = new PriorityQueue<>();
            int k = Integer.parseInt(br.readLine());
            String [] str = br.readLine().split(" ");
            for (int j = 0; j < k; j++) {
                pq.offer(Long.parseLong(str[j]));
            }
            long sum = 0;
            while (pq.size()>1) {
                long l=pq.poll();
                long m=pq.poll();
                sum+=l+m;
                pq.offer(l+m);
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);

    }

}