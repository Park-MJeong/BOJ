import java.io.*;
/*
무조건 세글자
두 수는 같지않고, 0은 포함되어있지않음
첫번째,세번째 글자위치 바뀜 -> reverse
*/
public class Main {
    static int start = 0;
    static int end = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input =br.readLine().split(" ");
        int a = Integer.parseInt(replaced(input[0]));
        int b = Integer.parseInt(replaced(input[1]));
        System.out.println(Math.max(a,b));
    }
    static String replaced(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

}
