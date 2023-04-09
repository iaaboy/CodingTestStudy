package prog161990;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        String [][] wallPapers = {
            {".#...", "..#..", "...#."},
            {"..........", ".....#....", "......##..", "...##.....", "....#....."},
            {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."},
            {"..", "#."}
        };

        Solution mSol = new Solution();
        for(String[] paper : wallPapers){
            mSol.solution(paper);
        }
    }
}

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int [4];

        TreeSet<Integer> xSet = new TreeSet<Integer>();
        TreeSet<Integer> ySet = new TreeSet<Integer>();
        int y = 0;
        for(String line : wallpaper) {
            for(int x = 0 ; x< line.length();x++){
                if(line.charAt(x) == '#') {
                    //xline좌표 넣는다
                    xSet.add(x);
                    ySet.add(y);
                    // System.out.println(y + ", " + x);
                }
            }
            y++;
        }

        // System.out.print(ySet.first() + ", " + xSet.first() + "/ ");
        // System.out.println((ySet.last()+1) + ", " + (xSet.last() + 1));
        // System.out.println(xSet);
        // System.out.println(ySet);

        answer[0] = ySet.first();
        answer[1] = xSet.first() ;
        answer[2] = ySet.last()+1;
        answer[3] = xSet.last() + 1;

        return answer;
    }
}