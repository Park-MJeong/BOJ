
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //수열의 크기
        String [] str = br.readLine().split(" ");
        int [] arr = new int[n]; //수열
        int [] dp = new int[n]; // 부분 수열 최대 길이
        int result =0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
            dp[i] = 1; // 자기자신
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);

    }

}