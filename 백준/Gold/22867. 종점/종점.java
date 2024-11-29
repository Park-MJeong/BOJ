import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 입력
 *
 * 출력
 * */
/* 문제해결
입력받은 시작시간, 종료시간을 2차원 배열에 저장해준다.
저장해 주기전에 : 와 . 를 없애준다.
이전 인덱스의 종료시간과 지금 인덱스의 시작시간을 비교
=>작으면 저장.
****************************************메모리초과
arrayList에 담아주고 
시작시간으로 오름차순 정렬, 같다면 나가는시간 오름차순 정렬
시작시간이면 차고지에 +1씩해준다, 나간다면 -1씩해준다.
현재 차고지에 있는값이 아닌 차고지 최대값을 구해야함!!

* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<int[]> time = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0].replaceAll("[.:]",""));
            int end = Integer.parseInt(input[1].replaceAll("[.:]",""));
            time.add(new int[]{start,1});
            time.add(new int[]{end,-1});
        }

//        정렬
        Collections.sort(time, new java.util.Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) { //시작시간이 같다면
                    return o1[1] - o2[1]; //나가는 시간 오름차순
                }
                return o1[0] - o2[0]; //시작시간이 다르면 시작시간 오름차순
            }
        });

        int cnt = 0;
        int max = 0;
        for(int[] t : time){
            cnt+=t[1];
            max = Math.max(max,cnt);
        }

        System.out.println(max);


    }
}