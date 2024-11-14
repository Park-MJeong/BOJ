import java.io.*;
/*
문자열의 시작과 끝값을 먼저 비교하고
서로 위치를 한칸씩 안쪽으로 이동하면서 비교
* */
public class Main {

    static int cnt ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            cnt=0;
            String s = br.readLine();
            System.out.println(isPalindrome(s)+" "+cnt);

        }
        br.close();

    }
    static int isPalindrome(String s){
        return recursion (s,0,s.length()-1);

    }

    static int recursion(String s,int l,int r){
        cnt++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);

    }
}
