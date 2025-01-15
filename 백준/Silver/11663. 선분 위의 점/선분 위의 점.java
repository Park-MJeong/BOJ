import java.io.*;
import java.util.*;

/*
* 입력 *
* 첫째 줄에 점의 개수 N개 , 선분의 개수 M개
* 둘째 줄에 점의 좌표 N개
* M개의 줄에 선분의 시작점과 끝점

* 출력 *
* 선분 위에 입력으로 주어진 점의 개수 출력
*
* 문제해결
*
*
*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        String [] str2 = br.readLine().split(" ");
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str2[i]);
        }
        Arrays.sort(arr);

        for (int i = 0; i < m; i++) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            int startPoint = binarySearch(arr,a);
            int endPoint = binarySearch(arr,b+1);


            sb.append(endPoint - startPoint).append("\n");
        }
        System.out.println(sb);

    }

    static int binarySearch(int [] arr,int x) {
        int start = 0;
        int end = arr.length;


        while (start < end) {
            int mid = (start + end)/2;
            if(arr[mid] < x){
                start = mid+1;
            }else end = mid;
        }
        return start;
    }
}
