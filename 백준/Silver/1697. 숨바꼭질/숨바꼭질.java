import java.util.*;
import java.io.*;
/*
* 입력
수빈이가 있는 위치 n 동생이 있는 위치 k
* 출력
수빈이가 동생을 찾는 가장 빠른 시간
* */
/*
 * 문제해결
수빈이의 이동 거리는 x+1 x-1 x*2
한번 움직일때마다 ++1초

수빈이와 동생의 시간을 입력받는다.

*먼저 수빈이의 거리를 큐에 넣고
* 큐가 비지않을때까지
* vexX만큼 계속 움직인다.
*( 움직일수 있는 거리인 10000나 0을 벗어나거나 해당위치의 결과값이 0이아니면 다음값 반복)
* 움직인거리는 큐에 넣어주고 그럴때마다 해당거리의 시간은 +1해준다.
* 움직인거리가 동생의 위치와 같으면 결과값출력

*
 */

import java.io.IOException;

public class Main {

    static int n,x;
    static int[] result = new int[100001];
    static int[]vecX = new int[]{1,-1,2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]); //수빈이 위치
        x = Integer.parseInt(str[1]); //동생위치
        if(n==x){
            System.out.println(0);
            return;
        }
        bfs();


    }
    static void bfs() {
        Deque<Integer> q = new ArrayDeque<>();

        q.offer(n);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for(int v:vecX){
                int tmp ;
                if(v==2){
                    tmp=cur*2;
                } else if (v==1) {
                    tmp=cur+1;
                }else tmp=cur-1;

                if(tmp<0||tmp>100000||result[tmp]!=0){
                    continue;
                }

                result[tmp]=result[cur]+1;
                if(tmp==x){
                    System.out.println(result[x]);
                    return;
                }
                q.offer(tmp);
            }
        }

    }

}