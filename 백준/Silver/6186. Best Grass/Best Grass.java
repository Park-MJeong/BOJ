import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
* 입력
정수 행 R 정수 열 C
R개의 줄
(한줄에 C개의 기호 # 또는 .)
* 출력
Bessie가 먹을 수 있는 풀 덩어리 수
* */

/* 문제해결
#은 한개, 최대2개까지 인접해있다.
대각선으로 위치한것은 각각 카운트해야한다.
R * C
#을 입력받으면 해당위치에 1을 저장 , .을 입력받으면 0 을 저장한다.
각 위치를 방문하는 배열을 추가하여 true입력

#을 입력받은 1이고 방문하지않은 배열이였다면 카운트해준다.
* */
public class Main {
    static int r;
    static int c;
    static boolean[][]check;
    static int[][] vec = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; //방향
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] str = br.readLine().split(" ");
        r =Integer.parseInt(str[0]);
        c =Integer.parseInt(str[1]);

        int[][] filed = new int[r][c]; // .과 #을 저장하는 배열
        check = new boolean[r][c]; //방문여부 저장하는 배열
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                if(line.charAt(j) == '#') filed[i][j] = 1;
                else filed[i][j] = 0;
            }
        }

        int cnt = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
//                #이 있고 방문한곳이 아니라면 +1
                if(filed[i][j] == 1 && !check[i][j]){ // #이고 방문한적이 없다면 갯수 ++
                    dfs(i,j,filed);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

    }
    static void dfs(int x,int y,int[][] filed){
        // 범위를 벗어나거나, 방문했거나, 풀이 아닌 경우 종료
        if (x < 0 || x >= r || y < 0 || y >= c|| check[x][y] || filed[x][y] == 0) {
            return ;
        }
        check[x][y] = true; //방문함
        for(int[] v : vec){
            int nx = x + v[0]; //x방향이동
            int ny = y + v[1]; //y방향이동
            dfs(nx,ny,filed);
        }


    }
}