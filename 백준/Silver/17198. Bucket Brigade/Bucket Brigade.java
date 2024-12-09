import java.io.*;
import java.util.*;

/*
* 입력
테스트 케이스 개수 T
각 테스트 케이스는 3줄로 입력이 이루어짐
체스판 한 변의 길이 l (체스판 크기 l*l)
나이트가 현재 있는 칸 x1 y1
나이트가 이동하려고 하는칸  x2 y2
*

* 출력
각 테스트 케이스마다 나이트가 최소 몇번만에 이동할 수 있는지 출력
* */
/*
* 문제해결 bfs

*/


public class Main {
    static int[][] vec ={{0,1},{0,-1},{1,0},{-1,0}};
    static boolean[][] check = new boolean[10][10];
    static char[][] map = new char[10][10];

    static class point{
        int x,y,cnt;
        point(int x,int y,int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;

        }
    }

    static point l;  //L 좌표



    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<10;i++){
            String str = br.readLine();
            for(int j=0;j<10;j++){
                map[i][j] = str.charAt(j);
                if(str.charAt(j) =='L'){
                    l = new point(i,j,0);
                }
            }
        }
        bfs();
    }

    static void bfs() {
        Deque<point> q = new LinkedList<>();
        q.offer(l);
        check[l.x][l.y] = true;

        while(!q.isEmpty()){
            point cur = q.poll();
            for(int[] v : vec){
                int nx = cur.x+v[0];
                int ny = cur.y+v[1];
                if(nx<0||ny<0||nx>=10||ny>=10||check[nx][ny]){
                    continue;
                }
                if(map[nx][ny]=='R'){
                    check[nx][ny] = true;
                }
                if(map[nx][ny]=='B'){
                    System.out.println(cur.cnt);
                    System.exit(0);
                }
                if(map[nx][ny]=='.'){
                    q.offer(new point(nx,ny,cur.cnt+1));
                    check[nx][ny] = true;
                }
            }
        }

    }
}