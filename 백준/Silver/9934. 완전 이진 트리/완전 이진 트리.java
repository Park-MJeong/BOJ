import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
정수k
숫자 2^k-1개

* 출력
(왼쪽 서브트리 - 현재노드 - 오른쪽 서브트리)로 배열 출력
* */

/* 문제해결
중위 순회 노드
(왼쪽 서브트리 - 현재노드 - 오른쪽 서브트리)
번호의 범위가 1~2^k 로 지정되어있다.
=>k : 노드의 깊이, 노드의 개수 2^k -1개

입력값 : 2   1   3
       [0] [1] [2]

출력 :  1    깊이:1
    2    3  깊이:2
[0][2]의 부모노드는 [1]



입력값 : 1   6   4   3   5   2   7
       [0] [1] [2] [3] [4] [5] [6]

출력 :  3     깊이:1
    6    2   깊이:2
  1 4   5 7  깊이:3

왼쪽 :  [0][2]의 부모노드는 [1]
오른쪽 :[4][6]의 부모노트는 [5]
[1][5]의 부모노드는 [3]
최상위 노드 ==> 모든배열의 중간위치,깊이 1

왼쪽노드는 (0,중간위치-1)에서 시작
오른쪽노트는 (중간위치+1,노드사이즈-1)에서 시작
* */
public class Main {

    static int[]num; //입력 배열 저장
    static int n ;//노드개수
    static List<ArrayList<Integer>> list; //노드의 깊이순차저장
    static int k; //노드의 깊이


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        k = Integer.parseInt(br.readLine()); //1<=k<=10,노드의 깊이
        n = (int) Math.pow(2,k) - 1; //입력받는 노드의 개수
        num = new int[n];
        list = new ArrayList<>();
        String[] input = br.readLine().split(" ");

        for (int i = 0; i <n; i++) {
            num[i] = Integer.parseInt(input[i]); //배열에 입력받은 수 저장
            }
        for (int i = 0; i <k; i++) { //노드의 깊이에 따른 숫자 저장
            list.add(new ArrayList<>());
        }
        postOrder(0,n-1,0);
        for (int i = 0; i <k; i++) {
            for(int j : list.get(i)){
                sb.append(j+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void postOrder(int start, int end,int d){
        if (d==k) { //현재입력된높이와 최종높이가 같으면 종료
            return;
        }
        int mid = (start + end)/2; //시작과 끝값의 중간위치
        list.get(d).add(num[mid]); //입력받은 배열의 중간값을 깊이에 저장
        postOrder(start,mid-1,d+1);
        postOrder(mid+1,end,d+1);

    }
}
