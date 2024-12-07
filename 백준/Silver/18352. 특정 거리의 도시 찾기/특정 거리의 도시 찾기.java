import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
도시의 개수 n 도로의 개수 m 거리정보 k 출발도시번호x
m개의 줄에 걸쳐 자연수 a,b가 주어짐 (단방향 도로)

* 출력
x로부터 출발햐여 최단거라기 k인 도시번호 한줄에 하나씩 출력
하나도 없으면 -1
* */
/*
* 문제해결 bfs
* 최단거리를 구하는 문제이므로 bfs를 사용한다.
**** 초기값을 -1로 주고 시작값을 0으로 변경해줘야한다.
* 처음 시작한 도시도 방문체크를 해줘야 하기때문이다.
* 3 3 2 1
1 2
2 1
2 3
*
*/

public class Main {
    static int n,m,k,x;
    static int [] dist;
    static boolean[]check;
    static List<List<Integer>> list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String [] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]); //도시의 개수 ,노드
        m = Integer.parseInt(str[1]); //도로의 개수 , 간선
        k = Integer.parseInt(str[2]); //원하는 최단거리
        x = Integer.parseInt(str[3]); //시작점

        dist = new int[n+1];
        Arrays.fill(dist,-1); //초기값 -1지정

        check = new boolean[n+1];

        list= new ArrayList<>(n+1);

        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            String [] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            list.get(a).add(b); //방향이 있으므로 방향대로만 추가
        }


        bfs(x);

        for(int i=1;i<=n;i++){
            if(dist[i]==k) sb.append(i).append("\n");
        }

        if(sb.length() ==0){
            System.out.println(-1);
        }else System.out.println(sb);

    }

    static void bfs(int a) {
        Deque<Integer> dq = new LinkedList<>();
        dq.offer(a);
        dist[a] = 0; //시작노드 0으로 시작

        while (!dq.isEmpty()){
            int cur = dq.poll();

            for(int i : list.get(cur)){
                if(dist[i]==-1) {
                    dist[i] = dist[cur]+1;
                    dq.offer(i);
                }
            }
        }
    }
}