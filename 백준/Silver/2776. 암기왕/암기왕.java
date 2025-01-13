import java.io.*;
import java.util.*;

/*
* 입력 *
* 테스트 케이스 개수 T
* 수첩1에 적어 놓은 정수 개수 N
* 정수N개
* 수첩2에 적어 놓은 정수 개수 M
* 정수 M개
*
* 출력 *
* 한줄에 한개씩 수첩2에 적혀있는 M개의 숫자 순서대로, 수첩1에 있으면 1,없으면 0 출력
*
*
* 문제해결 *
* 1. M개의 줄 만큼 출력해야하므로 StringBuilder를 사용하여 출력값을 모아 마지막에 출력한다.
* 2. 테스트 케이스 개수를 입력받는다.
* 3. 테스트 개수 만큼 for문을 진행
* 4. for문 안에서 정수N과 N개의 정수를 입력받는다.
* 5. HashSet에 해당 값을 저장한다.
* 6. for문 안에서 정수 M과 M개의 정수를 입력받는다.
* 7. 5에서 저장한 HashSet에 M을 비교하며 있으면 StringBuilder에 1을 추가,없으면 0을 추가해준다.
* 8. 최종 System.out.println을 출력한다.
* */

public class Main{
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Integer T =Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            HashSet<Integer> set1 = new HashSet<>();
            String [] str1 = br.readLine().split(" ");
            for(String n:str1){
                set1.add(Integer.parseInt(n));
            }

            int M = Integer.parseInt(br.readLine());
            HashSet<Integer> set2 = new HashSet<>();
            String [] str2 = br.readLine().split(" ");
            
            for(String m : str2){
                if(set1.contains(Integer.parseInt(m))){
                    sb.append("1").append("\n");
                }else sb.append("0").append("\n");
            }
        }
        System.out.println(sb);
        }
}
