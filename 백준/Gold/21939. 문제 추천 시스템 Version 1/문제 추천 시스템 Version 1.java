import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 입력
 * 정수 N
 * N개의 줄에 걸쳐 문제번호 난이도
 * 정수 M
 * M개의 줄에 걸쳐 명령어
 * recommened  1 :  가장 어려운 문제(여러개면,문제번호가 큰 것)
 *             -1 : 가장 쉬운 문제 (여러개면, 문제번호가 작은 것)
 * add 문제번호 난이도  : 해당 문제추가
 * solved 문제번호 해당  : 문제 제거
 *
 *
 * 출력
 * recommend명령어 마다 문제 번호 한 줄씩 출력
 * */
/* 문제해결
정수 n
객체를 만들어서 set에 저장 (난이도를 기준으로 정렬하기 위해서 )
=>가장 쉬운문제나 ,어려운문제 출력위해 필요
key,value형태로 map에도 저장
=>값을 저장하고,삭제하기 위해 필요

* */
public class Main {

    // 문제 정렬 기준
    public static class Solve implements Comparable<Solve> {
        int quiz;  // 문제번호
        int level; // 난이도
        public Solve(int quiz, int level) {
            this.quiz = quiz;
            this.level = level;
        }
        @Override
        public int compareTo(Solve o){
            if(level == o.level){
                return Integer.compare(quiz, o.quiz);
            } else{
                return Integer.compare(level, o.level);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TreeSet<Solve> set = new TreeSet<>(); //정렬된 값 들어감
        Map<Integer,Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            set.add(new Solve(Integer.parseInt(input[0]),Integer.parseInt(input[1])));
            map.put(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
        }




        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            String str = input[0];
            int num = Integer.parseInt(input[1]);
            if(str.equals("recommend")){
                if( num == -1 ){
                    sb.append(set.first().quiz).append("\n");
                    continue;
                }else{
                    sb.append(set.last().quiz).append("\n");
                    continue;
                }
            }
            if(str.equals("add")){
                set.add(new Solve(num, Integer.parseInt(input[2])));
                map.put(num, Integer.parseInt(input[2])); //둘다해주는 이유는 서로 저장된 값이 같아야 하기때문에
            }
            if(str.equals("solved")){
                int level = map.get(num);
                set.remove(new Solve(num,level));
                map.remove(num);//둘다해주는 이유는 서로 저장된 값이 같아야 하기때문에
            }
        }
        System.out.println(sb);

    }

}
