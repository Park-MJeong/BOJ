import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 입력
입력 n
x좌표 y좌표
*
* 출력
경험치합의 최댓값
* */

/* 문제해결
고도를 지나가니까 x값이 중복되는 경우가 없음.
map에 저장
y의 최솟값 ,최댓값지정
최솟값이 같으면 +1 (같은높이 건물)
최댓값 바뀌면 +1 (다른높이 건물)
y의 값이 0을 만나면 최소,최댓값 0으로 초기화
************stack에 저장***********
처음에 스택이 비어있으면 저장
peek한 값과 입력값비교
입력값이 크면 값 저장
입력값이 작으면
스택이 비지 않을때까지 이전값들과 비교하여
입력값과 비교하여 큰값들을 꺼내서 ++

스택에서 꺼낸값과 입력값이 같으면 저장 하지않고 꺼내서 ++

마지막에 스택에있는것을 모두 ++

* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int cnt =0;
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            int y = Integer.parseInt(str[1]);
            if(y==0){ //0이라면 ,다음값을 받음
                if(!stack.isEmpty()){
                    cnt+=stack.size(); //기존값 저장하고 비워줌
                    stack.clear();
                    continue;
                }
                continue;
            }
            if (!stack.isEmpty() && stack.peek()>y){ //기존값보다 크거나 같으면
                 while(!stack.isEmpty() && stack.peek()>y){ //스택이 비거나 기존값보다 작을때까지 반복
                cnt++;
                stack.pop();
                 }
            }
            if(stack.isEmpty() || (!stack.isEmpty() &&stack.peek()<y)){ //스택이 비어있거나 기존값보다 크면 스택에 저장
                stack.push(y);
            }

        }
        if(!stack.isEmpty()){
            cnt+=stack.size();
        }
        System.out.println(cnt);

    }

}