import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        String [] str = br.readLine().split(" ");
        int x = Integer.parseInt(br.readLine());

        int cnt =0;
        for (int i = 0; i < n; i++) {
            int y= Integer.parseInt(str[i]);
            if(x==y){
                cnt++;
            }

        }
        System.out.println(cnt);
    }
}