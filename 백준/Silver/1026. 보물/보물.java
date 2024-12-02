import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
정수 N
정수 A배열 : N개의 수
정수 B배열 : N개의 수
* 출력
최솟값 출력
* */

/* 문제해결
배열S는 각 배열의 같은 위치의 수를 곱한 값 을 모두 더한값
B는 재배열이 불가, A를 재배열하여 S를 최솟값으로 만들어야 한다.

B의 큰값과 A의 작은값이 곱해져야한다
B를 map에 넣어 key를 내림차순하여 B를 내림차순 하였을때 위치를 가져온다.
A를 오름차순 정렬 후
새로운 배열에 B의 내림차순 값을 가져와 그 위치에 A를 넣는다.
새로운 배열과 B의 각각 위치에 존재하는 값을 곱하고 모두 더한다.
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());  //정수n

        String[] a = br.readLine().split(" "); //배열a
        int[] arrA = new int[n];

        for (int i = 0; i < n; i++) {               //배열 a
            arrA[i] = Integer.parseInt(a[i]);
        }
        Arrays.sort(arrA); //a오름차순 정렬
        String[] b = br.readLine().split(" "); //배열a
        Integer[] arrB = new Integer[n];

        for (int i = 0; i < n; i++) {               //배열 a
            arrB[i] = Integer.parseInt(b[i]);
        }
        Arrays.sort(arrB,Collections.reverseOrder());
//        Arrays.sort(arrB,Collections.reverseOrder());
//        Arrays.reverse(arrB); //a오름차순 정렬

        int result = 0;
        for (int i = 0; i < n; i++) {
            result+= arrA[i]*arrB[i];
        }
        System.out.println(result);
//        for (int i = 0; i < n; i++) {
//            String[] b = br.readLine().split(" "); //배열 b
//            map.put(Integer.parseInt(b[i]), i);
//        }
//        List<Integer> list = new ArrayList<>(map.keySet());
//        Collections.reverse(list);  //리스트에 배열b의 key값을 내림차순 정렬
//
//
//
//        int[] arrB = new int[list.size()];
//        int result = 0;
//
//        for (int i = 0; i < list.size(); i++) {
////            arrB[i] = map.get(list.get(i));       //내림차순 정렬된 b의 key값으로 해당 인덱스를 찾는다.
//            result+= arrA[i] * list.get(i);   //오름차순 정렬된 a와 (a의 가장작은값부터 시작) b의 (최댓값부터시작)
//        }
//        System.out.println(result);

    }
}