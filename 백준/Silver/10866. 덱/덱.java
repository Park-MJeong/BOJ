import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
/*
* 입력
첫째줄에 명령어 수 N (1<= N <=10000 )
둘째 줄~ N개의 줄 명령어 주어짐
*
* 출력
완성된  문자열 출력, 빈문자열인 경우 0 출력
* */

/* 문제해결
Deque로 구현

* */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque <String> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder(); //

        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            String[]strings = br.readLine().split(" ");
            String s = strings[0];
            switch (s){
                case "push_front" :{
                    deque.addFirst(strings[1]);
                    break;
               }
                case "push_back" :{
                    deque.addLast(strings[1]);
                    break;

                }
                case "pop_front" :{
                    if(!deque.isEmpty()){
                        sb.append(deque.pollFirst()+"\n");
                    }else sb.append(-1+"\n");
                    break;
                }
                case "pop_back" :{
                    if(!deque.isEmpty()){
                        sb.append(deque.pollLast()+"\n");
                    }else sb.append(-1+"\n");
                    break;
                }
                case "size" :{
                    sb.append(deque.size()+"\n");
                    break;
                }
                case "empty" :{
                    if(!deque.isEmpty()){
                        sb.append(0+"\n");
                    }else sb.append(1+"\n");
                    break;
                }
                case "front" :{
                    if(!deque.isEmpty()){
                        sb.append(deque.peekFirst()+"\n");
                    }else sb.append(-1+"\n");
                    break;
                }
                case "back" :{
                    if(!deque.isEmpty()){
                        sb.append(deque.peekLast()+"\n");
                    }else sb.append(-1+"\n");
                    break;
                }
            }

        }

        System.out.println(sb);
        br.close();
    }

}
