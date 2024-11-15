import java.io.*;
import java.util.*;

/*
1)문제 분석
정리되지 않은 파일을 확장자 별로 정리하고 갯수 출력
출력순서는 확장자 오름차순
2)의사결정
N 입력받고 N 줄 반복 - for 문의 범위 N으로 설정, 한줄씩 입력받음
확장자와 파일이름은 . 으로 구분 - 구분자 '.'
파일명은 사용되지 xx -> 확장자만 뽑아내서 2차 배열에 담고,[확장자명][갯수]
확장자명을 기준으로 정렬 sort


**배열사용시 시간초과 되었음
**Key 중복허용하지 않는 Map사용
*/
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String,Integer> map = new HashMap<>();
        List<String> key = new ArrayList<>(map.keySet());  // 키값 오름차순 정렬위해서 담아줄 리스트


        for (int i = 0; i < N; i++) {
            String [] input = br.readLine().split("\\.");
            String extension = input[1];

//            containsKey : 해당 값이 map의 키값에 있는지 체크해줌
//            저장되어 있지 않다면 초기값이므로 list에도 넣어줘야한다.
            if (!map.containsKey(extension) ) {
                key.add(input[1]);
                map.put(extension,1);
            }
            else{
                map.put(extension,map.get(extension)+1);
            }

        }
//        System.out.println(map);
//        System.out.println(key);

        Collections.sort(key);  //정렬후 
        StringBuilder sb = new StringBuilder();

        for (String s : key) {
            sb.append(s +" "+map.get(s)+"\n"); //출력
        }

        System.out.println(sb);
    }
}
