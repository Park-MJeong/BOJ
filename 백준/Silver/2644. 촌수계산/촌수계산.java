import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
사람들의 전체 수 n
촌수를 계산 해야하는 번호 a b
부모 자식을 나타내는 입력받는 수 m
m줄 동안 부모x,자식y 입력받음

* 출력
입력에서 요구한 a와b의 촌수계산
계산이 되지않는다면 -1출력
* */
/*
* 문제해결 dfs
a의 1촌(부모 자식 관계)
부모님의 1촌은 조부모님 : a와는 2촌
조부보님의 1촌은 부모님의 형제들 :a와는 3촌

* 해당 값들과 촌수를 계산하기 위해 촌수를 저장하는 배열(dist)을 만든다. **기본값은 -1
* bfs함수 안에서 a의 촌수는 0 으로 만들어준다.
* for문을 돌면서
a의 부모님을 찾아 +1을해준다.
부모님의 조부모님을 찾아 +1을 해준다.
조부모님의 자식들을 찾아 +1을 해준다.(값이 -1인 사람만)
*
* dist의 위치값에 b를 넣어 해당값 출력
*/

public class Main {
    static int n,a,b;
//    static boolean[] check;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] dist; //촌수 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); //전체 사람 수

        dist = new int[n+1];
        Arrays.fill(dist,-1); //연결되지않으면 -1출력

//        check = new boolean[n+1];

        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }


        String[] str = br.readLine().split(" "); //촌수를 계산해야하는 두 사람의 번호
        a = Integer.parseInt(str[0]);
        b = Integer.parseInt(str[1]);

        int m = Integer.parseInt(br.readLine()); //부모 자식간의 관계의 갯수 m

        for(int i = 1; i < m+1; i++){
            String[] str1 = br.readLine().split(" ");
            int x= Integer.parseInt(str1[0]); // 부모
            int y= Integer.parseInt(str1[1]); //자식
            graph.get(y).add(x);
            graph.get(x).add(y);
        }
        
        bfs(a);
        
        System.out.println(dist[b]);

    }

    static void bfs(int start) {
        Deque<Integer> queue = new LinkedList<>();
        queue.add(start);
        dist[start] = 0; //기존값이 -1로 설정되어잇음. 내자신을 0으로 바꿔 아래식 계산

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int v: graph.get(cur)){
                if(dist[v] == -1){
                    dist[v] = dist[cur]+1;
                    queue.add(v);
                }
            }
        }
    }

}