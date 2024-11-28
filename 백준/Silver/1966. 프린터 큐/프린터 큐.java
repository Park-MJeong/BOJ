
import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/*
* 입력
첫 줄에는 테스트 케이스 수
각 테스트 케이스는 두 줄로 이루어짐
1. 문서의 총 개수 내가 원하는 문서의 위치
2. 문서마다 중요도
* *
*
* 출력
명령어가 주어질때마다 한줄에 하나씩 출력
* */

/* 문제해결
우선 queue에 값을 넣어준다.
맨 처음 값을 꺼내서 임시로 저장하고 다음에 위치한 값과 비교,
자신보다 큰 값이 있으면 내가 가진값을 큐의 맨 뒤로 저장
내가 가진값이 가장 큰 값이라면 cnt ++,
내가 원하는 문서위치값이 아니라면 다시반복, 원하는문서라면 cnt출력

* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] str = br.readLine().split(" ");
            String [] num = br.readLine().split(" ");

            int n = Integer.parseInt(str[0]); //문서의 개수
            int m = Integer.parseInt(str[1]); //내가 원하는 문서 위치
            int cnt = 0; //원하는 문서가 출력되는 순서

            Queue<int[]> q = new LinkedList<>(); //int[] 인덱스와 중요도 함께 저장
            for (int j = 0; j < n; j++) {
                q.add(new int[]{j,Integer.parseInt(num[j])});  //각각의 값 넣어줌
            }

            while (!q.isEmpty()) {
                int[] tmp = q.poll(); //tmp[0]:인덱스값,tmp[1]중요도값 ,  맨 앞에 값 꺼냄
                boolean check = true;  //내가 가진 값이 가장 큰 값인지 여부저장
                for (int[] tmpQ : q) {
                    if (tmp[1]<tmpQ[1]) { //내가 먼저 뽑은 값보다 저장된 값이 크면
                        check = false;
                        break; //해당 for문 탈출
                    }
                }
                if (check) { //가장 큰 값이라면
                    cnt++;
                    if (tmp[0]==m) {
                        sb.append(cnt).append("\n");
                        break;//원하는 위치값나오면 반복문 탈출
                    }
                } else q.add(tmp); //큐애 다시 값 저장해줌

            }
        }
        System.out.println(sb);
    }

}




