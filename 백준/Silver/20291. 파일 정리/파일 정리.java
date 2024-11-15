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
****HashMap은 정렬해주지 않아서 따로 정렬을 구현해야하고, TreeMap은 정렬까지 알아서 해줌
*/
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String,Integer> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            String [] input = br.readLine().split("\\.");
            String extension = input[1];  // . 으로 잘라서 확장자 가져옴

//            containsKey : 해당 값이 map의 키값에 있는지 체크해줌
            if (!map.containsKey(extension) ) {
                map.put(extension,1);
            }
            else{
                map.put(extension,map.get(extension)+1);
            }
        }

        StringBuilder sb = new StringBuilder();
//        Map.Entry : key-value 쌍을 나타내는 객체,  entrySet() : get으로 key,value값 가져옴
        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            sb.append(entry.getKey()+" "+entry.getValue()+"\n");
        }
        System.out.println(sb);
    }
}
