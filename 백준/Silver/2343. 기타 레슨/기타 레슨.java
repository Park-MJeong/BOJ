import java.io.*;
import java.util.*;

/*
* 입력 *
* 블루레이에 들어가는 강의 총 개수 N , 녹화본 블루레이 개수 M
* 둘째 줄에 N개의 강의의 녹화길이


* 출력 *
* 블루레이 크기 중 최소
*
* 문제해결
*
*
*/
public class Main {
    private static long left,right;
    private static int n,m;
    private static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] str = br.readLine().split(" ");
        String [] arr = br.readLine().split(" ");
         n = Integer.parseInt(str[0]);
         m = Integer.parseInt(str[1]);
         num = new int[n];
        long sum = 0;

        for(int i=0;i<n;i++){
         num[i] = Integer.parseInt(arr[i]);
         sum += num[i];
         left =Math.max(left,num[i]);
        }
        right = sum;
        System.out.println(binarySearch(left,right));

    }

    static long binarySearch(long left,long right) {
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = num[0];
            int cnt = 1;
            for (int i = 1; i < n; i++) {
                sum += num[i];
                if (sum > mid) {
                    sum = num[i];
                    cnt++;
                }
            }
            if (cnt <= m) {
                right = mid - 1;
            } else left = mid + 1;
        }
        return left;
    }
}
