import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.PriorityQueue;

/*
 * 입력
 * 정수 N
 * N개의 줄에 걸쳐 카드묶음 크기
 * 출력
 * 최소 비교 횟수
 * */
/* 문제해결
a<b<c
a+c + (a+c)+b
작은 값끼리 먼저 계속 더해져야한다.
우선순위큐 (내림차순)에 모두 저장하고.
처음에, 큐에서 두개의 값을 꺼내서 저장한다.
이 값을, 결과값에 더해주고, 큐에도 다시 넣어준다.
우선순위 큐 이므로 해당값이 제일 작다면 바로 뽑힐것이고 . 아니면 순위가 달라짐..?

* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        long result = 0;

        for (int i = 0; i < n; i++) {
            pq.offer(Long.parseLong(br.readLine()));
        } //힙에 입력값을 넣어준다.
        if(n==1) {
            System.out.println(0);
            return;
        }

        while (pq.size()>2) { //두개씩 꺼내므로 2보다 커야함
            long sum; //계속 초기화
            long a = pq.poll();
            long b = pq.poll();

            sum = a+b;
            pq.add(sum);
            result += sum;
        }
        if(!pq.isEmpty()) size2(pq,result);

        System.out.println(result);
    }

    public static void size2(PriorityQueue pq, long result) {
        for (Object l : pq) {
            result += (Long) l;
        }
        System.out.println(result);
        System.exit(0);
    }
}