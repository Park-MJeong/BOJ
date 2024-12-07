import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
나무의 수 n 상근이가 집으로 가져가려고 하는 나무길이 m
나무의 높이 n개

* 출력
적어도 m미터를 가져가이 위해 절단기에 설정할 수 있는 높이의 최댓값
* */
/*
* 문제해결 dfs
잘려진 나무만 가지고 간다.
많이 잘려도 환경보호를 위해 그 길이만 가져간다.
절단기의 높이보다 작으면 잘리지 않기때문에 둘고 가지 않는다.

나무의 높이를 입력받아 정렬한다.
나무높이의 중간값을 먼저 절단기 높이로 설정하고 원하는 나무길이보다 적으면 =>왼쪽탐색, 절단기 높이 1씩 감소하며 최댓값 찾음
원하는 나무길이보다 크면 오른쪽으로 이동 =>오른쪽탐색 ,절단기 높이1씩 증가하며 최댓값찾음

*
*/

public class Main {
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]); //나무의 수
        m = Integer.parseInt(str[1]); //원하는 나무의 길이

        int []dist = new int[n];


        String[] str1 = br.readLine().split(" "); //촌수를 계산해야하는 두 사람의 번호
        for(int i = 0; i <n; i++){
            dist[i] = Integer.parseInt(str1[i]); //나무 길이저장
        }
        Arrays.sort(dist); // 길이 오름차순 저장.


        System.out.println(binary(dist));

    }

    static long binary(int []dist) {
        int left =0;
        int right =dist[n-1]; //최대 높이 저장
        long result = 0;
        while(left <= right){
            int mid = (left+right)/2; //중간높이
            long temp=0;

            for(int i = 0; i <n; i++){
                if(dist[i] > mid){
                    temp += dist[i]-mid;
                }
            }
            if(temp >=m){ //원하는 길이보다 길거나 같다면 시작값을 중간값 +1하면서 ~끝까지 탐색 ==>오른쪽만 탐색
                result = mid; //해당 높이 저장
                left = mid+1; //중간길이 +1 (시작길이를 중간길이에서 1씩 증가하며 비교)
            } else right = mid-1; //작다면 왼쪽탐색 , 최대길이를 중간길이보다 작게(1씩감소하며 비교)
        }
        return result;
    }

}