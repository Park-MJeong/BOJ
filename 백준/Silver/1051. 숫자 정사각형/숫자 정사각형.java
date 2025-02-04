import java.io.*;

public class Main {
    static int N,M;
    static int [][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String [] str2 = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(str2[j]);
            }
        }
        int len=Math.min(N,M);
        if(len==1){
            System.out.println(1);
            return;
        }
        while(len>1){
            for(int i=0;i<=N-len;i++){
                for(int j=0;j<=M-len;j++){
                    int num=arr[i][j];
                    if(num==arr[i][j+len-1]&&num==arr[i+len-1][j]&&num==arr[i+len-1][j+len-1]){
                        System.out.println(len*len);
                        return;
                    }
                }
            }
            len--;
        }
        System.out.println(len*len);
//        System.out.println(answer(N,M,arr));

    }
}