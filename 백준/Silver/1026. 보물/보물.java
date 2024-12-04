import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
* 입력

* 출력

* */

/* 문제해결

최소값을 출력하기위해서는
최댓값과 최소값끼리 곱해서 더해줘야한다.

* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); //정수 n
        int [] arrA = new int[n];
        int [] arrB = new int[n];

        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) { //a배열 입력받음
            arrA[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) { //b배열 입력받음
            arrB[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrA); //a 오름차순 정렬

        Integer [] bIndex = new Integer[arrB.length];
        for(int i=0; i<arrB.length; i++){
            bIndex[i]=i;
        }
        Arrays.sort(bIndex,(i,j)->arrB[i]-arrB[j]); //오름차순 정렬
        int result=0; //결과값 저장
        for(int i=0; i<n;i++){
            result+=arrA[n-1-i]*arrB[bIndex[i]];
        }
        System.out.println(result);

    }
}