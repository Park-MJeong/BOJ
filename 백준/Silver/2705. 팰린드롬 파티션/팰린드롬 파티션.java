import java.io.*;
/*
n=10  5개
1+8+1,2+6+2,3+4+3,4+2+4,5+5
n=9  4개
1+7+1,2+5+2,3+3+3,4+1+4
n=8  4개
1+6+1,2+5+2,3+2+3,4+4
n=7  3개
1+5+1,2+3+2,3+1+3
n=6  3개
1+4+1,2+2+2,3+3
     (1)+4+(1)  1
   (2)+2+(2) = 2의팰린드롬 + 2 + 2의팰린드롬
 (3)+(3) = 3의 팰린드롬 + 3의 팰린드롬


재귀적 팰린드롬 파티션 수 = 주어진수/2
홀수일때는 갯수 증가 x
* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T =Integer.parseInt(br.readLine());
        int [] palindromeArr = new int[1001];
        palindrome(palindromeArr);

        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            System.out.println(palindromeArr[N]);
        }
    }
    static void palindrome(int [] arr) {
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] = arr[i - 1] + arr[i/2];
            }
            else{
                arr[i] = arr[i - 1];
            }
        }
    }
}
