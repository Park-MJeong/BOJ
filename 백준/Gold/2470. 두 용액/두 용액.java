import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String [] str = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr); //정렬되어야 포인트지점 이동가능
        int start = 0; // 탐색 시작 지점
        int end = n-1; //탐색 마지막 지점


        int[] res = new int[2]; //정답저장
        int min=Integer.MAX_VALUE;
        while(start < end) {
            int sum = arr[start]+arr[end];

            if(min> Math.abs(sum)) {
                min = Math.abs(sum); //0과 가까운것이기때문에 절댓값으로 비교

                res[0] = arr[start];
                res[1] = arr[end];

                if(sum==0) break;
            }

            if(sum <0) start++; //작은값이 커져야 0과 가까워짐
            else end--; //큰값이 작아져야 0과 가까워짐 
        }

        System.out.println(res[0]+" "+res[1]);



    }
}