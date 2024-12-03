import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
경험치갯수n 최대활성화k
*
* 출력
경험치합의 최댓값
* */

/* 문제해결
활성화된것은 경험치가 0이된다.
작은순서부터 활성화되고
가장 큰 값이 마지막에 활성화 되어야한다.
우선순위큐a에 입력값을 넣어주고
처음 활성화 => 값을 빼내고,cnt++1
두번째 활성화부터는  => 값을 빼내고, cnt++1, cnt*값 다른 큐b에 넣어줌
cnt만큼 반복하고
b를 결과값에 더한다.
a에 남은것은 활성화스톤 수 만큼 곱해줌


다른큐의 값에
* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long>pq = new PriorityQueue();
        PriorityQueue<Long>pq2 = new PriorityQueue();
        String [] str = br.readLine().split(" ");
        String [] str2 = br.readLine().split(" ");
        long n = Long.parseLong(str[0]); //경험치 수
        long k = Long.parseLong(str[1]); // 활성화 갯수
        long result = 0L;
        int cnt =0;
        for (int i = 0; i < n; i++) {
            pq.offer(Long.parseLong(str2[i]));
        }
        while (cnt<=k && !pq.isEmpty()) {
            Long m = pq.poll();
            pq2.offer(m*cnt);
            cnt++;
        }

        while (!pq2.isEmpty()) {
            result += pq2.poll();

        }
        while(!pq.isEmpty()){
            result += pq.poll()*k;
        }

        System.out.println(result);

    }

}