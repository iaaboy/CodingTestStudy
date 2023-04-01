package prog0401;
import java.util.*;

//추억 점수
public class MyMain {

    /*
    ["may", "kein", "kain", "radi"]	[5, 10, 1, 3]	[["may", "kein", "kain", "radi"],["may", "kein", "brin", "deny"], ["kon", "kain", "may", "coni"]]	[19, 15, 6]
    ["kali", "mari", "don"]	[11, 1, 55]	[["kali", "mari", "don"], ["pony", "tom", "teddy"], ["con", "mona", "don"]]	[67, 0, 55]
    ["may", "kein", "kain", "radi"]	[5, 10, 1, 3]	[["may"],["kein", "deny", "may"], ["kon", "coni"]]	[5, 15, 0]
    */
    public static void main(String[] args) {
        String[][] name = { { "may", "kein", "kain", "radi" }, { "kali", "mari", "don" }, { "may", "kein", "kain" } };
        int[][] yearning = { { 5, 10, 1, 3 }, { 11, 1, 55 }, { 5, 10, 1, 3 } };
        String[][][] photo = {
                { { "may", "kein", "kain", "radi" }, { "may", "kein", "brin", "deny" }, { "kon", "kain", "may", "coni" } },
                { { "kali", "mari", "don" }, { "pony", "tom", "teddy" }, { "con", "mona", "don" } },
                { { "may" }, { "kein", "deny", "may" }, { "kon", "coni" } } };

                for(int i = 0; i < 3; i++) {
                    System.out.println(new Solution().solution(name[i], yearning[i], photo[i]));
                }
    }
}

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap <String, Integer> grPoint = new HashMap<String, Integer>();
        ArrayList<Integer> preAnswer = new ArrayList<Integer>();
        int point = 0;
        for(int i = 0; i< name.length ; i++) {
            grPoint.put(name[i], yearning[i]);
        }

        for(String[] pList : photo) {
            for(String p: pList ) {
                if(grPoint.containsKey(p)) {
                    point += grPoint.get(p);
                }
            }
            preAnswer.add(point);
            point = 0;
        }

        
        int [] answer = new int[preAnswer.size()];

        for(int i=0; i< preAnswer.size();i++)
            answer[i] = preAnswer.get(i);       
        

        return answer;
    }
}