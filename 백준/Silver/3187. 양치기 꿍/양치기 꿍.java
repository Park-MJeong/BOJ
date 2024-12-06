import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
첫번째 줄에는 각 영역의 세로 R,가로C
다음 R줄에는 C개의 문자
* 출력
살아남게 되는 양과 늑대의 수를 각각 순서대로 출력
*/
/*
* 문제해결
* 전역변수선언 : 방문여부 저장(boolean)배열, 위치 이동값
* */

public class Main {

    static int R, C;
    static char[][] map;
    static boolean[][]check;
    static int[][] vec = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; //방향

    static int sheep, wolf;
    static int resultSheep, resultWolf;


    public static void main(String[] args) throws IOException {
        // 입력 값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]); //세로입력줄 수
        C = Integer.parseInt(input[1]); //가로입력 길이

        map = new char[R][C];  
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray(); 
        }

        check = new boolean[R][C];  

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
//                #을만나면 다른 울타리임
                if (map[i][j] != '#' && !check[i][j]){
                    bfs(i, j);
                }
            }
        }
        
        System.out.println(resultSheep+ " " + resultWolf);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        check[x][y] = true;
        sheep = 0;
        wolf = 0;

        // 현재위치에서 양,늑대 값 추가
        if (map[x][y] == 'k') sheep++;
        if (map[x][y] == 'v') wolf++;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int [] v :vec) {
                int nx = cx + v[0];
                int ny = cy +v[1];

                // 탈출문: 맵 범위 밖으로 나가는지 확인, 방문 여부 및 벽('#') 여부 확인
                if (nx >= R || ny >= C || nx < 0 || ny < 0 || check[nx][ny] || map[nx][ny] == '#') continue;

                check[nx][ny] = true;
//                이동한 위치에서의 양,늑대발견시 값 추가
                if (map[nx][ny] == 'k') sheep++; 
                if (map[nx][ny] == 'v') wolf++;  

                queue.add(new int[]{nx, ny});  
            }
        }

        // 양과 늑대 중 살아남을 수 있는 수를 계산
        if (sheep <= wolf) {
           resultWolf += wolf;  // 늑대수가 양의 수보다 크거나 같으면 양 다 x
        } else {
            resultSheep += sheep;  // 양이 더 많으면 늑대 다 x
        }
    }
}
