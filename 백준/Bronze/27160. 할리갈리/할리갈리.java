import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
과일이 겹쳐서 저장되면 안되므로 map을 이용
map의 value가 5일때만 Yes
* */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Integer> fruits = new HashMap<>();
        int cards = Integer.parseInt(br.readLine());

        fruits.put("STRAWBERRY",0);
        fruits.put("BANANA",0);
        fruits.put("LIME",0);
        fruits.put("PLUM",0);

        for (int i = 0; i <cards; i++) {
            String [] arr = br.readLine().split(" ");
            fruits.put(arr[0],fruits.get(arr[0])+Integer.parseInt(arr[1]));
        }

        Boolean result = fruits.containsValue(5);
        System.out.println(result==true?"YES":"NO");

    }
}
