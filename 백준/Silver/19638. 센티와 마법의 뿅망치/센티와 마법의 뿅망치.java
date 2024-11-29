
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
인구수 N 센티의 키 C 횟수제한T
두번째줄~N개의 줄에는 각 거인의 키 H
*
*
* 출력
C보다 H가 작으면 YES , 그 다음줄에는 최소 사용한 횟수
C보다 H가 크거나 같으면 NO, 그 다음줄에는 가장 큰 키 출력
* */

/* 문제해결
뿅망치에 맞으면 H/2 로 줄어듬 (단, 1인경우 영향받지않음)
만약 H가 1이라면 더이상 반복하지 않음 (C도 1이라면 NO,1출력)

망치사용횟수가 0이될때까지 무한 반복
최대힙을 사용하여 부모노드를 꺼낸후 cnt++, 키/2 감소
이때 C보다 작으면 반복문 탈출, YES와 cnt 출력
C보다 크면 계속 반복

* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        String [] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]); // 마을 인원
        int m = Integer.parseInt(str[1]); //센티의 키
        int t = Integer.parseInt(str[2]); //망치 횟수

        for(int i=0;i<n;i++){
            pq.offer(Integer.parseInt(br.readLine())); //힙에 마을 사람의 키 넣어줌
        }


        int cnt = 0; //망치 사용횟수
        while (t-- >0){
            int h=pq.poll();
            if(h==1){
                if(m==1){
                    System.out.println("NO");
                    System.out.println(1);
                    return;
                }else{
                    System.out.println("YES");
                    System.out.println(cnt);
                    return;
                }
            }
            if(m<=h){
                pq.offer(h/2);
                cnt++;
            }else{
                System.out.println("YES");
                System.out.println(cnt);
                return;
            }

        }
        int h=pq.poll();
        if(m<=h){
            System.out.println("NO");
            System.out.println(h);
        }else {
            System.out.println("YES");
            System.out.println(cnt);
        }



    }
}






