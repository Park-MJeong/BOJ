
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static Map<Integer,Integer> map = new TreeMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int T =Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int N =Integer.parseInt(br.readLine());
            for(int j=0;j<N;j++){
                String[] str =br.readLine().split(" ");
                int a = Integer.parseInt(str[0]);
                int b = Integer.parseInt(str[1]);
                map.put(a,b);
            }
            sunwi(N);
        }
        System.out.println(sb);

    }
    static void sunwi(int n){
        int minRank = map.get(1);
        int result = 1;
        for(int i=2;i<=n;i++){
            int k = map.get(i);
            if(k==1){
                result++;
                sb.append(result).append("\n");
                return;
            }
            if(k<minRank){
                result++;
                minRank = k;
            }
        }
        sb.append(result).append("\n");

    }
        }