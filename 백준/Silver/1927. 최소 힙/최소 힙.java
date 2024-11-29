
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
연산의 개수 N
정수 x가 N개의 줄에 주어짐
*
*
* 출력
빈 배열때 가장 작은값 출력 0
* */

/* 문제해결
자연수라면 배열에 값 넣어줌
0이라면 배열에서 가장작은 값 출력, 그리고 그 값 제거

* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(pq.isEmpty()) sb.append(0).append("\n");
                else sb.append(pq.poll()).append("\n");
            }else{
                pq.offer(x);
            }
        }
        System.out.println(sb);


    }
}






