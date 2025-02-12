import java.io.*;
import java.util.*;

/*
* 입력
방문횟수 n
a개의 숫자
=> 각 숫자들은 선물의 개수 선물의 가치(단,0이라면 방문한것)
*
* 출력
a가 0일때마다 선물 가치 출력
선물이 없다먼 -1출력
* */

/* 문제해결
가치가 큰 선물 하나의 값을 꺼내는것이므로 최대힙
0이면 힙에서 꺼낸 값 출력, 만약 힙이 비어있다면 -1출력
* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int n = Integer.parseInt(br.readLine()); //거점지 방문횟수
        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            if(arr[0].equals("0")){ //아이들 만난것
                if(pq.isEmpty()) sb.append(-1).append("\n");
                else sb.append(pq.poll()).append("\n");
            }else {
                for(int j = 1; j < arr.length; j++) { //선물 충전
                    pq.offer(Integer.parseInt(arr[j]));
                }
            }
        }
        System.out.println(sb);


    }
}