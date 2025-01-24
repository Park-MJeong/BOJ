import java.util.*;
import java.io.*;

class Main {
    static int r;
    static int c;
    static int[][] map;
    static int[][] visited;
    static int[][] melt;
    static int [][] dist ={{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] str = br.readLine().split(" ");
        r=Integer.parseInt(str[0]);
        c=Integer.parseInt(str[1]);
        map = new int[r][c];
        visited = new int[r][c];
        melt = new int[r][c];

        for(int i=0; i<r; i++) {
            String [] arr = br.readLine().split(" ");
            for(int j=0; j<c; j++) {
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }

        solution();
    }

    static void solution() {
        int year = 0;

        while(true) {
            //빙산 덩어리
            int count = 0;
            for(int i=0; i<r; i++) {
                for(int j=0; j<c; j++) {
                    if(visited[i][j] == 0 && map[i][j] != 0) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            if(count == 0) {
                System.out.println(0);
                break;
            } else if(count >= 2) {
                System.out.println(year);
                break;
            }

            melting();
            year++;
        }
    }


    static void dfs(int x, int y) {
        visited[x][y] = 1;

        for(int [] i : dist) {
            int nx = x + i[0];
            int ny = y + i[1];

            if(0 <= nx && nx < r && 0 <= ny && ny < c) {
                // 1년 후에 녹는 빙산의 양 구하기
                if(map[nx][ny] == 0)
                    melt[x][y]++;

                // dfs 재귀
                if(visited[nx][ny] == 0 && map[nx][ny] != 0)
                    dfs(nx, ny);
            }
        }
    }

    static void melting() {
        /**
         * 1. 빙산 녹이기
         * 2. 만약 녹인 높이가 음수가 되면 0으로 바꿔주기
         * 3. visited 초기화
         * 4. melt 초기화
         */
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                map[i][j] -= melt[i][j];

                if(map[i][j] < 0)
                    map[i][j] = 0;

                visited[i][j] = 0;
                melt[i][j] = 0;
            }
        }
    }
}