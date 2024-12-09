import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
점 N 선분 M
N개 점의 좌표
M개의 줄에 선분의 시작S 끝점E

* 출력
각각의 선분위에 입력으로 주어진 점 출력
* */
/*
 * 문제해결
S~E사이에 주어진점의 좌표가 몇개 포함되는지 갯수를 출력하면된다.
선분의 위치가 dot의 중간값 보다 크면 오른쪽 탐색, 작으면 왼쪽탐색
* 선분의 시작위치
위치와 중간값이 같으면 시작위치니까 왼쪽 탐색
* 선분의 마지막 위치
위치와 중간값이 같으면 마지막 위치니까 오른쪽 탐색
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int []dots = new int[n];

        String[] str1 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            dots[i] = Integer.parseInt(str1[i]);
        }
        Arrays.sort(dots); //이분탐색을 위해 오름차순

        for (int i = 0; i < m; i++) {
            String[] str2 = br.readLine().split(" ");
            int s=Integer.parseInt(str2[0]);
            int e=Integer.parseInt(str2[1]);

            int s_index = binary(dots,s,"s");
            int e_index = binary(dots,e,"e");
            sb.append( (e_index+1) - s_index ).append("\n");
        }
        System.out.println(sb);
    }
    static int binary(int[] dots, int start, String check) {
        int left = 0;
        int right = dots.length-1;

        while (left <= right) {
            int mid = (left + right)/2;

            if(check.equals("s")){ //선분 시작
                if(dots[mid]<start){
                    left = mid+1;
                }else right = mid-1;
            }
            if(check.equals("e")){ //선분 끝
                if(dots[mid]<=start){  //오른쪽 탐색
                    left = mid+1;
                }else  right = mid-1; //왼쪽탐색
            }
        }
        return (check.equals("s")?left:right);
    }


}