import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
숫자개수 N
숫자 N개가 주어짐
*
* 출력
좋은 수의 개수를 첫번째 줄에 출력
* */

/* 문제해결
어떤수가 본인을 더하는 것을 제외하고
다른 두개의 수를 더했을때 본인이랑 똑같으면 그수는 좋다!
좋은수의 개수를 최종 출력


* */
public class Main {

    public static int binarySearch(ArrayList<Integer> arr, int k,int i) {
            int start = 0 , end = arr.size() - 1; //이분탐색 시작,끝값
            while (start<end) {
                int sum=arr.get(start)+arr.get(end);
                if(i==start){ //시작값과 같으면 시작값을 큰값으로 옮겨 다른값을 찾아야함.
                    start++;
                    continue;
                }else if(i==end){//끝과 같으면 시작값을 큰값으로 옮겨 다른값을 찾아야함.
                    end--;
                    continue;
                }

                if (sum==k) return 1;

                else if(sum>k){ //시작값 +끝값 > 본인 =>큰값을 감소시켜 합이 본인과 가까워져야함
                    end--;

                }else start++; //시작값 +끝값 < 본인 =>시작 값을 증가시켜 합이 본인과 가까워져야함
            }
            return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<>();

        int N = Integer.parseInt(br.readLine()); //숫자의 개수
        String [] str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(str[i]));
        }
        Collections.sort(arr); //이분탐색을위해 정렬해준다.

        int result=0;

        for (int i = 0; i < N; i++) {
            int k = arr.get(i); //더했을때 나와야 하는 값
            result+=binarySearch(arr,k,i);
        }

        System.out.println(result);

    }

}