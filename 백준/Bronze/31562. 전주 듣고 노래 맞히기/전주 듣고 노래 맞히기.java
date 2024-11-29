
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
음을 아는 노래 개수 N 맞히기 시도할 노래 개수 M
두번째줄~N 줄
* 노래길이T 노래제목 S 일곱개의 음이름(공백으로 구분)
N+2번째 줄 ~ M개의 줄
* 노래의 첫 세음의 음이름(공백으로 구분)
* 출력
첫 세음과 동일하면 노래제목, 두 개 이상이면 ?, 없으면 !
* */

/* 문제해결
키와 값을 같이 저장해야하므로 hashTable사용
값은 여러 인덱스를 저장해야하므로 배열형태로 선언 =>반복문을 돌면서 제목과 첫 3음 저장
반복문을 돌면서 음이름을 배열로 저장하고 해시테이블의 값과 입력받은 음이름배열이 같다면
그 이름을 저장. 그리고 카운트를 올려줌
만약 카운트가 1이라면 이름을 출력하고
카운트가 2이상이 라면 ?를 출력하고
카운트가 0이라면 !를 출력

* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Hashtable<String,String[]> table = new Hashtable<>() ;


        String [] str =br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        for(int i = 0 ; i < n ; i++){
            String [] music = br.readLine().split(" ");
            table.put(music[1],Arrays.copyOfRange(music,2,5));
        }
        for(int i = 0 ; i < m ; i++){
            String [] song = br.readLine().split(" ");
            int cnt = 0;
            String name ="";
            for(String s : table.keySet()){
                if(Arrays.equals(song,table.get(s))){//키값을 통해 배열로 해당 음이름배열을 가져왔을때 같다면
                    cnt++;
                    name = s;
                }
            }
            if(cnt ==0) sb.append("!").append("\n");
            else if(cnt ==1) sb.append(name).append("\n");
            else sb.append("?").append("\n");

        }
        System.out.println(sb);

    }
}



