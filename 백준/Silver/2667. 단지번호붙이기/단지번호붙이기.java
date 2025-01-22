import java.util.*;
import java.io.*;
/*입력
* 첫번째줄 지도의 크기(정사각형) N
* N줄에 각각 N개의 자료 0 또는 1
*
* 출력
* 첫번째줄에 총 단지수 출력
* 각 단지내 집의 수 오름차순정렬 하여 한 줄에 하나씩 출력
*
* 문제해결
*
* */
public class Main {
    static int n,cnt;
    static int [][] arr_num;
    static boolean [][] visited;
    static List<Integer> res = new ArrayList<>();
    static int[][]dist = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr_num = new int[n][n];
        visited = new boolean[n][n];
        cnt=1;
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr_num[i][j] = Integer.parseInt(s[j]);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr_num[i][j] ==1 && !visited[i][j]){
                    dfs(i,j);
                    res.add(cnt);
                    cnt =1;

                }
            }
        }
        Collections.sort(res);

        for(int i:res){
            sb.append(i).append("\n");
        }
        System.out.println(res.size()+"\n"+sb);
    }
    static void dfs(int x, int y) {
        visited[x][y] = true;
        for(int[]d:dist){
            int nx = x+d[0];
            int ny = y+d[1];
            if(nx>=0 &&ny>=0 && nx<n && ny<n && !visited[nx][ny] && arr_num[nx][ny]==1){
                cnt++;
                dfs(nx,ny);
            }

        }

    }


}