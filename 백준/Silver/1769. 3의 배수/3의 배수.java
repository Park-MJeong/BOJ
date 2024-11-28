
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
한줄에 큰 자연수 X 입력 (X는 1,000,000자리 이하의 수)
*
* 출력
한자리수가 되려면 몇번의 변환과정을 거쳐야하는지
해당 수가 3의 배수면 YES,아니면 NO
* */

/* 문제해결
문자열로 수를 입력받는다
문자열의 길이가 1이될때까지 반복문을 실행한다.
=>문자열을 문자배열로 형변환후
=>나온 문자를 숫자로 형변환하여 더해준다
=>더해진 값은 다시 문자로 형변환시켜주고, cnt +1
* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        int cnt=0;

        while(number.length()>1){
            int sum=0;
            for(char c:number.toCharArray()){
                sum+=Character.getNumericValue(c);
            }
            number = Integer.toString(sum);
            cnt++;
        }
        int num = Integer.parseInt(number);
        System.out.println(cnt);
        System.out.println(num%3==0?"YES":"NO");
    }
}



