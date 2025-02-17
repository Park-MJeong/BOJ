
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
N에 대한 0호출 횟수 = N-1의 1 호출 횟수
N에 대한 1 호출 횟수 = N-1의 0 호출 횟수 + N-1의 1 호출 횟수
* */
public class Main{
    static StringBuilder sb = new StringBuilder();
    static int k0,k1,temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T =Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int n = Integer.parseInt(br.readLine());
            fibonacci(n);
            sb.append(k0).append(" ").append(k1).append("\n");
        }
        System.out.println(sb);

    }
    static void fibonacci(int n){
        k0=1;
        k1=0;
        temp=1;
        for(int i=0;i<n;i++){
            k0=k1;
            k1=temp;
            temp = k0+k1;
        }

    }
}