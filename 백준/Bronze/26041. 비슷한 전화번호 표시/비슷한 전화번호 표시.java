import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
startsWith(b) : b로시작 하는지 여부
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        int cnt = 0;
        String [] str = a.split(" "); 
        for(String s : str){
            if(!s.equals(b) && s.startsWith(b)){
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}