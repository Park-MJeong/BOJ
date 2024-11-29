
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
후보의 수 N
N개의 줄에 걸쳐 각 번호를 찍으려고 하는 사람의 수
*
* 출력
알몸이 아닌 상태로 의상을 입을 수 있는 경우
* */

/* 문제해결
다솜이는 기호1 번으로 숫자를 따로 저장해준다.
최대힙에 n-1(다솜이 득표제외) 득표수를 저장
힙에꺼내서 다솜이꺼와 비교
같거나 크면 -1해서 힙에 넣고, 다솜이는 +1, cnt +1해줌을
힙에서 꺼낸값이 다솜이보다 작을때 까지반복

* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int cnt =0;
        for (int i = 0; i < n-1; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        } //힙에 다른 후보의 투표수 저장

        if(n==1){
            System.out.println(0);
            return;
        }

        while (!pq.isEmpty()) {
            int x = pq.poll();
            if(k<=x){
                pq.offer(x-1);
                k++;
                cnt++;

            }else{
                System.out.println(cnt);
                return;
            }
        }
    }
}