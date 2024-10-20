package prog176963;
import java.util.*;

//추억 점수
public class MyMain {
    public static void main(String[] args) {
        String[][] name = { { "may", "kein", "kain", "radi" }};
        int[][] yearning = { { 5, 10, 1, 3 }};
        String[][][] photo = {
                { { "may", "kein", "kain", "radi" }, { "may", "kein", "brin", "deny" }, { "kon", "kain", "may", "coni" } }};

                for(int i = 0; i < 1; i++) {
                    System.out.println(Arrays.toString(new Solution().solution(name[i], yearning[i], photo[i])));
                }
    }
}

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        //각 사람별 그리움 포인트
        HashMap <String, Integer> grPoint = new HashMap<String, Integer>();
        int [] answer = new int[photo.length];
        int point = 0;
        for(int i = 0; i< name.length ; i++) {
            grPoint.put(name[i], yearning[i]);
        }

        int index = 0;
        for(String[] picture : photo) {
            for(String nm: picture ) {
                if(grPoint.containsKey(nm)) {
                    point += grPoint.get(nm);
                }
            }
            answer[index++] = point;
            point = 0;
        }
        return answer;
    }
}