import java.io.*;
/*
* B를 접두사로 가지는 A전화번호 찾기
* A와 B가 완전히 똑같으면 안된다.
* A의 길이는 B보다 무조건 길어야한다.*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input =br.readLine().split(" ");
        String B =br.readLine() ;
        int cnt=0;
        for (String input_A : input){
            int tmp =0;
            if(!input_A.equals(B) && B.length()<input_A.length() ){ //완전히 똑같은 수 제외,B보다 작은 길이 제외
                for(int j=0;j<B.length();j++) {
                    if(input_A.charAt(j) == B.charAt(j)){
                        tmp++;
                    }
                }
            }
           cnt = tmp == B.length() ? cnt+1 : cnt; //길이가 같으면 B를접두사로 가지는것
        }
        System.out.println(cnt);
    }

}
