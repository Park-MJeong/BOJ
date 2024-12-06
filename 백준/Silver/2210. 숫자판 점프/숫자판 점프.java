import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
각 위치의 숫자 주어짐 (5x5)
n줄까지는 n개의 이동 가능 수
* 출력
만들수 있는 숫자 조합 출력
* */

/* 문제해결
총5번 이동이 가능하다.
시작점은 정해져있지 않고, 방문했던 위치를 또 방문 가능하다.

2차원 배열에 입력받은 값을 저장한다.
인접해있는 네방향으로 이동하므로 이동방향을 저장한 배열을 전역변수로 선언
값을 중복저장하지않는 set에 5번이동하고 나면 해당 값을 저장한다.

* */
public class Main {

    static Set<String> set = new HashSet<>();
    static int [][] vec = {{-1,0},{0,-1},{1,0},{0,1}}; //왼쪽,위,아래,오른쪽 이동방향

    static class point{
        int x,y;
        String num;
        public point(int x,int y,String num){
            this.x=x;
            this.y=y;
            this.num=num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] jump = new String[5][5];

        for (int i = 0; i < 5; i++) { //입력값 배열에 저장
            jump[i] = br.readLine().split(" ");
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                bfs(i,j,jump);
            }
        }
        System.out.println(set.size());
    }
    public static void bfs(int a,int b,String[][]jump) {
        Queue<point> q = new LinkedList<>();

        q.offer(new point(a,b,jump[a][b]));

        while (!q.isEmpty()) {
            point p =q.poll();
            if(p.num.length()==6){
                set.add(p.num);
                continue;
            }
            for(int[]v:vec){
                int nx=p.x+v[0];
                int ny=p.y+v[1];
                if(nx<0||ny<0||nx>=5 ||ny>=5||jump[nx][ny]==null){
                    continue;
                }
                q.offer(new point(nx,ny,p.num+jump[nx][ny]));
            }
        }
    }
}