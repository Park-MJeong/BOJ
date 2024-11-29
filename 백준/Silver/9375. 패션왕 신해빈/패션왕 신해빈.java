
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
테스트 케이스 t
*해빈이가 가진 의상 수 n
*의상의 이름과 종류가 공백으로 구분
* 같은 종류의 의상은 하나만 입을수 있음
*
* 출력
알몸이 아닌 상태로 의상을 입을 수 있는 경우
* */

/* 문제해결
같은 종류의 의상은 하나만 입을 수 있으므로,
의상의 종류와 갯수를 짝지어 저장
종류 1개 3가지 의상
입거나 안입거나 4가지 가능성 - 맨몸1 =3
종류 2개  각각 2가지  1가지 의상
(1,2,x) x (1,x) = 6
6이지만 맨몸일경우 -1 이여서 5
* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); //케이스

        for (int i = 0; i < n; i++) {
            HashMap <String,Integer> hash = new HashMap<>();
            int m = Integer.parseInt(br.readLine()); //옷의 개수

            for (int j = 0; j < m; j++) {
                String[] str = br.readLine().split(" "); //옷이름, 종류
                String kind = str[1];
                hash.put(kind,hash.getOrDefault(kind,0)+1);
            }
            int result=1;
            for(int j : hash.values()){
                result *= j+1; //(각 의상마다의 갯수+안입는경우)를 곱해주고 
            }
            sb.append(result-1).append("\n"); //마지막에 모두안입으면 맨몸이므로 -1
        }

        System.out.println(sb);

    }
}