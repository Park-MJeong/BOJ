import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
n개의정보 주어짐
유형번호 해당번호 뒤에 줄섬
*
* 출력
* 학생의 수가 최대가 되었던 순간 학생수 & 대기하는 학생 수 출력
* 여러명이면 번호 가장작은 경우 출력
* */

/* 문제해결
먼저도착한사람이 식사하러 먼저들어감.
도착하는순서대로 줄을선다.
선입선출인 큐를 이용

큐의 사이즈가 최대일때 해당정보 저장
같다면 번호비교
* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int size=0;//큐의 최대사이즈
        int m = 100000; //최대사이즈 일때 번호

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String []str = br.readLine().split(" ");
            if (str[0].equals("1")) {
                q.add(Integer.parseInt(str[1])); //식사줄서기
                if(q.size()>size){
                    size=q.size();
                    m=Integer.parseInt(str[1]);
                    continue;
                }
                if(q.size()==size){
                    m=Math.min(m,Integer.parseInt(str[1]));
                }
            }
            else if(str[0].equals("2")){
                if(!q.isEmpty()){
                    q.poll(); //식사하러 들어감
                }
            }
        }
        System.out.println(size+" "+m);

    }

}