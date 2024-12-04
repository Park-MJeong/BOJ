import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
보석의 개수 N 가방 개수 K
그 다음 N개의 줄에는 각 보석의 정보인 무게M 가격V
그 다음 K개의 줄에는 가방에 담을 수 있는 최대 무게 C
*
* 출력
상덕이가 훔칠 수 있는 보석가격의합 최댓값 출력
* */

/* 문제해결
각 가방에는 한개의 보석만 넣을 수 있다.
입력받은 가방과 보석을 배열에 저장한다.
가방과,보석을 무게기준으로 오름차순 정렬한다.
가방의 무게를 오름차순정렬
=>작은 무게에 들어가는 보석은 나중에 큰 무게에도 무조건 들어갈 수 있다.
중복값을 허용하지 않는 우선순위큐에
각 가방의 무게가 넣을 수 있는 보석을 저장 한 후
가격내림차순으로 졍렬된 큐에서 가방의 개수만큼 값을 꺼내 더해준다.





* */
public class Main {

    static class Jewel {
        long w;
        long price;
        public Jewel(long w, long price){
            this.w = w;
            this.price = price;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]); //보석수
        int k = Integer.parseInt(str[1]); //가방수
        Integer [] bag = new Integer[k];

        Jewel[]jewels = new Jewel[n];

       for(int i = 0; i < n; i++){ //보석 무게,가격정보 입력
           str = br.readLine().split(" ");
           jewels[i] = new Jewel(Long.parseLong(str[0]), Long.parseLong(str[1]));
       }

        for (int i = 0; i < k; i++) { //가방 정보 입력
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bag); //가방 오름차순
        Arrays.sort(jewels,new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                return (int)(o1.w-o2.w); //무게기준 오름차순
            }
        });

        PriorityQueue<Jewel> pq = new PriorityQueue<>(new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                return (int)(o2.price-o1.price);
            }
        }); //가격 기준 내림차순


//            보석 무게가 가방의 무게보다 같거나 작으면 큐에 넣어준다.
        int cnt=0;
        long result =0;
        for(int i = 0; i < k; i++){

            while (cnt<n && jewels[cnt].w <= bag[i]){
                    pq.offer(jewels[cnt]);
                    cnt++; //비교한 보석수
            }
            if(!pq.isEmpty()){ //해당무게에서 가질수 있는 최대값을 저장
                result+=pq.poll().price;
            }

        }

        System.out.println(result);
    }

}