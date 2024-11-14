import java.io.*;
/*
1. a,b,c 중 하나라도  0이거나 0보다 작으면 1
2. a,b,c 중 하나라도 20보다 크면 w(20, 20, 20)
3. a < b < c 라면 w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
4. 해당 안되면  w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
5. -1,-1-,1 를 입력받으면 더 이상 입력받지 않는다.
* */
/*
몇줄을 입력받는지 정해져 있지 않다. -> while, break 조건
문제에서 함수가 구현되어 있으므로 해당 변수를 그대로 선언

* */
public class Main {

    static int [][][] dp = new int [21][21][21];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true){
            String [] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            //  더 이상 입력받지 않고 종료됨
            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(w(a ,b ,c)).append('\n');
        }
        System.out.println(sb);
        br.close();

    }

    static int w(int a,int b,int c){
//        0이거나 음수, 20초과는 주어진 값이 있으므로 해당 범위가 아니여야함
//        dp가 0이 아니라는건 이미 계산된 값이 있는것이이여서 굳이 재계산 안하고 바로 값을 꺼내면 됨
        if(a>0 && a<=20 && b>0 && b<=20 && c>0 && c<=20 && dp[a][b][c]!=0){
            return dp[a][b][c];

        }

        if( a <= 0 || b <= 0 || c <= 0) return 1;
        else if( a > 20 || b > 20 || c > 20)
            return dp[20][20][20] = w(20, 20, 20);
        else if(a < b && b < c)
            return  dp[a][b][c] =  w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        else return dp[a][b][c] =  w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);

    }
}
