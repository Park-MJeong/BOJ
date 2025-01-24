import java.io.*;
import java.util.*;
/*
* 입력
* 첫번째줄에 테스트 케이스의 개수 K
* K줄만큼 한 줄에 정점의 개수V, 간선의 개수 E
* 그 다음 E개의 줄에 걸쳐 인접한 두 정점의 번호 u,v
**/
public class Main{
    static int K, V, E, u, v;
    static int []visited;
    static ArrayList<ArrayList<Integer>> connect;
    static String answer;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        for(int i =0; i<K;i++){ //테스트 케이스 수
            answer ="YES";
            String [] str1 = br.readLine().split(" ");
            V = Integer.parseInt(str1[0]); //정점의 개수
            E = Integer.parseInt(str1[1]); //간선의 개수

            connect = new ArrayList<>();

            for(int j=0; j<=V; j++){
                connect.add(new ArrayList<>()); //초기화
            }

            for(int j =0; j< E; j++){
                String [] str2 = br.readLine().split(" ");
                u = Integer.parseInt(str2[0]);
                v = Integer.parseInt(str2[1]);

                connect.get(u).add(v);
                connect.get(v).add(u);
            }

            visited = new int[V+1];
            for(int j =1; j<=V; j++){
                if(visited[j]==0){
                    if(!bfs(j))
                        break;
                }
            }
            System.out.println(answer);
        }
    }

    public static boolean bfs(int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] =1;

        while(!q.isEmpty()){
            int now = q.poll();
            for(Integer i: connect.get(now)){
                if(visited[now]==visited[i]){
                    answer="NO";
                    return false;
                }
                if(visited[i]==0){
                    visited[i]=visited[now]*-1;
                    q.add(i);
                }
            }
        }
        return true;
    }
}