import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

/*
* 입력
정수 N
N개의 정수가 공백으로 주어짐
*
* 출력
압축된 정수 출력
* */

/* 문제해결
본인보다 작은수들을 압축할수 있다.
크거나 같은경우는 압축이 되지않는다.

숫자는 최대 1,000,000 개수 까지 주어진다.
리스트 for문을 통해 각각 인덱스위치값을 비교하여 숫자를 ++한 후
String Builder에 저장해준다.
***리스트 이중포문 ->시간초과

* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[]arrX = new int[n]; //입력값 저장
        int [] sortX = new int[n]; //x좌표 정렬
        int cnt =0; //작은값 카운트

        String [] str = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arrX[i] = Integer.parseInt(str[i]); //x좌표
            sortX[i] = arrX[i];
        }

        Arrays.sort(sortX);



        Map<Integer,Integer> map = new HashMap<>(); //좌표와 카운트 저장,좌표가 중복되면 카운트 값이 같기때문에 애초에 중복값을 제거하여 카운트
        /*
        * 0 1 2 2 3
        * 0 0 저장, 카운트 증가 =1
        * 1 1 저장 , 카운트 증가=2
        * 2 2 저장, 카운트 증가 =3
        * 2 넘어감
        * 3 3 저장, 카운트 증가.
        *
        * 이렇게 하면 본인보다 작은수 카운트 가능
        * */
        for(int i :sortX){
            if(!map.containsKey(i)){
                map.put(i,cnt++);
            }
        }
        for(int i : arrX){
            sb.append(map.get(i)+" ");
        }
        System.out.println(sb);
    }

}