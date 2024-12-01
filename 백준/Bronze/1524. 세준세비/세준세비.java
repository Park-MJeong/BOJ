import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/*
* 입력
첫줄에 테스트케이스 T(T<=100)
(줄 바꿈으로 각 테스트 구분)
세준이의 병사 N 세비의 병사M
세준의 병사 힘
세비의 병사힘


* 출력
세준이가 이기면 S , 세비가 이기면 B, 비기면 C
* */

/* 문제해결
각 전투에서 제일 약한 병사가 죽음
제일 약한 병사가 모두 같은편이라면 한명이 임의로 선택되어 죽음
양편에 제일 약한 병사가 있다면 세비의 약한 병사가 임의로 선택되어 죽음

한명이 남는순간 싸움은 끝나므로 C가 나올경우는 없다.
병사의 힘을 리스트에 저장하여
최댓값끼리 비교하고,
세준이 크거나 같다면 세비의 최소값 제거
세비가 크다면 세준의 최소값 제거
그렇게 해서 둘중에 한명의 리스트가 비어있다면 끝

* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            br.readLine(); // 빈 줄 처리
            String [] str = br.readLine().split(" ");


            // 병사들의 힘을 내림차순 정렬된 리스트로 변환 (long 사용)
            List<Long> junList = Arrays.stream(br.readLine().split(" "))
                    .map(Long::parseLong)
                    .sorted(Collections.reverseOrder())
                    .collect(Collectors.toList());

            List<Long> biList = Arrays.stream(br.readLine().split(" "))
                    .map(Long::parseLong)
                    .sorted(Collections.reverseOrder())
                    .collect(Collectors.toList());

            // 전투 시작
            while (!junList.isEmpty() && !biList.isEmpty()) {
                long jMax = junList.get(0); // 세준 병사의 최강체
                long bMax = biList.get(0); // 세비 병사의 최강체

                if (jMax >= bMax) {
                    biList.remove(biList.size() - 1); // 세비 병사의 최약체 제거
                } else {
                    junList.remove(junList.size() - 1); // 세준 병사의 최약체 제거
                }
            }

            // 결과 판단
            if (!biList.isEmpty()) {
                sb.append("B").append("\n");
            } else {
                sb.append("S").append("\n");
            }
        }
        System.out.println(sb);
    }
}
