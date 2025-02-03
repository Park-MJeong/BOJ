import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] str = br.readLine().split(" ");
        int row = Integer.parseInt(str[0]);
        int col = Integer.parseInt(str[1]);

        String [] board = new String[row];
        for (int i = 0; i < row; i++) {
            board[i] = br.readLine();
        }
        int cur = Integer.MAX_VALUE;
//        8*8 체스판
        for (int i = 0; i <= row-8; i++) {
            for (int j = 0; j <= col-8; j++) {
//                현재 체스판의 최소비용
                int curC = minCost(i,j,board);
//                최솟값 갱신
                if(cur>curC) cur=curC;
            }
        }
        System.out.println(cur);

    }
    static int minCost(int startRow, int startCol, String[] board) {
        String[] orgBoard = {"WBWBWBWB","BWBWBWBW"};
        int whiteSol=0;
        for(int i=0;i<8;i++){
            int row = startRow+i;
            for(int j=0;j<8;j++){
                int col = startCol+j;
                if(board[row].charAt(col) != orgBoard[row%2].charAt(j)) whiteSol++;
            }
        }
        return Math.min(whiteSol,64-whiteSol);
    }
}