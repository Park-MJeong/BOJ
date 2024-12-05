import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
테스트수 T
t줄만큼 정수 a 정수b

* 출력
a와 b가 최소공통조상노드*10
* */

/* 문제해결
본인의 조상 노드를 찾으려면 본인/2를 해야한다
이 값이 a와 b가 같을때 까지 반복한다.

* */
public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine()); //테스트 케이스 수

        for (int i = 0; i < t; i++) {
             String[] input = br.readLine().split(" ");
             int a = Integer.parseInt(input[0]);
             int b = Integer.parseInt(input[1]);
             while (a!=b){
                 if(a>b)  a/=2;
                 else if(b>a) b/=2;
            }
        sb.append(a*10).append("\n");
        }
        System.out.println(sb);
    }

}