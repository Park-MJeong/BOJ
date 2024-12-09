import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
노드의 개수 N 노드 쌍의 개수 M
N-1개 줄에 연결된 두 점과 거리
거리를 알고 싶은 M개의 노드

* 출력
두 노드사이의 거리 출력
* */
/*
 * 문제해결
노드사이를 저장하는 배열과 거리를 저장하는 배열을 만든다.

 */

public class Main {
    static int n,a,b;
    static List<List<point>> nodes;
    static boolean[] checked;
    static StringBuilder sb = new StringBuilder();

    static class point{
        int x,d;
        point(int x,int d){
            this.x=x;
            this.d=d;
        }
//        @Override
//        public String toString() {
//            return "(" + x + ", " +d+ ")";
//        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        nodes = new ArrayList<>(n+1);
        for(int i=0;i<n+1;i++){
            nodes.add(new ArrayList<>());
        }

        for(int i=0;i<n-1;i++){
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int d = Integer.parseInt(str[2]);
            nodes.get(a).add(new point(b,d));
            nodes.get(b).add(new point(a,d));
        }

        for(int i=0;i<m;i++){
            str = br.readLine().split(" ");
            a=Integer.parseInt(str[0]);
            b=Integer.parseInt(str[1]);
            bfs();
        }
        System.out.println(sb);

    }
    static void bfs() {
        Deque<point> q = new LinkedList<>();
        checked = new boolean[n+1];

        q.offer(new point(a,0));
        checked[a]=true;

        while(!q.isEmpty()){
            point cur = q.poll();
            int x = cur.x; //노드위치
            int d =cur.d; //거리
            if(x==b){ //꺼낸값과 내가원하는 노드위치와 같으면 그때까지의 누적합 출력
                sb.append(d).append("\n");
                return;
            }
            for(point p : nodes.get(x)){ //해당 노드위치를 넣었을떄 연결되는 노드와 거리값
                if(!checked[p.x]){
                    checked[p.x]=true;
                    q.offer(new point(p.x,d+p.d)); //d+p.d 누적합
                }
            }
        }

    }


}