import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
문자열 길이 L
영문 소문자로만 이루어진 문자열
*
* 출력
문자열을 해시값 정수로 계산하여 출력
* */

/* 문제해결
a=1,b=2,c=3,d=4 ... z=26
처음들어온수는 1, 두번째는 31, 세번째는 31^2 ... 최대 5글자이므로 마지막은 31^5

우선, 테이블에 각각 알파벳의 숫자를 저장한다ㅏ.
a는 아스키 코드로 97번

문자열의 위치값은 31의 n승이 될것임
해당 문자열은 테이블에서 해당 숫자를 찾아 두개를 곱한다.
문자열끼리의 값은 더해준다.

유한한 범위의 출력을 가지므로 주어진 m (1234567891)으로 나눈 나머지 출력

* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Hashtable<Character,Integer> table = new Hashtable<>() ;
        int n = Integer.parseInt(br.readLine());
        int m =1234567891;
        String s = br.readLine();

        long sum = 0;
        long r =1;

        for(int i=1 ; i<=26 ; i++){
            table.put((char)(96+i),i);
        }
        for(int i=0 ; i<n ; i++){
            sum+= (table.get(s.charAt(i))* r) % m ;
            r =(r*31) % m;
        }
        System.out.println(sum%m);

    }
}