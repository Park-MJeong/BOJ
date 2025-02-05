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
최댓값을 구하려면
작은순서부터 활성화되고
가장 큰 값이 마지막에 활성화 되어야한다.
=>활성화되면 그값은 0 이되고 다른수에 더해지기때문에 남아있는 스톤의 경험치가 클 수록 좋다.
활성화 갯수가 최대가 되면 그 이후로 남은 스톤은 활성화갯수만큼 경험치가 더해진다.

우선순위큐a에 입력값을 넣어주고
처음 활성화 => 값을 빼내고,cnt++1
두번째 활성화부터는  => 값을 빼내고, cnt++1, cnt*값 다른 큐b에 넣어줌
cnt만큼 반복하고 b를 결과값에 더한다.
a에 남은것은 활성화스톤 수 만큼 곱해줌


**null pointer에러로 모든 while문에 공백이 아닐때 조건을 추가해줌
* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long>pq = new PriorityQueue();

        String [] str = br.readLine().split(" ");
        String [] str2 = br.readLine().split(" ");

        long n = Long.parseLong(str[0]); //경험치 수
        long k = Long.parseLong(str[1]); // 활성화 갯수
        long result = 0L; //결과값

        for (int i = 0; i < n; i++) {
            pq.offer(Long.parseLong(str2[i]));
        }

        pq.poll();
        int cnt =1; //현재까지 활성화된 스톤 갯수

        while (!pq.isEmpty()) {
            if(cnt<k){
                result += pq.poll() * cnt;
                cnt++;
            }else {
                result+=pq.poll()*k;
            }
        }

        System.out.println(result);

    }

}