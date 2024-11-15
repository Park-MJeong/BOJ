import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
중복을 허용하지 않는 map에 값을 넣어줌
가장 큰 value값을 찾음
해당 값으로 key찾아서 출력

* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new TreeMap<>();
        List<String> list = new ArrayList<>(map.keySet());

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String book = br.readLine();
            if (!map.containsKey(book)) {
                map.put(book, 1);
            } else {
                map.put(book, map.get(book) + 1);
            }
        }

        int manyBooks = Collections.max(map.values());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(manyBooks)) {
                System.out.println(entry.getKey());
                break;
            }
        }
    }
}
