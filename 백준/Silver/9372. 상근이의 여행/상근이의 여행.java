import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
테스트수 T
국가의 수 N 비행기의종류 M
M개의 줄에 a,b의 쌍 (a와b를 왕복하는비행기 존재)

* 출력
상근이가 타야하는 비행기 종류의 최소개수
* */

/* 문제해결
비행 스케줄은 항상 연결 그래프를 이룸
연결 그래프에서 간선의 개수는 노드-1
노드 = 여행지
간선 = 비행기
* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine()); //테스트 케이스 수

        for (int i = 0; i < t; i++) {
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]); //국가의 수
            int m = Integer.parseInt(str[1]); //비행기의 종류
            for (int j = 0; j < m; j++) {
                String [] line = br.readLine().split(" ");
            }
            sb.append(n-1).append("\n");
        }
        System.out.println(sb);
    }

}
