import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;



/*
* 입력
N(사람 수) K(삭제하는 번호)
* *
*
* 출력
요세푸스 순열 출력 <3, 6, 2, 7, 5, 1, 4>
* */

/* 문제해결
N만큼 큐에 숫자를 저장한다.
큐 사이즈와 내가 원하는삭제번호가 크면 반복문을 내가 원하는 삭제 번호전까지 돌면서 뒤로 숫자를 보낸다.
그렇게 되면 다음은 내가 원하는 삭제번호이므로 반복문을 탈출하여 숫자를 꺼내어, sb(출력값)에 저장해준다
만약, 작다면 원하는 삭제번호- 이전 큐 사이즈로 출력위치를 찾아낸다.
=> 이미 해당 반복문을 할때면 사이즈가 1작아져있으므로 1을 더해줘야한다.
만약, 큐의 사이즈가 원하는 삭제번호보다 작다면 그대로 출력값에 저장해준다.
하지만 , 사이즈가 1이라면 콤마를 없애고 출력값에 저장

* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();

        String [] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        sb.append("<");
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        while (!q.isEmpty()) {
            int size = q.size();
           if(size==1){
                sb.append(q.poll());
                break;
            }
            if(size >= k){
                for(int i = 0; i < k-1; i++){
                    int temp = q.poll();
                    q.add(temp);
                }
                sb.append(q.poll()).append(", ");
            }else if (size <k) {
                if(k-(size+1) == 0){
                    sb.append(q.poll()).append(", ");
                    continue;
                }
                for(int j = 0; j <k-(size+1); j++){
                    int temp = q.poll();
                    q.add(temp);
                }
                sb.append(q.poll()).append(", ");

            }
        }
        sb.append(">");
        System.out.println(sb);
    }

}




