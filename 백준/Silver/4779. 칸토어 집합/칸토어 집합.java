import java.io.*;
import java.util.Arrays;

/*
* 더 이상 입력되지 않으면 문제끝, 출력종료
* 3의 n승 -> 3등분하여 가운데 공백
*0~8/9~17/18~26
* 0~2/3~5/6~8/ 9~17 /18~20/21~23/24~26
* 012345678
* 012   678  사이즈나누기3하고 중간값을 공백
* 0 2   6 8  앞,뒤로 사이즈/3된 길이의 중간에 공백
*
* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s=br.readLine()) !=null){
            int N = Integer.parseInt(s);
            int size = (int)Math.pow(3,N);
            char [] arr =new char[size];
            Arrays.fill(arr, '-');
            div(arr,0,size);
            System.out.println(new String(arr));;

        }
        br.close();
    }
    static void div(char[]arr,int index,int size){
        if(size<=1) return;

        int division = size / 3;


        int emptyStart = index +division;
        int emptyEnd = emptyStart+ division;

//        전체 중간공백
        for(int i = emptyStart ; i<emptyEnd;i++){
            arr[i] =' ';
        }
//        왼쪽 중간 공백
        div(arr,index,division);
//        오른쪽 중간 공백
        div(arr,emptyEnd,division);

    }


}