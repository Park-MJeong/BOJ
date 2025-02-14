
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        }
    });
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int [] result = new int[n];

        for (int i = 0; i < n; i++) {
            String [] str1 = br.readLine().split(" ");
            int k = Integer.parseInt(str1[0]);
            for (int j = 1; j <= k; j++) {
                queue.add(new int[] { Integer.parseInt(str1[j]), i }); //주문초밥,손님
            }
        }

        PriorityQueue<Integer> num = new PriorityQueue<>();
        String [] str1 = br.readLine().split(" "); //초밥나오는 순서

        for (int i = 0; i < m; i++) {
            num.add(Integer.parseInt(str1[i]));
        }

        while (!num.isEmpty()) {
            if(queue.isEmpty()) {
                break;
            }
            if (queue.peek()[0] == num.peek()) {
                int []temp = queue.poll();
                num.poll();
                result[temp[1]] ++; //손님이 초밥 먹음
            } else if (queue.peek()[0] > num.peek()) {
                num.poll(); //초밥버림
            } else {
                queue.poll();
            }
        }
        for (int i = 0; i < n; i++) {
            sb.append(result[i] + " ");
        }
        System.out.println(sb);

    }
}