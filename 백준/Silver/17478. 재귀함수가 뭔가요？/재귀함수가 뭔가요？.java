import java.io.*;
/*
처음호출때는 _ 없이 이야기 쭉 들려줌
그 다음 호출부터 _가 붙음
____*4 의 횟수와 재귀숫자 같음
답변하였지는 나중에 연달아 출력
* */
public class Main {
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        Recursion(N);


    }
    static void Recursion(int N){
        String bar ="_".repeat(cnt*4);

        System.out.println(bar+"\"재귀함수가 뭔가요?\"");


        if(cnt==N){
            System.out.println(bar+"\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            System.out.println(bar+"라고 답변하였지.");
            return; //함수종료
        }
        System.out.println(bar+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
        System.out.println(bar+"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
        System.out.println(bar+"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");

        cnt++;

        Recursion(N);

        System.out.println(bar+"라고 답변하였지.");
        cnt --;
    }

}