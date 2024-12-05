import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
구역의 크기 N
n줄까지는 n개의 이동 가능 수
* 출력
쩰리가 (n,n)에 도달하면 HaruHaru , 그렇지 못하면 Hing
* */

/* 문제해결
정해진 정사각형 외부로 나가면 안됨
출발점은 항상 (0,0)
이동하는 방향은 (1,0) 오른쪽, (0,1) 아래 뿐이다.
구역의 (n,n)에 도달하면 승리
한번에 이동할 수 있는 칸 수는 현재 밟고 있는 칸에 쓰여 있는 수(초과/미만 불가능)
* */
public class Main {
    static int n;
    static int[][] vec = {{1,0},{0,1}}; //오른쪽,아래 이동방향

    static class point{
        int x,y;
        public point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); //정사각형 크기
        int[][]game = new int[n][n];

        for (int i = 0; i < n; i++) { //게임정보 입력
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                game[i][j] = Integer.parseInt(input[j]);
            }
        }
        System.out.println(bfs(game));
    }
    public static String bfs(int[][]game) {
        boolean[][] visited = new boolean[n][n];
        Queue<point> q = new LinkedList<>();

        visited[0][0] =true; //시작위치 고정
        q.offer(new point(0, 0));
        while (!q.isEmpty()) {
            point p = q.poll();
            int k = game[p.x][p.y];
            if(game[p.x][p.y]==-1){
                return "HaruHaru";
            }
            for(int[]v :vec){
                int nx = p.x + (v[0]* k) ; //p.x의 크기만큼 이동
                int ny = p.y + (v[1]* k); //p.y의 크기만큼 이동
                if(nx>=n || ny>=n || visited[nx][ny]){ //범위를 벗어나거나 방문했다면
                    continue; //다음값
                }
                visited[nx][ny] = true;
                q.offer(new point(nx,ny)); //방문했으니 넣어줌
            }
        }
        return "Hing";

    }
}