import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
정점의 수 N 간선의 수 M 시작정점 R
M개의 줄에 간선정보 u v

* 출력
정점 i의 방문순서를 i번째 줄에 출력
* */

public class Main {
    static int u, v;
    static int m,n,r;
    static boolean[] check;
    static List<List<Integer>> graph = new ArrayList<>();
    static int [] visited; //방문춘서 저장
    static int cnt=1; //방문순서

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        r = Integer.parseInt(str[2]);

        check = new boolean[n+1]; // 방문 체크 저장
        visited = new int[n+1]; //방문 순서 저장

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) { // 문자 입력받고 저장
            String[]str1 = br.readLine().split(" ");
                u =Integer.parseInt(str1[0]);
                v =Integer.parseInt(str1[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(r);
        for (int i = 1; i <=n; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);

    }

    static void dfs(int start) {
        check[start] = true;
        visited[start] = cnt++;

        for(int i:graph.get(start)) {
            if(!check[i]) {
                dfs(i);
            }
        }
    }
}