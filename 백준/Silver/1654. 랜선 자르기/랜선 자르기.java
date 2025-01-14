import java.io.*;
import java.util.*;

/*
* 입력 *
* 이미 가지고 있는 랜선의 개수 K, 써야하는 랜선의 개수 N
* K줄에 걸쳐 이미 가지고 있는 랜선의 길이

* 출력 *
* N개를 만들 수 있는 랜선의 최대 길이
*
* 문제해결
* 1. 가지고 있는 랜선의 길이를 배열로 받는다
* 2. 입력받은 배열을 정렬해 준다.
* 2. 가지고 있는 랜선 길이의 중간값을 구한다.
* 3. 각 배열을 돌면서 중간값으로 나누고 몫을 더해준다.
* 4. 배열을 다 돌고 더해진 몫이 n보다 작으면 , 나눠야 하는 길이가 더 작아져야 하는것 이므로 최댓값의 길이를 중간값-1로 바꿔준다. 
* 중간값은 이미 계산된적이 있으므로 그값의 -1을 해준다.
*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] str = br.readLine().split(" ");
        int K = Integer.parseInt(str[0]);
        int N = Integer.parseInt(str[1]);

        int [] num = new int[K];
        long min ,max,mid;

        for(int i=0;i<K;i++){
            num[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(num);
        min = 1;
        max=num[K-1];


        while(min<=max){
            mid=(min+max)/2;
            long cnt = 0;
            for(int i=0;i<K;i++){
                cnt += num[i]/mid; //잘라진 랜선 개수
            }
//            잘라진 랜선개수가 부족하면 최대길이가 더 짧아 져야한다.
            if(cnt<N){
                max=mid-1;
            }else min=mid+1;

        }
        System.out.println(max);
    }
}
