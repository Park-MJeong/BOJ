import java.awt.*;
import java.util.*;
import java.io.*;
/*
* 입력
테스트케이스T
배추가로길이 M 세로길이 N 배추가 심어져있는 위치 개수K
K줄의 배추위치 x y
* 출력
각 테스트 케이스에 대해 필요한 최소의 배추흰지렁이 마리 수를 출력
* */
/*
 * 문제해결
행렬에 주어지는 x,y 위치에는 1을 넣어준다.아니면0
배추의 위치에 지렁이가 위치할 수있다.(상하좌우까지 영향을 줌)
변수에 배추의 개수만큼 배열크기를 지정한다.

*
*


*
 */

import java.io.IOException;
import java.util.List;

public class Main {
    static int m,n,k;
    static int[][] map;
    static int[][]vec=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    static boolean[][] check;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int cnt=0;
            
            String[] str = br.readLine().split(" ");
            m = Integer.parseInt(str[0]); // 가로
            n = Integer.parseInt(str[1]); // 세로
            k = Integer.parseInt(str[2]); // 배추갯수

            map = new int[m][n];
            check = new boolean[m][n];
            for (int j = 0; j < k; j++) { //배추밭에 정보 넣어줌
                String[] str1 = br.readLine().split(" ");
                int x = Integer.parseInt(str1[0]);
                int y = Integer.parseInt(str1[1]);
                map[x][y] = 1;
            }

            for (int j = 0; j < m; j++) {
                for (int l = 0; l < n; l++) {
                    if (map[j][l] == 1 && !check[j][l]) {
                        dfs(j, l);
                        cnt++;
                    }
                }
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }
    static void dfs (int x, int y){
        if(x<0||x>=m||y<0||y>=n||map[x][y]==0||check[x][y]){
            return;
        }
        check[x][y]=true;
        for(int [] v :vec){
            int nx=x+v[0];
            int ny=y+v[1];
            dfs(nx,ny);
        }

    }
}