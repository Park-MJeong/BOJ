import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T =Integer.parseInt(br.readLine()) ;
        for (int i=0;i<T;i++){
            String [] input =br.readLine().split(" ");
            int R =Integer.parseInt(input[0]) ;
            String S = input[1];
            System.out.println(Case(R,S));
        }
    }
    public static String  Case(int R, String S){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<S.length();i++){
            for(int j=0;j<R;j++){
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }
}
