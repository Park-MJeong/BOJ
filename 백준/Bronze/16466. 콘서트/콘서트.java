import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
1차 티켓팅에서 팔린 티켓 수 정수N
1차 티켓팅에서 팔린 티켓번호 정수 A
*
* 출력
양한아기 가질수있는 티켓 중 가장 작은 번호 출력
* */

/* 문제해결
배열의 크기 1,000,000
for 문을 n번돌며 해당 인덱스에 티켓 번호 저장
그 다음 for문에서 값이 0인거 출력하고 종료

* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] num = new int [1000001];
        int n= Integer.parseInt(br.readLine()); //팔린 티켓수
        String [] str = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int k =Integer.parseInt(str[i]);
            num[k] = k;
        }
        for (int i = 1; i <num.length; i++) {
            int k=num[i];
            if(k==0){
                System.out.println(i);
                return;
            }
        }
    }
}