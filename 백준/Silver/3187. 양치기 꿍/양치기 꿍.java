import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * [ 백준 3187번 양치기 꿍 ]
 * 문제 설명 : 양치기 꿍이 울타리 안에 양(k)과 늑대(v)를 집어 넣었다.
 *           - 한 울타리 영역 안에서 양의 수 > 늑대의 수일 경우, 늑대가 전부 잡아먹힌다.
 *           - 반대로 늑대의 수 >= 양의 수일 경우, 양이 전부 잡아먹힌다.
 *           - 울타리(#)로 막히지 않은 공간에는 양과 늑대가 존재하지 않으며, 대각선 이동은 불가능하다.
 *           문제는 최종적으로 살아남은 양과 늑대의 수를 계산하는 것이다.
 * 입력 : 첫 줄 - 영역의 세로(R)와 가로(C) 길이를 나타내는 두 정수
 *              3 <= R, C <= 250
 *       다음 R줄 - 각 줄에 .(빈 공간), #(울타리), v(늑대), k(양)로 구성된 문자
 * 출력 : 한 줄에 최종적으로 살아남은 양의 수와 늑대의 수를 공백으로 구분하여 출력한다.
 */
public class Main {
    static short R, C;
    static boolean[][] visited;
    static char[][] map;

    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};

    static int survivedSheep, survivedWolf;

    public static void main(String[] args) throws IOException {
        // 입력 값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Short.parseShort(input[0]);
        C = Short.parseShort(input[1]);

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != '#' && !visited[i][j]){
                    bfs(i, j);
                }
            }
        }
        System.out.println(survivedSheep + " " + survivedWolf);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int sheep = 0;
        int wolf = 0;
        if (map[x][y] == 'k') sheep++;
        if (map[x][y] == 'v') wolf++;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx >= R || ny >= C || nx < 0
                        || ny < 0 || visited[nx][ny] || map[nx][ny] == '#') continue;

                visited[nx][ny] = true;
                if (map[nx][ny] == 'k') sheep++;
                if (map[nx][ny] == 'v') wolf++;

                queue.add(new int[]{nx, ny});
            }
        }

        if (sheep <= wolf) {
            survivedWolf += wolf;
        } else {
            survivedSheep += sheep;
        }
    }
}