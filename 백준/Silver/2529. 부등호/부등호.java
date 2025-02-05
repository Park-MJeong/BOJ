import java.io.*;
import java.util.*;
public class Main{
    static int k; //부등호 개수
    static char [] arr; //부등호
    static boolean visit [] = new boolean[10];
    static ArrayList<String> result = new ArrayList<>();

    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        String [] str = br.readLine().split(" ");
        arr = new char[k];
        for (int i = 0; i < k; i++) {
            arr[i] = str[i].charAt(0);
        }
        for (int i = 0; i < 10; i++) {
            visit[i] = true; //방문처리
            dfs(i,0,i+""); //시작점, 카운트 : 부등호개수랑 같아야함, 숫자 이어줌
            visit[i] = false;
        }
        System.out.println(result.get(result.size()-1)); //최대
        System.out.println(result.get(0)); //최소
    }
    static void dfs(int now, int count, String s) {
        if(count==k){ //부등호 개수와 같으면, 지금까지의 숫자 리스트에 담아줌
            result.add(s);
            return;
        }
        for(int next=0;next<10;next++){
            if(!visit[next]){ //방문하지 않은 숫자라면
                /*
                부등호가 < 라면 다음숫자가 커야함, >라면 다음숫자가 작아야함
                * */
                if((arr[count]=='<'&&now<next) || (arr[count]=='>'&&now>next)){
                    visit[next]=true; //방문처리
                    dfs(next,count+1,s+next);
                    visit[next] = false; // 방문취소
                }
            }
        }
    }
}