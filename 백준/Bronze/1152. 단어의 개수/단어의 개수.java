import java.io.*;
/*
공백으로 시작하거나 끝날 수 있다.
*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input =br.readLine().trim(); //양쪽공백제거

        if(input.isEmpty()){
            System.out.println(0);
        }
        else {
            String [] s = input.split(" ");
            System.out.println(s.length);
        }
    }

}
