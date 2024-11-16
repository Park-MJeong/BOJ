import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
뽑을수 있는 가장 큰 수는 본인이 처음에 선 순서 -1
0이라면 그대로 위치, 뽑은 수 만큼 앞에 설 수 있다.
첫번째사람은 무조건 마지막에 위치
세번째 사람은 위치값 max:2 min:0
5번째 사람은 위치값 max:4 min:0

리스트의 위치값과 크기를  이용해서 해당 크기빼줌

* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        String [] n = br.readLine().split(" ");
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);

        for (int i = 1; i < T; i++) {
            list.add(i-Integer.parseInt(n[i]),i+1);
        }
        for (int i = 0; i < T; i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
