import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
* 입력
괄호열을 나타내는 문자열(스트링)이 주어진다. 단 그 길이는 1 이상, 30 이하
*
* 출력
첫째 줄에 그 괄호열의 값을 나타내는 정수를 출력한다. 만일 입력이 올바르지 못한 괄호열이면 반드시 0을 출력
* */

/* 문제해결
1로 시작
=> 정보얻은 고릴라 이름, k, k개의 정보
=>k개의 정보는 내림차순으로 정렬되어 저장되어야함
=>고릴라의 정보가 중복되지 않게 hashmap에 저장
=>정보가 사용되면 꺼내야함

2로 시작
=> 호석이가 구매할 고릴라 이름 , k개의 정보
=> 구매할 정보의 개수가 k개 이하면 가진정보 모두 구매

k의 합은 1,000,000 => long사용

* */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine()); //쿼리의 개수
        Map<String, PriorityQueue<Integer>>map = new HashMap<>(); //고릴라와 정보 저장

        long result = 0;

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); //숫자1또는 2
            String name = st.nextToken(); //고릴라 이름
            int k = Integer.parseInt(st.nextToken()); //정보 갯수


            if (n==1){ //고릴라와 정보저장
                for (int j = 1; j <= k; j++){
                    if (!map.containsKey(name)){ //저장된 고릴라가 아니라면
                        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());//내림차순 정보저장 공간
                        pq.add(Integer.parseInt(st.nextToken()));
                        map.put(name,pq); //이름과 정보 map에 저장
                    }else { //저장된 고릴라라면
                        map.get(name).add(Integer.parseInt(st.nextToken())); //map에서 찾아서 값 저장
                    }
                }
            }
            else if (n==2){ //호석이가 고릴라에게서 정보 가져옴
                PriorityQueue<Integer> pq2 = map.get(name);
                if(pq2 == null) continue; //찾을수 없는 고릴라는 정보거래 불가능
                 else { //정보가 있는 고릴라
                    int m = Math.min(k,pq2.size());
                    for (int j = 0 ; j < m; j++){
                        result+=map.get(name).poll();
                    }

                }
            }

        }

        System.out.println(result);
    }

}
