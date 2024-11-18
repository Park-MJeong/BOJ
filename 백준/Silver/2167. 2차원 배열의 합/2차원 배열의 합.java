import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
첫째줄에는 배열의 크기 N(행),M(열)
N개의 줄에 M개의 정수로 배열이 주어짐
K
i,j,x,y i행j열 ~ x행y열 위치까지 저장되어 있는 수들의 합 출력
x와 y는 항상 i와 j보다 크다.
    1   2   3
 1  1   2   4
 2  8   16  32
행의 범위는 i~x까지, 열의 범위는 j~y까지
* */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int [][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String [] size = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(size[j]);
            }
        }
//        System.out.println(Arrays.deepToString(arr));

        int k= Integer.parseInt(br.readLine());

        while (k-- > 0) {
            String [] line = br.readLine().split(" ");
            int i = Integer.parseInt(line[0]);
            int j = Integer.parseInt(line[1]);
            int x = Integer.parseInt(line[2]);
            int y = Integer.parseInt(line[3]);

            int sum = 0;
            for (int w = i-1 ; w < x; w++) {
                for (int r = j-1; r < y; r++) {
                    sum+=arr[w][r];
                }
            }
            sb.append(sum+"\n");
        }
        System.out.println(sb);

    }

}
