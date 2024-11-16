import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
한 주당 4줄씩 표현
요일별 오전근무 4
요일별 미들근무 6
요일별 저녁근무 4
요일별 야간근무 10
- : 휴무
아무도 출근하지 않으면 Yes
* */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] w = {4,6,4,10}; //
        int time = 0;

        Map<String, Integer> map = new HashMap<>(); //근무자 시간 정보


        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T*4; i++) {
            String [] arr = br.readLine().split(" ");

            time = time ==4 ? 0: time;

            for (int j = 0; j < 7; j++) {
                if (arr[j].equals("-")) {
                    continue;
                }
                if (!map.containsKey(arr[j])) {
                    map.put(arr[j],0);
                }
                map.put(arr[j],map.get(arr[j])+w[time]);

//                System.out.println(map);
            }
            time++;
        }
        
        if(map.size()==0){
            System.out.println("Yes");
            return;
        }
        
        Integer result = Collections.max(map.values()) - Collections.min(map.values());
        System.out.println(result<=12 ? "Yes" : "No");


    }
}
