import java.util.*;
import java.io.*;
/*
* 입력
n개의 수
n줄에 n개의 수
* 출력
산술평균 출력(소수점 이하 첫째자리에서 반올림)
중앙값 출력
최빈값 출력(여려개 있을 때 두번째로 작은값 출력)
범위출력
* */
/*
 * 문제해결
산술평균 : N개의 수들의 합을 N으로 나눈 값
중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
최빈값 : N개의 수들 중 가장 많이 나타나는 값
범위 : N개의 수들 중 최댓값과 최솟값의 차이


*
 */

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int []numbers = new int[n];
        int [] arr = new int[8001];
        double add=0;
        int cnt=0;
        for (int i = 0; i < n; i++) {
            numbers[i]=Integer.parseInt(br.readLine());
            add+=numbers[i];
        }

        Arrays.sort(numbers); // 중앙값 구하기 위해

//        각각의 빈도 구해서 저장,가장많이 카운트된것도 구함
        for (int i = 0; i < n; i++) {
            arr[numbers[i]+4000]++; // 각 숫자횟수 카운트
            cnt =Math.max(arr[numbers[i]+4000],cnt); //최대카운트 구함

        }

        ArrayList<Integer> list = new ArrayList<>();
//        가장많이 카운트된것과 값이 같으면 출력.1개면 바로 출력, 2개면 두번째로 작은수.
        for (int i = 0; i <arr.length; i++) {
            if(cnt==arr[i]){
                list.add(i-4000); //위에서 해당숫자에 4000더해줌
            }
        }


        System.out.println(Math.round(add /n)); //산술평균
        System.out.println(numbers[numbers.length/2]); //중앙값
        System.out.println(list.size()==1?list.get(0):list.get(1));
        System.out.println(numbers[n-1]-numbers[0]); //최댓값 - 최솟값

    }


}