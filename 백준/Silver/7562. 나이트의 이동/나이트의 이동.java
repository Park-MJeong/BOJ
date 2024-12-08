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
    static int l,x1,y1,x2,y2,size;
    static int[][] vec ={{2,1},{2,-1},{1,2},{1,-2},{-2,1},{-2,-1},{-1,2},{-1,-2}};
    static boolean[][] check;
    static StringBuilder sb = new StringBuilder();
    
    static class point{
        int x,y,cnt;
        public point(int x,int y,int cnt){
            this.x=x;
            this.y=y;
            this.cnt =cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            l = Integer.parseInt(br.readLine()); //체크판 한 변의 길이
            check = new boolean[l][l];

            String [] str = br.readLine().split(" "); //현재 위치
            x1 = Integer.parseInt(str[0]);
            y1 = Integer.parseInt(str[1]);

            String [] str2 = br.readLine().split(" "); //이동위치
            x2 = Integer.parseInt(str2[0]);
            y2 = Integer.parseInt(str2[1]);

            if(x1==x2&&y1==y2){ //같다면 이동하지않음
                sb.append(0).append("\n");
                continue;
            }
            bfs();
        }
        System.out.println(sb);

    }

    static void bfs() {
        Deque<point> queue = new LinkedList<>();
        queue.offer(new point(x1,y1,0));
        check[x1][y1] = true;

        while(!queue.isEmpty()){
            point cur = queue.poll();
            for(int[]v:vec){
                int nx = cur.x+v[0];
                int ny = cur.y+v[1];
                if(nx<0 || ny<0 || nx>=l || ny>=l || check[nx][ny]){
                    continue;
                }
                if(nx==x2 && ny==y2){ //이동한 위치가 목표위치와 같다면 출력
                    sb.append(cur.cnt+1).append("\n");
                    return;
                }
                queue.offer(new point(nx,ny,cur.cnt+1)); //조건에 걸리지않았다면 카운트 +1해주고, 해당 값 넣어줌
                check[nx][ny] = true;
            }

        }

    }

}