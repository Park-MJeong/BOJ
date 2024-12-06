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
모든 값을 입력받고 우선 저장한다.
a->b노드까지 의 금액을 모두 계산하여 리스트에 저장해준다.
각 거리까지의 최소비용을 계산하는 함수를 만들고 배열에 저장
배열에서 종료점에 해당하는 위치를 인덱스로 넣고 해당 값  출력

* */
public class Main {

    static class Edge{
        int target; // 도착노드
        int cost; //간선 가중치
        public Edge(int target, int weight){
            this.target = target;
            this.cost = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //로봇 변신상태 갯수
        String [] number = new String[n]; //로봇부품정보 입력 할 변수
        List<List<Edge>> graph = new ArrayList<>(n);

        for (int i = 0; i < n; i++) { //로봇의 부품 입력
            number[i] = br.readLine();
        }

        String [] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0])-1; //변신로봇 시작점
        int end = Integer.parseInt(input[1])-1; //변신로봇 끝점

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
//        계산해서 나올 수 있는  모든 비용을 저장
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j){
                    graph.get(i).add(new Edge(j,cal(number[i],number[j])));
                }
            }
        }

        int [] dist  = dijkstra(graph,start,n);
        System.out.println(dist[end]);
   }

    static int cal(String a, String b){ //필요한 돈 계산
        int cost = 0;
        for(int i = 0; i < a.length(); i++){
            cost+= (int) Math.pow(a.charAt(i)-b.charAt(i), 2);
        }
        return cost;
    }

    static int[] dijkstra(List<List<Edge>> graph,int start,int n) {
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE); //해당값 무한대로 초기화
        dist[start] = 0; //출발점 0에서 시작, 0->0의 비용은 0

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e->e.target)); //가격 오름차순
        pq.add(new Edge(start,0)); //시작은 가중치0으로 시작

        while(!pq.isEmpty()){
            Edge e = pq.poll();
            int currentT = e.target; //현재 탐색 정점
            int currentC = e.cost; //시작점 ~현재 탐색 노드까지 비용

            if(currentC>dist[currentT]) continue; //이미 저장된값이 작으면 더 이상 계산 필요없음

            for(Edge edge : graph.get(currentT)){
                int target = edge.target; //햔제 정점에서 갈 수 있는 정점
                int cost = edge.cost; // 현재 정점이 가진 금액

                if(dist[currentT]+cost < dist[target]){ //최소값 저장
                    dist[target] = dist[currentT]+cost;
                    pq.add(new Edge(target,dist[target]));
                }
            }
        }
        return dist;
    }
}