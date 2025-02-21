import java.io.*;
import java.util.*;

public class Main{
    static HashMap<Long,Long>map = new HashMap<>();
    static long n,p,q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long [] str = Arrays.stream(br.readLine().split(" ")).map(Long::valueOf).toArray(Long[]::new);

        n = str[0];
        p = str[1];
        q = str[2];

        System.out.println(result(n));
    }
    static long result(long i) {
        if(i==0) return 1;
        if(map.containsKey(i)){
            return map.get(i);
        }
        long start = i/p;
        long end = i/q;
        map.put(i,result(start)+result(end));
        return map.get(i);
    }

}