package prog148653;

public class MyMain {
    public static void main(String[] args) {
        int[] story = { 555, 16, 2554 };

        Solution mSol = new Solution();

        for (int i = 0; i < story.length; i++) {
            System.out.println(mSol.solution(story[i]));
        }
    }
}

class Solution {
    int[] dict = { 0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 };
    int answer;

    public int solution(int storey) {
        answer = 0;
        countButton(storey, false, false);
        return answer;
    }

    private void countButton(int st, boolean up, boolean notDecided) {
        boolean nextUp = false;
        boolean nextDC = false;
        if (st == 0) {
            if (up)
                answer++;
            return;
        }

        int num = st % 10;
        if (up)
            num++;

        if (notDecided && num >= 5)
            num++;

        if (num > 5) {
            nextUp = true;
        } else if (num == 5) {
            nextDC = true;
        }
        answer += dict[num];
        // System.out.println("  n:" + num + " , dict: " + dict[num] + " , sum " + answer);
        countButton(st / 10, nextUp, nextDC);
    }
}