import java.io.*;
import java.util.*;

/*
* 입력
* 첫번째 줄에 정점의 개수 N, 간선의 개수 M,탐색 시작 정점번호 V
* M개의 줄에 간선이 연결하는 두 정점의 번호
*
* 출력
* 첫째줄에 DFS
* 둘째줄에 BFS
* */
public class Main {
    static int Edge_arr[][];
    static boolean Visited_arr[];
    static int N;
    static int M;
    static int V;
    static int count;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] str1 = br.readLine().split(" ");
        N = Integer.parseInt(str1[0]);
        M = Integer.parseInt(str1[1]);
        V = Integer.parseInt(str1[2]);

        Edge_arr = new int[1001][1001];

        for(int i=0; i<M; i++) {
            String[] str2 = br.readLine().split(" ");
            int x = Integer.parseInt(str2[0]);
            int y = Integer.parseInt(str2[1]);

            Edge_arr[x][y] = Edge_arr[y][x] = 1;
        }

        Visited_arr = new boolean[1001];
        DFS(V);
        System.out.println();

        Visited_arr = new boolean[1001];
        BFS(V);

    }

    public static void DFS(int start) {
        Visited_arr[start] = true;

        System.out.print(start + " ");

        if(count == N) {
            return;
        }
        count ++;

        for(int i=1; i<=N; i++) {
            if(Edge_arr[start][i] == 1 && !Visited_arr[i]) {
                DFS(i);
            }
        }
    }



    public static void BFS(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        Visited_arr[start] = true;
        System.out.print(start + " ");

        while( !que.isEmpty() ) {
            start = que.poll();

            for(int i=1; i<=N; i++) {

                if(Edge_arr[start][i] == 1 && !Visited_arr[i]) {
                    que.offer(i);
                    Visited_arr[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }




}