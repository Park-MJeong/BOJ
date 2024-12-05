import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
세로길이 n 가로길이 m
n개의 줄에 걸쳐 한줄에 m개의 문자가 주어짐

* 출력
필요한 나무판자 개수 출력
* */

/* 문제해결
-를 만나면 가로행 검사
|만나면 세로행 검사
각 위치를 방문하여 방문한 위치는 true로 변경
본인과 다른 문자를 만나거나 범위를 벗어나거나 방문했거나 하면 함수 종료
* */
public class Main {


    static int x,y;
    static boolean[][]check;
    static int[][] vecX = {{1, 0}, {-1, 0}}; //세로이동 방향
    static int[][] vecY = {{0, 1}, {0, -1}}; //가로이동 방향

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] arr = br.readLine().split(" ");
        x = Integer.parseInt(arr[0]);
        y = Integer.parseInt(arr[1]);

        char [][] bottom = new char [x][y]; //문자저장
        check = new boolean[x][y]; //방문체크 저장

        for (int i = 0; i < x; i++) { //문자 입력받고 저장
            String str = br.readLine();
            for (int j = 0; j < y; j++) {
                bottom[i][j] = str.charAt(j);
            }
        }
        int cnt =0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (!check[i][j]) {
                    dfs(i,j,bottom);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

    }
    static void dfs(int i, int j,char [][]bottom){
        check[i][j] = true; //방문함
        char current = bottom[i][j];

//        가로탐색 -
//        y는 0보다같거나 크고 기존값을 넘어가면 안된다. & 이어받은 위치가 방문한적이 없어야한다 & 이어받은 값이 -로 같아야한다
        if(current=='-'){
            for (int[] v:vecY){
                int nx=i;
                int ny= j+v[1];
                if(ny >= 0 && ny < y && !check[nx][ny] && bottom[nx][ny] == '-'){
                    dfs(nx,ny,bottom);
                }
            }
        }
//        세로탐색 |
//        x 는 0보다같거나 크고 기존값을 넘어가면 안된다. & 이어받은 위치가 방문한적이 없어야한다 & 이어받은 값이 |로 같아야한다
        if(current=='|'){
            for (int[] v:vecX){
                int nx=i+v[0];
                int ny= j;
                if(nx >= 0 && nx < x && !check[nx][ny] && bottom[nx][ny] == '|'){
                    dfs(nx,ny,bottom);
                }
            }
        }

    }
}
